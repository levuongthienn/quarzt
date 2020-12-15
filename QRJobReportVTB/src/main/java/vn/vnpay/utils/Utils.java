package vn.vnpay.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vn.vnpay.config.ServiceConfig;

public class Utils {

    private static final Logger LOGGER = LogManager.getLogger(Utils.class);

    private static Pattern patternUnicode = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

    public static Date string2DateTime(String value) throws ParseException {
        if (StringUtils.isNotEmpty(value)) {
            SimpleDateFormat dateTime = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            return dateTime.parse(value);
        }
        return null;
    }

    public static String date2String(Date value) {
        SimpleDateFormat dateTime = new SimpleDateFormat("dd/MM/yyyy");
        return dateTime.format(value);
    }
    
}
