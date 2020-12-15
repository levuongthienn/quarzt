package vn.vnpay.commons.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "Data Response", description = "Dữ liệu tìm kiếm")
public class SearchRes<T> {

    @ApiModelProperty(value = "Số hàng")
    private Integer totalRow;

    @ApiModelProperty(value = "Dữ liệu tìm kiếm chi tiết")
    private T data;

    public static SearchRes of(Integer totalRow, Object data) {
        return SearchRes.builder()
                .totalRow(totalRow)
                .data(data)
                .build();
    }
}
