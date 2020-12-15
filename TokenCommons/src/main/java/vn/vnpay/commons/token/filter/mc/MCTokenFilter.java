package vn.vnpay.commons.token.filter.mc;

import vn.vnpay.commons.token.exception.TokenException;
import vn.vnpay.commons.token.utils.Utils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MCTokenFilter implements Filter {

    private static List excludedUrls;
    private static String ignoreSystem;

    public void init(FilterConfig filterConfig) throws ServletException {
        ignoreSystem = "/system/";
        excludedUrls = Arrays.asList(
                "",
                "/swagger.json",
                "/monitoring/ping",
                "/auth/login",
                "/auth/refreshToken",
                "/auth/resetPassword",
                "/auth/changePassword",
                "/auth/logout"
        );
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        String path = httpRequest.getPathInfo();
        String method = httpRequest.getMethod();
        if (!"OPTIONS".equals(method) && !excludedUrls.contains(path) && !path.contains(ignoreSystem)) {
            String jwtString = httpRequest.getHeader("Authorization");
            String ip = Utils.getClientIp(httpRequest);
            String responseErr;
            try {
                boolean checkAuth = MCTokenManager.validateJWT(jwtString, ip, path);
                if (!checkAuth) {
                    responseErr = "{\"code\":\"-1\", \"description\":\"Unauthorized\"}";
                    httpResponse.getOutputStream().write(responseErr.getBytes("UTF-8"));
                    return;
                }
            } catch (TokenException e) {
                responseErr = "{\"code\":\"-2\", \"description\":\"Token Fail.\"}";
                httpResponse.getOutputStream().write(responseErr.getBytes("UTF-8"));
                return;
            }
        }
        filterChain.doFilter(httpRequest, httpResponse);
    }

    public void destroy() {

    }
}
