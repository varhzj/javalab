package com.varhzj.lab.netty.timeserver.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

public class BIOTimeClient {

	private static final int PORT = 8080;
	private static final int THREAD_NUM = 1000;
	private static final String QUERY_TIME = "QUERY TIME";
	private static final CountDownLatch latch = new CountDownLatch(THREAD_NUM);

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < THREAD_NUM; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					try (Socket socket = new Socket("localhost", PORT);
							BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
							PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
						out.println(QUERY_TIME);
						System.out.println(
								"TimeClient - " + Thread.currentThread().getName() + " - send order to server");
						System.out.println(
								"TimeClient - " + Thread.currentThread().getName() + " - Now is " + in.readLine());
					} catch (Exception e) {

					}
					latch.countDown();
				}

			}).start();
		}

		try {
			latch.await();
			System.out.println("Cost time: " + (System.currentTimeMillis() - startTime) + "ms");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
