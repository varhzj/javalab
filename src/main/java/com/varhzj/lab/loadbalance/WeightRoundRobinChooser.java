package com.varhzj.lab.loadbalance;

import java.util.*;

/**
 * Created by varhzj on 2/7/17.
 * 加权轮询
 */
public class WeightRoundRobinChooser implements ServerChooser {

    private static Integer pos = 0;

    @Override
    public String getServer(String remoteIp) {
        // TODO 这个方法会存在问题
        // 重建一个Map，避免服务器上下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<>();
        serverMap.putAll(IpMap.serverWeightMap);

        Set<Map.Entry<String, Integer>> entrySet = serverMap.entrySet();
        List<String> ipList = new ArrayList<>();
        // 根据权重添加server
        for (Map.Entry<String, Integer> entry : entrySet) {
            String ip = entry.getKey();
            Integer weight = entry.getValue();
            for (int i = 0; i < weight; i++) {
                ipList.add(ip);
            }
        }

        String server = null;
        synchronized (pos) {
            if (pos > ipList.size()) {
                pos = 0;
            }
            server = ipList.get(pos);
            pos++;
        }
        return server;
    }
}
