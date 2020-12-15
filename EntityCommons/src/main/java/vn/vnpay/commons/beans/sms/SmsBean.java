package vn.vnpay.commons.beans.sms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Builder
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmsBean {

    private String code;
    private String description;

    private int id;

    private String requestId;
    private String mobile;
    private String email;
    private String fullName;
    private String username;
    private String merchantCode;
    private String merchantBrand;
    private String terminalID;
    private String terminalName;

    private int status;
    private int typeAccount;
    private int channelLogin;

    private String smsType;
    private String lang;
    private String checksum;

}
