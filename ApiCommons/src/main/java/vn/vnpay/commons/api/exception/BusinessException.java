package vn.vnpay.commons.api.exception;

import lombok.Data;
import vn.vnpay.commons.api.config.ResCode;

@Data
public class BusinessException extends Exception {
    private ResCode c;
    private String code;
    private String description;

    public ResCode getResCode() {
        return c;
    }

    public BusinessException() {
        super();
    }

//    public BusinessException(ResCode c) {
//        super();
//        this.c = c;
//    }

    public BusinessException(String code, String description) {
        super(code + " - " + description);
        this.code = code;
        this.description = description;
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }
}
