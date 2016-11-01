package com.varhzj.lab.concurrency.examples;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.math.BigInteger;

/**
 * Created by varhzj on 11/1/16.
 */
public abstract class AbstractFactorizer extends GenericServlet implements Servlet {

    protected void encodeIntoResponse(ServletResponse res, BigInteger[] factors) {
    }

    protected BigInteger[] factor(BigInteger i) {
        return new BigInteger[]{i};
    }

    protected BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("5");
    }

}
