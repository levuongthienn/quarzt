package vn.vnpay.commons.http.bean;

public enum ResCode {

    SUCCESS("00", "Success"),
    TIME_OUT("08", "Time Out"),
    EXCEPTION("96", "Exception"),
    FAIL("99", "Fail");

    private String code;
    private String description;

    ResCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
