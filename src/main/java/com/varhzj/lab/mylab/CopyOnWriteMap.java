package com.varhzj.lab.mylab;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by varhzj on 2/7/17.
 */
public class CopyOnWriteMap<K, V> implements Cloneable {

    private volatile Map<K, V> internalMap;

    public CopyOnWriteMap() {
        internalMap = new HashMap<K, V>();
    }

    public V put(K key, V value) {
        synchronized (this) {
            Map<K, V> newMap = new HashMap<K, V>(internalMap);
            V val = newMap.put(key, value);
            internalMap = newMap;
            return val;
        }
    }

    public V get(K key) {
        return internalMap.get(key);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        synchronized (this) {
            Map<K, V> newMap = new HashMap<K, V>(internalMap);
            newMap.putAll(map);
            internalMap = newMap;
        }
    }

}
