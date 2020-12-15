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
import vn.vnpay.commons.annotation.In;
//import vn.vnpay.backend.annotation.ValidatedSafeHtml;
//import vn.vnpay.backend.validategroup.CreateMerchant;

/**
 *
 * @author thanhld
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantDetailReq {
    
//    @Pattern(regexp = "^[0-9a-zA-Z\\-\\_\\/]{1,20}$", message = "Không được phép để trống; Tối đa 20 ký tự; Không nhập ký tự đặc biệt", groups = InsertMerchant.class)
    @ApiModelProperty(value = "Mã số thuế/CMND")
    private String merchantCode;
    
    @ApiModelProperty(value = "loại action. 0-xem thông tin; 1-Xem thông tin và thực hiện cập nhật")
    @In(values = {"0","1"}, message = "Giá trị không nằm trong phạm vi cho phép")
    private String type;
}
