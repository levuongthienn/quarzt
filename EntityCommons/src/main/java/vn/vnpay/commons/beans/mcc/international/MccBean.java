/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.mcc.international;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "MccBean", description = "Mcc Bean")
public class MccBean {
    @ApiModelProperty(value = "Mã mcc quốc tê")
    private String typeCode;
    
    @ApiModelProperty(value = "Tên mcc quốc tế")
    private String brandName;
    
    @ApiModelProperty(value = "Tên đầy đủ")
    private String fullName;
    
    @ApiModelProperty(value = "Mô tả")
    private String description;
    
    @ApiModelProperty(value = "Ngày tạo")
    private String createdDate;
    
    @ApiModelProperty(value = "Ngày cập nhật")
    private String updatedDate;
    
    @ApiModelProperty(value = "Trạng thái. 1: Hoat dong, -1: Dong")
    private int status;
}
