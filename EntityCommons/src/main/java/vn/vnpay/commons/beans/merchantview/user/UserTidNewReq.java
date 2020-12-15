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
@ApiModel(value = "UserTidNewReq", description = "Add User Tid Request")
public class UserTidNewReq {
    
    @ApiModelProperty(value = "Id tự sinh của merchant", required = true)
    @NotNull
    private int merchantId;
    
    @ApiModelProperty(value = "Số điện thoại")
    @NotNull
    @Pattern(regexp = "^((\\+84)|0)([0-9]{9,10})$")
//    @Size(min = 10, max = 11)
    private String phone;
    
    @ApiModelProperty(value = "Email")
    @NotNull
    @Pattern(regexp = "(^$)|(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$)")
    @Size(min = 0, max = 100)
    private String email;
    
    @ApiModelProperty(value = "Danh sách các điểm bán trên web theo merchant đã chọn")
    @NotNull
    private List<UserTidNewBean> listTid;
    
    @ApiModelProperty(value = "Chi nhánh merchant trên app.")
    @NotNull
    private int branchId;
    
    @ApiModelProperty(value = "Điểm bán trên app theo merchant.")
    private String terminalId;
    
    @ApiModelProperty(value = "Kênh đăng ký, 1-MMS, 2-MC Site, 3-MC App", example = "1")
    @NotNull
    private int channelRegister;
    
    @ApiModelProperty(value = "Mã chức năng của user trên App", example = "1,2,3")
    @NotNull
    private String roleApp;
    
    @ApiModelProperty(value = "Mã chức năng của user trên Web", example = "1,2,3")
    @NotNull
    private String roleWeb;
}
