package com.varhzj.lab.network.serversocket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DayTimeServer {

	public final static int PORT = 1234;

	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(PORT)) {
			while (true) {
				try (Socket conn = server.accept()) {
					Writer out = new OutputStreamWriter(conn.getOutputStream());
					Date now = new Date();
					out.write(now.toString() + "\r\n");
					out.flush();
					conn.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
