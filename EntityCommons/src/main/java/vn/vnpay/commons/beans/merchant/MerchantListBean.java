/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.merchant;

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
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantListBean {

    private int rowNum;
    
    @ApiModelProperty(value = "Mã merchant")
    private String merchantCode;
    
    @ApiModelProperty(value = "Tên merchant")
    private String merchantName;
    
    @ApiModelProperty(value = "ID Loại hình doanh nghiệp/MCC quốc tế")
    private int merchantType;
    
    @ApiModelProperty(value = "Mã loại hình doanh nghiệp/MCC quốc tế")
    private String merchantTypeCode;
    
    @ApiModelProperty(value = "Tên loại hình doanh nghiệp/MCC quốc tế")
    private String merchantTypeName;
    
    @ApiModelProperty(value = "Địa chỉ kinh doanh merchant")
    private String merchantAddress;
    
    @ApiModelProperty(value = "Phần trăm phí")
    private String feePercent;
    
    @ApiModelProperty(value = "Tiền phí")
    private String feeNumber;
    
    @ApiModelProperty(value = "Tên người liên hệ")
    private String contactFullName;
    
    @ApiModelProperty(value = "Số điện thoại liên hệ")
    private String contactPhone;
    
    @ApiModelProperty(value = "Email liên hệ")
    private String contactMail;
//
    @ApiModelProperty(value = "Đăng ký dịch vụ QRCODE")
    private int registerQrCode;
    
    @ApiModelProperty(value = "Đăng ký dịch vụ Cổng thanh toán")
    private int registerVnpayment;

    @ApiModelProperty(value = "Ngày tạo")
    private String createDate;
    
    @ApiModelProperty(value = "Trạng thái")
    private int status;
    
    @ApiModelProperty(value = "Tên trạng thái")
    private String statusStr;
    
    @ApiModelProperty(value = "status class")
    private String statusClass;
    
    @ApiModelProperty(value = "Mô tả trạng thái")
    private String statusDescription;

    @ApiModelProperty(value = "User xử lý")
    private String processUser;
    
    @ApiModelProperty(value = "Lý do")
    private String processDesc;
    
    @ApiModelProperty(value = "Ngày xử lý")
    private String processDate;

    
    @ApiModelProperty(value = "ID denied")
    private int deniedId;
    
    @ApiModelProperty(value = "Tên viết tắt")
    private String merchantBrand;
    
    @ApiModelProperty(value = "Mã phòng ban")
    private String departmentId;
    
    @ApiModelProperty(value = "Tên phòng ban")
    private String departmentName;
}
