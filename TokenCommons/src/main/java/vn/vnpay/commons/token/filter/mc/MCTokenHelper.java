package vn.vnpay.commons.token.filter.mc;

import io.jsonwebtoken.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vn.vnpay.commons.token.config.Constant;
import vn.vnpay.commons.token.config.TokenConfig;
import vn.vnpay.commons.token.exception.TokenException;

import java.util.HashMap;
import java.util.Map;

public class MCTokenHelper {

    private static final Logger LOGGER = LogManager.getLogger(MCTokenHelper.class);
    protected static byte[] key;
    protected static Map<String, Object> header;

    static {
        key = TokenConfig.TOKEN_KEY.getBytes();
        header = new HashMap<String, Object>();
        header.put(Header.TYPE, Header.JWT_TYPE);
        header.put(JwsHeader.ALGORITHM, SignatureAlgorithm.HS512);
    }

    static boolean validReqData(Claims body, String ip, String action, String username) {
        if (!ip.equals(body.get(Constant.aud, String.class)) || !TokenConfig.TOKEN_SOURCE.equals(body.get(Constant.iss, String.class))) {
            LOGGER.info("Hacker Man from IP: {} , and body: {}", ip, body.toString());
            return false;
        }
        if (Constant.REFRESH.equals(body.get(Constant.sub, String.class))) {
            LOGGER.info("IP: {} , use refresh token login: {}", ip, body.toString());
            return false;
        }
        LOGGER.info("Request from ip: {}, and user: {}", ip, username);
        if (1 == body.get(Constant.ChangePass, Integer.class) && !Constant.URL_CHANGEPASSWORD.equals(action)) {
            LOGGER.info("IP: {} , user: {} need change pass before login.", ip, username);
            return false;
        }
        return true;
    }

    static boolean hasValue(String str) {
        return str != null && str.length() > 0;
    }

    public static Claims informationToken(String jwtString) throws TokenException {
        try {
            return Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(jwtString)
                    .getBody();
        } catch (Exception e) {
            throw new TokenException("-2", "Token hash expire...!");
        }
    }

}
