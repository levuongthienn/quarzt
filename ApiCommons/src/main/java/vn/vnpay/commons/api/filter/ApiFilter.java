package vn.vnpay.commons.api.filter;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.util.Strings;
import vn.vnpay.commons.api.filter.helper.HttpRequestWrapper;
import vn.vnpay.commons.api.filter.helper.HttpResponseWrapper;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class ApiFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            long startTime = System.currentTimeMillis();
            servletRequest.setCharacterEncoding("UTF-8");
            HttpRequestWrapper httpRequestWrapper = new HttpRequestWrapper((HttpServletRequest) servletRequest);

            String method = httpRequestWrapper.getMethod();
            if (!"OPTIONS".equals(method))
                writeLogInput(httpRequestWrapper);
            HttpResponseWrapper httpResponseWrapper = new HttpResponseWrapper((HttpServletResponse) servletResponse);
            setResponseHeader(httpResponseWrapper);
            filterChain.doFilter(httpRequestWrapper, httpResponseWrapper);
            httpResponseWrapper.flushBuffer();
            if (!"OPTIONS".equals(method))
                writeLogOutput(httpResponseWrapper, servletResponse, startTime);
        } catch (Throwable tb) {
            LOGGER.error("Ex: {}", tb);
        }
    }

    private void writeLogInput(HttpRequestWrapper httpRequestWrapper) {
        String token = RandomStringUtils.random(15, true, true);
        ThreadContext.put("token", token);
        String path = httpRequestWrapper.getPathInfo();
        String body = httpRequestWrapper.getBody();

        String ip = getClientIp(httpRequestWrapper);

        LOGGER.info("Begin Req start endpoint: {}, from ip: {}, with Data: {}", path, ip, body);
    }

    private void writeLogOutput(HttpResponseWrapper httpResponseWrapper, ServletResponse servletResponse, long startTime) throws UnsupportedEncodingException {
        byte[] copy = httpResponseWrapper.getCopy();
        String res = new String(copy, servletResponse.getCharacterEncoding());
        long endTime = System.currentTimeMillis();
        LOGGER.info("End Time Res: {} ms, Response value: {}", endTime - startTime, res);
    }

    private void setResponseHeader(HttpResponseWrapper httpResponseWrapper) {
        httpResponseWrapper.addHeader("Access-Control-Allow-Origin", "*");
        httpResponseWrapper.addHeader("Access-Control-Max-Age", "600");
        httpResponseWrapper.addHeader("Access-Control-Allow-Methods", "GET, POST");
        httpResponseWrapper.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
    }

    @Override
    public void destroy() {
        LOGGER.info("Destroy application success.");
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

    private static final Logger LOGGER = LogManager.getLogger(ApiFilter.class);

}
