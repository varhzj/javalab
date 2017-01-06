package com.varhzj.lab.mylab.callback;

/**
 * Created by varhzj on 1/4/17.
 */
public class Server {

    public void getClientMsg(Callback callback, String msg) {
        System.out.println("Server: Receive message from client: " + msg);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Server: Succeed, return status 200");
        String status = "200";
        callback.process(status);
    }

}
