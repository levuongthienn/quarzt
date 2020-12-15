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
public class MerchantListReq {

    @Size(min = 0, max = 20)
    @ApiModelProperty(value = "Mã số thuế/CMND")
    private String merchantCode;
    
    @ApiModelProperty(value = "Trạng thái merchant")
    private int status;
    
    @ApiModelProperty(value = "Loại hình doanh nghiệp/MCC quốc tế")
    private int merchantType;
    
    @ApiModelProperty(value = "Tên viết tắt merchant")
    private String merchantBrand;
    
    @ApiModelProperty(value = "Loại tìm kiếm: 0- Danh sách merchant tổng hợp, 1- Danh sách mercahnt chờ duyệt")
    private String type;
}
