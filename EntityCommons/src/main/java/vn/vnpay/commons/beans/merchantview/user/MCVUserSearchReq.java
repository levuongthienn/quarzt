/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.merchantview.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
@ApiModel(value = "UserTidSearchReq", description = "Get List User Request")
public class MCVUserSearchReq {
    @Min(0)
    @ApiModelProperty(value = "Từ record")
    private int fromRow;

    @Min(0)
    @Max(100)
    @ApiModelProperty(value = "Số lượng record lấy ra", example = "10")
    private int pageSize;
    
    @ApiModelProperty(value = "Số điện thoại")
    private String phone;
    
    @ApiModelProperty(value = "Email")
    private String email;
    
    @ApiModelProperty(value = "Trạng thái, 1 la hoat dong. 0 la tam khoa. 2 la cho kich hoat. -1 lấy all", example = "-1")
    private int status;
}
