package vn.vnpay.commons.qrcode.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "DataCheckRes", description = "Result response")
public class DataCheckRes {
    @ApiModelProperty(value = "Kết quả check or update")
    private boolean isCheck;
    
    public static DataCheckRes of(boolean result) {
        return DataCheckRes.builder()
                .isCheck(result)
                .build();
    }
}
