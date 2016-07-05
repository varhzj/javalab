package com.varhzj.lab.netty.timeserver.bio;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BIOTimeServer {

	private static final int PORT = 8080;

	public static void main(String[] args) {
		ExecutorService executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), 50, 120L,
				TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10000));

		try (ServerSocket server = new ServerSocket(PORT)) {
			System.out.println("TimeServer start in port: " + PORT);
			Socket socket = null;
			while (true) {
				socket = server.accept();
				// new Thread(new TimeServerHandler(socket)).start();
				executor.execute(new TimeServerHandler(socket));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		executor.shutdown();
	}

}
