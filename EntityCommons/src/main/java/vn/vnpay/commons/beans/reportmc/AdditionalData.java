package vn.vnpay.commons.beans.reportmc;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalData {

    private String district;
    private String phone;
    private String email;
    private String name;
    private String address;
}
