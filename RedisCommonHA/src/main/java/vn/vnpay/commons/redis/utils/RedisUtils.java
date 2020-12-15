package vn.vnpay.commons.redis.utils;

import org.apache.logging.log4j.util.Strings;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.Normalizer;
import java.util.regex.Pattern;

public class RedisUtils {

    private static final String regexAll = "*";
    private static final Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

    public static String ignoreAccents(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        return pattern.matcher(temp)
                .replaceAll("")
                .replace('đ', 'd')
                .replace('Đ', 'D');
    }

    public static String buildPatternSearch(String dataSearch) {
        if (Strings.isEmpty(dataSearch)) {
            return regexAll;
        } else {
            return new StringBuilder("*")
                    .append(ignoreAccents(dataSearch).toLowerCase())
                    .append(regexAll).toString();
        }
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
