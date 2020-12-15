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
import vn.vnpay.commons.beans.terminal.BranchMerchantBean;
import vn.vnpay.commons.beans.terminal.TerminalContact;
import vn.vnpay.commons.beans.terminal.TerminalBean;
//import vn.vnpay.backend.annotation.ValidatedSafeHtml;
//import vn.vnpay.backend.validategroup.CreateMerchant;
//import vn.vnpay.backend.annotation.In;
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
public class CreateMerchantReq {
    
//    @ValidatedSafeHtml(groups = CreateMerchant.class)
    @Valid
    @ApiModelProperty(value = "Thông tin merchant")
    private MerchantBean merchant;
    
    @Valid
    @ApiModelProperty(value = "Thông tin chi nhánh")
    private BranchMerchantBean terminalBranch;
    
//    @ValidatedSafeHtml(groups = CreateMerchant.class)
    @Valid
    @ApiModelProperty(value = "Thông tin terminal")
    private TerminalBean terminal;
    
//    @ValidatedSafeHtml(groups = CreateMerchant.class)
    @Valid
    @ApiModelProperty(value = "Thông tin liên hệ")
    private TerminalContact terminalContact;
    
//    @ValidatedSafeHtml(groups = CreateMerchant.class)
    @Valid
    @ApiModelProperty(value = "Thông tin tài liệu")
    private MerchantDocument merchantDoc;
    
//    @NotEmpty
    @ApiModelProperty(value = "Data checksum")
    private String hashData;
    
}
