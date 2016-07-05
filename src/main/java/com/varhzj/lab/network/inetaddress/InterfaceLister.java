package com.varhzj.lab.network.inetaddress;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class InterfaceLister {

	public static void main(String[] args) {
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			while (interfaces.hasMoreElements())
				System.out.println(interfaces.nextElement());
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

}
