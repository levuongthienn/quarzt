/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.merchant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vn.vnpay.commons.beans.MerchantInfo;
import vn.vnpay.commons.beans.OrganizationMcBean;
import vn.vnpay.commons.beans.TerminalInfo;
import vn.vnpay.commons.beans.terminal.TerminalContact;

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
@ApiModel(value = "MerchantInfoRes", description = "Dữ liệu Merchant Info")
public class MerchantInfoRes {
    
    @ApiModelProperty(value = "Thông tin merchant")
    @Valid
    private MerchantInfo merchant;
    
    @ApiModelProperty(value = "Thông tin terminal")
    private TerminalInfo terminal;
    
    @ApiModelProperty(value = "Thông tin liên hệ")
    private TerminalContact terminalContact;
    
    @ApiModelProperty(value = "Thông tin Chi nhánh merchant")
    private TerminalInfo terminalBranch;
    
    @ApiModelProperty(value = "Thông tin tổ chức quốc tế")
    private List<OrganizationMcBean> listOrganization;
}
