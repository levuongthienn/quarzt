/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.sync.ascmms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;
//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vn.vnpay.commons.annotation.In;
import vn.vnpay.commons.interfaces.InsertMerchant;
//import vn.vnpay.backend.validategroup.CreateMerchant;


@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SyncMerchantBean {

    @ApiModelProperty(value = "Key merchant tại hệ thống asc", required = true)
    private String ascMid;

    @Size(min = 1, max = 100, message = "Không được phép để trống; Tối đa 100 ký tự", groups = InsertMerchant.class)
    @ApiModelProperty(value = "Tên Merchant")
    private String merchantName;

//    @Pattern(regexp = "(?!^[0-9]*$)(?!^[a-zA-Z!@#$%^&*()_+=<>?]*$)^([a-zA-Z!@#$%^&*.,/()_+=<>?0-9]{1,25})$", message = "Không được phép để trống; Tối đa 25 ký tự; Không nhập ký tự đặc biệt", groups = InsertMerchant.class)
    @ApiModelProperty(value = "Tên viết tắt")
    private String merchantBrand;

    @Size(min = 1, max = 100, message = "Không được phép để trống; Tối đa 100 ký tự", groups = InsertMerchant.class)
    @ApiModelProperty(value = "Master Merchant")
    private String masterMerchant;

    @ApiModelProperty(value = "Mã nhà cung cấp (Billing)")
    @Size(min = 0, max = 100, message = "Tối đa 100 ký tự", groups = InsertMerchant.class)
    private String providerCode;

    @Min(value = -1, message = "Chưa chọn loại hình doanh nghiệp", groups = InsertMerchant.class)
    @ApiModelProperty(value = "Id của loại hình doanh nghiệp")
    private int merchantType;

    @Size(min = 1, max = 150, message = "Không được phép để trống; Tối đa 150 ký tự", groups = InsertMerchant.class)
    @ApiModelProperty(value = "Địa chỉ đăng ký kinh doanh")
    private String merchantAddress;

    @Size(min = 0, max = 150, message = "Tối đa 150 ký tự", groups = InsertMerchant.class)
    @ApiModelProperty(value = "Địa chỉ kinh doanh")
    private String merchantBusinessAddress;

    @Size(min = 2, max = 6, message = "Không được phép để trống; Tối thiểu/Tối đa 2-6 ký tự", groups = InsertMerchant.class)
    @ApiModelProperty(value = "Mã Tỉnh/Thành phố")
    private String province;

    @Size(min = 2, max = 6, message = "Không được phép để trống; Tối thiểu/Tối đa 2-6 ký tự", groups = InsertMerchant.class)
    @ApiModelProperty(value = "Mã Quận/Huyện")
    private String district;

    @Size(min = 0, max = 6, message = "Tối đa 6 ký tự", groups = InsertMerchant.class)
    @ApiModelProperty(value = "Mã Phường/Xã")
    private String wards;

    @ApiModelProperty(value = "Mã bưu điện")
    @Size(min = 0, max = 15, message = "Tối đa 15 ký tự", groups = InsertMerchant.class)
    private String pinCode;

    @Pattern(regexp = "^[0-9a-zA-Z\\-\\_\\/]{1,20}$", message = "Không được phép để trống; Tối đa 20 ký tự; Không nhập ký tự đặc biệt", groups = InsertMerchant.class)
    @ApiModelProperty(value = "Mã số thuế/CMND")
    private String merchantCode;

    @ApiModelProperty(value = "Website doanh nghiệp")
    @Size(min = 0, max = 300, message = "Tối đa 300 ký tự", groups = InsertMerchant.class)
    private String merchantWebsite;

    @ApiModelProperty(value = "User merchant app")
    @Size(min = 0, max = 15, message = "Tối đa 15 ký tự", groups = InsertMerchant.class)
    private String appUser;
    
    @ApiModelProperty(value = "User khởi tạo")
    @Size(min = 0, max = 100, message = "Tối đa 15 ký tự", groups = InsertMerchant.class)
    private String createUser;

    @ApiModelProperty(value = "Đơn vị phát triển. (id)")
    @Min(value = 1, message = "Không được phép để trống", groups = InsertMerchant.class)
    private int department;

    @ApiModelProperty(value = "Nhân viên. (id)")
    @Min(value = 1, message = "Không được phép để trống", groups = InsertMerchant.class)
    private int staff;
    
}
