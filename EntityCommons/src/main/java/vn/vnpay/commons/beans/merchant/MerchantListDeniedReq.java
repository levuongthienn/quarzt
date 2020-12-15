/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.merchant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author thanhld
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantListDeniedReq {

    @Size(min = 0, max = 20)
    @ApiModelProperty(value = "Mã số thuế/CMND")
    private String merchantCode;
    
    @ApiModelProperty(value = "merchant type")
    private int merchantType;
    
    @ApiModelProperty(value = "User xử lý")
    private String processUser;
    
    @ApiModelProperty(value = "id denied")
    private int idDenied;
    
    @ApiModelProperty(value = "Merchant brand")
    private String merchantBrand;
    
    @ApiModelProperty(value = "Loại tìm kiếm: 0-Danh sách merchant bị từ chối, 1- Danh sách lịch sử merchant bị từ chối")
    private String type;
}
