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
public class CacheTerminalByMCReq {

    @ApiModelProperty(value = "Mã merchant")
    private String merchantCode;
    
    @ApiModelProperty(value = "trạng thái terminal")
//    @In(values = {"-1","0","1","2","3","4"}, message = "Giá trị không nằm trong phạm vi cho phép")
    private String status;
    
    @ApiModelProperty(value = "id chi nhánh điểm bán")
    private String terminalBranchId;
    
    @ApiModelProperty(value = "Patern search")
    private String paternSearch;
    
    @ApiModelProperty(value = "Lấy tất cả terminal theo merchant --> isAllTerminal = true otherwise isAllTerminal = false")
    private boolean isAllTerminal;

}
