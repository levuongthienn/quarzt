package vn.vnpay.commons.redis.connection;

import com.google.common.base.Optional;
import com.lambdaworks.redis.RedisAsyncConnection;
import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisConnectionPool;
import com.lambdaworks.redis.RedisURI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vn.vnpay.commons.redis.config.RedisConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RedisConnectionManager {

    private static final Logger LOGGER = LogManager.getLogger(RedisConnectionManager.class);

    private RedisConnectionPool<RedisAsyncConnection<String, String>> asyncPool;

    private RedisClient client;

    private static final class SingletonHolder {

        private static final RedisConnectionManager INSTANCE = new RedisConnectionManager();
    }

    public static RedisConnectionManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private RedisConnectionManager() {

    }

    public void start() {
        try {
            List<Address> addresses = genAddress();
            RedisURI redisURI;
            if (null == addresses || addresses.size() == 0) {
                LOGGER.info("arrClientURI is NULL");
                return;
            } else {
                if (addresses.size() > 1) {
                    redisURI = RedisURI.Builder
                            .sentinel(addresses.get(0).getHost(), addresses.get(0).getPort(), RedisConfig.REDIS_MASTERNAME)
                            .withPassword(RedisConfig.REDIS_PASSWORD)
                            .withDatabase(RedisConfig.REDIS_DATABASE)
                            .build();
                    for (int i = 1; i < addresses.size(); i++) {
                        redisURI.getSentinels().add(RedisURI.create(addresses.get(i).getHost(), addresses.get(i).getPort()));
                    }
                } else {
                    redisURI = RedisURI.Builder
                            .redis(addresses.get(0).getHost(), addresses.get(0).getPort())
                            .withPassword(RedisConfig.REDIS_PASSWORD)
                            .withDatabase(RedisConfig.REDIS_DATABASE)
                            .build();
                }
                if (null == redisURI) {
                    LOGGER.info("redisURI IS NULL.");
                    return;
                }
            }
            client = RedisClient.create(redisURI);
            client.setDefaultTimeout(RedisConfig.REDIS_TIME_OUT, TimeUnit.SECONDS);
            asyncPool = client.asyncPool(RedisConfig.MAX_IDLE, RedisConfig.MAX_ACTIVE);
            LOGGER.info("Start redis connection asyn pool Success.");
        } catch (Exception ex) {
            LOGGER.error("Start redis connection asyn pool failed by ex: {}.", ex);
        }
    }

    private List<Address> genAddress() {
        List<Address> listAddress = null;
        try {
            String[] hostPorts = RedisConfig.LIST_REDIS_URI.split("/");
            listAddress = new ArrayList();
            String[] strHostPort;
            String host;
            int port;
            for (String hostPort : hostPorts) {
                strHostPort = hostPort.split(":");
                host = strHostPort[0];
                port = Integer.valueOf(strHostPort[1]);
                final Address address = Address.builder()
                        .host(host)
                        .port(port)
                        .build();
                listAddress.add(address);
            }
        } catch (Exception e) {
            LOGGER.error("Get address have ex: {}", e);
        }

        return listAddress;
    }

    public RedisAsyncConnection<String, String> getConnection() {
        RedisAsyncConnection<String, String> connection = null;
        for (int i = 0; i < 3; i++) {
            try {
                connection = asyncPool.allocateConnection();
            } catch (Exception ex) {
                LOGGER.error("Get connection from redis pool failed and retry by ex: {}.", ex);
                connection = null;
            }
            if (null != connection) {
                return connection;
            }
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException ex) {
                LOGGER.error("Get connection from redis pool InterruptedException: {}.", ex);
            }
        }
        return connection;
    }

    public Optional<RedisAsyncConnection<String, String>> getConnectionOptional() {
        try {
            final RedisAsyncConnection<String, String> connection = asyncPool.allocateConnection();
            return Optional.of(connection);
        } catch (Exception ex) {
            LOGGER.error("Get connection from redis pool failed by ex: {}.", ex);
            return Optional.absent();
        }
    }

    public void returnConnection(RedisAsyncConnection<String, String> T) {
        try {
            if (T != null) {
                asyncPool.freeConnection(T);
            }
        } catch (Exception ex) {
            LOGGER.error("Return connection to pool by ex: {}.", ex);
        }

    }

    public void shutdown() {
        try {
            asyncPool.close();
            client.shutdown();
        } catch (Exception ex) {
            LOGGER.error("Shutdown pool and redis client by ex: {}.", ex);
        }

    }
}