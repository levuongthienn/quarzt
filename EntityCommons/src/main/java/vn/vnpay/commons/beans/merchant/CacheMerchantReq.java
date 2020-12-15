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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 *
 * @author thanhld
 */
    @Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CacheMerchantReq {
    
    @ApiModelProperty(value = "Trạng thái merchant")
//    @In(values = {"-1","0","1","2","3","5"}, message = "Giá trị không nằm trong phạm vi cho phép")
    @Size(min = 1, message = "Status không được bỏ trống")
    private String status;
    
    @ApiModelProperty(value = "Patern search")
    private String paternSearch;
    
}
