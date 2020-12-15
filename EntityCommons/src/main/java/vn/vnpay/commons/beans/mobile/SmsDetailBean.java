/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.mobile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "SmsDetailBean", description = "Sms info")
public class SmsDetailBean {
    @ApiModelProperty(value = "Mã tự tăng")
    private int id;
    
    @ApiModelProperty(value = "Số thứ tự bản ghi")
    private int rowNum;
    
    @ApiModelProperty(value = "Số điện thoại nhận SMS")
    private String toMobile;
    
    @ApiModelProperty(value = "Loại tin. 1 - Tài khoản, 2- Biến động")
    private int smsType;
    
    @ApiModelProperty(value = "Ngày lưu thông tin trên hệ thống")
    private String localDate;
    
    @ApiModelProperty(value = "Nội dung sms")
    private String content;
    
    @ApiModelProperty(value = "Trạng thái. 1 là Success, -1 là Fail")
    private int status;
    
    @ApiModelProperty(value = "Loại dữ liệu")
    private int dataType;
}
