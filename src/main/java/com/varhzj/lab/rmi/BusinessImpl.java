package com.varhzj.lab.rmi;

import java.rmi.RemoteException;

/**
 * Created by varhzj on 11/21/16.
 */
public class BusinessImpl implements Business {

    @Override
    public String echo(String msg) throws RemoteException {
        if ("quit".equalsIgnoreCase(msg)) {
            System.out.println("Server will be shutdown.");
            System.exit(0);
        }
        System.out.println("Message from client: " + msg);
        return "Server response: " + msg;
    }
}
