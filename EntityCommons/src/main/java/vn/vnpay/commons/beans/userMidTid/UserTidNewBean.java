/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.userMidTid;

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
@ApiModel(value = "UserTidNewBean", description = "Data Add User Tid")
public class UserTidNewBean {
    @ApiModelProperty(value = "Mã chi nhánh trên web")
    @NotNull
    private int branchId;
    
    @ApiModelProperty(value = "Mã điểm bán trên web")
    @NotNull
    private String terminalId;
    
    @ApiModelProperty(value = "Tên điểm bán trên web")
    @NotNull
    private String terminalName;
}
