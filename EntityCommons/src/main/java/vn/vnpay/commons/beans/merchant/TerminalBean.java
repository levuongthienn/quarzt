/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.merchant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.SafeHtml;
import vn.vnpay.commons.annotation.In;
//import vn.vnpay.backend.annotation.In;
//import vn.vnpay.backend.validategroup.CreateMerchant;

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
public class TerminalBean {
    @Size(min = 1, max = 100)
    @ApiModelProperty(value = "Mã terminal")
    private String terminalID;
    
    @Pattern(regexp = "^[0-9a-zA-Z]{1,20}$")
    @ApiModelProperty(value = "Mã merchant ASB")
    private String ascBranch;

    @Size(min = 1, max = 100)
    @SafeHtml
    @ApiModelProperty(value = "Tên terminal")
    private String terminalName;

    @Size(min = 0, max = 20)
    @ApiModelProperty(value = "Mã dịch vụ")
    private String tserviceCode;

    @Size(min = 0, max = 150)
    @ApiModelProperty(value = "Địa chỉ kinh doanh của terminal")
    private String terminalBusinessAddress;

    @Size(min = 0, max = 100)
    @ApiModelProperty(value = "Website terminal")
    private String websiteBusiness;

    @Min(value = 0)
    @ApiModelProperty(value = "Sản phẩm kinh doanh")
    private long businessProduct;
    
    @Size(min = 0, max = 10)
    @ApiModelProperty(value = "MCC nội địa")
    private String mcc;

    @Size(min = 0, max = 400)
    @ApiModelProperty(value = "Mô tả sản phẩm kinh doanh")
    private String productDesc;

    @Size(min = 0, max = 100)
    @ApiModelProperty(value = "Facebook")
    private String facebook;

    @Size(min = 1, max = 150)
    @ApiModelProperty(value = "Chủ tài khoản thụ hưởng")
    private String accountHolder;

    @Size(min = 1, max = 30)
    @ApiModelProperty(value = "Số tài khoản thụ hưởng")
    private String accountNumber;

    @Size(min = 6, max = 6)
    @ApiModelProperty(value = "Mã ngân hàng")
    private String bankCode;

    @Size(min = 1, max = 100)
    @ApiModelProperty(value = "Chi nhánh")
    private String bankBranch;

    @Size(min = 1, max = 3)
    @ApiModelProperty(value = "Loại tiền tệ")
    private String currency;

    @Size(min = 0, max = 30)
    @ApiModelProperty(value = "VISA PAN")
    private String visaPan;

    @Size(min = 0, max = 30)
    @ApiModelProperty(value = "MASTER PAN")
    private String masterPan;

    @Size(min = 0, max = 30)
    @ApiModelProperty(value = "UNIONPAY PAN")
    private String unionpayPan;

    @ApiModelProperty(value = "Đăng ký dịch vụ QRCODE. (1: Đăng ký, 2: Không đăng ký)")
    @In(values = {"1", "2"})
    private long registerQrcode;

    @ApiModelProperty(value = "Đăng ký dịch vụ Cổng thanh toán. (1: Đăng ký, 2: Không đăng ký)")
    @In(values = {"1", "2"})
    private long registerVnpayment;
    
    @Size(min = 0, max = 30)
    @ApiModelProperty(value = "JCB PAN")
    private String jcbPan;
    
    @Size(min = 0, max = 30)
    @ApiModelProperty(value = "DCI PAN")
    private String dciPan;
    
    
    @Min(value = 0)
    @ApiModelProperty(value = "Fee on us")
    private long feeOnUs;
    
    @Min(value = 0)
    @ApiModelProperty(value = "Fee of us")
    private long feeOfUs;
    
    @ApiModelProperty(value = "Đăng ký nhận thông báo SMS. (1: Đăng ký, 2: Không đăng ký)")
    private long registerSms;

    @ApiModelProperty(value = "Đăng ký nhận thông báo OTT. (1: Đăng ký, 2: Không đăng ký)")
    private long registerOtt;
    
    
}
