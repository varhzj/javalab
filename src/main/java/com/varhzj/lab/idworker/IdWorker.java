package com.varhzj.lab.idworker;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IdWorker {

    // 开始时间戳 (2018-01-01)
    private final long twepoch = 1514736000000L;
    // 机器id
    private final long workerIdBits = 5L;
    // 数据中心id所占标识
    private final long dataCenterIdBits = 5L;
    // 支持的最大机器id，结果是31 (这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数)
    private final long maxWorkerId = ~(-1L << workerIdBits);
    // 支持的最大数据标识id，结果是31
    private final long maxDataCenterId = ~(-1L << dataCenterIdBits);
    // 序列在id中占的位数
    private final long sequenceBits = 12L;
    // 机器ID向左移12位
    private final long workerIdShift = sequenceBits;

    // 数据标识id向左移17位(12+5)
    private final long dataCenterIdShift = sequenceBits + workerIdBits;

    // 时间截向左移22位(5+5+12)
    private final long timestampLeftShift = sequenceBits + workerIdBits + dataCenterIdBits;

    // 生成序列的掩码，这里为4095 (0b111111111111=0xfff=4095)
    private final long sequenceMask = ~(-1L << sequenceBits);

    private long workerId;
    private long dataCenterId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;
    private Lock lock = new ReentrantLock();

    public IdWorker(long workerId, long dataCenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException("WorkerId can't be generate");
        }
        if (dataCenterId > maxDataCenterId || dataCenterId < 0) {
            throw new IllegalArgumentException("DataCenterId can't be generate");
        }
        this.workerId = workerId;
        this.dataCenterId = dataCenterId;
    }

    public long nextId() {
        lock.lock();
        try {
            long timestamp = getCurTimestamp();
            // 时间回拨,生成失败,抛出异常
            if (timestamp < lastTimestamp) {
                throw new RuntimeException("Clock move backward.");
            }
            // 同一时间内产生,序列递增
            if (timestamp == lastTimestamp) {
                sequence = (sequence + 1) & sequenceMask;
                // 溢出, 阻塞到下一毫秒
                if (sequence == 0) {
                    timestamp = tilNextTimestamp();
                }
            }
            // 时间戳改变,重置序列
            else {
                sequence = 0L;
            }
            // 更新时间戳
            lastTimestamp = timestamp;

            return ((timestamp - twepoch) << timestampLeftShift) // 时间戳移位
                    | (dataCenterId << dataCenterIdShift) // 数据中心移位
                    | (workerId << workerIdShift) // 工作节点移位
                    | sequence; // 序列号
        } finally {
            lock.unlock();
        }
    }

    private long tilNextTimestamp() {
        long timestamp = getCurTimestamp();
        while (timestamp <= lastTimestamp) {
            timestamp = getCurTimestamp();
        }
        return timestamp;
    }

    private long getCurTimestamp() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        IdWorker idWorker = new IdWorker(0, 0);

        for (int i = 0; i < 100; i++) {
            long id = idWorker.nextId();
            System.out.println(id);
        }
    }

}
