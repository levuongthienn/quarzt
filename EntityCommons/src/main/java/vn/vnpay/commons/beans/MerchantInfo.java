/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author thanhld
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantInfo {
    
    @ApiModelProperty(value = "Key merchant")
    private long id;
    
    @ApiModelProperty(value = "Mã merchant")
    private String merchantCode;
    
    @ApiModelProperty(value = "serviceCode")
    private String serviceCode;
    
    @ApiModelProperty(value = "Tên viết tắt merchant")
    private String merchantBrand;
    
    @ApiModelProperty(value = "Tên merchant")
    private String merchantName;
    
    @ApiModelProperty(value = "Thông tin MCC quốc tế")
    private MerchantTypeBean merchantTypeBean;
    
//    @ApiModelProperty(value = "Loại hình doanh nghiệp/MCC quốc tế")
//    private int merchantType;
//    
//    @ApiModelProperty(value = "Mã loại hình doanh nghiệp/MCC quốc tế")
//    private String merchantTypeCode;
//    
//    @ApiModelProperty(value = "Tên loại hình doanh nghiệp/MCC quốc tế")
//    private String merchantTypeName;
    
    @ApiModelProperty(value = "Địa chỉ đăng ký kinh doanh")
    private String address;
    
    @ApiModelProperty(value = "Mô tả")
    private String description;
    
    @ApiModelProperty(value = "Trạng thái merchant")
    private int status;
    
    @ApiModelProperty(value = "statusClass")
    private String statusClass;
    
    @ApiModelProperty(value = "Tên trạng thái merchant")
    private String statusDescription;
    
    @ApiModelProperty(value = "website")
    private String website;
    
    @ApiModelProperty(value = "Master merchant")
    private String masterMerchantCode;
    
    @ApiModelProperty(value = "Mã tỉnh/thành phố")
    private String provinceCode;
    
    @ApiModelProperty(value = "Tên tỉnh/thành phố")
    private String provinceName;
    
    @ApiModelProperty(value = "Mã Quận/Huyện")
    private String districtCode;
    
    @ApiModelProperty(value = "Tên Quận/Huyện")
    private String districtName;
    
    @ApiModelProperty(value = "Thông chi nhánh phát riển")
    private DepartmentBean departmentBean;
    
//    @ApiModelProperty(value = "Mã chi nhánh")
//    private int departmentId;
//    
//    @ApiModelProperty(value = "Tên chi nhánh")
//    private String departmentName;
    
    @ApiModelProperty(value = "Thông nhân viên")
    private StaffBean staffBean;
    
//    @ApiModelProperty(value = "ID nhân viên")
//    private int staffId;
//    
//    @ApiModelProperty(value = "Mã nhân viên")
//    private String staffCode;
//    
//    @ApiModelProperty(value = "Tên nhân viên")
//    private String staffName;
    
//    @ApiModelProperty(value = "Email nhân viên")
//    private String staffEmail;
    
    @ApiModelProperty(value = "genqrChecksum")
    private String genqrChecksum;
    
    @ApiModelProperty(value = "genqrAccesskey")
    private String genqrAccesskey;
    
    @ApiModelProperty(value = "switchCode")
    private String switchCode;
    
    @ApiModelProperty(value = "Ngày tạo")
    private String createdDate;
    
    @ApiModelProperty(value = "Ngày cập nhật")
    private String modifyDate;
    
    @ApiModelProperty(value = "User xử lý")
    private String processUser;
    
    @ApiModelProperty(value = "Mô tả xử lý")
    private String processDesc;
    
    @ApiModelProperty(value = "deniedApproveDesc")
    private String deniedApproveDesc;
    
    @ApiModelProperty(value = "createUser")
    private String createUser;
    
    @ApiModelProperty(value = "createUserEmail")
    private String createUserEmail;
    
    @ApiModelProperty(value = "orgStatus")
    private int orgStatus;
    
    @ApiModelProperty(value = "emailVnpay")
    private String emailVnpay;
    
    @ApiModelProperty(value = "passEmailVnpay")
    private String passEmailVnpay;
    
    @ApiModelProperty(value = "processAddition")
    private String processAddition;
    
    @ApiModelProperty(value = "deniedApproveCode")
    private String deniedApproveCode;
    
    @ApiModelProperty(value = "Địa chỉ kinh doanh")
    private String businessAddress;
    
    @ApiModelProperty(value = "User app")
    private String appUser;
    
    @ApiModelProperty(value = "User merchant site")
    private String merchantSiteUser;
    
    @ApiModelProperty(value = "Mã bưu điện")
    private String pinCode;
    
    @ApiModelProperty(value = "Mã Tỉnh/Thành phố")
    private String providerCode;
    
    @ApiModelProperty(value = "Giấy phép đăng kí kinh doanh ")
    private String businessCert;
    
    @ApiModelProperty(value = "Url download Giấy phép đăng kí kinh doanh ")
    private String businessCertUrl;
    
    @ApiModelProperty(value = "Giấy phép đăng kí tên miền")
    private String domainCert;
    
    @ApiModelProperty(value = "Url download Giấy phép đăng kí tên miền")
    private String domainCertUrl;
    
    @ApiModelProperty(value = "Giấy phép đăng ký tài khoản với cơ quan thuế")
    private String businessTaxCert;
    
    @ApiModelProperty(value = "Url download Giấy phép đăng ký tài khoản với cơ quan thuế")
    private String businessTaxCertUrl;
    
    @ApiModelProperty(value = "CMND/Thẻ căn cước công dân")
    private String identifyCard;
    
    @ApiModelProperty(value = "Url download CMND/Thẻ căn cước công dân")
    private String identifyCardUrl;
    
    @ApiModelProperty(value = "Hợp đồng ký kết")
    private String contract;
    
    @ApiModelProperty(value = "Url download Hợp đồng ký kết")
    private String contractUrl;
    
    @ApiModelProperty(value = "nickName")
    private String nickName;
}
