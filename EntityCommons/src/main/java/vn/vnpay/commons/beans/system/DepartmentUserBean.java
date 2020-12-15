/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.system;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "UserBranchBean", description = "User Branch staff")
public class DepartmentUserBean {

    @ApiModelProperty(value = "id user")
    private int userId;
    @ApiModelProperty(value = "username")
    private String userName;
    @ApiModelProperty(value = "Id phòng ban")
    private int departmentId;
    @ApiModelProperty(value = "Mã phòng ban")
    private String departmentCode;
    @ApiModelProperty(value = "Tên phòng ban")
    private String departmentName;
    @ApiModelProperty(value = "Trạng thái")
    private int status;
}
