package vn.vnpay.commons.beans.trans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RescodeBean {
    private String resCode;
    private String resDesc;
}
