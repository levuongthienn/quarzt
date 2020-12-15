/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author truongnq
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantDocBean {

    @ApiModelProperty(value = "Giấy phép đăng kí kinh doanh ")
    private String businessCert;

    @ApiModelProperty(value = "Url download Giấy phép đăng kí kinh doanh ")
    private String businessCertUrl;

    @ApiModelProperty(value = "Giấy phép đăng kí tên miền")
    private String domainCert;

    @ApiModelProperty(value = "Url download Giấy phép đăng kí tên miền")
    private String domainCertUrl;

    @ApiModelProperty(value = "Giấy phép đăng ký tài khoản với cơ quan thuế")
    private String businessTaxCert;

    @ApiModelProperty(value = "Url download Giấy phép đăng ký tài khoản với cơ quan thuế")
    private String businessTaxCertUrl;

    @ApiModelProperty(value = "CMND/Thẻ căn cước công dân")
    private String identifyCard;

    @ApiModelProperty(value = "Url download CMND/Thẻ căn cước công dân")
    private String identifyCardUrl;

    @ApiModelProperty(value = "Hợp đồng ký kết")
    private String contract;

    @ApiModelProperty(value = "Url download Hợp đồng ký kết")
    private String contractUrl;

}
