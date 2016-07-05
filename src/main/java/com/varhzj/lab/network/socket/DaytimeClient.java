package com.varhzj.lab.network.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class DaytimeClient {

	public static void main(String[] args) {
		String hostname = args.length > 0 ? args[0] : "time.nist.gov";
		try (Socket socket = new Socket(hostname, 13)) {
			socket.setSoTimeout(15000);
			InputStream in = socket.getInputStream();
			StringBuilder time = new StringBuilder();
			InputStreamReader reader = new InputStreamReader(in, "ASCII");
			int c;
			while ((c = reader.read()) != -1)
				time.append((char) c);
			System.out.println(time);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
