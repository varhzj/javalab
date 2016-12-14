package com.varhzj.lab.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by varhzj on 11/21/16.
 */
public class Client {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost");
        String name = "BusinessDemo";
        Business business = (Business) registry.lookup(name);
        System.out.println(business.echo("hello"));
        business.echo("quit");
    }

}
