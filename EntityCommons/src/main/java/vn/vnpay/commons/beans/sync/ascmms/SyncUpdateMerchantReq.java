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
//import vn.vnpay.backend.annotation.ValidatedSafeHtml;
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
public class SyncUpdateMerchantReq {
    
//    @Size(min = 1, max = 100)
//    @ApiModelProperty(value = "Merchant ID")
//    private long id;
    
//    @Pattern(regexp = "^[0-9a-zA-Z\\-\\_\\/]{1,20}$", message = "Không được phép để trống; Tối đa 20 ký tự; Không nhập ký tự đặc biệt")
    @ApiModelProperty(value = "Mã số thuế/CMND cũ")
    private String oldMerchantCode;
    
    @Pattern(regexp = "^[0-9a-zA-Z\\-\\_\\/]{1,20}$", message = "Không được phép để trống; Tối đa 20 ký tự; Không nhập ký tự đặc biệt")
    @ApiModelProperty(value = "Mã số thuế/CMND mới")
    private String merchantCode;
    
    @Pattern(regexp = "^[A-Za-z0-9\\s]{1,20}+$", message = "Không được phép để trống; Tối đa 25 ký tự; Không nhập ký tự đặc biệt")
    @ApiModelProperty(value = "Tên viết tắt")
    private String merchantBrand;
    
    @Size(min = 1, max = 100, message = "Không được phép để trống; Tối đa 100 ký tự")
    @ApiModelProperty(value = "Tên Merchant cũ")
    private String oldMerchantName;
    
    @Size(min = 1, max = 100, message = "Không được phép để trống; Tối đa 100 ký tự")
    @ApiModelProperty(value = "Tên Merchant mới")
    private String merchantName;
    
    @Size(min = 1, max = 100, message = "Không được phép để trống; Tối đa 100 ký tự")
    @ApiModelProperty(value = "Master Merchant")
    private String masterMerchant;
    
    @ApiModelProperty(value = "Mã nhà cung cấp (Billing)")
    @Size(min = 0, max = 100, message = "Tối đa 100 ký tự")
    private String providerCode;
    
    @Min(value = -1, message = "Chưa chọn loại hình doanh nghiệp")
    @ApiModelProperty(value = "Id của loại hình doanh nghiệp")
    private int merchantType;
    
    @Size(min = 1, max = 150, message = "Không được phép để trống; Tối đa 150 ký tự")
    @ApiModelProperty(value = "Địa chỉ đăng ký kinh doanh") 
    private String merchantAddress;

    @Size(min = 0, max = 150, message = "Tối đa 150 ký tự")
    @ApiModelProperty(value = "Địa chỉ kinh doanh")
    private String merchantBusinessAddress;

    @Size(min = 2, max = 6, message = "Không được phép để trống; Tối thiểu/Tối đa 2-6 ký tự")
    @ApiModelProperty(value = "Mã Tỉnh/Thành phố")
    private String province;

    @Size(min = 2, max = 6, message = "Không được phép để trống; Tối thiểu/Tối đa 2-6 ký tự")
    @ApiModelProperty(value = "Mã Quận/Huyện")
    private String district;
    
    
    @ApiModelProperty(value = "Website doanh nghiệp")
    @Size(min = 0, max = 300, message = "Tối đa 300 ký tự")
    private String merchantWebsite;
    
    @ApiModelProperty(value = "Trạng thái merchant")
    private int merchantStatus;
    
    @ApiModelProperty(value = "User merchant app")
    @Size(min = 0, max = 15, message = "Tối đa 15 ký tự")
    private String appUser;
    
    @ApiModelProperty(value = "Mã bưu điện")
    @Size(min = 0, max = 15, message = "Tối đa 15 ký tự")
    private String pinCode;
    
    @ApiModelProperty(value = "Đơn vị phát triển. (id)")
    @Min(value = 1, message = "Không được phép để trống")
    private int department;

    @ApiModelProperty(value = "Nhân viên. (id)")
    @Min(value = 1, message = "Không được phép để trống")
    private int staff;
    
//    @ValidatedSafeHtml(groups = CreateMerchant.class)
    @ApiModelProperty(value = "Thông tin tài liệu")
    private SyncMerchantDocument merchantDoc;
    
//    @Pattern(regexp = "^[0-9a-zA-Z]{1,20}$")
//    @ApiModelProperty(value = "Mã merchant ASB")
//    private String ascBranch;
    
//    @NotEmpty
    @ApiModelProperty(value = "Data checksum")
    private String hashData;
    
    @ApiModelProperty(value = "User update", required = true)
    private String modifyUser;
}
