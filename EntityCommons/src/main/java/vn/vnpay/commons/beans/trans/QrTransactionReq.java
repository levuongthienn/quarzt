package vn.vnpay.commons.beans.trans;

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
@ApiModel(value = "QrTransactionReq: Dữ liệu tìm kiếm chi tiết")
public class QrTransactionReq {

    @Size(max = 10)
    @ApiModelProperty(value = "Mã định danh Master Merchant")
    private String masterMcCode;
    @Size(max = 20)
    @ApiModelProperty(value = "Mã định danh của merchant")
    private String merchantCode;
    @ApiModelProperty(value = "Mã chi nhánh")
    private int terminalIdBrand;
    @ApiModelProperty(value = "Mã điểm bán")
    private String terminalId;
    @ApiModelProperty(value = "Mã ngân hàng thanh toán")
    private String bankCode;
    @ApiModelProperty(value = "Loại thanh toán")
    private String serviceCode;
    @ApiModelProperty(value = "Số điện thoại")
    private String mobile;
    @ApiModelProperty(value = "Số tài khoản - số thẻ")
    private String accountNo;
    @ApiModelProperty(value = "Mã giao dịch của MMS")
    private String qrTrace;
    @ApiModelProperty(value = "Số hóa đơn")
    private String billNumber;
    @ApiModelProperty(value = "Trạng thái", example = "-1")
    private int status;

}
