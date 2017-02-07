package com.varhzj.lab.loadbalance;

import java.util.*;

/**
 * Created by varhzj on 2/7/17.
 * 随机
 */
public class RandomChooser implements ServerChooser {

    private static Random random = new Random();

    @Override
    public String getServer(String remoteIp) {
        // TODO 这个方法会存在问题
        // 重建一个Map，避免服务器上下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<>();
        serverMap.putAll(IpMap.serverWeightMap);

        // 获取Ip地址列表
        List<String> ipList = new ArrayList<>(serverMap.keySet());
        int pos = random.nextInt(ipList.size());
        return ipList.get(pos);
    }
}
