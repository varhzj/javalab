package com.varhzj.lab.concurrency.basic;

public class Bank implements Runnable{

	private Account accout;

	public Bank(Account accout) {
		this.accout = accout;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			accout.subtractAccout(1000);
		}
	}



}
