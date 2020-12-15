package vn.vnpay.commons.token.utils;

import org.apache.logging.log4j.util.Strings;
import vn.vnpay.commons.redis.exception.RedisException;
import vn.vnpay.commons.redis.manager.RedisManager;
import vn.vnpay.commons.token.beans.UserDetailBean;
import vn.vnpay.commons.token.beans.mc.UserMcBean;
import vn.vnpay.commons.token.config.TokenConfig;

import javax.servlet.http.HttpServletRequest;

public class Utils {

    public static UserDetailBean getUserFromCache(String username) throws RedisException {
        return (UserDetailBean) RedisManager.getInstance().getNoLogs(TokenConfig.ALL_USER_LOGIN, username, UserDetailBean.class);
    }

    public static UserMcBean getUserMcFromCache(String username) throws RedisException {
        return (UserMcBean) RedisManager.getInstance().getNoLogs(TokenConfig.MC_USER_LOGIN, username, UserMcBean.class);
    }

    public static String getClientIp(HttpServletRequest request) {
        String remoteAddr = "";
        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (Strings.isEmpty(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }
        return remoteAddr;
    }
}
