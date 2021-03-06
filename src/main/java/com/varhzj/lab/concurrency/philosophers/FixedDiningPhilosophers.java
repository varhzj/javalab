package com.varhzj.lab.concurrency.philosophers;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixedDiningPhilosophers {

	public static void main(String[] args) throws InterruptedException, IOException {
		int ponder = 0;
		if (args.length > 0)
			ponder = Integer.parseInt(args[0]);
		int size = 5;
		if (args.length > 1)
			size = Integer.parseInt(args[1]);
		ExecutorService exec = Executors.newCachedThreadPool();
		Chopstick[] chopsticks = new Chopstick[size];
		for (int i = 0; i < size; i++)
			chopsticks[i] = new Chopstick();
		for (int i = 0; i < size; i++)
			if (i < size - 1)
				exec.execute(new Philosopher(chopsticks[i], chopsticks[i + 1], i, ponder));
			else
				exec.execute(new Philosopher(chopsticks[0], chopsticks[i], i, ponder));
		if (args.length == 3 && "timeout".equals(args[2]))
			TimeUnit.SECONDS.sleep(5);
		else {
			System.out.println("Press 'Enter' to quit");
			System.in.read();
		}
		exec.shutdownNow();
	}

}
