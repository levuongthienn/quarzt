package vn.vnpay.commons.beans.mobile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "Thêm mới và chỉnh sửa số diện thoại nhận SMS biến động", description = "Thêm mới và chỉnh sửa")
public class AddOrUpdateMobileReq {
    @ApiModelProperty(value = "Id tự tăng của bảng QR_TERMINAL_PHONE")
    private int id;
    @ApiModelProperty(value = "Mã merchant MMS")
    @NotNull
    @NotBlank
    private String merchantCode;
    @ApiModelProperty(value = "Mã chi nhánh merchant MMS")
    private int merchantBranchId;
    @ApiModelProperty(value = "Mã điểm bán")
    @NotNull
    @NotBlank
    private String terminalId;
    @ApiModelProperty(value = "Số điện thoại nhận sms biến động")
    private String mobileNum;
    @ApiModelProperty(value = "Trạng thái số điện thoại nhận sms biến động")
    private int status;
}
