package vn.vnpay.commons.mcv.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Dữ liệu tìm kiếm chi tiết: Transaction Detail")
public class QrTransactionDetailReq {

    @NotNull
    @ApiModelProperty(value = "ID")
    private int id;

    @ApiModelProperty(value = "Status")
    private Integer status;

    @ApiModelProperty(value = "noteChaneStatus")
    private String noteChaneStatus;

    @ApiModelProperty(value = "Database Search", example = "true")
    private boolean isOnline;

    @ApiModelProperty(value = "false")
    private boolean isChangeData;

    @NotNull
    @ApiModelProperty(value = "Thời gian gi nhận giao dịch tại MMS - dd/MM/yyyy HH24:mi:ss", example = "01/12/2019 00:00:00")
    @Size(min = 19, max = 19)
    @Pattern(regexp = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4} (2[0-3]|[01]?[0-9]):([0-5]?[0-9]):([0-5]?[0-9])$", message = "Date time like pattern: dd/MM/yyyy HH24:mi:ss")
    private String localDate;
}
