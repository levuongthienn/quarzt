package vn.vnpay.commons.beans.mobile;


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
@ApiModel(value = "Số diện thoại nhận SMS biến động", description = "Dữ liệu tìm kiếm")
public class MobileBean {
    @ApiModelProperty(value = "Id tự tăng của bảng QR_TERMINAL_PHONE")
    private int id;
    @ApiModelProperty(value = "Mã merchant MMS")
    private String merchantCode;
    @ApiModelProperty(value = "Tên merchant MMS")
    private String merchantBrand;
    @ApiModelProperty(value = "Id chi nhánh merchant MMS")
    private int merchantBranchId;
    @ApiModelProperty(value = "Mã chi nhánh merchant MMS")
    private String merchantBranchCode;
    @ApiModelProperty(value = "Tên chi nhánh merchant MMS")
    private String merchantBranchName;
    @ApiModelProperty(value = "Mã điểm bán")
    private String terminalId;
    @ApiModelProperty(value = "Tên điểm bán")
    private String terminalName;
    @ApiModelProperty(value = "Số điện thoại nhận sms biến động")
    private String mobileNum;
    @ApiModelProperty(value = "Ngày thêm mới")
    private String localDate;
    @ApiModelProperty(value = "Trạng thái số điện thoại nhận sms biến động")
    private int status;
    private int rowNum;
}
