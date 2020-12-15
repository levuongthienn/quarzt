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
public class DeniedTerminalReq {

    @ApiModelProperty(value = "Mã key merchant")
    private int merchantId;
    
    @ApiModelProperty(value = "Mã terminal")
    private String terminalId;
    
    @ApiModelProperty(value = "user xử lý")
    private String processUser;

    @ApiModelProperty(value = "thông tin xử lý")
    private String processAddition;
    
    @ApiModelProperty(value = "trạng thái")
    private int status;
    
    @ApiModelProperty(value = "id denied")
    private int idDeniend;
    
    @ApiModelProperty(value = "description denied")
    private String descDeniend;

    @ApiModelProperty(value = "email")
    private String merchantCreateUserEmail;
    
    @ApiModelProperty(value = "mã merchant")
    private String merchantCode;
    
    @ApiModelProperty(value = "tên merchant")
    private String merchantName;
    
    @ApiModelProperty(value = "tên viết tắt merchant")
    private String merchantBrand;
    
    @ApiModelProperty(value = "tên terminal")
    private String terminalName;

}
