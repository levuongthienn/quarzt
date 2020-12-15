/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.qrcodemc;

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
@ApiModel(value = "QRCodeSearchReq", description = "Dữ liệu tìm kiếm")
public class QRCodeMcSearchReq {
    
    @ApiModelProperty(value = "Mã điểm bán")
    private String terminalID;
    
    @ApiModelProperty(value = "Trạng thái")
    private int status;
    
    @ApiModelProperty(value = "Mã sản phẩm")
    private String productID;
    
    @ApiModelProperty(value = "Tên sản phẩm")
    private String productName;
}
