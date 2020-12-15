package vn.vnpay.commons.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "Bank Bean", description = "Bank Bean")
public class BankBean {

    @ApiModelProperty(value = "ID")
    private long id;

    @ApiModelProperty(value = "Mã ngân hàng")
    private String bankCode;
    @ApiModelProperty(value = "Tên viết tắt ngân hàng")
    private String brandName;
    @ApiModelProperty(value = "Tên đầy đủ ngân hàng")
    private String bankName;
    @ApiModelProperty(value = "Ngày tạo")
    private String createDate;
    @ApiModelProperty(value = "Ngày thay đổi")
    private String modifyDate;
    @ApiModelProperty(value = "Trạng thái")
    private String status;
}
