package vn.vnpay.commons.redis.manager;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.lambdaworks.redis.MapScanCursor;
import com.lambdaworks.redis.RedisAsyncConnection;
import com.lambdaworks.redis.RedisFuture;
import com.lambdaworks.redis.ScanArgs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vn.vnpay.commons.redis.config.RedisConfig;
import vn.vnpay.commons.redis.connection.RedisConnectionManager;
import vn.vnpay.commons.redis.exception.RedisException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RedisManager {

    private static final Logger LOGGER = LogManager.getLogger(RedisManager.class);

    private static final Gson GSON = new Gson();

    private static RedisManager ourInstance = new RedisManager();

    public static RedisManager getInstance() {
        return ourInstance;
    }

    private RedisManager() {
    }

    public boolean set(String key, String field, String value) throws RedisException {
        LOGGER.info("Begin set redis with key: {} , field: {} , value: {}", key, field, value);
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            redisConnection.hset(key, field, value);
            LOGGER.info("Set value success.");
            return true;
        } catch (Exception ex) {
            LOGGER.error("End set bean have ex: {}", ex);
            throw new RedisException("Set value to Redis have Err", ex);
        } finally {
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }

    public boolean set(String key, String field, Object value) throws RedisException {
        LOGGER.info("Begin set redis with key: {} , field: {} , value: {}", key, field, value);
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            String valueStr = GSON.toJson(value);
            redisConnection.hset(key, field, valueStr);
            LOGGER.info("Set value success.");
            return true;
        } catch (Exception ex) {
            LOGGER.error("End set bean have ex: {}", ex);
            throw new RedisException("Set value to Redis have Err", ex);
        } finally {
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }

    public boolean setNX(String key, Object value, long ttl) throws RedisException {
        LOGGER.info("Begin setNX redis with key: {} ,  value: {}", key, value);
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            String valueStr = GSON.toJson(value);
            RedisFuture<Boolean> check = redisConnection.setnx(key, valueStr);
            boolean isSet = check.get();
            if (isSet)
                redisConnection.expire(key, ttl);
            LOGGER.info("setNX value to redis: {}.", isSet);
            return isSet;
        } catch (Exception ex) {
            LOGGER.error("End set bean have ex: {}", ex);
            throw new RedisException("setNX value to Redis have Err", ex);
        } finally {
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }

    public String setLockRecord(String key, String value, long ttl) throws RedisException {
        LOGGER.info("Begin setNX redis with key: {} ,  value: {}", key, value);
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            RedisFuture<Boolean> check = redisConnection.setnx(key, value);
            boolean isSet = check.get();
            if (isSet) {
                redisConnection.expire(key, ttl);
                LOGGER.info("setNX value to redis: {}.", isSet);
                return value;
            } else {
                RedisFuture<String> valueC = redisConnection.get(key);
                LOGGER.info("setNX value to redis: {}.", isSet);
                return valueC.get();
            }
        } catch (Exception ex) {
            LOGGER.error("End set bean have ex: {}", ex);
            throw new RedisException("setNX value to Redis have Err", ex);
        } finally {
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }

    public boolean hmset(String key, Map<String, String> map) throws RedisException {
        LOGGER.info("Begin hmset redis with key: {} ,  value: {}", key, map);
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            if (map.isEmpty()) {
                LOGGER.info("Map have empty, don't need set.");
                return false;
            }
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            RedisFuture<String> hmset = redisConnection.hmset(key, map);
            LOGGER.info("hmset value to redis: {}.", hmset.get());
            return true;
        } catch (Exception ex) {
            LOGGER.error("End set bean have ex: {}", ex);
            throw new RedisException("hmset value to Redis have Err", ex);
        } finally {
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }

    public <T> void updateValueToArray(String key, ConcurrentMap<String, Set<T>> map) {
        LOGGER.info("Begin update key: {}, with value: {}", key, map.toString());
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            ConcurrentMap<String, String> mapStr = new ConcurrentHashMap<>();
            for (Map.Entry<String, Set<T>> entry : map.entrySet()) {
                RedisFuture<String> future = redisConnection.hget(key, entry.getKey());
                if (null == future)
                    throw new RedisException("Data not found");
                String dataString = future.get();
                Set<T> set;
                if (dataString == null) {
                    set = new HashSet<>();
                } else {
                    set = GSON.fromJson(dataString, HashSet.class);
                }
                Set s = GSON.fromJson(GSON.toJson(entry.getValue()), HashSet.class);

                set.addAll(s);
                mapStr.put(entry.getKey(), GSON.toJson(set));
            }
            if (mapStr.size() > 0) {
                redisConnection.hmset(key, mapStr);
            }
            LOGGER.info("End update key success");
        } catch (Exception e) {
            LOGGER.error("updateValueToArray cache have ex: {}", e);
        } finally {
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }


    public List<String> hmget(String key, String... fields) throws RedisException {
        LOGGER.info("Begin hmset redis with key: {} ,  value: {}", key, fields);
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            RedisFuture<List<String>> hmset = redisConnection.hmget(key, fields);
            LOGGER.info("hmset value to redis: {}.", hmset.get());
            return hmset.get();
        } catch (Exception ex) {
            LOGGER.error("End set bean have ex: {}", ex);
            throw new RedisException("setNX value to Redis have Err", ex);
        } finally {
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }

    public String get(String key, String field) throws RedisException {
        LOGGER.info("Begin get redis with key: {} , field: {}", key, field);
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            RedisFuture<String> future = redisConnection.hget(key, field);
            if (null == future) throw new RedisException("Data not found");
            String dataString = future.get();
            LOGGER.info("End get redis with key: {} , field: {} , value: {}", key, field, dataString);
            return dataString;
        } catch (Exception ex) {
            LOGGER.error("End get bean have ex: {}.", ex);
            throw new RedisException("Get redis have Error.", ex);
        } finally {
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }

    public String get(String key) throws RedisException {
        LOGGER.info("Begin get redis with key: {}", key);
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            RedisFuture<String> future = redisConnection.get(key);
            if (null == future) throw new RedisException("Data not found");
            String dataString = future.get();
            LOGGER.info("End get redis with key: {}, value: {}", key, dataString);
            return dataString;
        } catch (Exception ex) {
            LOGGER.error("End get bean have ex: {}.", ex);
            throw new RedisException("Get redis have Error.", ex);
        } finally {
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }

    public Object get(String key, Class<?> rawClass) throws RedisException {
        LOGGER.info("Begin get redis with key: {}", key);
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            RedisFuture<String> future = redisConnection.get(key);
            if (null == future) throw new RedisException("Data not found");
            String dataString = future.get();
            LOGGER.info("End get redis with key: {} , value: {}", key, dataString);
            return GSON.fromJson(dataString, rawClass);
        } catch (Exception ex) {
            LOGGER.error("End get bean have ex: {}.", ex);
            throw new RedisException("Get redis have Error.", ex);
        } finally {
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }

    public Map<String, String> hgetall(String key) throws RedisException {
        LOGGER.info("Begin hgetall redis with key: {} ", key);
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            RedisFuture<Map<String, String>> future = redisConnection.hgetall(key);
            if (null == future) throw new RedisException("Data not found");
            Map<String, String> value = future.get();
            LOGGER.info("End get redis with key: {} , value: {}", key, value);
            return value;
        } catch (Exception ex) {
            LOGGER.error("End get bean have ex: {}.", ex);
            throw new RedisException("Get redis have Error.", ex);
        } finally {
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }

    public <T> Map<String, T> hgetall(String key, Class<T> aclass) throws RedisException {
        Map<String, T> stringObjectMap = new ConcurrentHashMap<>();
        try {
            Map<String, String> value = hgetall(key);
            if (value != null)
                for (Map.Entry<String, String> entry : value.entrySet()) {
                    stringObjectMap.put(entry.getKey(), GSON.fromJson(entry.getValue(), aclass));
                }
            return stringObjectMap;
        } catch (Exception ex) {
            LOGGER.error("End get hgetall have ex: {}.", ex);
            throw new RedisException("Get redis have Error.", ex);
        }
    }

    public <T> List<T> hgetallToList(String key, Class<T> aclass) throws RedisException {
        LOGGER.info("Begin hgetallToList redis with key: {} ", key);
        List<T> ls = new ArrayList<>();
        try {
            Map<String, String> value = hgetall(key);
            for (Map.Entry<String, String> entry : value.entrySet()) {
                ls.add(GSON.fromJson(entry.getValue(), aclass));
            }
            LOGGER.info("End hgetallToList redis with key: {} , value: {}", key, ls);
            return ls;
        } catch (Exception ex) {
            LOGGER.error("End get hgetallToList have ex: {}.", ex);
            throw new RedisException("hgetallToList redis have Error.", ex);
        }
    }

    public Object get(String key, String field, final Class<?> rawClass) throws RedisException {
        LOGGER.info("Begin get redis with key: {} , field: {}", key, field);
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            RedisFuture<String> future = redisConnection.hget(key, field);
            if (null == future) throw new RedisException("Data not found");
            String dataString = future.get();
            Object obj = GSON.fromJson(dataString, rawClass);
            LOGGER.info("End get redis with key: {} , field: {} , value: {}", key, field, dataString);
            return obj;
        } catch (Exception ex) {
            LOGGER.error("End get bean have ex: {}.", ex);
            throw new RedisException("Get redis have Error.", ex);
        } finally {
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }

    public Object getNoLogs(String key, String field, final Class<?> rawClass) throws RedisException {
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            RedisFuture<String> future = redisConnection.hget(key, field);
            if (null == future) throw new RedisException("Data not found");
            String dataString = future.get();
            return GSON.fromJson(dataString, rawClass);
        } catch (Exception ex) {
            LOGGER.error("End get bean have ex: {}.", ex);
            throw new RedisException("Get redis have Error.", ex);
        } finally {
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }

    public Object hget(String key, String field, final Type type) throws RedisException {
        LOGGER.info("Begin get redis with key: {} , field: {}", key, field);
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            RedisFuture<String> future = redisConnection.hget(key, field);
            if (null == future) throw new RedisException("Data not found");
            String dataString = future.get();
            Object obj = GSON.fromJson(dataString, type);
            LOGGER.info("End get redis with key: {} , field: {} , value: {}", key, field, dataString);
            return obj;
        } catch (Exception ex) {
            LOGGER.error("End get bean have ex: {}.", ex);
            throw new RedisException("Get redis have Error.", ex);
        } finally {
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }

    public Object hget(String tokenKey, String key, String field, final Type type) throws RedisException {
        LOGGER.info("[TOKEN: {}] Begin get redis with key: {} , field: {}", tokenKey, key, field);
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            RedisFuture<String> future = redisConnection.hget(key, field);
            if (null == future) throw new RedisException("Data not found");
            String dataString = future.get();
            Object obj = GSON.fromJson(dataString, type);
            LOGGER.info("[TOKEN: {}] End get redis with key: {} , field: {} , value: {}", tokenKey, key, field, dataString);
            return obj;
        } catch (Exception ex) {
            LOGGER.error("[TOKEN: {}] End get bean have ex: {}.", tokenKey, ex);
            throw new RedisException("Get redis have Error.", ex);
        } finally {
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }

    public Map<String, String> getAll(String key) throws RedisException {
        LOGGER.info("Begin getAll redis with key: {}.", key);
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            RedisFuture<Map<String, String>> future = redisConnection.hgetall(key);
            if (null == future) throw new RedisException("Data not found");
            Map<String, String> dataString = future.get();
            LOGGER.info("End getAll redis with key: {} , value: {}", key, dataString);
            return dataString;
        } catch (Exception ex) {
            LOGGER.error("End getAll bean have ex: {}.", ex);
            throw new RedisException("Getall redis have Error.", ex);
        } finally {
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }

    public boolean setWithExpireTime(String key, String field, String value, int time) throws RedisException {
        LOGGER.info("Begin setWithExpireTime redis with key: {} and time: {}", key, time);
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            redisConnection.hset(key, field, value);
            redisConnection.expire(key, time);
            LOGGER.info("End setWithExpireTime redis success.");
            return true;
        } catch (Exception ex) {
            LOGGER.error("End setWithExpireTime bean have ex: {}.", ex);
            throw new RedisException("setWithExpireTime redis have Error.", ex);
        } finally {
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }

    public int setWithExpireTimeCounter(String key, long time) throws RedisException {
        LOGGER.info("Begin setWithExpireTimeCounter redis with key: {} and time: {}", key, time);
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            int count;
            try {
                RedisFuture<String> value = redisConnection.get(key);
                count = Integer.valueOf(value.get());
                count++;
                RedisFuture<Long> ttl = redisConnection.ttl(key);
                time = ttl.get();
            } catch (Exception e) {
                count = 1;
            }
            redisConnection.set(key, String.valueOf(count));
            redisConnection.expire(key, time);
            LOGGER.info("End setWithExpireTimeCounter redis success with key: {} and value: {}, ttl :{}.", key, count, time);
            return count;
        } catch (Exception ex) {
            LOGGER.error("End setWithExpireTimeCounter bean have ex: {}.", ex);
            throw new RedisException("setWithExpireTimeCounter redis have Error.", ex);
        } finally {
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }

    public boolean expire(String key, int time) throws RedisException {
        LOGGER.info("Begin expire redis with key: {} and time: {}", key, time);
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            redisConnection.expire(key, time);
            LOGGER.info("End expire redis success.");
            return true;
        } catch (Exception ex) {
            LOGGER.error("End expire bean have ex: {}.", ex);
            throw new RedisException("Expire redis have Error.", ex);
        } finally {
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }

    public boolean exist(String key, String field) throws RedisException {
        LOGGER.info("Begin check exist redis with key: {} and field: {}", key, field);
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            RedisFuture<Boolean> future = redisConnection.hexists(key, field);
            if (null == future) throw new RedisException("Data not found");
            boolean check = future.get();
            LOGGER.info("End check exist with value: {}.", check);
            return check;
        } catch (Exception ex) {
            LOGGER.error("Check exist key have ex: {}.", ex);
            throw new RedisException("Check exist key have Error.", ex);
        } finally {
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }

    public Long del(String key, String... field) throws RedisException {
        LOGGER.info("Begin dell redis with key: {} and field: {}", key, field);
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            RedisFuture<Long> future = redisConnection.hdel(key, field);
            Long out = future.get();
            LOGGER.info("End dell redis with number key: {}.", out);
            return out;
        } catch (Exception ex) {
            LOGGER.error("Del key have ex: {}.", ex);
            throw new RedisException("Del key have Error.", ex);
        } finally {
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }

    public Long delKeys(String... keys) throws RedisException {
        LOGGER.info("Begin dell redis with key: {}", keys);
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            RedisFuture<Long> future = redisConnection.del(keys);
            Long out = future.get();
            LOGGER.info("End dell redis with number key: {}.", out);
            return out;
        } catch (Exception ex) {
            LOGGER.error("Del key have ex: {}.", ex);
            throw new RedisException("Del key have Error.", ex);
        } finally {
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }

    public Long delWithDB(String key, int indexDB) throws RedisException {
        LOGGER.info("Begin dell redis with key: {}", key);
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            redisConnection.select(indexDB);
            // key = merchant_code
            RedisFuture<Long> future = redisConnection.del(key);
            Long out = future.get();
            LOGGER.info("End dell redis with number key: {}.", out);
            return out;
        } catch (Exception ex) {
            LOGGER.error("Del key have ex: {}.", ex);
            throw new RedisException("Del key have Error.", ex);
        } finally {
            redisConnection.select(RedisConfig.REDIS_DATABASE);
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }

    public Long hdelWithDB(String key, String filed, int indexDB) throws RedisException {
        LOGGER.info("Begin hdelWithDB redis with key: {}", key);
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            redisConnection.select(indexDB);
            // key = merchant_code
            RedisFuture<Long> future = redisConnection.hdel(key, filed);
            Long out = future.get();
            LOGGER.info("End hdelWithDB redis with number key: {}.", out);
            return out;
        } catch (Exception ex) {
            LOGGER.error("hdelWithDB key have ex: {}.", ex);
            throw new RedisException("hdelWithDB key have Error.", ex);
        } finally {
            redisConnection.select(RedisConfig.REDIS_DATABASE);
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }

    public Map<String, String> findInKey(String key, String patternSearch) throws RedisException {
        LOGGER.info("Begin findInKey redis with key: {} and dataSearch: {}", key, patternSearch);
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            ScanArgs scanArgs = new ScanArgs()
                    .limit(RedisConfig.MAX_FIND_RETURN_VALUE)
                    .match(patternSearch);
            RedisFuture<MapScanCursor<String, String>> mapsScan = redisConnection.hscan(key, scanArgs);
            MapScanCursor<String, String> mapsScanValue = mapsScan.get();
            Map<String, String> map = mapsScanValue.getMap();
            LOGGER.info("end findInKey redis with value: {}.", map);
            return map;
        } catch (Exception ex) {
            LOGGER.error("Find key have ex: {}.", ex);
            throw new RedisException("Find key have Error.", ex);
        } finally {
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }

    public <T> List<T> findInKey(String key, String patternSearch, Class<T> aclass) throws RedisException {
        LOGGER.info("Begin findInKey redis with key: {} and dataSearch: {}", key, patternSearch);
        RedisAsyncConnection<String, String> redisConnection = null;
        try {
            redisConnection = RedisConnectionManager.getInstance().getConnection();
            ScanArgs scanArgs = new ScanArgs()
                    .limit(RedisConfig.MAX_FIND_RETURN_VALUE)
                    .match(patternSearch);
            RedisFuture<MapScanCursor<String, String>> mapsScan = redisConnection.hscan(key, scanArgs);
            MapScanCursor<String, String> mapsScanValue = mapsScan.get();
            Map<String, String> map = mapsScanValue.getMap();
            LOGGER.info("end findInKey redis with value: {}.", map);
            return convertToList(map, aclass);
        } catch (Exception ex) {
            LOGGER.error("Find key have ex: {}.", ex);
            throw new RedisException("Find key have Error.", ex);
        } finally {
            RedisConnectionManager.getInstance().returnConnection(redisConnection);
        }
    }

    public <T> List<T> convertToList(Map<String, String> map, Class<T> aclass) throws RedisException {
        LOGGER.info("Begin convertToList redis ");
        List<T> ls = new ArrayList<>();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                ls.add(GSON.fromJson(entry.getValue(), aclass));
            }
            LOGGER.info("End hgetallToList redis with value: {}", ls);
            return ls;
        } catch (JsonSyntaxException ex) {
            LOGGER.error("End get convertToList have ex: {}.", ex);
            throw new RedisException("hgetallToList redis have Error.", ex);
        }
    }

//    public List<Map<String, String>> findInKeyCursor(String key, String patternSearch) throws RedisException {
//        LOGGER.info("Begin findInKey redis with key: {} and dataSearch: {}", key, patternSearch);
//        RedisAsyncConnection<String, String> redisConnection = null;
//        int cursor = 0;
//        try {
//            redisConnection = RedisConnectionManager.getInstance().getConnection();
//            ScanArgs scanArgs = new ScanArgs()
//                    .limit(RedisConfig.MAX_FIND_RETURN_VALUE)
//                    .match(patternSearch);
//            ScanCursor sc = new ScanCursor();
//            sc.setCursor(String.valueOf(cursor));
//            RedisFuture<MapScanCursor<String, String>> mapsScan;
//            List<Map<String, String>> list = new ArrayList<>();
//            do{
//                mapsScan = redisConnection.hscan(key, sc, scanArgs);
//                MapScanCursor<String, String> mapsScanValue = mapsScan.get();
//                list.add(mapsScanValue.getMap());
//                cursor = Integer.parseInt(mapsScanValue.getCursor());
//                sc.setCursor(String.valueOf(cursor));
//            }while(cursor>0);
//
//            final ScanArgs scanArgs = new ScanArgs();
//            scanArgs.match("1449821324-hungnvasd11");
//            scanArgs.limit(1000);
//            ScanCursor sc = new ScanCursor();
//            sc.setCursor("0");
//            final MapScanCursor<String, String> mapScanCursor = redisConnection.sync().hscan("ALL_MERCHANT",sc, scanArgs);
//            return list;
//        } catch (Exception ex) {
//            LOGGER.error("Find key have ex: {}.", ex);
//            throw new RedisException("Find key have Error.", ex);
//        } finally {
//            RedisConnectionManager.getInstance().returnConnection(redisConnection);
//        }
//    }

//    public List<Map.Entry<String, String>> scanHSet(String domain, String match) {
//    try (ShardedJedis shardedJedis = shardedJedisPool.getResource()) {
//        int cursor = 0;
//
//        ScanParams scanParams = new ScanParams();
//        scanParams.match(match);
//        Jedis jedis = shardedJedis.getShard(domain);
//        ScanResult<Map.Entry<String, String>> scanResult;
//        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>();
//        do {
//            scanResult = jedis.hscan(domain, String.valueOf(cursor), scanParams);
//            list.addAll(scanResult.getResult());
//            cursor = Integer.parseInt(scanResult.getStringCursor());
//        } while (cursor > 0);
//        return list;
//    }
}
