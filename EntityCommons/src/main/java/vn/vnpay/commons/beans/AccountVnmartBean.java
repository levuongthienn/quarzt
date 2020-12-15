/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author thanhld
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountVnmartBean {

    @ApiModelProperty(notes = "Id account")
    private long id;
    
    @ApiModelProperty(notes = "Terminal Id")
    private String terminalId;
    
    @ApiModelProperty(notes = "Số ví")
    private String accountVnmart;
    
    @ApiModelProperty(notes = "Tên ví")
    private String nameAccVnmart;
    
    @ApiModelProperty(notes = "Trạng thái")
    private int status;
    
    @ApiModelProperty(notes = "Ngày tạo")
    private String createdDate;
    
    @ApiModelProperty(notes = "Mã merchant")
    private String merchantCode;
    
    @ApiModelProperty(notes = "Số tài khoản ngân hàng")
    private String bankAccount;
    
    @ApiModelProperty(notes = "merchantAccOriginal")
    private String merchantAccOriginal;
    
    @ApiModelProperty(notes = "merchantAccOriginal")
    private String bankAccOriginal;

}
