package vn.vnpay.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vn.vnpay.commons.database.connection.DatabaseConnection;
import vn.vnpay.commons.redis.connection.RedisConnectionManager;
import vn.vnpay.commons.thread.ThreadPoolManager;
import vn.vnpay.config.Config;
import vn.vnpay.quartz.DsTranSuccessJobBatch;
import vn.vnpay.config.ServiceConfig;
import vn.vnpay.job.JobManager;
import vn.vnpay.job.bean.JobData;
import vn.vnpay.quartz.QrUpdateStatusJobBatch;
import vn.vnpay.quartz.SyncDataTransJob;
import vn.vnpay.quartz.SyncDataTransRefundJob;
import vn.vnpay.quartz.SyncDataTransReportJob;

public class JobMain {
    private static Logger LOG = LogManager.getLogger(JobMain.class);

    public static void main(String[] args) {
        try {
            Config.initConfig();
            initConnection();
            ThreadPoolManager.getInstance().scheduleAtFixedRate(new Config(), 60, 60000);
//            ThreadPoolManager.getInstance().scheduleAtFixedRate(new FakeData(), 1200, 600000);
            JobManager.getInstance().startJob(JobData.builder()
                            .jobName(ServiceConfig.JOB_TRAN_DETAIL_SUCCESS)
                            .hour(ServiceConfig.QUARTZ_HOUR)
                            .minute(ServiceConfig.QUARTZ_MINUTE)
                            .job(DsTranSuccessJobBatch.class)
                            .build(),
                    JobData.builder()
                            .jobName(ServiceConfig.JOB_UPDATE_STATUS_QR)
                            .hour(ServiceConfig.QR_QUARTZ_HOUR)
                            .minute(ServiceConfig.QR_QUARTZ_MINUTE)
                            .job(QrUpdateStatusJobBatch.class)
                            .build(),
                    JobData.builder()
                            .jobName(ServiceConfig.JOB_SYNC_DATA)
                            .hour(ServiceConfig.SYNC_DATA_HOUR)
                            .minute(ServiceConfig.SYNC_DATA_MINUTE)
                            .job(SyncDataTransJob.class)
                            .build(),
                    JobData.builder()
                            .jobName(ServiceConfig.JOB_SYNC_TRANS_REFUND_DATA)
                            .hour(ServiceConfig.SYNC_DATA_TRANS_REFUND_HOUR)
                            .minute(ServiceConfig.SYNC_DATA_TRANS_REFUND_MINITE)
                            .job(SyncDataTransRefundJob.class)
                            .build(),
                    JobData.builder()
                            .jobName(ServiceConfig.JOB_SYNC_TRANS_REPORT_DATA)
                            .hour(ServiceConfig.SYNC_DATA_TRANS_REPORT_HOUR)
                            .minute(ServiceConfig.SYNC_DATA_TRANS_REPORT_MINITE)
                            .job(SyncDataTransReportJob.class)
                            .build()
            );

            Runtime.getRuntime().addShutdownHook(ShutdownHook.getInstance());
        } catch (Throwable tb) {
            LOG.error("Throwable", tb);
        }
    }

    private static void initConnection() {
        try {
            DatabaseConnection.getInstance().start();
            RedisConnectionManager.getInstance().start();
        } catch (Exception e) {
            LOG.error("Exception: ", e);
        }
    }
}
