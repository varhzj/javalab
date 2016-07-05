package com.varhzj.lab.concurrency.basic;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable {

	private static ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
		protected Date initialValue() {
			return new Date();
		}
	};
	private static ThreadLocal<Date> endDate = new ThreadLocal<>();

	@Override
	public void run() {
		System.out.println("Starting Thread: " + Thread.currentThread().getId() + ": " + startDate.get());
		try {
			TimeUnit.SECONDS.sleep((long) Math.rint(Math.random() * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread Finished: " + Thread.currentThread().getId() + ": " + startDate.get());
		System.out.println(endDate.get());
	}

	public static void main(String[] args) {
		SafeTask task = new SafeTask();
		for (int i = 0; i < 3; i++) {
			new Thread(task).start();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
