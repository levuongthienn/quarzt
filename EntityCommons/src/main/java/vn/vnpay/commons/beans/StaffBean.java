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
public class StaffBean {
    
    @ApiModelProperty(notes = "ID nhân viên")
    private int staffId;
    
    @ApiModelProperty(notes = "Mã nhân viên")
    private String staffCode;
    
    @ApiModelProperty(notes = "Tên nhân viên")
    private String staffName;
    
    @ApiModelProperty(notes = "Email nhân viên")
    private String staffEmail;
}
