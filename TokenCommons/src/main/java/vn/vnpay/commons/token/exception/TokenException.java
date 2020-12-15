package vn.vnpay.commons.token.exception;

import lombok.Data;

@Data
public class TokenException extends Exception {
    private String code;
    private String description;


    public TokenException() {
        super();
    }

    public TokenException(String code, String description) {
        super();
        this.code = code;
        this.description = description;
    }

    public TokenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public TokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenException(String message) {
        super(message);
    }

    public TokenException(Throwable cause) {
        super(cause);
    }
}
