package com.varhzj.lab.loadbalance;

/**
 * Created by varhzj on 2/7/17.
 */
public interface ServerChooser {

    String getServer(String remoteIp);

}
