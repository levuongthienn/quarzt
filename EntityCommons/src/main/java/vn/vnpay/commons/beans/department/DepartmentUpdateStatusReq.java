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
@ApiModel(value = "DepartmentUpdateStatusReq", description = "Update Status Department Request")
public class DepartmentUpdateStatusReq {
    @ApiModelProperty(value = "Mã chi nhánh")
    @NotNull
    private String departCode;
    
    @ApiModelProperty(value = "Trạng thái của chi nhánh. 1: Hoat dong, -1: Dong")
    @NotNull
    private int status;
}
