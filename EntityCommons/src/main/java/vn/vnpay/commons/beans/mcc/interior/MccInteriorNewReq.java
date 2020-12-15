/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.mcc.interior;

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
@ApiModel(value = "MccInteriorNewReq", description = "Add Mcc Interior Request")
public class MccInteriorNewReq {
    @ApiModelProperty(value = "Mã MCC nội địa")
    @NotNull
    @Size(min=6, max= 50, message = "Giới hạn từ 6 - 50 ký tự.")
    @Pattern(regexp = "^[0-9a-zA-Z]{6,50}$", message = "Chỉ cho phép nhập số và ký tự không dấu. Giới hạn từ 6- 50 ký tự.")
    private String typeCode;
    
    @ApiModelProperty(value = "Tên MCC nội địa")
    @NotNull
    @Size(min=0, max= 50, message = "Giới hạn từ 0 - 50 ký tự.")
    @Pattern(regexp = "^[A-Za-z0-9\\\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ\\s]*$", message = "Chỉ cho phép nhập số, chữ Tiếng việt và khoảng trắng .")
    private String brandName;
    
    @ApiModelProperty(value = "Mô tả")
//    @NotNull
    @Size(min=0, max= 150, message = "Giới hạn từ 0 - 150 ký tự.")
    @Pattern(regexp = "(^$)|(^[A-Za-z0-9\\\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ\\s]*$)", message = "Chỉ cho phép nhập số, chữ Tiếng việt và khoảng trắng .")
    private String description;
}
