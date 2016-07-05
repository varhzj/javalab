package com.varhzj.lab.concurrency;

public class Singleton {

	private volatile static Singleton instance;

	private Singleton() {

	}

	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null)
					instance = new Singleton();
			}
		}
		return instance;
	}

	public static void main(String[] args) {
		Singleton ins1 = Singleton.getInstance();
		System.out.println(ins1 == Singleton.getInstance());
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		System.out.println(t1.isAlive());
		t1.start();

	}

}
