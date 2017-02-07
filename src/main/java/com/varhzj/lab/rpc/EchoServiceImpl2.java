package com.varhzj.lab.rpc;

/**
 * Created by varhzj on 2/7/17.
 */
public class EchoServiceImpl2 implements EchoService {

    @Override
    public String echo(String ping) {
        return ping;
    }
}
