package vn.vnpay.commons.beans.trans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RefundVNPAYBean {
    private String phase2Trace;
    private String masterMcCode;
    private String mcCode;
    private String mobile;
    private String accountNo;
    private String amountRefund;
    private String amountRemain;
    private String debitAmount;
    private String descRefund;
    private String typeRefund;
    private String status;
    private String userId;
    private String bankCode;
    private String payDate;
    private String orderCode;
    private String terminalName;
    private String txnId;
    private String refundDate;
    private String checkSum;
}
