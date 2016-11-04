package com.varhzj.lab.concurrency.examples;

import com.varhzj.lab.concurrency.annotations.GuardedBy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by varhzj on 11/4/16.
 * 使用ConcurrentHashMap替代HashMap
 * 存在重复计算问题
 */
public class Memorizer2<K, V> implements Computable<K, V> {

    private final Map<K, V> cache = new ConcurrentHashMap<K, V>();
    private final Computable<K, V> kvComputable;

    public Memorizer2(Computable<K, V> kvComputable) {
        this.kvComputable = kvComputable;
    }

    @Override
    public V compute(K arg) throws InterruptedException {
        V res = cache.get(arg);
        if (res == null) {
            res = kvComputable.compute(arg);
            cache.put(arg, res);
        }
        return res;
    }
}
