package vn.vnpay.commons.beans.merchantview.terminal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import vn.vnpay.commons.beans.cache.TerminalBean;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class CacheTerminalRes {

    private List<TerminalBean> listData;
}
