/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.mobile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "SmsSearchReq", description = "Get list SMS request")
public class SmsSearchReq {
    @Min(0)
    @ApiModelProperty(value = "Từ record")
    private int fromRow;

    @Min(0)
    @Max(100)
    @ApiModelProperty(value = "Số lượng record lấy ra", example = "10")
    private int pageSize;
    
    @ApiModelProperty(value = "Số điện thoại")
    private String mobile;
    
    @ApiModelProperty(value = "Loại tin. 1 - Tài khoản, 2- Biến động")
    private int smsType;
    
    @ApiModelProperty(value = "Từ ngày", example = "01/01/2019 00:00:00")
    private String fromDate;
    
    @ApiModelProperty(value = "Đến ngày", example = "31/12/2020 00:00:00")
    private String toDate;
}
