package org.dc.riot.lol.rx.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * Rate throttling semaphore. This is the primary rate throttling service.
 * A single instance of this class should exist per {@link org.dc.riot.lol.rx.model.Region Region}.
 * 
 * @author Dc
 * @since 1.0
 * @see {@link org.dc.riot.lol.rx.service.interfaces.ApiFactory RiotApiFactory}
 * @see {@link org.dc.riot.lol.rx.model.Region Region}
 */
public class TicketBucket {

	private int buffer = 750;
	private ArrayList<Bucket> buckets;

	public TicketBucket(RateRule... rules) {
		buckets = new ArrayList<>(rules.length);
		for (int i=0; i<rules.length; i++) {
			buckets.add(new Bucket(rules[i]));
		}

		Collections.sort(buckets, new Comparator<Bucket>() {
			@Override
			public int compare(Bucket lhs, Bucket rhs) {
				if (lhs.getRule().getMilliseconds() > rhs.getRule().getMilliseconds()) {
					return 1;
				} else if (lhs.getRule().getMilliseconds() < rhs.getRule().getMilliseconds()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
	}

	/**
	 * Takes a {@link Ticket} from each {@link Bucket} in this semaphore.
	 * Blocks until each {@link Bucket} yields a {@link Ticket}
	 * 
	 * @return a {@link Ticket} from each {@link Bucket}
	 */
	public Ticket[] take() throws InterruptedException {
		Ticket[] tickets = new Ticket[buckets.size()];
		for (int i=0; i<tickets.length; i++) {
			tickets[i] = buckets.get(i).take();
		}
		
		return tickets;
	}

	/**
	 * Return a set of {@link Ticket} to the appropriate {@link Bucket}(s)
	 * 
	 * @param tickets
	 */
	public void put(Ticket... tickets) throws InterruptedException {
		for (Ticket t : tickets) {
			for (Bucket b : buckets) {
				if (b.put(t)) {
					break;
				}
			}
		}
	}
	
	public void setBuffer(int buffer) {
		if (buffer > -1) {
			this.buffer = buffer;
		}
	}
	
	public int getBuffer() {
		return buffer;
	}

	/**
	 * Structured queue of {@link Ticket} objects
	 * 
	 * @author Dc
	 */
	private class Bucket {
		private static final int BUFFER_MS = 750;

		private UUID name = UUID.randomUUID();
		private ArrayBlockingQueue<Ticket> tickets;
		private RateRule rule;

		private ScheduledExecutorService librarian;

		/**
		 * Generates the {@link Ticket} items contained in this {@link Bucket}
		 * 
		 * @param rule
		 */
		Bucket(RateRule rule) {
			this.rule = rule;

			tickets = new ArrayBlockingQueue<>(rule.getRequests());
			try {
				for (int i=0; i<rule.getRequests(); i++) {
					tickets.put(new Ticket(name, i));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				// eat this, won't ever happen
			}

			librarian = Executors.newScheduledThreadPool(1, new ThreadFactory() {
				@Override
				public Thread newThread(Runnable r) {
					return new Thread(r, "LIBRARIAN-" + name);
				}
			});
		}

		/**
		 * Take a single {@link Ticket}. Blocks until a {@link Ticket} is available.
		 * 
		 * @return next available {@link Ticket}
		 * @throws InterruptedException
		 */
		Ticket take() throws InterruptedException {
			return tickets.take();
		}

		/**
		 * Handles necessary <code>Thread.sleep</code> calls to ensure rates are maintained
		 * 
		 * @param t {@link Ticket} to return
		 * @param alreadySlept allows a single Thread to return {@link Ticket}s to multiple {@link Bucket}s
		 * @return <code>true</code> if the supplied {@link Ticket} was returned, <code>false</code> otherwise
		 * @throws InterruptedException
		 */
		boolean put(Ticket t) throws InterruptedException {
			if (t.getParent().equals(name)) {
				librarian.schedule(() -> {
						try {
							tickets.put(t);
						} catch (InterruptedException e) {
							System.out.println("May have leaked a Ticket " + t.name);
						}
					},
					rule.getMilliseconds() + BUFFER_MS,
					TimeUnit.MILLISECONDS);

				return true;
			} else {
				return false;
			}
		}

		RateRule getRule() {
			return rule;
		}
		
		@Override
		public String toString() {
			return "[" + Bucket.class.getSimpleName() + " " + name + " " + rule + "]";
		}
	}

	/**
	 * Rate control ticket. Client code need not create these directly, they
	 * should be obtained from <code>TicketBucket.take();</code>
	 * <br/>
	 * <br/>
	 * It is very important that tickets be returned to their parent {@link TicketBucket},
	 * else the {@link TicketBucket} will have no Tickets to give and the application will deadlock.
	 * <br/>
	 * <br/>
	 * Using {@link org.dc.riot.lol.rx.service.interfaces.ApiFactory RiotApiFactory}'s
	 * <code>new*Interface(Region,true);</code>
	 * will produce interface accessors with all rate control and Ticket management already set up.
	 * 
	 * @author Dc
	 * @since 1.0
	 * @see {@link org.dc.riot.lol.rx.service.interfaces.ApiFactory RiotApiFactory}
	 */
	public static class Ticket {
		private UUID name = UUID.randomUUID();
		private int index = -1;
		private UUID parentName;

		Ticket(UUID parentName, int index) {
			this.parentName = parentName;
			this.index = index;
		}

		public UUID getName() {
			return name;
		}

		public UUID getParent() {
			return parentName;
		}

		public int getIndex() {
			return index;
		}
		
		@Override
		public String toString() {
			return "[Ticket " + name + "]";
		}
	}

}
