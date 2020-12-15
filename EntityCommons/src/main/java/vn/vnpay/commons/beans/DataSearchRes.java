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
public class DataSearchRes<T> {

    @ApiModelProperty(value = "Số hàng")
    private Integer totalRow;

    @ApiModelProperty(value = "Tổng tiền")
    private Long totalAmount;
    
    @ApiModelProperty(value = "Tổng tiền sau km")
    private Long totalRealAmount;

    @ApiModelProperty(value = "Dữ liệu tìm kiếm chi tiết")
    private T data;

    public static DataSearchRes of(Integer totalRow, Long totalAmount, Object data) {
        return DataSearchRes.builder()
                .totalRow(totalRow)
                .totalAmount(totalAmount)
                .data(data)
                .build();
    }
    public static DataSearchRes of(Integer totalRow, Long totalAmount, Long totalRealAmount, Object data) {
        return DataSearchRes.builder()
                .totalRow(totalRow)
                .totalAmount(totalAmount)
                .totalRealAmount(totalRealAmount)
                .data(data)
                .build();
    }

    public static DataSearchRes of(Integer totalRow, Object data) {
        return DataSearchRes.builder()
                .totalRow(totalRow)
                .data(data)
                .build();
    }
}
