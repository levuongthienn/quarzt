package vn.vnpay.commons.beans.reportmc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "SumTerminalReq: Dữ liệu tìm kiếm chi tiết")
public class SumTerminalReq {

    @ApiModelProperty(value = "Loại thanh toán")
    private String payType;
    @ApiModelProperty(value = "Loại thanh toán! Tất cả: -1")
    private int status;
    @ApiModelProperty(value = "Mã định danh của chi nhánh merchant")
    private String merchantBranchId;
    @ApiModelProperty(value = "Mã định danh của terminal")
    private String terminalId;
}
