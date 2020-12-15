package vn.vnpay.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vn.vnpay.commons.database.manager.DatabaseManager;
import vn.vnpay.commons.database.manager.DatabaseUtils;
import vn.vnpay.config.ProcedureConfig;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import vn.vnpay.commons.database.exception.DatabaseException;
import vn.vnpay.config.ServiceConfig;
import vn.vnpay.utils.Utils;

public class SyncDataDao {

    private static final Logger LOGGER = LogManager.getLogger(SyncDataDao.class);

    private static SyncDataDao INSTANCE = new SyncDataDao();

    public static SyncDataDao getInstance() {
        return INSTANCE;
    }

    private SyncDataDao() {
    }

    public boolean syncData() {
        LOGGER.info("Begin running job sync data");
        Connection con = null;
        CallableStatement st = null;
        try {
            con = DatabaseManager.getInstance().getConnectionOff();
            String sql = DatabaseUtils.buildQuerry(ProcedureConfig.PROC_SYNC_DATA_TRANS, 1);
            st = con.prepareCall(sql);

            st.setString("P_DATE", getTimeSyncData());
            LOGGER.info("START execute procedure");
            boolean result = st.executeUpdate() > 0;
            LOGGER.info("Job sync data with result: {}", result);
            return result;

        } catch (Exception ex) {
            LOGGER.error("Job sync data with Ex: {}", ex);
            return false;
        } finally {
            DatabaseManager.getInstance().closeQuietly(con, st);
        }
    }

    public boolean syncTransRefundData() {
        LOGGER.info("Begin running job sync data trans refund");
        Connection con = null;
        CallableStatement st = null;
        try {
            con = DatabaseManager.getInstance().getConnectionOff();
            String sql = DatabaseUtils.buildQuerry(ProcedureConfig.PROC_SYNC_DATA_TRANS_REFUND, 1);
            st = con.prepareCall(sql);

            st.setString("P_DATE", getTimeSyncData());
            LOGGER.info("START execute procedure trans refund");
            boolean result = st.executeUpdate() > 0;
            LOGGER.info("Job sync data trans refund with result: {}", result);
            return result;

        } catch (Exception ex) {
            LOGGER.error("Job sync data trans refund with Ex: {}", ex);
            return false;
        } finally {
            DatabaseManager.getInstance().closeQuietly(con, st);
        }
    }

    public boolean syncTransReportData() {
        LOGGER.info("Begin running job sync data trans report");
        Connection con = null;
        CallableStatement st = null;
        try {
            con = DatabaseManager.getInstance().getConnectionOff();
            String sql = DatabaseUtils.buildQuerry(ProcedureConfig.PROC_SYNC_DATA_TRANS_REPORT, 1);
            st = con.prepareCall(sql);

            st.setString("P_DATE", getTimeSyncData());
            LOGGER.info("START execute procedure trans report");
            boolean result = st.executeUpdate() > 0;
            LOGGER.info("Job sync data trans report with result: {}", result);
            return result;

        } catch (Exception ex) {
            LOGGER.error("Job sync data trans report with Ex: {}", ex);
            return false;
        } finally {
            DatabaseManager.getInstance().closeQuietly(con, st);
        }
    }

    public static String getTimeSyncData() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, ServiceConfig.SYNC_DATA_DAY);
        return Utils.date2String(c.getTime());
    }
}
