package com.varhzj.lab.loadbalance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by varhzj on 2/7/17.
 * IP 散列
 */
public class HashChooser implements ServerChooser {

    @Override
    public String getServer(String remoteIp) {
        // TODO 这个方法会存在问题
        // 重建一个Map，避免服务器上下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<>();
        serverMap.putAll(IpMap.serverWeightMap);

        // 获取Ip地址列表
        List<String> ipList = new ArrayList<>(serverMap.keySet());

        int hashCode = remoteIp.hashCode();
        int ipSize = ipList.size();
        int pos = hashCode % ipSize;
        return ipList.get(pos);
    }
}
