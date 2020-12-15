package vn.vnpay.commons.beans.cache;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantBean {
    private String id;
    private String merchantCode;
    private String merchantBrand;
    private String merchantName;
    private String status;
    private String statusName;
}

