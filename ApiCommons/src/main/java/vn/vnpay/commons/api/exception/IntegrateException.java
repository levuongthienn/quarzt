package vn.vnpay.commons.api.exception;

public class IntegrateException extends Exception {
    public IntegrateException() {
        super();
    }

    public IntegrateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public IntegrateException(String message, Throwable cause) {
        super(message, cause);
    }

    public IntegrateException(String message) {
        super(message);
    }

    public IntegrateException(Throwable cause) {
        super(cause);
    }
}
