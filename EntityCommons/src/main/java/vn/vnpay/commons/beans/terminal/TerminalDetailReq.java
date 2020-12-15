/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.terminal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vn.vnpay.commons.annotation.In;
//import vn.vnpay.backend.annotation.ValidatedSafeHtml;
//import vn.vnpay.backend.validategroup.CreateTerminal;

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
public class TerminalDetailReq {

    @Size(min = 1, max = 100)
    @ApiModelProperty(value = "Mã terminal")
    private String terminalId;
    
    @ApiModelProperty(value = "Mã merchant")
    private int merchantId;
    
    @ApiModelProperty(value = "loại action. 0-xem thông tin; 1-Xem thông tin và thực hiện cập nhật")
    @In(values = {"0","1"}, message = "Giá trị không nằm trong phạm vi cho phép")
    private String type;
    
}
