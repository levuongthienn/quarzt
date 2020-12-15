/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.vnpay.commons.redis.config;

import vn.vnpay.commons.configuration.Property;

public class RedisConfig {

    @Property(key = "MAX_IDLE", defaultValue = "10")
    public static int MAX_IDLE;

    @Property(key = "MAX_ACTIVE", defaultValue = "20")
    public static int MAX_ACTIVE;

    @Property(key = "REDIS_DATABASE", defaultValue = "0")
    public static int REDIS_DATABASE;

    @Property(key = "REDIS_MASTERNAME", defaultValue = "redismaster")
    public static String REDIS_MASTERNAME;

    @Property(key = "REDIS_PASSWORD", defaultValue = "testredis@123")
    public static String REDIS_PASSWORD;

    @Property(key = "REDIS_TIME_OUT", defaultValue = "60")
    public static int REDIS_TIME_OUT;

    @Property(key = "LIST_REDIS_URI", defaultValue = "10.22.7.122:6379")
    public static String LIST_REDIS_URI;

    @Property(key = "MAX_FIND_RETURN_VALUE", defaultValue = "20")
    public static int MAX_FIND_RETURN_VALUE;

}
