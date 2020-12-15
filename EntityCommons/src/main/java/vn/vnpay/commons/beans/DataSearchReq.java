package vn.vnpay.commons.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "Dữ liệu tìm kiếm tổng quát")
public class DataSearchReq<T> {
    @Min(0)
    @ApiModelProperty(value = "Từ record")
    private int fromRow;

    @Min(0)
    @Max(100)
    @ApiModelProperty(value = "Số lượng record lấy ra", example = "10")
    private int pageSize;

    @ApiModelProperty(value = "Database Search", example = "true")
    private boolean isOnline;

    @NotNull
    @Size(min = 19, max = 19)
    @Pattern(regexp = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4} (2[0-3]|[01]?[0-9]):([0-5]?[0-9]):([0-5]?[0-9])$", message = "Date time like pattern: dd/MM/yyyy HH24:mi:ss")
    @ApiModelProperty(value = "Từ ngày", required = true, example = "01/01/2019 00:00:00")
    private String fromDate;

    @NotNull
    @Size(min = 19, max = 19)
    @Pattern(regexp = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4} (2[0-3]|[01]?[0-9]):([0-5]?[0-9]):([0-5]?[0-9])$", message = "Date time like pattern: dd/MM/yyyy HH24:mi:ss")
    @ApiModelProperty(value = "Đến ngày", required = true, example = "31/12/2020 00:00:00")
    private String toDate;

    @Valid
    @ApiModelProperty(value = "Dữ liệu tìm kiếm chi tiết ", required = true)
    private T data;
}
