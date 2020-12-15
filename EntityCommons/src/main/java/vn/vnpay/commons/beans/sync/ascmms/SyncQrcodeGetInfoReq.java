/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.sync.ascmms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SyncQrcodeGetInfoReq {
    
    @Valid
    @ApiModelProperty(value = "Mã merchant", required = true)
    private String merchantCode;
    
    @Valid
    @ApiModelProperty(value = "Mã terminal", required = true)
    private String terminalId;
    
    @Valid
    @ApiModelProperty(value = "Mã sản phẩm")
    private String productId;
}
