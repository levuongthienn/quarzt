package vn.vnpay.commons.beans.trans;

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
@ApiModel(value = "QrTransactionRefundReq: Dữ liệu tìm kiếm quản lý giao dịch hoàn")
public class QrTransactionRefundReq {

    @ApiModelProperty(value = "Mã giao dịch của MMS")
    private String qrTrace;
    @ApiModelProperty(value = "Số hóa đơn - Nếu trong dataQr có số hóa đơn thì lấy trong data, còn nếu ko có thì bằng mã thanh toán")
    private String billNumber;
    @ApiModelProperty(value = "Mã Đơn hàng - Phụ thuộc vào đầu merchant trả ra.")
    private String payCode;
    @ApiModelProperty(value = "Mã thanh toán - Mã bank trả về")
    private String orderCode;
    @ApiModelProperty(value = "Loại thanh toán")
    private String serviceCode;
    @ApiModelProperty(value = "Loại thanh toán - 1: toàn phần, 2: từng phần")
    private String typeRefund;
    @ApiModelProperty(value = "Mã định danh của merchant")
    private String merchantCode;
    @ApiModelProperty(value = "Mã chi nhánh")
    private String terminalIdBrand;
    @ApiModelProperty(value = "Mã điểm bán")
    private String terminalId;
//    @ApiModelProperty(value = "Mã ngân hàng thanh toán")
//    private String bankCode;
    @ApiModelProperty(value = "Số điện thoại")
    private String mobile;
    @ApiModelProperty(value = "Trạng thái", example = "-1")
    private int status;

}
