/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.qrcode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vn.vnpay.commons.beans.MerchantInfo;
import vn.vnpay.commons.beans.TerminalInfo;

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
public class QrCodeInquiryRes{
    
    private String dataQr;
    
    private MerchantInfo merchantInfo;
    
    private TerminalInfo terminalInfo;
}
