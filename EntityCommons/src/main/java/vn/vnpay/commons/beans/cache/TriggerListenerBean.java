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
public class TriggerListenerBean {

    private long id;
    private String listenerRowId;
    private String listenerTable;
    private String listenerFunction;
    private String createDate;
}
