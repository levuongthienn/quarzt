/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.qrcode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "QRCodeCheckProductIdReq", description = "Check ProductId Of Merchant Request")
public class QRCodeCheckProductIdReq {
    @ApiModelProperty(value = "Product id")
    @NotNull
    private String productId;
    
    @ApiModelProperty(value = "Merchant code")
    @NotNull
    private String merchantCode;
    
    @ApiModelProperty(value = "Terminal id")
    @NotNull
    private String terminalId;
}
