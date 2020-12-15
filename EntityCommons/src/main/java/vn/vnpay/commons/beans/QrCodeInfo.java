/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author thanhld
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class QrCodeInfo {

    private String id;
    private String merchantCode;
    private String tid;
    private String ccyCode;
    private String amount;
    private String expiredDate;
    private String dataQr;
    private String createdDate;
    private String referenceId;
    private String productName;
    private String imageName;
    private String creator;
    private String payType;
    private String versionQr;
    private String status;
    private String serverId;
    private String dataType;
    private String countryCode;
    private String merchantName;
}
