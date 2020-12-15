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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "UserMidTidBean", description = "User merchant/terminal web/app Bean")
public class UserMidTidBean {
    @ApiModelProperty(value = "Id tự tăng của user")
    private int id;
    
    @ApiModelProperty(value = "Tên đăng nhập")
    private String userName;
    
    @ApiModelProperty(value = "Số điện thoại")
    private String phone;
    
    @ApiModelProperty(value = "Email")
    private String email;
    
    @ApiModelProperty(value = "Mật khẩu")
    private String password;
    
    @ApiModelProperty(value = "Trạng thái, 1 la hoat dong. 0 la tam khoa. 2 la cho kich hoat. -1 lấy all")
    private int status;
    
    @ApiModelProperty(value = "Id tự tăng merchant")
    private int merchantId;
    
    @ApiModelProperty(value = "Mã merchant")
    private String merchantCode;
    
    @ApiModelProperty(value = "Tên merchant")
    private String merchantName;
    
    @ApiModelProperty(value = "Mã chi nhánh merchant trên app")
    private int branchIdApp;
    
    @ApiModelProperty(value = "Mã điểm bán trên app")
    private String terminalIdApp;
    
    @ApiModelProperty(value = "Tên điểm bán trên app")
    private String terminalNameApp;
    
    @ApiModelProperty(value = "Danh sách điểm bán trên web")
    private List<UserTidNewBean> listTidWeb;
    
    @ApiModelProperty(value = "Loại tài khoản. 1 la Merchant. 2 la Điểm bán. 3 là Chi nhánh Merchant")
    private int typeAccount;
    
    @ApiModelProperty(value = "Kênh đăng ký. 1 la MMS. 2 la MC Site. 3 la MC App")
    private int channelRegister;
    
    @ApiModelProperty(value = "Ngày tạo")
    private String createdDate;
    
    @ApiModelProperty(value = "Is admin. channellogin =1 và parentId = 0 là admin.")
    private int parentId;
    
    @ApiModelProperty(value = "isAdmin = 1 là admin", example = "0")
    private int isAdmin;
    
    @ApiModelProperty(value = "Kênh đăng nhập. 1-la Web. 2-la App")
    private int channelLogin;
    
    @ApiModelProperty(value = "Mã chi nhánh merchant dạng text")
    private String branchMidId;
    
    @ApiModelProperty(value = "Danh sách Chi nhánh merchant của user")
    private List<UserBranchBean> listBranchUser;
    
    @ApiModelProperty(value = "Tên chi nhánh merchant")
    private String branchMidName;
    
    @ApiModelProperty(value = "TerminalId của Chi nhánh trong bảng qr_terminal")
    private String branchCode;
    
    @ApiModelProperty(value = "Mã master merchant")
    private String masterMerchantCode;
    
    @ApiModelProperty(value = "Chức năng trên app")
    private String roleApp;
    
    @ApiModelProperty(value = "Chức năng trên web")
    private String roleWeb;
    
}
