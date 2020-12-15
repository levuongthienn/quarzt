/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.department;

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
@ApiModel(value = "DepartmentNewReq", description = "Add Department Request")
public class DepartmentNewReq {
     @ApiModelProperty(value = "Mã chi nhánh")
    @NotNull
    @Size(min=6, max= 20, message = "Giới hạn từ 6 - 20 ký tự.")
     @Pattern(regexp = "^[0-9a-zA-Z]{6,20}$", message = "Cho phép nhập ký tự chữ, tiếng việt không dấu hoặc số.")
    private String departCode;
    
    @ApiModelProperty(value = "Tên chi nhánh")
    @NotNull
    @Size(min=6, max= 80, message = "Giới hạn từ 6 - 80 ký tự.")
    @Pattern(regexp = "^[A-Za-z0-9\\\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ\\s]{6,80}$", message = "Chỉ cho phép nhập số, chữ Tiếng việt và khoảng trắng .")
    private String departName;
    
    @ApiModelProperty(value = "Mô tả")
    @NotNull
    @Size(min=0, max= 150, message = "Giới hạn từ 6 - 150 ký tự.")
    @Pattern(regexp = "^[A-Za-z0-9\\\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ\\s]*$", message = "Chỉ cho phép nhập số, chữ Tiếng việt và khoảng trắng .")
    private String description;
}
