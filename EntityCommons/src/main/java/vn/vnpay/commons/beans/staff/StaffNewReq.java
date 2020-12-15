/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.staff;

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
@ApiModel(value = "StaffNewReq", description = "Add New Staff Request")
public class StaffNewReq {
    @ApiModelProperty(value = "Mã nhân viên", required = true)
    @NotNull
    @Size(min=6, max= 20, message = "Giới hạn từ 6 - 20 ký tự.")
    @Pattern(regexp = "^[0-9a-zA-Z]{6,20}$", message = "Cho phép nhập ký tự chữ, tiếng việt không dấu hoặc số.")
    private String staffCode;
    
    @ApiModelProperty(value = "Họ và tên", required = true)
    @NotNull
    @Size(min=6, max= 80, message = "Giới hạn từ 6 - 80 ký tự.")
    @Pattern(regexp = "^[A-Za-z0-9\\\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ\\s]{6,80}$", message = "Chỉ cho phép nhập số, chữ Tiếng việt và khoảng trắng .")
    private String fullName;
    
    @ApiModelProperty(value = "Email")
    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9]+(?:\\.[A-Za-z0-9]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "Nhập đúng định dạng Email.")
    private String email;
    
    @ApiModelProperty(value = "Số điện thoại")
    @NotNull
    @Pattern(regexp = "(^$)|(((\\+84)|0)([0-9]{9,10}))$", message = "Giới hianj từ 3 - 14 ký tự.")
    private String mobile;
    
    @ApiModelProperty(value = "Mã chi nhánh", required = true)
    @NotNull
    private String departCode;
}
