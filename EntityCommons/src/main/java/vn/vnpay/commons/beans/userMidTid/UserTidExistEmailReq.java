/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.userMidTid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
@ApiModel(value = "UserTidExistEmailReq", description = "Check Duplicate Email User Request")
public class UserTidExistEmailReq {
    @ApiModelProperty(value = "Mã user")
    @NotNull
    private int userId;
    
    @ApiModelProperty(value = "Email sử dụng để liên hệ của merchant")
    @NotNull
    @Pattern(regexp = "(?:((?:[\\w-]+(?:\\.[\\w-]+)*)@(?:(?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.(?:[a-z]{2,6}(?:\\.[a-z]{2})?));*)")
    @Size(min = 0, max = 100)
    private String email;
}
