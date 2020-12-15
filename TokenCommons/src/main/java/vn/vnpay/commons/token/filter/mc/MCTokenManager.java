package vn.vnpay.commons.token.filter.mc;

import com.google.common.base.Strings;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vn.vnpay.commons.redis.exception.RedisException;
import vn.vnpay.commons.token.beans.UserDetailBean;
import vn.vnpay.commons.token.beans.mc.UserMcBean;
import vn.vnpay.commons.token.config.Constant;
import vn.vnpay.commons.token.config.TokenConfig;
import vn.vnpay.commons.token.exception.TokenException;
import vn.vnpay.commons.token.utils.Utils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MCTokenManager extends MCTokenHelper {

    private static final Logger LOGGER = LogManager.getLogger(MCTokenManager.class);


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
        UserMcBean userDetailBean = null;
        boolean auth = false;
        try {
            if (hasValue(jwtString)) {
                Claims body = informationToken(jwtString);
                String username = body.get(Constant.Username, String.class);
                if (validReqData(body, ip, action, username)) {
                    userDetailBean = Utils.getUserMcFromCache(username);
                    List functionLink = userDetailBean.getFunctionLinks();
                    auth = userDetailBean.getTypeAccount() == 1 || functionLink.contains(action);
                }
            }
            if (!auth)
                LOGGER.info("Valid token: {}, from ip: {}, with user: {}", jwtString, ip, userDetailBean);
            return auth;
        } catch (Exception e) {
            LOGGER.error("Valid token: {}, from ip: {}, with user: {}, have EX: {}", jwtString, ip, userDetailBean, e);
            throw new TokenException("-2", "Token Fail.");
        }
    }

    public static UserMcBean getUserMerchantFromToken(String token) throws TokenException, RedisException {
        Claims claims = informationToken(token);
        return Utils.getUserMcFromCache(claims.get(Constant.Username, String.class));
//                .username(claims.get(Constant.Username, String.class))
//                .name(claims.get(Constant.Name, String.class))
//                .phone(claims.get(Constant.Phone, String.class))
//                .email(claims.get(Constant.Email, String.class))
////                .branchId(claims.get(Constant.BranchId, String.class))
//                .typeAccount(claims.get(Constant.TypeAccount, Integer.class))
//                .fistLogin(claims.get(Constant.FistLogin, Integer.class))
//                .lastTimeLogin(claims.get(Constant.LastTimeLogin, String.class))
//                .merchantCode(claims.get(Constant.MerchantCode, String.class))
//                .merchantId(claims.get(Constant.MerchantId, Integer.class))
////                .terminalId(claims.get(Constant.TerminalId, String.class))
//                .build();
    }

    public static UserMcBean getRolesTerminal(String token, String terminalId) throws TokenException, RedisException {
        UserMcBean userMcBean = getUserMerchantFromToken(token);
        if (userMcBean.getRoles() == null || userMcBean.getRoles().size() == 0)
            throw new TokenException("-1", "Permission denied.");
        String terminalIdAdd = "," + terminalId + ",";
        StringBuilder branchId = new StringBuilder();
        StringBuilder terAdd = new StringBuilder();
        for (Map.Entry<String, String> e : userMcBean.getRoles().entrySet()) {
            branchId.append(e.getKey()).append(",");
            if (Strings.isNullOrEmpty(terminalId)) {
                terAdd.append(e.getValue()).append(",");
                continue;
            }
            String terminalIds = "," + e.getValue() + ",";
            if (terminalIds.contains(terminalIdAdd)) {
                terAdd = new StringBuilder(terminalId + ",");
            }
        }
        if (Strings.isNullOrEmpty(branchId.toString())) throw new TokenException("-1", "Permission denied.");
        branchId.substring(0, branchId.length() - 1);
        if (Strings.isNullOrEmpty(terAdd.toString())) throw new TokenException("-1", "Permission denied.");
        terAdd.substring(0, terAdd.length() - 1);
        userMcBean.setBranchId(branchId.toString());
        userMcBean.setTerminalId(terAdd.toString());
        return userMcBean;
    }

    public static UserMcBean getRolesTerminal(String token, String branchId, String terminalId) throws TokenException, RedisException {
        UserMcBean userMcBean = getUserMerchantFromToken(token);
        StringBuilder branchIdAdd = new StringBuilder();
        StringBuilder terminalIdAll = new StringBuilder();
        for (Map.Entry<String, String> e : userMcBean.getRoles().entrySet()) {
            if (Strings.isNullOrEmpty(branchId)) {
                branchIdAdd.append(e.getKey()).append(",");
                terminalIdAll.append(e.getValue()).append(",");
                continue;
            }
            if (e.getKey().equalsIgnoreCase(branchId)) {
                branchIdAdd = new StringBuilder(e.getKey() + ",");
                if (Strings.isNullOrEmpty(terminalId)) {
                    terminalIdAll.append(e.getValue()).append(",");
                    continue;
                }
                String terminalIdAdd = "," + terminalId + ",";
                String terminalIds = "," + e.getValue() + ",";
                if (terminalIds.contains(terminalIdAdd)) {
                    terminalIdAll = new StringBuilder(terminalId + ",");
                    break;
                }
            }
        }
        if (!Strings.isNullOrEmpty(branchIdAdd.toString())) {
            branchIdAdd.substring(0, branchIdAdd.length() - 1);
            userMcBean.setBranchId(branchIdAdd.toString());
            if (!Strings.isNullOrEmpty(terminalIdAll.toString())) {
                terminalIdAll.substring(0, terminalIdAll.length() - 1);
                userMcBean.setTerminalId(terminalIdAll.toString());
                return userMcBean;
            }
        }
        throw new TokenException("-1", "Permission denied.");
    }
}
