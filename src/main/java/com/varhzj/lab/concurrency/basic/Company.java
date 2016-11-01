package com.varhzj.lab.concurrency.basic;

public class Company implements Runnable {

	private Account account;

	public Company(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			account.addAccount(1000);
		}
	}

	public static void main(String[] args) {
		Account account = new Account();
		account.setBalance(1000);

		Thread companyThread = new Thread(new Company(account));
		Thread bankThread = new Thread(new Bank(account));
		System.out.println("Initial balance: " + account.getBalance());

		companyThread.start();
		bankThread.start();

		try {
			companyThread.join();
			bankThread.join();
			System.out.println("Final balance: " + account.getBalance());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
