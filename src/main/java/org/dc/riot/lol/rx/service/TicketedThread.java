package org.dc.riot.lol.rx.service;

import org.dc.riot.lol.rx.service.RiotApiSemaphore.Ticket;

class TicketedThread extends Thread {
	
	private Ticket[] tickets = null;
	
	public TicketedThread() {
		super();
	}

	public TicketedThread(Runnable target, String name) {
		super(target, name);
	}

	public TicketedThread(Runnable target) {
		super(target);
	}

	public TicketedThread(String name) {
		super(name);
	}

	public TicketedThread(ThreadGroup group, Runnable target, String name, long stackSize) {
		super(group, target, name, stackSize);
	}

	public TicketedThread(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);
	}

	public TicketedThread(ThreadGroup group, Runnable target) {
		super(group, target);
	}

	public TicketedThread(ThreadGroup group, String name) {
		super(group, name);
	}

	void setTickets(Ticket... tickets) {
		if (tickets == null) {
			throw new IllegalArgumentException("Tickets can't be null");
		}

		if (this.tickets == null) {
			this.tickets = tickets;
		} else {
			throw new IllegalStateException("Cannot set already defined Tickets w/o first clearing");
		}
	}
	
	Ticket[] getTickets() {
		return this.tickets;
	}
	
	public void clearTickets() {
		if (this.tickets == null) {
			throw new IllegalStateException("Cannot clear already cleared tickets");
		} else {
			this.tickets = null;
		}
	}
	
	@Override
	public String toString() {
		String suffix = "";
		if (this.tickets != null) {
			for (Ticket t : this.tickets) {
				suffix += " " + t.toString();
			}
		}

		return super.getName() + suffix;
	}
}
