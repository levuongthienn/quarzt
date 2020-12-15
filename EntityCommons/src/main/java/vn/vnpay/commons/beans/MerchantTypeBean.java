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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author thanhld
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantTypeBean {
    
    @ApiModelProperty(notes = "Id MCC quốc tế")
    private int merchantTypeId;
    
    @ApiModelProperty(notes = "Mã MCC quốc tế")
    private String merchantTypeCode;
    
    @ApiModelProperty(notes = "Tên MCC quốc tế")
    private String merchantTypeName;
}
