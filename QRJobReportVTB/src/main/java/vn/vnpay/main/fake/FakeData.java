package vn.vnpay.main.fake;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import vn.vnpay.commons.http.OkHttpManager;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class FakeData implements Runnable {

    Logger LOG = LogManager.getLogger(FakeData.class);
    Random rd = new Random();
    DateFormat dfm = new SimpleDateFormat("yyyyMMddHHmmss");


    @Override
    public void run() {
        String token = RandomStringUtils.random(15, true, true);
        System.out.println(11111);
        ThreadContext.put("token", token);
        QrPayment qrPayment = makeQrPayment(token);
        OkHttpManager.getInstance().post(qrPayment, "http://10.22.7.123:8004/PaymentApi/rest/QrcodePayment/paymentService");
    }

    private QrPayment makeQrPayment(String token) {

        QrcodeItem qrcodeItem = QrcodeItem.builder()
                .note("hungnv test giao dich")
                .qrInfor(getValue(QrDefault.qr))
                .quantity("1")
                .build();
        return QrPayment.builder()
                .userName(getValue(QrDefault.usernames))
                .accountNo(getValue(QrDefault.mobile))
                .mobile(getValue(QrDefault.mobile))
                .debitAmount(BigDecimal.valueOf(rd.nextInt(1000000)))
                .transactionReference(token)
                .bankCode(getValue(QrDefault.bank))
                .orderCode(String.valueOf(rd.nextInt(10000)))
                .respCode(getValue(QrDefault.status))
                .respDesc("Thanh Cong")
                .traceTransfer(String.valueOf(rd.nextInt(10000)))
                .messageType("1")
                .payDate(dfm.format(new Date()))
                .item(Arrays.asList(qrcodeItem))
                .build();
    }


    private String getValue(String[] strs) {
        return strs[rd.nextInt(strs.length)];
    }
}
