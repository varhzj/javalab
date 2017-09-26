package com.varhzj.lab.guava.base;

import com.google.common.base.Optional;

/**
 * Created by varhzj on 4/17/17.
 */
public class OptionalSample {

    public static void main(String[] args) {
        Optional<Integer> possible = Optional.of(5);
        possible.isPresent();
    }

}
