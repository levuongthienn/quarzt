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
@ApiModel(value = "Dữ liệu giao dịch", description = "Dữ liệu giao dịch")
public class QrTransaction {
    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "Row Number")
    private Long rowNum;

    @ApiModelProperty(value = "isOnline")
    private boolean isOnline;

    @ApiModelProperty(value = "Số điện thoại")
    private String mobile;
    @ApiModelProperty(value = "Tên khách hàng")
    private String customerName;
    @ApiModelProperty(value = "Số tài khoản - số thẻ")
    private String accountNo;
    @ApiModelProperty(value = "Loại thẻ")
    private String typeSource;

    @ApiModelProperty(value = "Mã giao dịch của MMS")
    private String qrTrace;
    @ApiModelProperty(value = "Mã thanh toán")
    private String orderCode;
    @ApiModelProperty(value = "Thời gian thanh toán - dd/MM/yyyy HH24:mi:ss")
    private String paymentDate;
    @ApiModelProperty(value = "Thời gian gi nhận giao dịch tại MMS - dd/MM/yyyy HH24:mi:ss")
    private String localDate;
    @ApiModelProperty(value = "Mã đơn hàng")
    private String billNumber;

    @ApiModelProperty(value = "Trạng thái")
    private int status;

    @ApiModelProperty(value = "Mã lỗi giao dịch")
    private String resCodeTrans;

    @ApiModelProperty(value = "Loại qrcode")
    private String serviceCode;
    @ApiModelProperty(value = "Loại thanh toán")
    private String payType;

    @ApiModelProperty(value = "Số tiền trước KM")
    private String debitAmount;
    @ApiModelProperty(value = "Số tiền sau KM")
    private String realAmount;
    @ApiModelProperty(value = "Số tiền tip&fee")
    private String tipFee;
    @ApiModelProperty(value = "Mã ngân hàng thanh toán")
    private String bankCode;

    @ApiModelProperty(value = "Mã định danh Master Merchant")
    private String masterMcCode;

    @ApiModelProperty(value = "Mã điểm bán")
    private String terminalId;
    @ApiModelProperty(value = "Tên điểm bán")
    private String terminalName;

    @ApiModelProperty(value = "Mã chi nhánh")
    private String terminalIdBrand;
    @ApiModelProperty(value = "Tên chi nhánh")
    private String terminalNameBrand;

    @ApiModelProperty(value = "Mã định danh của merchant")
    private String merchantCode;
    @ApiModelProperty(value = "Tên merchant")
    private String merchantName;
    @ApiModelProperty(value = "MCC nội địa")
    private String mcc;
    @ApiModelProperty(value = "MCC quốc tế")
    private String mccGlobal;

    @ApiModelProperty(value = "Nội dung giao dịch.")
    private String txnContent;

    @ApiModelProperty(value = "Mã đơn hàng")
    private String payCode;
    @ApiModelProperty(value = "Số hóa đơn")
    private String txnId;

    private String termBilling;

    @ApiModelProperty(value = "Ghi chú thay đổi trạng thái giao dịch")
    private String noteChangeStatus;

    @ApiModelProperty(value = "Trừ tiền khách hàng - hệ thống Bank")
    private String phase2Trace;
    @ApiModelProperty(value = "Trừ tiền khách hàng Code - Bank")
    private String phase2Code;
    @ApiModelProperty(value = "Mô tả chi tiết trừ tiền khách hàng")
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

    @ApiModelProperty(value = "Đảo tiền VNPAY")
    private String phase4Trace;
    @ApiModelProperty(value = "Code - Đảo tiền VNPAY")
    private String phase4Code;
    @ApiModelProperty(value = "Mô tả chi tiết Đảo tiền VNPAY")
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

    @ApiModelProperty(value = "Mô tả chi tiết")
    private String additionalData;

    @ApiModelProperty(value = "Loại tiền gốc")
    private String originalCurrency;

    @ApiModelProperty(value = "Tỉ giá")
    private String rate;

    @ApiModelProperty(value = "Loại tiền quy đổi")
    private String destCurrency;

    @ApiModelProperty(value = "Số tiền quy đổi trước KM")
    private String destDebitAmount;

    @ApiModelProperty(value = "Số tiền quy đổi sau KM")
    private String destRealAmount;

    @ApiModelProperty(value = "Tiền phí giao dịch qr thái lan")
    private String feeFixed;

    private List<RefundBean> refundBeans;
    private List<QrTransactionDetail> qrTransactionDetails;
}
