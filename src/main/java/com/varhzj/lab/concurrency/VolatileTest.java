package com.varhzj.lab.concurrency;

public class VolatileTest {
	private static volatile int test = 0;

	public static void increase() {
		test++;
	}

	public static void main(String[] args) {
		for(int i = 0; i < 20; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					for (int j = 0; j < 100; j++)
						increase();
				}
			}).start();
		}

		System.out.println(test);
	}
}
