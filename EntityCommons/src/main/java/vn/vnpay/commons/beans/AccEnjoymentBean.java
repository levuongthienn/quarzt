/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Pattern;
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
public class AccEnjoymentBean {
    
    @ApiModelProperty(notes = "Id account")
    private int accEnjoymentId;
    
    @Size(min = 6, max = 6, message = "Tối đa 30 ký tự")
    @ApiModelProperty(notes = "Mã ngân hàng hưởng")
    private String bankCode;
    
    @Size(min = 1, max = 100)
    @ApiModelProperty(notes = "Tên chi nhánh ngân hàng hưởng")
    private String branchName;
    
    @Size(min = 1, max = 30)
    @ApiModelProperty(notes = "Mã chi nhánh ngân hàng hưởng")
    private String branchCode;
    
    @ApiModelProperty(notes = "Tên ngân hàng hưởng")
    private String bankName;
    
    @Pattern(regexp = "^[0-9a-zA-Z]{1,150}$", message = "Tối đa 150 ký tự")
    @ApiModelProperty(notes = "Tên chủ tài khoản")
    private String accountHolder;
    
    @Pattern(regexp = "^[0-9a-zA-Z]{1,30}$", message = "Tối đa 30 ký tự")
    @ApiModelProperty(notes = "Số tài khoản")
    private String accountNumber;
    
//    @Pattern(regexp = "^[0-9a-zA-Z]{0,30}$", message = "Tối đa 30 ký tự")
    @ApiModelProperty(notes = "Mã chi nhánh")
    private String branch;
    
    @ApiModelProperty(value = "Loại tiền tệ", example = "VND")
    private String currencyCode;
}
