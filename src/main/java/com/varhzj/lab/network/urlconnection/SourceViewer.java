package com.varhzj.lab.network.urlconnection;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SourceViewer {

	public static void main(String[] args) {
		if (args.length > 0) {
			URL u;
			try {
				u = new URL(args[0]);
				URLConnection uc = u.openConnection();
				try (InputStream raw = uc.getInputStream()) {
					InputStream buffer = new BufferedInputStream(raw);
					Reader reader = new InputStreamReader(buffer);
					int c;
					while ((c = reader.read()) != -1)
						System.out.print((char) c);
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
