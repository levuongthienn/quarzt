package vn.vnpay.commons.api.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.vnpay.commons.api.config.ResCode;
import vn.vnpay.commons.api.exception.BusinessException;
import vn.vnpay.commons.api.exception.CacheException;
import vn.vnpay.commons.api.exception.DaoException;
import vn.vnpay.commons.api.exception.IntegrateException;
import vn.vnpay.commons.api.exception.ServiceException;
import vn.vnpay.commons.api.exception.ValidationException;
import vn.vnpay.commons.token.exception.TokenException;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponseBean<T> {
    private String code;
    private String description;

    private T data;

    public static BaseResponseBean of(ResCode c) {
        return BaseResponseBean.builder()
                .code(c.code())
                .description(c.description())
                .build();
    }

    public static BaseResponseBean of(Exception e) {
        ResCode c;
        if (e instanceof ServiceException) {
            c = ResCode.SERVICE_EXCEPTION_89;
        } else if (e instanceof DaoException) {
            c = ResCode.DAO_EXCEPTION_79;
        } else if (e instanceof CacheException) {
            c = ResCode.CACHE_EXCEPTION_69;
        } else if (e instanceof IntegrateException) {
            c = ResCode.INTEGRATE_EXCEPTION_59;
        } else if (e instanceof ValidationException) {
            return of(ResCode.VALIDATION_EXCEPTION_49.code(), e.getMessage());
        } else if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            return of(businessException.getCode(), businessException.getDescription());
        } else if (e instanceof TokenException) {
            TokenException tokenException = (TokenException) e;
            return of(tokenException.getCode(), tokenException.getDescription());
        } else {
            c = ResCode.EXCEPTION;
        }
        return of(c.code(), c.description());
    }

    public static BaseResponseBean of(Object o, ResCode c) {
        return BaseResponseBean.builder()
                .code(c.code())
                .description(c.description())
                .data(o)
                .build();
    }

    public static BaseResponseBean of(Object o, String code, String description) {
        return BaseResponseBean.builder()
                .code(code)
                .description(description)
                .data(o)
                .build();
    }

    public static BaseResponseBean of(String code, String description) {
        return BaseResponseBean.builder()
                .code(code)
                .description(description)
                .build();
    }

}
