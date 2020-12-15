package vn.vnpay.commons.token.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vn.vnpay.commons.redis.exception.RedisException;
import vn.vnpay.commons.token.beans.UserDetailBean;
import vn.vnpay.commons.token.config.Constant;
import vn.vnpay.commons.token.config.TokenConfig;
import vn.vnpay.commons.token.exception.TokenException;
import vn.vnpay.commons.token.utils.Utils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TokenManager extends TokenHelper {

    private static final Logger LOGGER = LogManager.getLogger(TokenManager.class);

    public static String createSignedJWT(Map<String, Object> map, String ip, boolean refresh, long ttl) throws TokenException {
        String jwtString;
        try {
            Calendar date = Calendar.getInstance();
            long currentTime = date.getTimeInMillis();
            long expireTime = currentTime + ttl * 60 * 1000;
            jwtString = Jwts.builder()
                    .setClaims(map)
                    .setHeader(header)
                    .setIssuer(TokenConfig.TOKEN_SOURCE)
                    .setAudience(ip)
                    .setSubject(refresh ? Constant.REFRESH : Constant.AUTHENTICATE)
                    .signWith(SignatureAlgorithm.HS512, key)
                    .setIssuedAt(new Date(currentTime))
                    .setExpiration(new Date(expireTime))
                    .compact();
        } catch (Exception e) {
            LOGGER.error("Create token have ex: {}", e);
            throw new TokenException("49", "Fail to create JWT");
        }
        return jwtString;
    }

    static boolean validateJWT(String jwtString, String ip, String action) throws TokenException {
        UserDetailBean userDetailBean = null;
        boolean auth = false;
        try {
            if (hasValue(jwtString)) {
                Claims body = informationToken(jwtString);
                String username = body.get(Constant.Username, String.class);
                if (validReqData(body, ip, action, username)) {
                    userDetailBean = Utils.getUserFromCache(username);
                    List functionLink = userDetailBean.getFunctionLinks();
                    auth = userDetailBean.getGroupId() == 1 || functionLink.contains(action);
                }
            }
            if (!auth)
                LOGGER.info("Valid token: {}, from ip: {}, with user: {}", jwtString, ip, userDetailBean);
            return auth;
        } catch (RedisException e) {
            LOGGER.error("Valid token: {}, from ip: {}, with user: {}, have EX: {}", jwtString, ip, userDetailBean, e);
            throw new TokenException("-2", "Token Fail.");
        }
    }

    public static UserDetailBean getUserFromToken(String token) throws TokenException {
        Claims claims = informationToken(token);
        return UserDetailBean.builder()
                .username(claims.get(Constant.Username, String.class))
                .name(claims.get(Constant.Name, String.class))
                .groupId(claims.get(Constant.GroupId, Integer.class))
                .phone(claims.get(Constant.Phone, String.class))
                .email(claims.get(Constant.Email, String.class))
                .changePass(claims.get(Constant.ChangePass, Integer.class))
                .build();
    }
}
