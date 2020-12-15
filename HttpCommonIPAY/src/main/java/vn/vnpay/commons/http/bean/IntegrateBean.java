package vn.vnpay.commons.http.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IntegrateBean<T> {

    private String code;
    private String description;
    private T data;
}
