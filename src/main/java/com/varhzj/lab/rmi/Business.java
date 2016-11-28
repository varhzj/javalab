package com.varhzj.lab.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by varhzj on 11/21/16.
 */
public interface Business extends Remote {

    String echo(String msg) throws RemoteException;

}
