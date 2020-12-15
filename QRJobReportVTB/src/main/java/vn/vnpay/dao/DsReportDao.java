package vn.vnpay.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vn.vnpay.commons.database.manager.DatabaseManager;
import vn.vnpay.commons.database.manager.DatabaseUtils;
import vn.vnpay.config.ProcedureConfig;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import vn.vnpay.commons.database.exception.DatabaseException;

public class DsReportDao {

    private static final Logger LOGGER = LogManager.getLogger(DsReportDao.class);

    private static DsReportDao INSTANCE = new DsReportDao();

    public static DsReportDao getInstance() {
        return INSTANCE;
    }

    private DsReportDao() {
    }

    public boolean JobDsTranSuccess() {
        LOGGER.info("Begin running job success transaction detail report ds");
        Connection con = null;
        CallableStatement st = null;
        try {
            con = DatabaseManager.getInstance().getConnectionOff();
            String sql = DatabaseUtils.buildQuerry(ProcedureConfig.PROC_JOB_DS_TRAN_SUCCESS, 0);
            st = con.prepareCall(sql);
            LOGGER.info("START execute procedure");
            boolean result = st.executeUpdate() > 0;
            LOGGER.info("Job success transaction detail report with data: {}", result);
            return result;

        } catch (Exception ex) {
            LOGGER.error("Job success transaction detail report ds with Ex: {}", ex);
            return false;
        } finally {
            DatabaseManager.getInstance().closeQuietly(con, st);
        }
    }

    public boolean autoUpdateStatusQR() {
        LOGGER.info("Begin autoUpdateStatusQR.");
        Connection con = null;
        CallableStatement st = null;
        try {
            con = DatabaseManager.getInstance().getConnectionOff();
            String querry = DatabaseUtils.buildQuerry(ProcedureConfig.PRO_UPDATE_STATUS_JOB, 0);
            st = con.prepareCall(querry);
            boolean result = st.executeUpdate() > 0;
            LOGGER.info("Function autoUpdateStatusQRt with response: {}", result);
            return result;
        } catch (Exception e) {
            LOGGER.error("Function autoUpdateStatusQR is have exception: {}", e);
            return false;
        } finally {
            DatabaseManager.getInstance().closeQuietly(con, st);
        }
    }

}
