/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.sync.ascmms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
public class SyncCreateMerchantReq {
    
//    @ValidatedSafeHtml(groups = CreateMerchant.class)
    @Valid
    @ApiModelProperty(value = "Thông tin merchant")
    private SyncMerchantBean merchant;
    
//    @Valid
//    @ApiModelProperty(value = "Thông tin chi nhánh")
//    private SyncBranchMerchantBean terminalBranch;
    
//    @ValidatedSafeHtml(groups = CreateMerchant.class)
    @Valid
    @ApiModelProperty(value = "Thông tin terminal")
    private SyncTerminalBean terminal;
    
//    @ValidatedSafeHtml(groups = CreateMerchant.class)
    @Valid
    @ApiModelProperty(value = "Thông tin liên hệ")
    private SyncTerminalContact terminalContact;
    
//    @ValidatedSafeHtml(groups = CreateMerchant.class)
    @Valid
    @ApiModelProperty(value = "Thông tin tài liệu")
    private SyncMerchantDocument merchantDoc;
    
//    @NotEmpty
    @ApiModelProperty(value = "Data checksum")
    private String hashData;
    
}
