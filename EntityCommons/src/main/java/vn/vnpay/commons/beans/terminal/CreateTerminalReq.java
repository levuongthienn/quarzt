/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.terminal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vn.vnpay.commons.annotation.In;
import vn.vnpay.commons.interfaces.InsertTerminal;
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
public class CreateTerminalReq {

//    @Valid
    @Pattern(regexp = "^[0-9a-zA-Z]{1,20}$")
    @ApiModelProperty(value = "Mã số thuế/CMND")
    private String merchantCode;
    
    @Valid
    @ApiModelProperty(value = "Thông tin terminal")
    private TerminalBean terminal;
    
//    @ValidatedSafeHtml(groups = CreateTerminal.class)
    @Valid
    @ApiModelProperty(value = "Thông tin liên hệ")
    private TerminalContact terminalContact;
    
//    @NotEmpty
    @ApiModelProperty(value = "Data checksum")
    private String hashData;
    
    @ApiModelProperty(value = "action")
    @In(values = {"SAVE","APPROVED"})
    @Size(min = 0, max = 100, groups = InsertTerminal.class)
    private String action;
}
