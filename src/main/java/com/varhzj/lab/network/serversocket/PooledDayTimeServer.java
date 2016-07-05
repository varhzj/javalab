package com.varhzj.lab.network.serversocket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PooledDayTimeServer {

	private static final int PORT = 1313;
	private static final int POOL_SIZE = 50;

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(POOL_SIZE);
		try (ServerSocket server = new ServerSocket(PORT)) {
			while (true) {
				Socket conn = server.accept();
				pool.submit(new DaytimeTask(conn));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class DaytimeTask implements Callable<Void> {

		private Socket conn;

		DaytimeTask(Socket conn) {
			this.conn = conn;
		}

		@Override
		public Void call() throws Exception {
			try {
				Writer out = new OutputStreamWriter(conn.getOutputStream());
				Date now = new Date();
				out.write(now.toString() + "\r\n");
				out.flush();
			} catch (IOException ex) {
				System.err.println(ex);
			} finally {
				conn.close();
			}
			return null;
		}

	}

}
