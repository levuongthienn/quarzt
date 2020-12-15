package vn.vnpay.commons.database.manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vn.vnpay.commons.database.config.DatabaseConfig;
import vn.vnpay.commons.database.connection.DatabaseConnection;
import vn.vnpay.commons.database.exception.DatabaseException;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatabaseManager {

    private static final Logger LOGGER = LogManager.getLogger(DatabaseManager.class);

    private static DatabaseManager ourInstance = new DatabaseManager();

    public static DatabaseManager getInstance() {
        return ourInstance;
    }

    private DatabaseManager() {
    }

    public Connection getConnectDataSourceOn() throws DatabaseException {
        return getConnectDataSource(DatabaseConfig.DATA_SOURCE_ON);
    }

    public Connection getConnectDataSourceOff() throws DatabaseException {
        return getConnectDataSource(DatabaseConfig.DATA_SOURCE_OFF);
    }

    private Connection getConnectDataSource(String dataSource) throws DatabaseException {
        try {
            DataSource ds = (DataSource) new InitialContext().lookup(dataSource);
            return ds.getConnection();
        } catch (Exception e) {
            LOGGER.error("Error while getting datasource context: {} by ex : {}", dataSource, e);
            throw new DatabaseException("Get connection DB Eror.", e);
        }
    }

    public Connection getConnectionByType(boolean isOnline) throws DatabaseException {
        LOGGER.info("Get connection from DB : {}", isOnline ? "Online" : "Offline");
        return isOnline ? getConnectionOnl() : getConnectionOff();
    }

    private static DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Connection getConnectionByDate(String dateStr) throws DatabaseException {

        try {
            Date date = sdf.parse(dateStr);
            return date.after(atStartOfDay(new Date())) ? getConnectionOnl() : getConnectionOff();
        } catch (ParseException e) {
            throw new DatabaseException(e);
        }
    }

    private Date atStartOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public Connection getConnectionOnl() throws DatabaseException {
        try {
            return DatabaseConnection.getInstance().getPds().getConnection();
        } catch (SQLException ex) {
            LOGGER.error("Get database connection fail: ", ex);
            throw new DatabaseException("Get connection DB Eror.", ex);
        }
    }

    public Connection getConnectionOff() throws DatabaseException {
        try {
            return DatabaseConnection.getInstance().getPdsOff().getConnection();
        } catch (SQLException ex) {
            LOGGER.error("Get database connection fail: ", ex);
            throw new DatabaseException("Get connection DB Eror.", ex);
        }
    }

    public void close(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    public void close(ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
    }

    public void close(Statement stmt) throws SQLException {
        if (stmt != null) {
            stmt.close();
        }
    }

    public void closeQuietly(Connection conn) {
        try {
            close(conn);
        } catch (SQLException e) {
            LOGGER.warn("CloseQuietly connection fail: ", e);
        }
    }

    public void closeQuietly(Statement stmt, ResultSet rs) {
        try {
            closeQuietly(rs);
        } finally {
            closeQuietly(stmt);
        }
    }

    public void closeQuietly(Connection conn, Statement stmt) {
        try {
            closeQuietly(stmt);
        } finally {
            closeQuietly(conn);
        }
    }

    public void closeQuietly(Connection conn, Statement stmt, ResultSet rs) {
        try {
            closeQuietly(rs);
        } finally {
            try {
                closeQuietly(stmt);
            } finally {
                closeQuietly(conn);
            }
        }
    }

    public void closeQuietly(ResultSet rs) {
        try {
            close(rs);
        } catch (SQLException e) {
            LOGGER.warn("CloseQuietly ResultSet fail: ", e);
        }
    }

    public void closeQuietly(Statement stmt) {
        try {
            close(stmt);
        } catch (SQLException e) {
            LOGGER.warn("CloseQuietly Statement fail: ", e);
        }
    }

}
