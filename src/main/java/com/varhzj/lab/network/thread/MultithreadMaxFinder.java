package com.varhzj.lab.network.thread;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultithreadMaxFinder {

	public static int max(int[] data) throws InterruptedException, ExecutionException {
		if (data == null)
			throw new IllegalArgumentException("Data cannot be null!");
		int length = data.length;
		if (length == 0)
			throw new IllegalArgumentException();
		if (length == 1)
			return data[0];
		long startTime = System.currentTimeMillis();
		ExecutorService service = Executors.newFixedThreadPool(2);
		Future<Integer> future1 = service.submit(new FindMaxTask(data, 0, length / 2));
		Future<Integer> future2 = service.submit(new FindMaxTask(data, length / 2 + 1, length));
		service.shutdown();
		int max = Math.max(future1.get(), future2.get());
		System.out.println("total cost:" + (System.currentTimeMillis() - startTime));
		return max;
	}

	public static void main(String[] args) throws Exception {
		Random rand = new Random();
		final int length = 100000000;
		int[] data = new int[length];
		for (int i = 0; i < length; i++)
			data[i] = rand.nextInt(length);
		System.out.println(max(data));
		System.out.println(new FindMaxTask(data, 0, length).call());
	}
}
