package com.varhzj.lab.concurrency.basic;

public class TicketOffice2 implements Runnable {

	private Cinema cinema;

	public TicketOffice2(Cinema cinema) {
		this.cinema = cinema;
	}

	@Override
	public void run() {
		cinema.sellTickets1(20);
		cinema.sellTickets2(20);
		cinema.sellTickets1(10);
		cinema.returnTickets2(5);
		cinema.sellTickets2(5);
		cinema.sellTickets1(10);
		cinema.sellTickets2(10);
	}

}
