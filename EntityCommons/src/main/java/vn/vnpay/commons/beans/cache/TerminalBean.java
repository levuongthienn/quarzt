package vn.vnpay.commons.beans.cache;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TerminalBean {
    private int id;
    private String merchantCode;
    private String terminalId;
    private String terminalName;
    private int merchantBranchId;
    private String merchantBranchCode;
    private String status;
}

