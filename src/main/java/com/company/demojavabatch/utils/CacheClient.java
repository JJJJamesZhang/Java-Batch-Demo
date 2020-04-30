package com.company.demojavabatch.utils;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class CacheClient {
    private static JedisPool jedisPool;

    public static JedisPool getJedisPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(8);
        config.setMaxTotal(18);
        JedisPool pool = new JedisPool(config, "redis-service", 6379, 2000 );
        return pool;
    }
}
