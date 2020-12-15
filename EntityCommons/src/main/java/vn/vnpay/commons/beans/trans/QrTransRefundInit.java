package vn.vnpay.commons.beans.trans;

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
@ApiModel(value = "Dữ liệu khởi tạo giao dịch hoàn: Transaction refund")
public class QrTransRefundInit {

    @NotNull
    @ApiModelProperty(value = "ID")
    private int id;

    @NotNull
    @ApiModelProperty(value = "Thời gian gi nhận giao dịch tại MMS - dd/MM/yyyy HH24:mi:ss", example = "01/12/2019 00:00:00")
    @Size(min = 19, max = 19)
    @Pattern(regexp = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4} (2[0-3]|[01]?[0-9]):([0-5]?[0-9]):([0-5]?[0-9])$", message = "Date time like pattern: dd/MM/yyyy HH24:mi:ss")
    private String localDate;

    @ApiModelProperty(value = "Database Search", example = "true")
    private boolean isOnline;

    @ApiModelProperty(value = "Loại hoàn: 1 - Toàn Phần, 2 - Hoàn 1 phần")
    private int typeRefund;

    @ApiModelProperty(value = "Số tiền khởi tạo hoàn")
    private long initAmount;

    @ApiModelProperty(value = "Số tiền hoàn thực")
    private long amountRefund;

    @ApiModelProperty(value = "Ghi chú")
    private String note;

    @ApiModelProperty(value = "Trạng thái cập nhật")
    private int status;

}
