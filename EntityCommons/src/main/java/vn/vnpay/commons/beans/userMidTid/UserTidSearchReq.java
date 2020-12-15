/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.userMidTid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "UserTidSearchReq", description = "Get List User Request")
public class UserTidSearchReq {
    @ApiModelProperty(value = "Mã merchant")
    private int merchantId;
    
    @ApiModelProperty(value = "Mã chi nhánh merchant")
    private int merchantBranchId;
    
    @ApiModelProperty(value = "Mã điểm bán")
    private String terminalId;
    
    @ApiModelProperty(value = "Số điện thoại")
    private String phone;
    
    @ApiModelProperty(value = "Email")
//    @NotNull
    private String email;
    
    @ApiModelProperty(value = "Loại tài khoản")
    private int typeAccount;
    
    @ApiModelProperty(value = "Kênh đăng ký")
    private int channelRegister;
    
    @ApiModelProperty(value = "Trạng thái", example = "-1")
    private int status;
}
