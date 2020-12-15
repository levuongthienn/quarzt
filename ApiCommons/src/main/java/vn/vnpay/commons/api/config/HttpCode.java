package vn.vnpay.commons.api.config;

public enum HttpCode {
    SUCCESS(200) {
        public String description() {
            return "Success";
        }
    }, EXCEPTION(500) {
        public String description() {
            return "Error";
        }
    };
    private final int i;

    private HttpCode(int i) {
        this.i = i;
    }

    public int code() {
        return this.i;
    }

    public abstract String description();
}
