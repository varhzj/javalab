package com.varhzj.lab.rpc;

/**
 * Created by varhzj on 2/7/17.
 */
public class EchoServiceImpl implements EchoService {

    @Override
    public String echo(String ping) {
        return ping != null ? ping + " --> I am ok." : "I am ok.";
    }
}
