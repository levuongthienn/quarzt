/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.merchant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import vn.vnpay.backend.annotation.ValidatedSafeHtml;
//import vn.vnpay.backend.validategroup.CreateMerchant;

/**
 *
 * @author thanhld
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RejectMerchantReq {
    
    @Size(min = 1, max = 20)
    @ApiModelProperty(value = "Mã số thuế/CMND")
    private String merchantCode;
    
    @ApiModelProperty(value = "User xử lý")
    private String processUser;
    
    @ApiModelProperty(value = "processAddition")
    private String processAddition;
    
    @ApiModelProperty(value = "Trạng thái")
    private int status;
    
    @ApiModelProperty(value = "idDenied")
    private int idDenied;
    
    @ApiModelProperty(value = "descDenied")
    private String descDenied;
    
    @ApiModelProperty(value = "createUserEmail")
    private String createUserEmail;
}
