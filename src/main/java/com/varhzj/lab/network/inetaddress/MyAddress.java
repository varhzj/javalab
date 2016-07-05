package com.varhzj.lab.network.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyAddress {

	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address.getCanonicalHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
