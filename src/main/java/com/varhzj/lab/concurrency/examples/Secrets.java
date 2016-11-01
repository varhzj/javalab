package com.varhzj.lab.concurrency.examples;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by varhzj on 16-11-1.
 * 发布一个对象
 */
public class Secrets {

    public static Set<Secret> secrets;

    public void init() {
        secrets = new HashSet<>();
    }

}

class Secret {}
