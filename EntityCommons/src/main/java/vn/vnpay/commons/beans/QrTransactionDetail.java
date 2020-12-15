package vn.vnpay.commons.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "Chi tiết giao dịch", description = "Chi tiết giao dịch")
public class QrTransactionDetail {
    
    private String productId;
    private String productName;
    private int quantity;
    private String amount;
    private String note;
}
