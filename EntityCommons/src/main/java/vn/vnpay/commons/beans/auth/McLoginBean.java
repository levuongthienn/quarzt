package vn.vnpay.commons.beans.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class McLoginBean {

    @NotNull
    @Size(min = 1, max = 30, message = "Giới hạn từ 6 - 30 ký tự.")
    //@Pattern(regexp = "^[0-9a-zA-Z]{6,20}$", message = "Cho phép nhập ký tự chữ, tiếng việt không dấu hoặc số.")
    @ApiModelProperty(value = "Số điện thoại đăng nhập")
    private String username;

    @NotNull
//    @Size(min = 6, max = 50, message = "Giới hạn từ 6 - 50 ký tự.")
//    @Pattern(regexp = "(?!^[0-9]*$)(?!^[a-zA-Z!@#$%^&*()_+=<>?]*$)^([a-zA-Z!@#$%^&*()_+=<>?0-9]{6,15})$", message = "Mật khẩu không đúng định dạng.")
    @ApiModelProperty(value = "Mật khẩu đăng nhập")
    private String password;
}
