/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.merchantview.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
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
@ApiModel(value = "UserTidUpdateInfoReq", description = "Update Info User Request")
public class UserTidUpdateInfoReq {
    @ApiModelProperty(value = "Mã user")
    @NotNull
    private int userId;
    
    @ApiModelProperty(value = "Id tự sinh của merchant", required = true)
    @NotNull
    private int merchantId;
    
//    @ApiModelProperty(value = "Số điện thoại")
//    @NotNull
//    @Pattern(regexp = "^(\\+84|0)[\\d]+$")
//    @Size(min = 10, max = 11)
//    private String phone;
    
    @ApiModelProperty(value = "Tên đăng nhập", required = true)
    @NotNull
//    @Pattern(regexp = "^(\\+84|0)[\\d]+$")
//    @Size(min = 10, max = 11)
    private String userName;
    
    @ApiModelProperty(value = "Loại tài khoản. 1 la Merchant. 2 la Điểm bán. 3 là Chi nhánh Merchant", required = true, example = "2")
    private int typeAccount;
    
    @ApiModelProperty(value = "Email")
//    @NotNull
    @Pattern(regexp = "(^$)|(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$)")
    @Size(max = 100)
    private String email;
    
    @ApiModelProperty(value = "Danh sách các điểm bán trên web theo merchant đã chọn")
    @NotNull
    private List<UserTidNewBean> listTid;
    
    @ApiModelProperty(value = "Chi nhánh merchant trên app.")
    @NotNull
    private int branchIdApp;
    
    @ApiModelProperty(value = "Điểm bán trên app theo merchant.")
    private String terminalIdApp;
    
    @ApiModelProperty(value = "Mã chức năng của user trên App", example = "1,2,3")
    @NotNull
    private String roleApp;
    
    @ApiModelProperty(value = "Mã chức năng của user trên Web", example = "1,2,3")
    @NotNull
    private String roleWeb;
}
