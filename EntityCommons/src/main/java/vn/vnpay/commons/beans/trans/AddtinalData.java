package vn.vnpay.commons.beans.trans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddtinalData {

    private String district;
    private String districtname;
    private String phone;
    private String email;
    private String name;
    private String address;
    private String provincename;
}
