package vn.vnpay.commons.beans.mobile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "Cập nhật trạng thái số diện thoại nhận SMS biến động", description = "Cập nhật trạng thái")
public class UpdateStatusMobileReq {

    @ApiModelProperty(value = "Id tự tăng của bảng QR_TERMINAL_PHONE")
    private int id;
    @ApiModelProperty(value = "Trạng thái số điện thoại nhận sms biến động")
    private int status;
}
