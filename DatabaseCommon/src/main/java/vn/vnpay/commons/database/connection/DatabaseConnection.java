package vn.vnpay.commons.database.connection;

import oracle.ucp.UniversalConnectionPoolAdapter;
import oracle.ucp.UniversalConnectionPoolException;
import oracle.ucp.admin.UniversalConnectionPoolManager;
import oracle.ucp.admin.UniversalConnectionPoolManagerImpl;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vn.vnpay.commons.database.config.DatabaseConfig;

public class DatabaseConnection {

    private static final Logger LOGGER = LogManager.getLogger(DatabaseConnection.class);

    private PoolDataSource pds;
    private PoolDataSource pdsOff;

    private String name;
    private String nameOff;

    private UniversalConnectionPoolManager poolMgr;
    private UniversalConnectionPoolManager poolMgrOff;

    private static DatabaseConnection ourInstance = new DatabaseConnection();

    public static DatabaseConnection getInstance() {
        return ourInstance;
    }

    private DatabaseConnection() {
    }

    public void start() {
        startOnline();
        startOffline();
    }

    public void startOnline() {
        try {
            LOGGER.info("Begin start connection pool");
            name = DatabaseConfig.SERVICE_NAME + ":Database:" + DatabaseConnection.class.getName();
            poolMgr = UniversalConnectionPoolManagerImpl.getUniversalConnectionPoolManager();
            pds = PoolDataSourceFactory.getPoolDataSource();
            pds.setConnectionPoolName(name);
            pds.setConnectionFactoryClassName(DatabaseConfig.FACTORY_CLASS);
            pds.setURL(DatabaseConfig.URL_ONL);
            pds.setUser(DatabaseConfig.USERNAME_ONL);
            pds.setPassword(DatabaseConfig.PASSWORD_ONL);

            poolMgr.createConnectionPool((UniversalConnectionPoolAdapter) pds);

            pds.setInactiveConnectionTimeout(DatabaseConfig.INACTIVE_CONNECTION_TIMEOUT);

            pds.setInitialPoolSize(DatabaseConfig.INIT_POOL_SIZE);
            pds.setMinPoolSize(DatabaseConfig.MIN_POOL_SIZE);
            pds.setMaxPoolSize(DatabaseConfig.MAX_POOL_SIZE);
            pds.setValidateConnectionOnBorrow(DatabaseConfig.VALIDATE_CONNECTION);
            pds.setSQLForValidateConnection(DatabaseConfig.SQL_FOR_VALIDATE);

            poolMgr.startConnectionPool(name);
            LOGGER.info("Start connection pool to database [ConnectionFactoryClass: {}, " +
                            "URL: {}, " +
                            "UserName: {}, " +
                            "Password: {}, " +
                            "MinPoolSize: {}, " +
                            "InitPoolSize: {}, " +
                            "MaxPoolSize: {}, " +
                            "ValidateConnectionOnBorrow {}]",
                    DatabaseConfig.FACTORY_CLASS,
                    DatabaseConfig.URL_ONL,
                    DatabaseConfig.USERNAME_ONL,
                    DatabaseConfig.PASSWORD_ONL,
                    DatabaseConfig.MIN_POOL_SIZE,
                    DatabaseConfig.INIT_POOL_SIZE,
                    DatabaseConfig.MAX_POOL_SIZE,
                    DatabaseConfig.VALIDATE_CONNECTION);
        } catch (Exception ex) {
            LOGGER.error("Start connection pool to database [ConnectionFactoryClass: {}, " +
                            "URL: {}, " +
                            "UserName: {}, " +
                            "Password: {}, " +
                            "MinPoolSize: {}, " +
                            "InitPoolSize: {}, " +
                            "MaxPoolSize: {}, " +
                            "ValidateConnectionOnBorrow {}]" +
                            "With Exception: {}",
                    DatabaseConfig.FACTORY_CLASS,
                    DatabaseConfig.URL_ONL,
                    DatabaseConfig.USERNAME_ONL,
                    DatabaseConfig.PASSWORD_ONL,
                    DatabaseConfig.MIN_POOL_SIZE,
                    DatabaseConfig.INIT_POOL_SIZE,
                    DatabaseConfig.MAX_POOL_SIZE,
                    DatabaseConfig.VALIDATE_CONNECTION,
                    ex);
        }
    }

    public void startOffline() {
        try {
            LOGGER.info("Begin start connection pool");
            nameOff = DatabaseConfig.SERVICE_NAME + "OFF:Database:" + DatabaseConnection.class.getName();
            poolMgrOff = UniversalConnectionPoolManagerImpl.getUniversalConnectionPoolManager();
            pdsOff = PoolDataSourceFactory.getPoolDataSource();
            pdsOff.setConnectionPoolName(nameOff);
            pdsOff.setConnectionFactoryClassName(DatabaseConfig.FACTORY_CLASS);
            pdsOff.setURL(DatabaseConfig.URL_OFF);
            pdsOff.setUser(DatabaseConfig.USERNAME_OFF);
            pdsOff.setPassword(DatabaseConfig.PASSWORD_OFF);

            poolMgrOff.createConnectionPool((UniversalConnectionPoolAdapter) pdsOff);

            pdsOff.setInactiveConnectionTimeout(DatabaseConfig.INACTIVE_CONNECTION_TIMEOUT);

            pdsOff.setInitialPoolSize(DatabaseConfig.INIT_POOL_SIZE);
            pdsOff.setMinPoolSize(DatabaseConfig.MIN_POOL_SIZE);
            pdsOff.setMaxPoolSize(DatabaseConfig.MAX_POOL_SIZE);
            pdsOff.setValidateConnectionOnBorrow(DatabaseConfig.VALIDATE_CONNECTION);
            pdsOff.setSQLForValidateConnection(DatabaseConfig.SQL_FOR_VALIDATE);

            poolMgrOff.startConnectionPool(nameOff);
            LOGGER.info("Start connection pool to database [ConnectionFactoryClass: {}, " +
                            "URL: {}, " +
                            "UserName: {}, " +
                            "Password: {}, " +
                            "MinPoolSize: {}, " +
                            "InitPoolSize: {}, " +
                            "MaxPoolSize: {}, " +
                            "ValidateConnectionOnBorrow {}]",
                    DatabaseConfig.FACTORY_CLASS,
                    DatabaseConfig.URL_OFF,
                    DatabaseConfig.USERNAME_OFF,
                    DatabaseConfig.PASSWORD_OFF,
                    DatabaseConfig.MIN_POOL_SIZE,
                    DatabaseConfig.INIT_POOL_SIZE,
                    DatabaseConfig.MAX_POOL_SIZE,
                    DatabaseConfig.VALIDATE_CONNECTION);
        } catch (Exception ex) {
            LOGGER.error("Start connection pool to database [ConnectionFactoryClass: {}, " +
                            "URL: {}, " +
                            "UserName: {}, " +
                            "Password: {}, " +
                            "MinPoolSize: {}, " +
                            "InitPoolSize: {}, " +
                            "MaxPoolSize: {}, " +
                            "ValidateConnectionOnBorrow {}]" +
                            "With Exception: {}",
                    DatabaseConfig.FACTORY_CLASS,
                    DatabaseConfig.URL_OFF,
                    DatabaseConfig.USERNAME_OFF,
                    DatabaseConfig.PASSWORD_OFF,
                    DatabaseConfig.MIN_POOL_SIZE,
                    DatabaseConfig.INIT_POOL_SIZE,
                    DatabaseConfig.MAX_POOL_SIZE,
                    DatabaseConfig.VALIDATE_CONNECTION,
                    ex);
        }
    }

    public void stop() {
        stopOnl();
        stopOff();
    }

    public void stopOnl() {
        try {
            poolMgr.destroyConnectionPool(name);
        } catch (UniversalConnectionPoolException ex) {
            LOGGER.error("Destroy connection to database fail: ", ex);
        }
    }

    public void stopOff() {
        try {
            poolMgrOff.destroyConnectionPool(nameOff);
        } catch (UniversalConnectionPoolException ex) {
            LOGGER.error("Destroy connection to database fail: ", ex);
        }
    }

    public PoolDataSource getPds() {
        if (null == pds) {
            startOnline();
        }
        return pds;
    }

    public PoolDataSource getPdsOff() {
        if (null == pdsOff) {
            startOffline();
        }
        return pdsOff;
    }
}
