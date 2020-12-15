/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.mcc.international;

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
@ApiModel(value = "MccNewReq", description = "Add Mcc Request")
public class MccNewReq {
    @ApiModelProperty(value = "Mã MCC quốc tế")
    @Pattern(regexp = "^[0-9a-zA-Z]{4,50}$", message = "Chỉ cho phép nhập số và ký tự không dấu. Giới hạn từ 4 - 50 ký tự.")
    private String typeCode;
    
    @ApiModelProperty(value = "Tên MCC quốc tế")
    @NotNull
    @Size(min=3, max= 50, message = "Giới hạn từ 3 - 50 ký tự.")
    private String brandName;
    
    @ApiModelProperty(value = "Mô tả")
    @Size(min=0, max= 150, message = "Giới hạn từ 6 - 150 ký tự.")
    private String description;
    
}
