package vn.vnpay.commons.http.utils;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vn.vnpay.commons.http.bean.IntegrateBean;
import vn.vnpay.commons.http.bean.ResCode;

import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;

public class HttpUtils {

    private static final Logger LOGGER = LogManager.getLogger(HttpUtils.class);

    public static final Gson GSON = new Gson();

    public static String detectException(Exception ex) {
        LOGGER.error("Call API have exception: {}", ex);
        if (ex instanceof SocketTimeoutException) {
            LOGGER.info("Exption is SocketTimeoutException");
            return responseBuilder(ResCode.TIME_OUT);
        } else if (ex instanceof InterruptedException) {
            LOGGER.info("Exption is InterruptedException");
            return responseBuilder(ResCode.TIME_OUT);
        } else if (ex instanceof SocketException) {
            LOGGER.info("Exption is SocketException");
            return responseBuilder(ResCode.TIME_OUT);
        } else if (ex instanceof IOException) {
            LOGGER.info("Exception is IOException");
            return responseBuilder(ResCode.TIME_OUT);
        }
        return responseBuilder(ResCode.EXCEPTION);
    }

    public static String responseBuilder(ResCode resCode) {
        return GSON.toJson(responseBuilderObj(resCode));
    }

    public static IntegrateBean responseBuilderObj(ResCode resCode) {
        return IntegrateBean.builder()
                .code(resCode.getCode())
                .description(resCode.getDescription())
                .build();
    }

    public static Type getType(final Class<?> rawClass, final Class<?> parameter) {
        return new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[]{parameter};
            }

            @Override
            public Type getRawType() {
                return rawClass;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }
        };
    }
}
