package vn.vnpay.commons.token.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetailBean {
    private long id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String lastTimeLogin;
    private int groupId;
    //private int status;
    private int changePass;
    private List<String> functionLinks;

    private String tokenRefresh;
}
