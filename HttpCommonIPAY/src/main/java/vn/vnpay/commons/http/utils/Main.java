package vn.vnpay.commons.http.utils;

import com.google.gson.Gson;
import vn.vnpay.commons.http.OkHttpManager;

public class Main {


    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        String data = "{\"code\":\"00\",\"message\":\"Tru tien thanh cong, so trace 501677\",\"msgType\":\"1\",\"txnId\":\"7efe5205\",\"qrTrace\":\"000177835\",\"bankCode\":\"VIETCOMBANK\",\"mobile\":\"0949100109\",\"accountNo\":\"\",\"amount\":\"100000\",\"payDate\":\"20200106113109\",\"masterMerCode\":\"A000000775\",\"merchantCode\":\"0106539659\",\"terminalId\":\"FPLUS06\",\"addData\":[{\"merchantType\":\"4816\",\"serviceCode\":\"06\",\"masterMerCode\":\"A000000775\",\"merchantCode\":\"0106539659\",\"terminalId\":\"FPLUS06\",\"productId\":\"\",\"amount\":\"100000\",\"ccy\":\"704\",\"qty\":\"1\",\"note\":\"\"}],\"checksum\":\"C975B97224B01D6736398001FEEFCC11\",\"ccy\":\"704\",\"address\":\"\",\"secretKey\":\"VNPAY\"}";
        String url = "https://nob-stag.glxplay.io/billing/vnpay/callback";

        String res = OkHttpManager.getInstance().post(data, url);
        System.out.println(res);
    }
}
