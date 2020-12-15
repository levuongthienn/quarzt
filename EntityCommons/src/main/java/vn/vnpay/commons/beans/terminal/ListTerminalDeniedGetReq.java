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
public class ListTerminalDeniedGetReq {

    @ApiModelProperty(value = "Mã terminal")
    private String terminalId;
    
    @ApiModelProperty(value = "Mã merchant")
    private String merchantId;
    
    @ApiModelProperty(value = "denied id")
    private int deniedId;
    
    @ApiModelProperty(value = "user từ chối")
    private String deniedUser;
    
    @ApiModelProperty(value = "Chi nhánh")
    private String terminalBranchId;
    
    @ApiModelProperty(value = "Cấp bậc")
    private String levelTerminal;
    
    @ApiModelProperty(value = "Loại tìm kiếm: ALL, WAITTING")
    private String type;
    
}
