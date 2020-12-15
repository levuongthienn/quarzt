package vn.vnpay.commons.database.config;

import vn.vnpay.commons.configuration.Property;

public class DatabaseConfig {

    @Property(key = "SERVICE_NAME", defaultValue = "MMS")
    public static String SERVICE_NAME;

    @Property(key = "INIT_POOL_SIZE", defaultValue = "10")
    public static int INIT_POOL_SIZE;

    @Property(key = "MIN_POOL_SIZE", defaultValue = "5")
    public static int MIN_POOL_SIZE;

    @Property(key = "MAX_POOL_SIZE", defaultValue = "40")
    public static int MAX_POOL_SIZE;

    @Property(key = "VALIDATE_CONNECTION", defaultValue = "true")
    public static boolean VALIDATE_CONNECTION;

    @Property(key = "SQL_FOR_VALIDATE", defaultValue = "select sysdate from dual")
    public static String SQL_FOR_VALIDATE;

    @Property(key = "FACTORY_CLASS", defaultValue = "oracle.jdbc.pool.OracleDataSource")
    public static String FACTORY_CLASS;

    @Property(key = "INACTIVE_CONNECTION_TIMEOUT", defaultValue = "60")
    public static int INACTIVE_CONNECTION_TIMEOUT;

    @Property(key = "DATA_SOURCE_ON", defaultValue = "jdbc/mmsvietin")
    public static String DATA_SOURCE_ON;

    @Property(key = "DATA_SOURCE_OFF", defaultValue = "jdbc/mmsoffvietin")
    public static String DATA_SOURCE_OFF;

    @Property(key = "USERNAME_ONL", defaultValue = "mmsvietin")
    public static String USERNAME_ONL;

    @Property(key = "PASSWORD_ONL", defaultValue = "mmsvietin")
    public static String PASSWORD_ONL;

    @Property(key = "URL_ONL", defaultValue = "jdbc:oracle:thin:@10.22.7.24:1521:VNPTEST")
    public static String URL_ONL;

    @Property(key = "USERNAME_OFF", defaultValue = "mmsoffvietin")
    public static String USERNAME_OFF;

    @Property(key = "PASSWORD_OFF", defaultValue = "mmsoffvietin")
    public static String PASSWORD_OFF;

    @Property(key = "URL_OFF", defaultValue = "jdbc:oracle:thin:@10.22.7.23:1521/OFFLINE")
    public static String URL_OFF;
}
