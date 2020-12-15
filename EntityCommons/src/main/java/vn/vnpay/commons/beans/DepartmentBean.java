/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author thanhld
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartmentBean {
    
    @ApiModelProperty(notes = "Id chi nhánh")
    private int departmentId;
    
    @ApiModelProperty(notes = "Mã chi nhánh")
    private String departmentCode;
    
    @ApiModelProperty(notes = "Tên chi nhánh")
    private String departmentName;
}
