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
@ApiModel(value = "DeoartmentExistCodeReq", description = "Check Exist Department Code Request")
public class DepartmentExistCodeReq {
    @ApiModelProperty(value = "Mã chi nhánh")
    @NotNull
    @Size(min=6, max= 20, message = "Giới hạn từ 6 -20 ký tự.")
    private String departCode;
}
