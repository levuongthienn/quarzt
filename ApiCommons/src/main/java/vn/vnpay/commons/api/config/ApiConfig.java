package vn.vnpay.commons.api.config;

import vn.vnpay.commons.configuration.Property;

public class ApiConfig {

    @Property(key = "SOURCE", defaultValue = "MMS")
    public static String SOURCE;

    @Property(key = "TITLE", defaultValue = "Jetty, Swagger Api")
    public static String TITLE;

    @Property(key = "DESCRIPTION", defaultValue = "Jetty, Swagger Api")
    public static String DESCRIPTION;

    @Property(key = "SCHEMES", defaultValue = "http")
    public static String SCHEMES;

    @Property(key = "HOST", defaultValue = "localhost:8080")
    public static String HOST;

    @Property(key = "PORT", defaultValue = "8080")
    public static int PORT;

    @Property(key = "APPLICATION_PATH", defaultValue = "api")
    public static String APPLICATION_PATH;

    @Property(key = "CONTEXT_ROOT", defaultValue = "/")
    public static String CONTEXT_ROOT;

    @Property(key = "VERSION", defaultValue = "1.0")
    public static String VERSION;
}
