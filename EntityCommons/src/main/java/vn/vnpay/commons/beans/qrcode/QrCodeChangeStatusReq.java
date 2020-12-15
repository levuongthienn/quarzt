/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.qrcode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vn.vnpay.commons.annotation.In;
//import vn.vnpay.backend.annotation.In;
//import vn.vnpay.backend.validategroup.ChangeStatusReq;

/**
 *
 * @author thanhld
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class QrCodeChangeStatusReq {
    
    @Pattern(regexp = "^[0-9a-zA-Z]{1,20}$")
    @ApiModelProperty(required = true, value ="Mã merchant")
    private String merchantId;
    
    @ApiModelProperty(required = true, value ="Mã terminal")
    private String terminalId;
    
    @ApiModelProperty(required = true, value ="Trạng thái QR. 0-Inactive, 1-Active")
    @In(values = {"0", "1"})
    private int status;
    
    @ApiModelProperty(required = true, value ="Loại QR")
    @In(values = {"01","02","03","04"})
    private String payType;
}
