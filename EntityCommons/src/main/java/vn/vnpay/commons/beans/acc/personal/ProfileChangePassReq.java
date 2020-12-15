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
@ApiModel(value = "ProfileChangePassReq", description = "Change Password Account Personal Request")
public class ProfileChangePassReq {
//    @ApiModelProperty(value = "Tên đăng nhập", required = true)
//    @NotNull
//    private String userName;
    
    @ApiModelProperty(value = "Mật khẩu hiện tại", required = true)
    @NotNull
    @Size(min=6, max= 50, message = "Giới hạn từ 6 - 50 ký tự.")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-zA-Z]).{6,50}$", message = "Cho phép nhập tất cả các loại ký tự, bắt buộc nhập chữ và số.")
    private String passWordOld;
    
    @ApiModelProperty(value = "Mật khẩu mới", required = true)
    @NotNull
    @Size(min=6, max= 50, message = "Giới hạn từ 6 - 50 ký tự.")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-zA-Z]).{6,50}$", message = "Cho phép nhập tất cả các loại ký tự, bắt buộc nhập chữ và số.")
    private String passWordNew;
}
