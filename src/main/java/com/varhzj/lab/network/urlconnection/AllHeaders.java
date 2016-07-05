package com.varhzj.lab.network.urlconnection;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AllHeaders {

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			try {
				URL u = new URL(args[i]);
				System.out.println("========" + u + "========");
				URLConnection uc = u.openConnection();
				for (int j = 1;; j++) {
					String header = uc.getHeaderField(j);
					if (header == null)
						break;
					System.out.println(uc.getHeaderFieldKey(j) + ": " + header);
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println();
		}
	}

}
