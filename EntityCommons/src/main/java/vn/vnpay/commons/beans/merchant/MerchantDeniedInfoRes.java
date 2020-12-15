/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.merchant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vn.vnpay.commons.beans.MerchantInfo;
import vn.vnpay.commons.beans.TerminalInfo;

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
public class MerchantDeniedInfoRes {

    @ApiModelProperty(value = "Thông tin merchant")
    @Valid
    private MerchantInfo merchant;

    @ApiModelProperty(value = "Thông tin terminal")
    private TerminalInfo terminal;
    
    @ApiModelProperty(value = "Thông tin chi nhánh merchant")
    private TerminalInfo terminalBranch;

    @ApiModelProperty(value = "Thông tin liên hệ")
    private vn.vnpay.commons.beans.terminal.TerminalContact terminalContact;

}
