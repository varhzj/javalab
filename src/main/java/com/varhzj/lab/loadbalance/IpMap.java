package com.varhzj.lab.loadbalance;

import java.util.HashMap;

/**
 * Created by varhzj on 2/7/17.
 */
public final class IpMap {

    public static HashMap<String, Integer> serverWeightMap = new HashMap<>();

    static {
        serverWeightMap.put("192.168.1.100", 1);
        serverWeightMap.put("192.168.1.101", 1);
        serverWeightMap.put("192.168.1.102", 4);
        serverWeightMap.put("192.168.1.103", 1);
        serverWeightMap.put("192.168.1.104", 1);
        serverWeightMap.put("192.168.1.105", 3);
        serverWeightMap.put("192.168.1.106", 1);
        serverWeightMap.put("192.168.1.107", 1);
        serverWeightMap.put("192.168.1.108", 2);
        serverWeightMap.put("192.168.1.109", 1);
        serverWeightMap.put("192.168.1.110", 1);
    }
}
