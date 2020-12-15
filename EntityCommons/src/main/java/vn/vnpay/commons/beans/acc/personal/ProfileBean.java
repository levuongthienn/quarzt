/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.beans.acc.personal;

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
@ApiModel(value = "ProfileBean", description = "Profile Bean")
public class ProfileBean {
    private int userId;
    private String userName;
    private String fullName;
    private String email;
    private String phone;
    private int status;
    private int statusGroup;
    private String creatDate;
    private String modifyDate;
    private String lastTimeLogin;
    private int roleId;
    private String roleName;
    private int changePass;
}
