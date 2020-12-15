package vn.vnpay.main.fake;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class QrPayment {

    private String mobile;
    private String bankCode;
    private String accountNo;
    private String payDate;
    private BigDecimal debitAmount;
    private String respCode;
    private String respDesc;
    private String traceTransfer;
    private String messageType;
    private String tipAndFee;
    private List<QrcodeItem> item;
    private String checkSum;
    private String orderCode; // Ma don hang

    private String userName; // Ten day du cua tai khoan app banking

    private String realAmount; // So tien thuc tru tai ngan hang sau khi tru tien khuyen
    private String promotionCode; // Ma khuyen mai

    private String cardAccountNo;

    private String senderAccountNumber; // So tien thuc tru tai ngan hang sau khi tru tien khuyen
    private String senderName; // Ma khuyen mai
    private String typeMessage; // ty gia
    private String orgBankName; // ten ngan hang thanh toan

    private String transactionReference; // Onus
}
