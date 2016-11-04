package com.varhzj.lab.concurrency.examples;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by varhzj on 11/4/16.
 */
public class Memorizer<K, V> implements Computable<K, V> {

    private final Map<K, Future<V>> cache = new ConcurrentHashMap<K, Future<V>>();
    private final Computable<K, V> kvComputable;

    public Memorizer(Computable<K, V> kvComputable) {
        this.kvComputable = kvComputable;
    }

    @Override
    public V compute(K arg) throws InterruptedException {
        Future<V> future = cache.get(arg);
        if (future == null) {
            FutureTask<V> futureTask = new FutureTask<V>(() -> kvComputable.compute(arg));
            future = cache.putIfAbsent(arg, futureTask);
            if (future == null) {
                future = futureTask;
                futureTask.run();
            }
        }
        try {
            return future.get();
        } catch (CancellationException e) {
            cache.remove(arg, future);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
