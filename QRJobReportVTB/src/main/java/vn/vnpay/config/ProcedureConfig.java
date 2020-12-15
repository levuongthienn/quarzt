package vn.vnpay.config;

import vn.vnpay.commons.configuration.Property;

public class ProcedureConfig {
    @Property(key = "PROC_JOB_DS_TRAN_SUCCESS", defaultValue = "")
    public static String PROC_JOB_DS_TRAN_SUCCESS;

    @Property(key = "PROC_JOB_DS_TRAN_REFUND", defaultValue = "")
    public static String PROC_JOB_DS_TRAN_REFUND;

    @Property(key = "PRO_UPDATE_STATUS_JOB", defaultValue = "")
    public static String PRO_UPDATE_STATUS_JOB;

    @Property(key = "PROC_SYNC_DATA_TRANS", defaultValue = "")
    public static String PROC_SYNC_DATA_TRANS;

    @Property(key = "PROC_SYNC_DATA_TRANS_REFUND", defaultValue = "")
    public static String PROC_SYNC_DATA_TRANS_REFUND;

    @Property(key = "PROC_SYNC_DATA_TRANS_REPORT", defaultValue = "")
    public static String PROC_SYNC_DATA_TRANS_REPORT;

}
