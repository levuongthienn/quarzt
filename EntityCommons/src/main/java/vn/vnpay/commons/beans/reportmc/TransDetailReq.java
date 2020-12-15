/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.reportmc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

/**
 *
 * @author khanhbn
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "DsTransDetailSuccess: Dữ liệu tìm kiếm chi tiết")
public class TransDetailReq {

    @ApiModelProperty(value = "Mã chi nhánh")
    private String merchantBranchId;
    @ApiModelProperty(value = "Mã điểm bán")
    private String terminalId;
    @ApiModelProperty(value = "Mã đơn vị thanh toán")
    private String bankCode;
    @ApiModelProperty(value = "Loại thanh toán")
    private String payType;
    @ApiModelProperty(value = "trạng thái giao dịch")
    private int status;
    
}
