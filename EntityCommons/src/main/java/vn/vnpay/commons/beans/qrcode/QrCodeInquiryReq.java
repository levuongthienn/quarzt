/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.qrcode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;
import vn.vnpay.commons.annotation.In;
//import vn.vnpay.backend.validategroup.QrCode;

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
//@XmlRootElement
public class QrCodeInquiryReq {
    
    @NotEmpty
    @Size(min = 1, max = 20)
    @ApiModelProperty(value = "Mã Merchant")
//    @JsonProperty("merchantId")
    private String merchantId;
    
    @SafeHtml
    @NotEmpty
    @Size(min = 1, max = 20)
    @ApiModelProperty(value = "Mã terminal")
//    @JsonProperty("terminalId")
    private String terminalId;
    
    @NotEmpty
    @ApiModelProperty(required = true, value="qrcode")
    @In(values = {"01","02","03","04"})
    @Pattern(regexp = "^[ 0-9a-zA-Z]{1,25}$")
    private String payType;
    
}
