package com.varhzj.lab.concurrency.examples;

import com.varhzj.lab.concurrency.annotations.GuardedBy;
import com.varhzj.lab.concurrency.annotations.ThreadSafe;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by varhzj on 11/1/16.
 * 线程安全，锁粒度变细，但是存在重复计算的可能？？？
 */
@ThreadSafe
public class CachedFactorizer extends AbstractFactorizer {

    @GuardedBy("this")
    private BigInteger lastNumber;
    @GuardedBy("this")
    private BigInteger[] lastFactors;
    @GuardedBy("this")
    private long hits;
    @GuardedBy("this")
    private long cacheHits;

    // 依然需要使用synchronized内置锁
    public synchronized double getCacheHitRatio() {
        return (double) cacheHits / (double) hits;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = null;
        synchronized (this) {
            ++hits;
            if (i.equals(lastNumber)) {
                ++cacheHits;
                factors = lastFactors.clone(); // 注意使用了clone()
            }
        }
        if (factors == null) {
            factors = factor(i); // 存在重复计算？？？
            synchronized (this) {
                lastNumber = i;
                lastFactors = factors.clone();
            }
        }
    }
}
