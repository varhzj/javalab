package com.varhzj.lab.concurrency.examples;

import com.varhzj.lab.concurrency.annotations.GuardedBy;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by varhzj on 11/1/16.
 * 线程安全，但效率太低，一次只能处理一个请求
 */
public class SynchronizedFactorizer extends AbstractFactorizer {

    @GuardedBy("this")
    private BigInteger lastNumber;
    @GuardedBy("this")
    private BigInteger[] lastFactors;

    @Override
    public synchronized void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        if (i.equals(lastNumber)) {
            encodeIntoResponse(res, lastFactors);
        }
        else {
            BigInteger[] factors = factor(i);
            lastNumber = i;
            lastFactors = factors;
            encodeIntoResponse(res, factors);
        }
    }

}
