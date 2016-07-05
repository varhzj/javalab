package com.varhzj.lab.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {

	private IntGenerator generator;
	private final int id;

	public EvenChecker(IntGenerator g, int ident) {
		this.generator = g;
		this.id = ident;
	}

	@Override
	public void run() {
		System.out.println(id);
		while (!generator.isCanceled()) {
			int val = generator.next();
			if (val % 2 != 0) {
				System.out.println(val + " is not even!");
				generator.cancel();
			}
		}
	}

	public static void test(IntGenerator g, int count) {
		System.out.println("Press CTRL-C to exit");
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < count; i++) {
			exec.execute(new EvenChecker(g, i));
		}
		exec.shutdown();
	}

	public static void test(IntGenerator g) {
		test(g, 10);
	}

}
