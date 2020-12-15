package vn.vnpay.commons.beans.mobile;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "Tìm kiếm số diện thoại nhận SMS biến động", description = "Tìm kiếm")
public class ListMobileReq {
    @ApiModelProperty(value = "Mã merchant MMS")
    private String merchantCode;
    @ApiModelProperty(value = "Mã chi nhánh merchant MMS")
    private String merchantBranchId;
    @ApiModelProperty(value = "Tên điểm bán")
    private String terminalId;
    @ApiModelProperty(value = "Số điện thoại nhận sms biến động")
    private String mobileNum;
    @ApiModelProperty(value = "Trạng thái số điện thoại nhận sms biến động")
    private int status;
}
