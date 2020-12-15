/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.userMidTid;

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
@ApiModel(value = "HistoryDeviceBean", description = "Data History Active user terminal app")
public class HistoryDeviceBean {
    @ApiModelProperty(value = "Deviceid. Là mã thiết bị di động")
    private long clientId;
    
    @ApiModelProperty(value = "IP request")
    private String requestIP;
    
    @ApiModelProperty(value = "Device. Là tên thiết bị di động")
    private String PM;
    
    @ApiModelProperty(value = "OS. Là loại hệ điều hành của thiết bị di động")
    private String OS;
    
    @ApiModelProperty(value = "Actived Date. Thời gian kích hoạt ứng dụng")
    private String activatedTime;
    
    @ApiModelProperty(value = "Imei. Là mã Imei của thiết bị di động")
    private String imei;
}
