/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.staff;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "StaffBean", description = "Staff Bean")
public class StaffBean {
    private int staffId;
    private String staffCode;
    private String nickName;
    private String fullName;
    private String email;
    private String mobile;
    private int status;
    private String createdDate;
    private String modifyDate;
    private int departId;
    private String departCode;
}
