/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.merchant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import vn.vnpay.backend.annotation.ValidatedSafeHtml;
//import vn.vnpay.backend.validategroup.CreateMerchant;

/**
 *
 * @author thanhld
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantDetailRes {
    private int id;
    private String merchantCode;
    private String merchantName;
    private String merchantBrand;
    private String masterMerchantCode;
    private String masterMerchant;
    private String providerCode;
    private int merchantType;
    private String merchantTypeCode;
    private String merchantTypeName;
    private int status;
    private String statusClass;
    private String statusDescription;
    private String website;
    private String address;
    private String merchantBusinessAddress;
    private String provinceCode;
    private String provinceName;
    private String districtCode;
    private String districtName;
    private String businessCert;
    private String businessCertUrl;
    private String domainCert;
    private String domainCertUrl;
    private String businessTaxCert;
    private String businessTaxCertUrl;
    private String identifyCard;
    private String identifyCardUrl;
    private String contract;
    private String contractUrl;
    private int departmentId;
    private String departmentCode;
    private String departmentName;
    private int staffId;
    private String staffName;
    private String staffCode;
    private String nickName;
    private int terminalSize;
    private String createUser;
    private String appUser;
    private String merchantSiteUser;
    private String pinCode;
    private String listOrganization;
    private String numOfTer;
}
