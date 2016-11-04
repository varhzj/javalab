package com.varhzj.lab.concurrency.examples;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by varhzj on 11/4/16.
 */
public class ExpensiveFunction implements Computable<String, BigInteger> {

    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        TimeUnit.SECONDS.sleep(new Random().nextInt(5));
        return new BigInteger(arg);
    }
}
