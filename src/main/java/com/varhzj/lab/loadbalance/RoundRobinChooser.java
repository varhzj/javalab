package com.varhzj.lab.loadbalance;

import java.util.*;

/**
 * Created by varhzj on 2/7/17.
 * 轮询
 */
public class RoundRobinChooser implements ServerChooser{

    private static Integer pos = 0;

    @Override
    public String getServer(String remoteIp) {
        // TODO 这个方法会存在问题
        // 重建一个Map，避免服务器上下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<>();
        serverMap.putAll(IpMap.serverWeightMap);

        // 获取Ip地址列表
        List<String>  ipList = new ArrayList<>(serverMap.keySet());
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
