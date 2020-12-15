package vn.vnpay.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vn.vnpay.commons.database.connection.DatabaseConnection;
import vn.vnpay.commons.redis.connection.RedisConnectionManager;
import vn.vnpay.commons.thread.ThreadPoolManager;
import vn.vnpay.job.JobManager;

public class ShutdownHook extends Thread {

    private static final Logger logger = LogManager.getLogger(ShutdownHook.class);

    public static ShutdownHook getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void run() {
        try {
            DatabaseConnection.getInstance().stop();
            RedisConnectionManager.getInstance().shutdown();
            JobManager.getInstance().killJob();
            ThreadPoolManager.getInstance().shutdown();
            logger.info("Clean up all success");
        } catch (Exception ex) {
            logger.error("Shutdown Service have ex: {}.", ex);
        }
    }

    private static final class SingletonHolder {
        private static final ShutdownHook INSTANCE = new ShutdownHook();
    }
}