package vn.vnpay.commons.mcv.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "QrTransUpdateFlagReq: Cập nhật trạng thái đơn hàng")

public class QrTransUpdateFlagReq {

    @NotNull
    @ApiModelProperty(value = "ID")
    private int id;
    @NotNull
    @ApiModelProperty(value = "Trạng thái đơn hàng")
    private int orderStatus;
    
    @ApiModelProperty(value = "Database Search", example = "true")
    private boolean isOnline;

}
