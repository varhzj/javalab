package com.varhzj.lab.concurrency.examples;

import com.varhzj.lab.concurrency.annotations.Immutable;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by varhzj on 11/2/16.
 * Immutable holder that caching a number and its factors;
 */
@Immutable
public class OneValueCache {

    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger num, BigInteger[] factors) {
        this.lastNumber = num;
        this.lastFactors = Arrays.copyOf(factors, factors.length); // use copyOf
    }

    public BigInteger[] getLastFactors(BigInteger i) {
        if (lastNumber == null || !i.equals(lastNumber)) {
            return null;
        }
        else {
            return Arrays.copyOf(lastFactors, lastFactors.length);
        }
    }
}
