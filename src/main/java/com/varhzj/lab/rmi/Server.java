package com.varhzj.lab.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by varhzj on 11/21/16.
 */
public class Server {

    public static void main(String[] args) throws RemoteException {
        int port = 9527;
        String name = "BusinessDemo";
        Business business = new BusinessImpl();
        UnicastRemoteObject.exportObject(business, port);
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind(name, business);
    }

}
