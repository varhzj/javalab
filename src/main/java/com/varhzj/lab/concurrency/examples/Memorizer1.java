package com.varhzj.lab.concurrency.examples;

import com.varhzj.lab.concurrency.annotations.GuardedBy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by varhzj on 11/4/16.
 * 使用synchronized和HashMap实现计算缓存
 * 效率低
 */
public class Memorizer1<K, V> implements Computable<K, V> {

    @GuardedBy("this")
    private final Map<K, V> cache = new HashMap<K, V>();
    private final Computable<K, V> kvComputable;

    public Memorizer1(Computable<K, V> kvComputable) {
        this.kvComputable = kvComputable;
    }

    @Override
    public synchronized V compute(K arg) throws InterruptedException {
        V res = cache.get(arg);
        if (res == null) {
            res = kvComputable.compute(arg);
            cache.put(arg, res);
        }
        return res;
    }
}
