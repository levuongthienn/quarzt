/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.merchantview.user;

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
@ApiModel(value = "UserTerminalBean", description = "User Terminal Web Bean")
public class UserBranchBean {
    @ApiModelProperty(value = "Tên chi nhánh merchant")
    private String branchName;
    
    @ApiModelProperty(value = "Mã chi nhánh merchant")
    private String branchCode;
    
    @ApiModelProperty(value = "Mã tự tăng chi nhánh merchant")
    private int branchId;
}
