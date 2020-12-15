package vn.vnpay.main.fake;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QrcodeItem {

    private String qrInfor;
    private String quantity;
    private String note;

}
