package vn.vnpay.commons.api.validation;

import org.apache.logging.log4j.util.Strings;
import vn.vnpay.commons.api.exception.ValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

public class ValidatorRequest {
    private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private static Validator validator = validatorFactory.getValidator();

    public static void valid(Object obj) throws ValidationException {
        Set set = validator.validate(obj);
        if (set.size() > 0) {
            for (Object o : set) {
                ConstraintViolation constraintViolation = (ConstraintViolation) o;
                String result = constraintViolation.getPropertyPath().toString() + ": " + constraintViolation.getMessage();
                if (Strings.isNotEmpty(result))
                    throw new ValidationException(result);
            }
        }
    }

    public static void valid(Object obj, Class<?> typeClass) throws ValidationException {
        Set set = validator.validate(obj, typeClass);
        if (set.size() > 0) {
            String result = "";
            for (Object o : set) {
                ConstraintViolation constraintViolation = (ConstraintViolation) o;
                result += constraintViolation.getPropertyPath().toString() + ": " + constraintViolation.getMessage() + "; ";
            }
            throw new ValidationException(result);
        }
    }

    public static boolean compareDate(String fromDateStr, String toDateStr) throws ValidationException {
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date fromDate = convertDate(fromDateStr, sdf);
        Date toDate = convertDate(toDateStr, sdf);
        return fromDate.after(toDate);
    }

    public static Date getStartOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        calendar.set(year, month, day, 0, 0, 0);
        return calendar.getTime();
    }

    public static Date getEndOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        calendar.set(year, month, day, 23, 59, 59);
        return calendar.getTime();
    }

    public static Date convertDate(String dateStr, DateFormat sdf) throws ValidationException {
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new ValidationException("Date not in format: dd/MM/yyyy HH:mm:ss");
        }
    }
}
