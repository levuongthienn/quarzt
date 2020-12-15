/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.department;

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
@ApiModel(value = "DepartmentBean", description = "Department Bean")
public class DepartmentBean {
    @ApiModelProperty(value = "Mã tự tăng của chi nhánh")
    private int departId;
    
    @ApiModelProperty(value = "Mã chi nhánh")
    private String departCode;
    
    @ApiModelProperty(value = "Tên chi nhánh")
    private String departName;
    
    @ApiModelProperty(value = "Mô tả")
    private String description;
    
    @ApiModelProperty(value = "Ngày tạo")
    private String createdDate;
    
    @ApiModelProperty(value = "Trạng thái. 1: Hoat dong, -1: Dong")
    private int status;
    
    @ApiModelProperty(value = "Ngày update")
    private String updatedDate;
}
