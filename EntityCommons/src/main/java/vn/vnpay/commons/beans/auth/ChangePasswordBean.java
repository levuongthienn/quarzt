package vn.vnpay.commons.beans.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "ChangePasswordBean", description = "ChangePasswordBean")
public class ChangePasswordBean {

//    @NotNull
//    @Size(min = 1, max = 30, message = "Giới hạn từ 6 - 50 ký tự.")
//    @Pattern(regexp = "^[0-9a-zA-Z]{6,20}$", message = "Cho phép nhập ký tự chữ, tiếng việt không dấu hoặc số.")
    @ApiModelProperty(value = "Mật khẩu cũ")
    private String oldPassword;

    @NotNull
//    @Size(min = 1, max = 100, message = "Giới hạn từ 6 - 30 ký tự.")
//    @Pattern(regexp = "(?!^[0-9]*$)(?!^[a-zA-Z!@#$%^&*()_+=<>?]*$)^([a-zA-Z!@#$%^&*.,/()_+=<>?0-9]{6,30})$", message = "Cho phép nhập ký tự chữ, tiếng việt không dấu hoặc số.")
    @ApiModelProperty(value = "Mật khẩu mới")
    private String newPassword;
}
