//<<<<<<< Updated upstream
//package vn.vnpay.config;
//
//import vn.vnpay.commons.api.config.commons.BaseConfig;
//import vn.vnpay.commons.configs.ThreadConfig;
//import vn.vnpay.commons.database.config.DatabaseConfig;
//import vn.vnpay.commons.redis.config.RedisConfig;
//
//import java.io.IOException;
//
//public class Config extends BaseConfig implements Runnable {
//
//    @Override
//    public void run() {
//        try {
//            OtherConfig();
//        } catch (Exception e) {
//            LOGGER.error("Init Service have Exception: ", e);
//        }
//    }
//
//    public static void initConfig() throws IOException {
//        logger();
//        commonsInit();
//        OtherConfig();
//        LOGGER.info("Load all config success.");
//    }
//
//    private static void OtherConfig() throws IOException {
//        mapConfig("Service.properties", ServiceConfig.class);
//        mapConfig("Procedure.properties", ProcedureConfig.class);
//    }
//
//    private static void commonsInit() throws IOException {
//        mapConfig("ThreadConfig.properties", ThreadConfig.class);
//        mapConfig("DatabaseConfig.properties", DatabaseConfig.class);
//        mapConfig("RedisConfig.properties", RedisConfig.class);
//
//    }
//}
//=======
package vn.vnpay.config;

import org.apache.logging.log4j.Logger;
import vn.vnpay.commons.api.config.commons.BaseConfig;
import vn.vnpay.commons.configs.ThreadConfig;
import vn.vnpay.commons.database.config.DatabaseConfig;
import vn.vnpay.commons.redis.config.RedisConfig;
import java.io.IOException;

public class Config extends BaseConfig implements Runnable {

    private static Logger LOGGER;

    @Override
    public void run() {
        try {
            OtherConfig();
        } catch (Exception e) {
            LOGGER.error("Init Service have Exception: ", e);
        }
    }

    public static void initConfig() throws IOException {
        logger();
        commonsInit();
        OtherConfig();
        LOGGER.info("Load all config success.");
    }

    private static void OtherConfig() throws IOException {
        mapConfig("Service.properties", ServiceConfig.class);
        mapConfig("Procedure.properties", ProcedureConfig.class);
    }

    private static void commonsInit() throws IOException {
        mapConfig("ThreadConfig.properties", ThreadConfig.class);
        mapConfig("DatabaseConfig.properties", DatabaseConfig.class);
        mapConfig("RedisConfig.properties", RedisConfig.class);
    }
}
