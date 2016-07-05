package com.varhzj.lab.concurrency.basic;

public class Company implements Runnable {

	private Account accout;

	public Company(Account accout) {
		this.accout = accout;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			accout.addAccout(1000);
		}
	}

	public static void main(String[] args) {
		Account accout = new Account();
		accout.setBalance(1000);

		Thread companyThread = new Thread(new Company(accout));
		Thread bankThread = new Thread(new Bank(accout));
		System.out.println("Initial balance: " + accout.getBalance());

		companyThread.start();
		bankThread.start();

		try {
			companyThread.join();
			bankThread.join();
			System.out.println("Final balance: " + accout.getBalance());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
