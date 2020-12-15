/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author truongnq
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InternalMccBean {

    @ApiModelProperty(value = "Id mcc nội địa")
    private long mccId;

    @ApiModelProperty(value = "Mã MCC nội địa")
    private String mccCode;

    @ApiModelProperty(value = "Tên MCC nội địa")
    private String mccName;

    @ApiModelProperty(value = "Thông tin mô tả")
    private String description;

}
