package com.varhzj.lab.concurrency.examples;

import com.varhzj.lab.concurrency.annotations.NotThreadSafe;
import com.varhzj.lab.concurrency.annotations.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by varhzj on 11/1/16.
 *
 */
@NotThreadSafe
public class UnsafeCountingFactorizer extends AbstractFactorizer {

    private long count = 0;

    public long getCount() {
        return count;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        count++; // 线程不安全
        encodeIntoResponse(res, factors);
    }

}
