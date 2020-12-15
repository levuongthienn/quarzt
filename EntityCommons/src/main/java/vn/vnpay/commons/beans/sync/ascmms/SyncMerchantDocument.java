/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.sync.ascmms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vn.vnpay.commons.beans.FileBean;

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
public class SyncMerchantDocument {
     
//    @NotBlank(groups = CreateMerchant.class)
    @ApiModelProperty(notes = "Giấy phép đăng ký kinh doanh")
    private FileBean businessCert;
    
    @ApiModelProperty(notes = "Giấy phép đăng ký tên miền")
    private FileBean domainCert;
    
    @ApiModelProperty(notes = "CMND/Thẻ căn cước công dân")
    private FileBean identifyCard;
    
    @ApiModelProperty(notes = "Giấy phép đăng ký tài khoản với cơ quan thuế")
    private FileBean businessTaxCert;
    
    @ApiModelProperty(notes = "Hợp đồng ký kết với VNPAY")
    private FileBean contract;
    
}
