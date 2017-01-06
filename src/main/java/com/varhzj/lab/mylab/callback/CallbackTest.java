package com.varhzj.lab.mylab.callback;

/**
 * Created by varhzj on 1/4/17.
 */
public class CallbackTest {

    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client(server);

        client.sendMsg("Hello, Server.");
    }

}
