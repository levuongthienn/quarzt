package vn.vnpay.commons.beans.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResBean {

    @NotNull
    @ApiModelProperty(value = "Token đăng nhập hệ thống.")
    private String token;

    @NotNull
    @ApiModelProperty(value = "Token dùng để refresh lại token đăng nhập.")
    private String refreshToken;
}
