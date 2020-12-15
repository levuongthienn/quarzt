/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.mcc.international;

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
@ApiModel(value = "MccSearchReq", description = "Get List Mcc Request")
public class MccSearchReq {
    
    @ApiModelProperty(value = "Mã MCC quốc tế")
    @NotNull
    private String typeCode;
    
    @ApiModelProperty(value = "Tên MCC quốc tế")
    @NotNull
    private String brandName;
}
