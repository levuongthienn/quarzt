/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.qrcode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author thanhld
 */
@Getter
@Setter
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenerateQrAPIRequest {

    private String appId;
    private String merchantName;
    private String serviceCode;
    private String countryCode;
    private String masterMerCode;
    private String merchantCode;
    private String merchantType;
    private String terminalId;
    private String payType;
    private String productName;
    private String productId;
    private String txnId;
    private String amount;
    private String tipAndFee;
    private String ccy;
    private String expDate;
    private String desc;
    private String checksum;
    private String creator;
}
