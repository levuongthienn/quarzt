/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.mcc.interior;

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
@ApiModel(value = "MccInteriorUpdateStatusReq", description = "Update Status Mcc Interior Request")
public class MccInteriorUpdateStatusReq {
    @ApiModelProperty(value = "Mã MCC nội địa")
    @NotNull
    private String typeCode;
    
    @ApiModelProperty(value = "Trạng thái. 1: hoat dong, -1: tam khoa")
    @NotNull
    private int status;
}
