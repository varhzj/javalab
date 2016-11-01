package com.varhzj.lab.concurrency.examples;

import com.varhzj.lab.concurrency.annotations.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by varhzj on 11/1/16.
 * 使用AtomicLong类型变量统计已处理请求数量
 */
@ThreadSafe
public class CountingFactorizer extends AbstractFactorizer {

    private AtomicLong count = new AtomicLong(0);

    public long getCount() {
        return count.get();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        count.incrementAndGet(); // 线程安全
        encodeIntoResponse(res, factors);
    }

}
