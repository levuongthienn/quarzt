package vn.vnpay.commons.api.config;

public enum ResCode {
    SUCCESS("00") {
        public String description() {
            return "Success";
        }
    }, DATE_TIME_VALID("01") {
        public String description() {
            return "Khoảng thời gian tìm kiếm không hợp lệ.";
        }
    }, DATA_LIST_IS_EMPTY("02") {
        public String description() {
            return "Không tồn tại danh sách theo yêu cầu.";
        }
    }, EXCEPTION("99") {
        public String description() {
            return "Exception";
        }
    }, SERVICE_EXCEPTION_89("89") {
        public String description() {
            return "Service Exception";
        }
    }, DAO_EXCEPTION_79("79") {
        public String description() {
            return "DAO Exception";
        }
    }, CACHE_EXCEPTION_69("69") {
        public String description() {
            return "Cache Exception";
        }
    }, INTEGRATE_EXCEPTION_59("59") {
        public String description() {
            return "Integrate Exception";
        }
    }, VALIDATION_EXCEPTION_49("49") {
        public String description() {
            return "Validation Exception";
        }
    }, BUSINESS_EXCEPTION_39("39") {
        public String description() {
            return "Business Exception";
        }
    }, AUTHENTICATE_EXCEPTION("-1") {
        public String description() {
            return "Unauthorized";
        }
    };

    private final String i;

    private ResCode(String i) {
        this.i = i;
    }

    public String code() {
        return this.i;
    }

    public abstract String description();
}
