package com.varhzj.lab.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

	public static AtomicInteger race = new AtomicInteger(0);

	public static void increase() {
		race.incrementAndGet();
	}

	public static void main(String[] args) {
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("test");
			}
		});
		t2.start();

		for (int i = 0; i < 20; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
					for (int j = 0; j < 1000; j++)
						increase();
				}
			}).start();
		}

		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(race.get());
	}

}
