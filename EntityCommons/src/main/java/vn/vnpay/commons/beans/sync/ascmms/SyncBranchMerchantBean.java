/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.sync.ascmms;

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
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import vn.vnpay.commons.interfaces.InsertMerchant;
import vn.vnpay.commons.interfaces.InsertTerminal;

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
public class SyncBranchMerchantBean {
    
    @Pattern(regexp = "^[0-9a-zA-Z]{2,16}$", groups = {InsertMerchant.class}, message="Độ dài từ 2 đến 16 ký tự")
    @ApiModelProperty(value = "Mã terminal")
    private String terminalId;

    @Size(min = 1, max = 20, message = "Không được phép để trống; Tối đa 20 ký tự", groups = {InsertMerchant.class})
    @ApiModelProperty(value = "Tên terminal")
    private String terminalName;

    @Size(min = 0, max = 20, message = "Tối đa 20 ký tự", groups = {InsertMerchant.class})
    @ApiModelProperty(value = "Mã dịch vụ")
    private String tserviceCode;

    @Size(min = 0, max = 150, message = "Tối đa 150 ký tự", groups = {InsertMerchant.class})
    @ApiModelProperty(value = "Địa chỉ kinh doanh của terminal")
    private String terminalBusinessAddress;

    @Size(min = 0, max = 100, message = "Tối đa 100 ký tự", groups = {InsertMerchant.class})
    @ApiModelProperty(value = "Website terminal")
    private String websiteBusiness;

    @Min(value = -1, message = "Chưa chọn giá trị MCC quốc tế", groups = {InsertMerchant.class})
    @ApiModelProperty(value = "Sản phẩm kinh doanh")
    private long businessProduct;
    
    @Min(value = -1, message = "Chưa chọn giá trị MCC nội địa", groups = {InsertMerchant.class})
    @ApiModelProperty(value = "MCC nội địa")
    private long mcc;
    
    @Length(max = 200, message = "Tối đa 200 ký tự", groups = {InsertMerchant.class})
    @ApiModelProperty(value = "Mô tả sản phẩm kinh doanh")
    private String productDesc;

    @Length(max = 100, message = "Tối đa 100 ký tự", groups = {InsertMerchant.class})
    @ApiModelProperty(value = "Facebook")
    private String facebook;

    @NotEmpty(message = "Không được phép để trống", groups = {InsertMerchant.class})
    @Length(max = 100, message = "Tối đa 150 ký tự", groups = {InsertMerchant.class})
    @ApiModelProperty(value = "Chủ tài khoản thụ hưởng")
    private String accountHolder;

    @Pattern(regexp = "^[0-9a-zA-Z]{1,150}$", message="Không được phép để trống; Không nhập ký tự đặc biệt; Tối đa 30 ký tự", groups = {InsertMerchant.class})
    @ApiModelProperty(value = "Số tài khoản thụ hưởng")
    private String accountNumber;

    @Size(min = 6, max = 6, message = "Không được phép để trống; Tối thiểu/Tối đa 6 ký tự", groups = {InsertMerchant.class})
    @ApiModelProperty(value = "Mã ngân hàng")
    private String bankCode;

    @NotEmpty(message = "Không được phép để trống", groups = {InsertMerchant.class})
    @Length(max = 100, message = "Tối đa 100 ký tự")
    @ApiModelProperty(value = "Chi nhánh")
    private String bankBranch;

    @Length(max = 3, message = "Tối đa 3 ký tự", groups = {InsertMerchant.class})
    @ApiModelProperty(value = "Loại tiền tệ", example = "VND")
    private String currency;

    @Length(max = 30, message = "Tối đa 30 ký tự", groups = {InsertMerchant.class})
    @ApiModelProperty(value = "VISA PAN")
    private String visaPan;

    @Length(max = 30, message = "Tối đa 30 ký tự", groups = {InsertMerchant.class})
    @ApiModelProperty(value = "MASTER PAN")
    private String masterPan;

    @Length(max = 30, message = "Tối đa 30 ký tự", groups = {InsertMerchant.class})
    @ApiModelProperty(value = "UNIONPAY PAN")
    private String unionpayPan;

    @ApiModelProperty(value = "Đăng ký dịch vụ QRCODE. (1: Đăng ký, 2: Không đăng ký)")
//    @In(values = {"1", "2"})
    private long registerQrcode;

    @ApiModelProperty(value = "Đăng ký dịch vụ Cổng thanh toán. (1: Đăng ký, 2: Không đăng ký)")
//    @In(values = {"1", "2"})
    private long registerVnpayment;
    
    @Length(max = 30, message = "Tối đa 30 ký tự", groups = {InsertMerchant.class})
    @ApiModelProperty(value = "JCB PAN")
    private String jcbPan;
    
    @Length(max = 30, message = "Tối đa 30 ký tự", groups = {InsertMerchant.class})
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
    
//    @Min(value = 0)
//    @ApiModelProperty(value = "Tài khoản vnmart")
//    private long accVnmartId;
    
    @Pattern(regexp = "^[0-9]{1,13}$", message = "Không được phép để trống; Chỉ nhập số; Tối đa 13 ký tự", groups = {InsertMerchant.class})
    @ApiModelProperty(value = "App user terminal")
    private String terminalAppUser;
    
    @Length(max = 200, message = "Tối đa 200 ký tự", groups = {InsertTerminal.class})
    @ApiModelProperty(value = "Tài liệu terminal")
    private String terminalDocument;
    
    @ApiModelProperty(value = "User tạo")
    private String createUser;
    
    @ApiModelProperty(value = "Cấp bậc terminal. (1: chi nhánh, 2: điểm bán)")
    private long terminalLevel;
    
    @ApiModelProperty(value = "Id cấp chi nhánh")
    private long branchTerminalId;
    
    @ApiModelProperty(value = "Đơn vị phát triển. (id)")
    @Min(value = 1, groups = {InsertMerchant.class})
    private int department;

    @ApiModelProperty(value = "Nhân viên. (id)")
    @Min(value = 1, groups = {InsertMerchant.class})
    private int staff;
}
