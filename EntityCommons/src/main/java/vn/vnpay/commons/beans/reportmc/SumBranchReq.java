package vn.vnpay.commons.beans.reportmc;


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
@ApiModel(value = "SumBranchReq: Dữ liệu tìm kiếm chi tiết")
public class SumBranchReq {

    @ApiModelProperty(value = "Loại thanh toán")
    private String payType;
    @ApiModelProperty(value = "Trạng thái")
    private int status;
    @ApiModelProperty(value = "Mã định danh của chi nhánh merchant")
    private String merchantBranchId;
}
