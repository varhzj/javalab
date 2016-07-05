package com.varhzj.lab.netty.timeserver.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class TimeServerHandler implements Runnable {

	private Socket socket;
	private static final String QUERY_TIME = "QUERY TIME";

	public TimeServerHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);) {
			String currentTime = null;
			String order = null;
			while (true) {
				order = in.readLine();
				if (order == null)
					break;
				System.out.println("TimeServer -" + Thread.currentThread().getName() + "- recive order: " + order);
				currentTime = QUERY_TIME.equalsIgnoreCase(order) ? new Date(System.currentTimeMillis()).toString()
						: "BAD ORDER";
				out.println(currentTime);
			}
		} catch (Exception e) {
			if (socket != null)
				try {
					socket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			socket = null;
		}
	}

}
