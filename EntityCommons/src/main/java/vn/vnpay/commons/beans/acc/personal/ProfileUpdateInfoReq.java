/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.acc.personal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
@ApiModel(value = "ProfileUpdateInfo", description = "Update Info Account Personal Request")
public class ProfileUpdateInfoReq {
//    @ApiModelProperty(value = "Tên đăng nhập")
//    @NotNull
//    private String userName;
    
    @ApiModelProperty(value = "Họ và tên")
    @NotNull
    @Size(max= 200, message = "Giới hạn 200 ký tự.")
    private String fullName;
    
    @ApiModelProperty(value = "Email")
    @NotNull
    @Size(max= 200, message = "Giới hạn 200 ký tự.")
    @Pattern(regexp = "(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$)")
    private String email;
    
    @ApiModelProperty(value = "Số điện thoại")
    @NotNull
    @Size(max= 200, message = "Giới hạn 200 ký tự.")
    @Pattern(regexp = "((\\+84)|0)([0-9])$")
    private String phone;
}
