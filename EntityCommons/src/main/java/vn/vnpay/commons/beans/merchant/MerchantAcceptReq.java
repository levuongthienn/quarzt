/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.merchant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author thanhld
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantAcceptReq {
    
    @ApiModelProperty(value = "User xử lý")
    private String processUser;
    
    @ApiModelProperty(value = "Trạng thái")
    private int status;
    
    @ApiModelProperty(value = "Email")
    private String email;
    
    @ApiModelProperty(value = "Số điện thoại")
    private String phoneNumber;
    
    @ApiModelProperty(value = "Mã merchant")
    private String merchantCode;
    
    @ApiModelProperty(value = "Tên viết tắt merchant")
    private String merchantBrand;
    
    @ApiModelProperty(value = "User merchant")
    @NotNull(message = "User không được phép để trống")
    private String userTerminalBranch;
}
