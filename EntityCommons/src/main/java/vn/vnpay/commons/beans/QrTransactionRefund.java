package vn.vnpay.commons.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "Dữ liệu giao dịch hoàn", description = "Dữ liệu giao dịch hoàn")
public class QrTransactionRefund {

    @ApiModelProperty(value = "Mã giao dịch gốc")
    private Long id;
    @ApiModelProperty(value = "Mã giao dịch hoàn")
    private Long idRefund;
    @ApiModelProperty(value = "Row Number")
    private Long rowNum;
    @ApiModelProperty(value = "Mã giao dịch của MMS")
    private String qrTrace;
    @ApiModelProperty(value = "Số hóa đơn")
    private String billNumber;
    @ApiModelProperty(value = "Mã thanh toán")
    private String orderCode;
    @ApiModelProperty(value = "Mã đơn hàng")
    private String payCode;

    @ApiModelProperty(value = "Số hóa đơn")
    private String txnId;
    @ApiModelProperty(value = "Nội dung giao dịch.")
    private String txnContent;

    @ApiModelProperty(value = "Mã đại lý")
    private String merchantCode;
    @ApiModelProperty(value = "Tên đại lý")
    private String merchantName;
    @ApiModelProperty(value = "Mã chi nhánh")
    private String terminalIdBrand;
    @ApiModelProperty(value = "Tên chi nhánh")
    private String terminalNameBrand;
    @ApiModelProperty(value = "Mã điểm bán")
    private String terminalId;
    @ApiModelProperty(value = "Tên điểm bán")
    private String terminalName;
    @ApiModelProperty(value = "Loại thanh toán")
    private String payType;
    @ApiModelProperty(value = "Loại hoàn")
    private int typeRefund;
    @ApiModelProperty(value = "Số điện thoại")
    private String mobile;
    @ApiModelProperty(value = "Số tiền yêu cầu hoàn")
    private String initAmountRefund;
    @ApiModelProperty(value = "Số tiền hoàn thực")
    private String amountRefund;
    @ApiModelProperty(value = "Trạng thái")
    private int status;
    @ApiModelProperty(value = "Trạng thái")
    private int statusRefund;
    @ApiModelProperty(value = "Mô tả hoàn")
    private String msgRefund;

    @ApiModelProperty(value = "Nội dung hoàn")
    private String description;

    @ApiModelProperty(value = "User yêu cầu hoàn")
    private String requestedUser;
    @ApiModelProperty(value = "Kênh khởi tạo hoàn")
    private int channel;
    @ApiModelProperty(value = "Thời gian thanh toán - dd/MM/yyyy HH24:mi:ss")
    private String paymentDate;
    @ApiModelProperty(value = "Thời gian gi nhận giao dịch tại MMS - dd/MM/yyyy HH24:mi:ss")
    private String localDate;
    @ApiModelProperty(value = "Thời gian khởi tạo hoàn - dd/MM/yyyy HH24:mi:ss")
    private String initTime;
    @ApiModelProperty(value = "Thời gian hoàn - dd/MM/yyyy HH24:mi:ss")
    private String refundTime;
    private List<QrTransactionDetail> qrTransactionDetails;

    @ApiModelProperty(value = "Mã định danh Master Merchant")
    private String masterMcCode;

    @ApiModelProperty(value = "MCC nội địa")
    private String mcc;
    @ApiModelProperty(value = "MCC quốc tế")
    private String mccGlobal;

    @ApiModelProperty(value = "Tên khách hàng")
    private String customerName;
    @ApiModelProperty(value = "Số tài khoản - số thẻ")
    private String accountNo;
    @ApiModelProperty(value = "Loại thẻ")
    private String typeSource;
    @ApiModelProperty(value = "Mã ngân hàng thanh toán")
    private String bankCode;

    @ApiModelProperty(value = "Số tiền trước KM")
    private String debitAmount;
    @ApiModelProperty(value = "Số tiền sau KM")
    private String realAmount;

    @ApiModelProperty(value = "Loại qrcode")
    private String serviceCode;

    @ApiModelProperty(value = "Mã thanh toán - hệ thống Bank")
    private String phase2Trace;
    @ApiModelProperty(value = "Code - Bank")
    private String phase2Code;
    @ApiModelProperty(value = "Mô tả chi tiết")
    private String phase2Desc;

    @ApiModelProperty(value = "Trừ tiền VNPAY")
    private String phase22Trace;
    @ApiModelProperty(value = "Từ tiền VNPAY Code")
    private String phase22Code;
    @ApiModelProperty(value = "Từ tiền VNPAY Mô tả chi tiết")
    private String phase22Desc;

    @ApiModelProperty(value = "Mã - hệ thống Merchant")
    private String phase3Trace;
    @ApiModelProperty(value = "Code - Merchant")
    private String phase3Code;
    @ApiModelProperty(value = "Mô tả chi tiết")
    private String phase3Desc;
    @ApiModelProperty(value = "Ngày giao dịch phase 3")
    private String phase3Date;

    @ApiModelProperty(value = "Mã hoàn - hệ thống Bank")
    private String phase4Trace;
    @ApiModelProperty(value = "Code - Bank")
    private String phase4Code;
    @ApiModelProperty(value = "Mô tả chi tiết")
    private String phase4Desc;
    @ApiModelProperty(value = "Ngày giao dịch phase 4")
    private String phase4Date;

    @ApiModelProperty(value = "Đảo tiền khách hàng")
    private String phase42Trace;
    @ApiModelProperty(value = "Code 2- Đảo tiền khách hàng")
    private String phase42Code;
    @ApiModelProperty(value = "Mô tả chi tiết 2 Đảo tiền khách hàng")
    private String phase42Desc;
    @ApiModelProperty(value = "Ngày giao dịch phase 4")
    private String phase42Date;
}
