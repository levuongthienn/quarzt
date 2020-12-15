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

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "Dữ liệu tìm kiếm")
public class SearchReq<T> {
    @Min(0)
    @ApiModelProperty(value = "Từ record")
    private int fromRow;

    @Min(0)
    @Max(100)
    @ApiModelProperty(value = "Số lượng record lấy ra", example = "10")
    private int pageSize;

    @Valid
    @ApiModelProperty(value = "Dữ liệu tìm kiếm chi tiết ", required = true)
    private T data;
}
