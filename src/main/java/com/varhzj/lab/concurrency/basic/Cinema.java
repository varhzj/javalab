package com.varhzj.lab.concurrency.basic;

public class Cinema {

	private long vacanciesCinema1;
	private long vacanciesCinema2;

	private final Object ctrObj1, ctrObj2;

	public Cinema() {
		ctrObj1 = new Object();
		ctrObj2 = new Object();
		vacanciesCinema1 = 200;
		vacanciesCinema2 = 200;
	}

	public boolean sellTickets1(int num) {
		synchronized (ctrObj1) {
			if (num <= vacanciesCinema1) {
				vacanciesCinema1 -= num;
				return true;
			}
			return false;
		}
	}

	public boolean sellTickets2(int num) {
		synchronized (ctrObj2) {
			if (num <= vacanciesCinema2) {
				vacanciesCinema2 -= num;
				return true;
			}
			return false;
		}
	}

	public boolean returnTickets1(int num) {
		synchronized (ctrObj1) {
			vacanciesCinema1 += num;
			return true;
		}
	}

	public boolean returnTickets2(int num) {
		synchronized (ctrObj2) {
			vacanciesCinema2 += num;
			return true;
		}
	}

	public long getVacanciesCinema1() {
		return vacanciesCinema1;
	}

	public long getVacanciesCinema2() {
		return vacanciesCinema2;
	}

	public static void main(String[] args) {
		Cinema cinema = new Cinema();
		Thread ticketThread1 = new Thread(new TicketOffice1(cinema));
		Thread ticketThread2 = new Thread(new TicketOffice2(cinema));
		ticketThread1.start();
		ticketThread2.start();
		try {
			ticketThread1.join();
			ticketThread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Room 1 vacancies: " + cinema.getVacanciesCinema1());
		System.out.println("Room 2 vacancies: " + cinema.getVacanciesCinema2());
	}

}
