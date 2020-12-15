package vn.vnpay.commons.token.config;

import vn.vnpay.commons.configuration.Property;

public class TokenConfig {
    @Property(key = "TOKEN_SOURCE", defaultValue = "MMS")
    public static String TOKEN_SOURCE;

    @Property(key = "TOKEN_KEY", defaultValue = "Meoz Meoz")
    public static String TOKEN_KEY;

    @Property(key = "ALL_USER_LOGIN", defaultValue = "ALL_USER_LOGIN")
    public static String ALL_USER_LOGIN;

    @Property(key = "MC_USER_LOGIN", defaultValue = "MC_USER_LOGIN")
    public static String MC_USER_LOGIN;
}
