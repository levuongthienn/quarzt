package vn.vnpay.commons.beans.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResetPasswordBean {

    @NotNull
    @NotBlank
    @Size(min = 1, max = 30, message = "Giới hạn từ 6 - 100 ký tự.")
    //@Pattern(regexp = "^[0-9a-zA-Z]{6,20}$", message = "Cho phép nhập ký tự chữ, tiếng việt không dấu hoặc số.")
    @ApiModelProperty(value = "Email đang ký")
    private String email;

    @NotNull
    @NotBlank
    @ApiModelProperty(value = "Kiểu reset password: EMAIL, SMS")
    private String type;
}
