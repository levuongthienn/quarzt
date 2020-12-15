/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.terminal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vn.vnpay.commons.beans.MerchantInfo;
import vn.vnpay.commons.beans.TerminalInfo;
//import vn.vnpay.backend.annotation.ValidatedSafeHtml;
//import vn.vnpay.backend.validategroup.CreateTerminal;

/**
 *
 * @author thanhld
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TerminalDeniedInfoRes {

    @ApiModelProperty(value = "Thông tin merchant")
    private MerchantInfo merchantBean;
    
    @ApiModelProperty(value = "Thông tin terminal")
    private TerminalInfo terminalBean;
    
    @ApiModelProperty(value = "Thông tin terminal")
    private TerminalContact terminalContact;
    
}
