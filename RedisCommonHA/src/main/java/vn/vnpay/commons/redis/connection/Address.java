package vn.vnpay.commons.redis.connection;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Address {
    private String host;
    private int port;
}
