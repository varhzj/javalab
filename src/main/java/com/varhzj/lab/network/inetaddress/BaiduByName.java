package com.varhzj.lab.network.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class BaiduByName {

	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getByName("www.baidu.com");
			System.out.println(address);
			InetAddress[] all = InetAddress.getAllByName("www.baidu.com");
			for (InetAddress ia : all)
				System.out.println(ia.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
