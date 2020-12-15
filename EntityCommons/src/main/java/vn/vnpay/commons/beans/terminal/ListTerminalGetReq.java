/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.terminal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
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
public class ListTerminalGetReq {

    @ApiModelProperty(value = "Mã terminal")
    private String terminalId;
    
    @ApiModelProperty(value = "Mã merchant")
    private String merchantId;
    
    @ApiModelProperty(value = "Chi nhánh")
    private String terminalBranchId;
    
    @ApiModelProperty(value = "Cấp bậc")
    private String levelTerminal;
    
    @ApiModelProperty(value = "Trạng thái terminal")
    private String status;
    
    @ApiModelProperty(value = "Loại tìm kiếm: 0-Danh sách terminal tổng hợp, 1-Danh sách terminal chờ duyệt")
    @In(values = {"0","1"}, message = "Giá trị phải là 0 hoặc 1")
    private String type;
    
}
