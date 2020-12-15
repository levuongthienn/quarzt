/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.merchantview.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "UserTidUpdateStatusReq", description = "Update Status User Request")
public class UserTidUpdateStatusReq {
    @ApiModelProperty(value = "Mã user")
    @NotNull
    private int userId;
    
//    @ApiModelProperty(value = "Trạng thái update, 1 la hoat dong. 0 la tam khoa. 2 la cho kich hoat")
//    @NotNull
//    private int status;
}
