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
import vn.vnpay.commons.annotation.In;
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
public class AcceptTerminalKTReq {

    @ApiModelProperty(value = "Mã terminal")
    private String terminalId;
    
    @ApiModelProperty(value = "Mã merchant")
    private String merchantId;
    
    @ApiModelProperty(value = "User xử lý")
    private String processUser;
    
    @ApiModelProperty(value = "user app terminal")
    private String terminalAppUser;
    
    @ApiModelProperty(value = "app password")
    private String terminalAppPassword;
    
    @ApiModelProperty(value = "Cấp bậc terminal")
    @In(values = {"1","2"}, message = "Giá trị không nằm trong phạm vi cho phép")
    private long terminalLevel;
    
}
