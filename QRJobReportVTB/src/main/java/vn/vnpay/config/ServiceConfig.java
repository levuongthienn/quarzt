package vn.vnpay.config;

import vn.vnpay.commons.configuration.Property;

public class ServiceConfig {

    @Property(key = "QUARTZ_HOUR", defaultValue = "4")
    public static int QUARTZ_HOUR;

    @Property(key = "QUARTZ_MINUTE", defaultValue = "00")
    public static int QUARTZ_MINUTE;

    @Property(key = "JOB_TRAN_DETAIL_SUCCESS", defaultValue = "DETAIL_SUCCESS")
    public static String JOB_TRAN_DETAIL_SUCCESS;

    @Property(key = "JOB_TRAN_REFUND_DETAIL", defaultValue = "REFUND_DETAIL")
    public static String JOB_TRAN_REFUND_DETAIL;

    @Property(key = "JOB_UPDATE_STATUS_QR", defaultValue = "UPDATE_STATUS_QR")
    public static String JOB_UPDATE_STATUS_QR;

    @Property(key = "QR_QUARTZ_HOUR", defaultValue = "3")
    public static int QR_QUARTZ_HOUR;

    @Property(key = "QR_QUARTZ_MINUTE", defaultValue = "00")
    public static int QR_QUARTZ_MINUTE;

    @Property(key = "SYNC_DATA_HOUR", defaultValue = "3")
    public static int SYNC_DATA_HOUR;

    @Property(key = "SYNC_DATA_MINUTE", defaultValue = "00")
    public static int SYNC_DATA_MINUTE;

    @Property(key = "JOB_SYNC_DATA", defaultValue = "")
    public static String JOB_SYNC_DATA;

    @Property(key = "SYNC_DATA_DAY", defaultValue = "")
    public static int SYNC_DATA_DAY;

    @Property(key = "SYNC_DATA_TRANS_REFUND_HOUR", defaultValue = "3")
    public static int SYNC_DATA_TRANS_REFUND_HOUR;

    @Property(key = "SYNC_DATA_TRANS_REFUND_MINITE", defaultValue = "00")
    public static int SYNC_DATA_TRANS_REFUND_MINITE;

    @Property(key = "JOB_SYNC_TRANS_REFUND_DATA", defaultValue = "")
    public static String JOB_SYNC_TRANS_REFUND_DATA;

    @Property(key = "SYNC_DATA_TRANS_REPORT_HOUR", defaultValue = "3")
    public static int SYNC_DATA_TRANS_REPORT_HOUR;

    @Property(key = "SYNC_DATA_TRANS_REPORT_MINITE", defaultValue = "00")
    public static int SYNC_DATA_TRANS_REPORT_MINITE;

    @Property(key = "JOB_SYNC_TRANS_REPORT_DATA", defaultValue = "")
    public static String JOB_SYNC_TRANS_REPORT_DATA;

}
