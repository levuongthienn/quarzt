/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.sync.ascmms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
public class SyncCreateTerminalReq {

    @Pattern(regexp = "^[0-9a-zA-Z\\-\\_\\/]{1,20}$")
    @ApiModelProperty(value = "Mã số thuế/CMND")
    private String merchantCode;
    
    @Valid
    @ApiModelProperty(value = "Thông tin terminal")
    private SyncTerminalBean terminal;
    
    @Valid
    @ApiModelProperty(value = "Thông tin liên hệ")
    private SyncTerminalContact terminalContact;
    
    @ApiModelProperty(value = "Data checksum")
    private String hashData;
    
}
