/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.staff;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
@ApiModel(value = "StaffSearchReq", description = "Get List Staff Request")
public class StaffSearchReq {
    @Min(0)
    @ApiModelProperty(value = "Từ record")
    private int fromRow;

    @Min(0)
    @Max(100)
    @ApiModelProperty(value = "Số lượng record lấy ra", example = "10")
    private int pageSize;
    
    @ApiModelProperty(value = "Mã nhân viên")
    private String staffCode;
    
    @ApiModelProperty(value = "Tên Đầy Đủ")
    private String fullName;
    
    @ApiModelProperty(value = "Mã chi nhánh")
    private String departCode;
    
    @ApiModelProperty(value = "Trạng thái")
    private int status;
}
