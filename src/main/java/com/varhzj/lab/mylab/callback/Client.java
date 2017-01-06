package com.varhzj.lab.mylab.callback;

/**
 * Created by varhzj on 1/4/17.
 */
public class Client {

    private Server server;

    public Client(Server server) {
        this.server = server;
    }

    public void sendMsg(String msg) {
        System.out.println("Client: Send message " + msg + "to server");
        new Thread(new Runnable() {
            @Override
            public void run() {
                server.getClientMsg(new Callback() {
                    @Override
                    public void process(String status) {
                        System.out.println("Client: Server callback return " + status);
                    }
                }, msg);
            }
        }).start();
        System.out.println("Client: Send message async succeed.");
    }


}
