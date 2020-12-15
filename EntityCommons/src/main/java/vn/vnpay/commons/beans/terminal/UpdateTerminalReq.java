/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.terminal;

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
import vn.vnpay.commons.annotation.In;
import vn.vnpay.commons.interfaces.UpdateMerchantBranch;
import vn.vnpay.commons.interfaces.UpdateTerminal;
//import vn.vnpay.backend.annotation.ValidatedSafeHtml;
//import vn.vnpay.backend.validategroup.CreateTerminal;

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
public class UpdateTerminalReq {
    
    @Min(value=0, message = "Không có giá trị", groups = {UpdateTerminal.class, UpdateMerchantBranch.class})
    @ApiModelProperty(value = "Key terminal")
    private long id;
    
    @Pattern(regexp = "^[0-9a-zA-Z\\-\\_\\/]{1,20}$", message="Độ dài từ 1 đến 20 ký tự; Không nhập ký tự đặc biệt", groups = {UpdateTerminal.class, UpdateMerchantBranch.class})
    @ApiModelProperty(value = "Mã số thuế/CMND")
    private String merchantCode;
    
    @Pattern(regexp = "^[0-9a-zA-Z]{2,30}$", message = "Độ dài 2-16 ký tự; Không nhập ký tự đặc biệt", groups = {UpdateTerminal.class, UpdateMerchantBranch.class})
    @ApiModelProperty(value = "Mã terminal mới")
    private String terminalId;
    
//    @Pattern(regexp = "^[0-9a-zA-Z]{1,20}$")
//    @ApiModelProperty(value = "Mã merchant tại ASC")
//    private String ascBranch;

    @Size(min = 1, max = 100, message = "Không cho phép bỏ trống; Tối đa 100 ký tự", groups = {UpdateTerminal.class, UpdateMerchantBranch.class})
    @ApiModelProperty(value = "Tên terminal")
    private String terminalName;

    @Length(max = 100, message = "Tối đa 150 ký tự", groups = {UpdateTerminal.class, UpdateMerchantBranch.class})
    @ApiModelProperty(value = "Địa chỉ kinh doanh của terminal")
    private String terminalBusinessAddress;

    @Length(max = 100, message = "Tối đa 100 ký tự", groups = {UpdateTerminal.class, UpdateMerchantBranch.class})
    @ApiModelProperty(value = "Website terminal")
    private String websiteBusiness;

//    @Size(min = 1, max = 10)
    @Min(value=-1, message = "Chưa chọn sản phẩm kinh doanh", groups = {UpdateTerminal.class, UpdateMerchantBranch.class})
    @ApiModelProperty(value = "Sản phẩm kinh doanh")
    private long businessProduct;
    
    @Min(value=1, message = "Không có giá trị", groups = {UpdateTerminal.class, UpdateMerchantBranch.class})
    @ApiModelProperty(value = "MCC nội địa")
    private long mcc;
    
    @Size(min = 0, max = 400, message = "Tối đa 400 ký tự", groups = {UpdateTerminal.class, UpdateMerchantBranch.class})
    @ApiModelProperty(value = "Mô tả sản phẩm kinh doanh")
    private String productDesc;
    
    @Size(min = 0, max = 20, message = "Tối đa 20 ký tự", groups = {UpdateTerminal.class, UpdateMerchantBranch.class})
    @ApiModelProperty(value = "Mã dịch vụ (billing)")
    private String serviceCode;

    @Size(min = 0, max = 100, message = "Tối đa 100 ký tự", groups = {UpdateTerminal.class, UpdateMerchantBranch.class})
    @ApiModelProperty(value = "Facebook")
    private String facebook;

    @Size(min = 1, max = 150, message = "Không được phép để trống; Tối đa 150 ký tự", groups = {UpdateTerminal.class})
    @ApiModelProperty(value = "Chủ tài khoản thụ hưởng")
    private String accountHolder;

    @Size(min = 1, max = 30, message = "Không được phép để trống; Tối đa 30 ký tự", groups = {UpdateTerminal.class})
    @ApiModelProperty(value = "Số tài khoản thụ hưởng")
    private String accountNumber;

    @Size(min = 6, max = 6, message = "Không được phép để trống; Tối thiêu/tối đa 6 ký tự", groups = {UpdateTerminal.class})
    @ApiModelProperty(value = "Mã ngân hàng")
    private String bankCode;

    @Size(min = 1, max = 100, message = "Không được phép để trống; Tối đa 100 ký tự", groups = {UpdateTerminal.class})
    @ApiModelProperty(value = "Chi nhánh")
    private String bankBranch;

    @Size(min = 1, max = 3, message = "Không được phép để trống; Tối đa 3 ký tự", groups = {UpdateTerminal.class, UpdateMerchantBranch.class})
    @ApiModelProperty(value = "Loại tiền tệ")
    private String currency;

//    @Size(min = 0, max = 30, message = "Tối đa 30 ký tự", groups = {UpdateTerminal.class, UpdateMerchantBranch.class})
    @ApiModelProperty(value = "VISA PAN")
    private String visaPan;

    @Size(min = 0, max = 30)
    @ApiModelProperty(value = "MASTER PAN")
    private String masterPan;
    
    @Size(min = 0, max = 30)
    @ApiModelProperty(value = "JCB PAN")
    private String jcbPan;
    
    @Min(value = 0)
    @ApiModelProperty(value = "Fee on us")
    private long feeOnUs;
    
    
    @Min(value = 0)
    @ApiModelProperty(value = "Fee of us")
    private long feeOfUs;
    
    @ApiModelProperty(value = "Đăng ký nhận thông báo SMS. (1: Đăng ký, 2: Không đăng ký)")
    @In(values = {"1","2"}, message = "Giá trị không nằm trong phạm vi cho phép", groups = {UpdateTerminal.class, UpdateMerchantBranch.class})
    private long registerSms;

    @ApiModelProperty(value = "Đăng ký nhận thông báo OTT. (1: Đăng ký, 2: Không đăng ký)")
    @In(values = {"1","2"}, message = "Giá trị không nằm trong phạm vi cho phép", groups = {UpdateTerminal.class, UpdateMerchantBranch.class})
    private long registerOtt;
    
    @ApiModelProperty(value = "Trạng thái terminal")
    private long terminalStatus;
    
//    @Min(value = 0)
//    @ApiModelProperty(value = "Tài khoản vnmart")
//    private long accVnmartId;
    
    
    @Length(max = 15, message = "Tối đa 15 ký tự", groups = {UpdateTerminal.class})
    @Size(min = 1, max = 15, message = "Không cho phép bỏ trống; Tối đa 15 ký tự", groups = {UpdateMerchantBranch.class})
    @ApiModelProperty(value = "App user terminal")
    private String terminalAppUser;
    
//    @Size(min = 0, max = 200)
//    @ApiModelProperty(value = "Tài liệu terminal")
//    private String terminalDocument;
    
//    @Size(min = 0, max = 100)
//    @ApiModelProperty(value = "User tạo")
//    private String createUser;
    
//    @ValidatedSafeHtml(groups = CreateTerminal.class)
    @ApiModelProperty(value = "Thông tin liên hệ")
    private TerminalContact terminalContact;
    
    @ApiModelProperty(value = "Đơn vị phát triển. (id)")
    @Min(value = 1, message = "Không có giá trị", groups = {UpdateMerchantBranch.class})
    private int department;

    @ApiModelProperty(value = "Nhân viên. (id)")
    @Min(value = 1, message = "Không có giá trị", groups = {UpdateMerchantBranch.class})
    private int staff;
    
    @Min(value=1,message = "Không được phép để trống", groups = {UpdateTerminal.class})
    @ApiModelProperty(value = "Id cấp chi nhánh mới")
    private long branchTerminalId;
    
//    @Min(value=1,message = "Không được phép để trống", groups = {UpdateTerminal.class})
    @ApiModelProperty(value = "Id cấp chi nhánh cũ")
    private long oldBranchTerminalId;
    
    @ApiModelProperty(value = "Cấp bậc")
    private long levelTerminal;
    
//    @NotEmpty
    @ApiModelProperty(value = "Data checksum")
    private String hashData;
}
