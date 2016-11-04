package com.varhzj.lab.concurrency.examples;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by varhzj on 11/4/16.
 */
public class Factorizer extends AbstractFactorizer {

    private final Computable<BigInteger, BigInteger[]> computable = new Computable<BigInteger, BigInteger[]>() {
        @Override
        public BigInteger[] compute(BigInteger arg) throws InterruptedException {
            return factor(arg);
        }
    };
//    private final Computable<BigInteger, BigInteger[]> computable = (arg) -> factor(arg);
    private final Computable<BigInteger, BigInteger[]> cache = new Memorizer<>(computable);

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        try {
            BigInteger i = extractFromRequest(req);
            encodeIntoResponse(res, cache.compute(i));
        } catch (InterruptedException e) {
            encodeError(res, "factorizer interrupted.");
        }
    }
}
