package com.varhzj.lab.concurrency.examples;

import com.varhzj.lab.concurrency.annotations.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by varhzj on 11/1/16.
 * 无状态对象一定是线程安全的
 */
@ThreadSafe
public class StatelessFactorizer extends AbstractFactorizer {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        encodeIntoResponse(res, factors);
    }

}
