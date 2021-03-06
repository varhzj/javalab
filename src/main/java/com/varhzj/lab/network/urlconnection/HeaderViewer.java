package com.varhzj.lab.network.urlconnection;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class HeaderViewer {

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			try {
				URL u = new URL(args[i]);
				System.out.println("=========" + u + "=========");
				URLConnection uc = u.openConnection();
				System.out.println("Content-type: " + uc.getContentType());
				if (uc.getContentEncoding() != null)
					System.out.println("Content-encoding: " + uc.getContentEncoding());
				if (uc.getDate() != 0)
					System.out.println("Date: " + new Date(uc.getDate()));
				if (uc.getLastModified() != 0)
					System.out.println("Last modified: " + new Date(uc.getLastModified()));
				if (uc.getExpiration() != 0)
					System.out.println("Expired date: " + new Date(uc.getExpiration()));
				if (uc.getContentLength() != -1)
					System.out.println("Content-length: " + uc.getContentLength());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println();
		}
	}

}
