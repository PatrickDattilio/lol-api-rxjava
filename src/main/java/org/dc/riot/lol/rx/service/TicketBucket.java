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
 * A single instance of this class should exist per
 * {@link ApiKey} per {@link org.dc.riot.lol.rx.service.Region Region}.
 * 
 * @author Dc
 * @since 1.0
 * @see {@link org.dc.riot.lol.rx.service.interfaces.ApiFactory RiotApiFactory}
 * @see {@link org.dc.riot.lol.rx.service.Region Region}
 */
public class TicketBucket {

	private long bufferMS = 750;
	private ArrayList<Bucket> buckets;

	/**
	 * @param rules the set of {@link RateRule}s that this {@link TicketBucket}
	 * should conform to
	 */
	TicketBucket(RateRule... rules) {
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
	 * @param tickets set of {@link Ticket}s retrieved using {@link #take()}
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
	
	public void setBuffer(int buffer, TimeUnit unit) {
		if (buffer > -1) {
			this.bufferMS = unit.toMillis(buffer);
		}
	}
	
	public long getBuffer() {
		return bufferMS;
	}
	
	public void stall(long delay, TimeUnit timeUnit) {
		for (Bucket b : buckets) {
			b.stall(delay, timeUnit);
		}
	}
	
	protected long getTime() {
		return System.currentTimeMillis();
	}

	/**
	 * Structured queue of {@link Ticket} objects
	 * 
	 * @author Dc
	 * @since 1.0
	 */
	private class Bucket {

		private UUID name = UUID.randomUUID();
		private ArrayBlockingQueue<Ticket> tickets;
		private RateRule rule;

		private final Object stallLock = new Object();
		private boolean stalled = false;
		private long unstallTime = 0L;
		private Runnable stallTask = () -> {
			while (getTime() < unstallTime) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// need to worry about this?
				}
			}

			synchronized (stallLock) {
				stalled = false;
				stallLock.notifyAll();
			}
		};

		private ScheduledExecutorService librarian;

		/**
		 * Generates the {@link Ticket} items contained in this {@link Bucket}
		 * 
		 * @param rule {@link RateRule} that this {@link Bucket} will conform to
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

			librarian = Executors.newScheduledThreadPool(2, new ThreadFactory() {
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
			if (stalled) {
				synchronized (stallLock) {
					if (stalled) {
						stallLock.wait();
					}
				}
			}

			return tickets.take();
		}

		/**
		 * Handles necessary <code>Thread.sleep</code> calls to ensure rates are maintained
		 * 
		 * @param t {@link Ticket} to return
		 * @return <code>true</code> if the supplied {@link Ticket} was scheduled for return, <code>false</code> otherwise
		 * @throws InterruptedException
		 */
		boolean put(Ticket t) throws InterruptedException {
			if (t.getParent().equals(name)) {
				librarian.schedule(() -> {
						try {
							tickets.put(t);
						} catch (InterruptedException e) {
						}
					},
					rule.getMilliseconds() + bufferMS,
					TimeUnit.MILLISECONDS);

				return true;
			} else {
				return false;
			}
		}
		
		/**
		 * Disables this {@link Bucket} for a certain amount of time.
		 * Note: {@link Ticket}s may be returned during this time
		 * @param delay
		 * @param unit
		 */
		void stall(long delay, TimeUnit unit) {
			stalled = true;
			long validTime = getTime() + unit.toMillis(delay);
			if (validTime > unstallTime) {
				librarian.schedule(stallTask, delay, unit);
			}
		}

		/**
		 * @return the {@link RateRule} that this {@link Bucket} conforms to
		 */
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
	 * should be obtained from {@link TicketBucket#take()}
	 * <br/>
	 * <br/>
	 * It is very important that tickets be returned via {@link TicketBucket#put(Ticket[])}
	 * else the {@link TicketBucket} will have no tickets to give and the application will deadlock.
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

		private Ticket(UUID parentName, int index) {
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
