package com.varhzj.lab.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Horse implements Runnable {

	private static int counter = 0;
	private final int id = counter++;
	private int strides = 0;
	private static Random rand = new Random(47);
	private static CyclicBarrier barrirer;

	public Horse(CyclicBarrier b) {
		barrirer = b;
	}

	public synchronized int getStrides() {
		return strides;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					strides += rand.nextInt(3);
				}
				barrirer.await();
			}
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

	public String toString() {
		return "Horse " + id + " ";
	}

	public String tracks() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strides; i++)
			sb.append("*");
		sb.append(id);
		return sb.toString();
	}

}

public class HorseRace {

	static final int FINISH_LINE = 75;
	private List<Horse> horses = new ArrayList<>();
	private ExecutorService exec = Executors.newCachedThreadPool();
	private CyclicBarrier barrirer;

	public HorseRace(int nHorses, int pause) {
		barrirer = new CyclicBarrier(nHorses, new Runnable() {

			@Override
			public void run() {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < FINISH_LINE; i++)
					sb.append("=");
				System.out.println(sb);
				for (Horse horse : horses)
					System.out.println(horse.tracks());
				for (Horse horse : horses)
					if (horse.getStrides() >= FINISH_LINE) {
						System.out.println(horse + " won!");
						exec.shutdownNow();
						return;
					}
				try {
					TimeUnit.MILLISECONDS.sleep(pause);
				} catch (InterruptedException e) {
					System.out.println("barrier-action sleep interrupted");
				}
			}

		});

		for (int i = 0; i < nHorses; i++) {
			Horse horse = new Horse(barrirer);
			horses.add(horse);
			exec.execute(horse);
		}
	}

	public static void main(String[] args) {
		int nHorses = 7;
		int pause = 200;
		if (args.length > 0) {
			int n = Integer.parseInt(args[0]);
			nHorses = n > 0 ? n : nHorses;
		}
		if (args.length > 1) {
			int p = Integer.parseInt(args[1]);
			pause = p > 0 ? p : pause;
		}
		new HorseRace(nHorses, pause);
	}

}
