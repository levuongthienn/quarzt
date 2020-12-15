/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.terminal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
//import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vn.vnpay.commons.interfaces.InsertMerchant;
import vn.vnpay.commons.interfaces.InsertTerminal;
//import vn.vnpay.backend.validategroup.CreateMerchant;

/**
 *
 * @author truongnq
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TerminalContact{
    
//    @NotBlank(groups = CreateMerchant.class)
    @Size(min = 0, max = 100, message = "Tối đa 50 ký tự", groups = {InsertMerchant.class, InsertTerminal.class})
    @ApiModelProperty(value = "Họ và tên người liên hệ")
    private String fullName;

//    @NotBlank(groups = CreateMerchant.class)
    @Size(min = 0, max = 13, message = "Tối đa 13 ký tự", groups = {InsertMerchant.class, InsertTerminal.class})
    @ApiModelProperty(value = "Số điện thoại liên hệ")
    private String phoneNumber;

    @Size(min = 0, max = 13, message = "Tối đa 13 ký tự", groups = {InsertMerchant.class, InsertTerminal.class})
    @ApiModelProperty(value = "Số điện thoại liên hệ")
    private String phoneNumber1;

    @Size(min = 0, max = 13, message = "Tối đa 13 ký tự", groups = {InsertMerchant.class, InsertTerminal.class})
    @ApiModelProperty(value = "Số điện thoại liên hệ")
    private String phoneNumber2;

//    @NotBlank(groups = CreateMerchant.class)
    @Size(min = 0, max = 100, message = "Tối đa 100 ký tự", groups = {InsertMerchant.class, InsertTerminal.class})
    @Pattern(regexp = "^(.+)@(.+)$")
    @ApiModelProperty(value = "Email liên hệ")
    private String email;

    @Size(min = 0, max = 100, message = "Tối đa 100 ký tự", groups = {InsertMerchant.class, InsertTerminal.class})
    @Pattern(regexp = "^(.+)@(.+)$")
    @ApiModelProperty(value = "Email liên hệ")
    private String email1;

    @Size(min = 0, max = 100, message = "Tối đa 100 ký tự", groups = {InsertMerchant.class, InsertTerminal.class})
    @Pattern(regexp = "^(.+)@(.+)$")
    @ApiModelProperty(value = "Email liên hệ")
    private String email2;
}
