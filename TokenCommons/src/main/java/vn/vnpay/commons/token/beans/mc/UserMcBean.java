package vn.vnpay.commons.token.beans.mc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserMcBean {
    private long id;
    private String username;
    private String phone;
    private String password;
    private String name;
    private String email;
    private String lastTimeLogin;
    private int fistLogin;
    private int typeAccount;
    private int status;
    private int changePass;
    private List<String> functionLinks;

    private int merchantId;
    private String merchantCode;
    private String branchId;
    private String terminalId;

    private Map<String, String> roles;
}
