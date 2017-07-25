package com.varhzj.lab.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by varhzj on 17-1-14.
 */
public class JedisUtil {

    private static JedisPool jedisPool;
    private static String host = "127.0.0.1";
    private static int port = 6379;
    private static int timeout = 60000;
    private static AtomicInteger failCount = new AtomicInteger(0);

    static {
        initPool();
    }

    private synchronized static void initPool() {
        if (jedisPool == null || jedisPool.isClosed()) {
            try {
                JedisPoolConfig poolConfig = new JedisPoolConfig();
                poolConfig.setMaxTotal(32);
                poolConfig.setMinIdle(20);
                poolConfig.setMaxWaitMillis(1000);
                jedisPool = new JedisPool(poolConfig, host, port, timeout);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void set(String key, String value) {
        if (jedisPool == null || jedisPool.isClosed()) {
            initPool();
        }
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set(key, value);
        } catch (Exception e) {
            failCount.getAndIncrement();
            e.printStackTrace();
        }
    }

    public static void setExpire(String key, String value, int seconds) {
        if (jedisPool == null || jedisPool.isClosed()) {
            initPool();
        }
        try (Jedis jedis = jedisPool.getResource()) {
            String res = jedis.set(key, value);
            jedis.expire(key, seconds);
            System.out.println(res);
        } catch (Exception e) {
            failCount.getAndIncrement();
            e.printStackTrace();
        }
    }

    public static String getStr(String key) {
        if (jedisPool == null || jedisPool.isClosed()) {
            initPool();
        }
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.get(key);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        JedisUtil.setExpire("tests", "stset", 1);

        TimeUnit.MILLISECONDS.sleep(5000);

        System.out.println(JedisUtil.getStr("tests") == null);
//        Random random = new Random();
//        Runnable testRunnable = () -> JedisUtil.set(String.valueOf(random.nextInt()), String.valueOf(random.nextInt()));
//        long start = System.nanoTime();
//        for (int i = 0; i < 100000; i++) {
//            testRunnable.run();
//        }
//        System.out.println((System.nanoTime() - start) / 10000);
//        for (int j = 0; j < 1000; j++) {
//            new Thread(testRunnable).start();
//        }
//        System.out.println(failCount.get());
    }
}
