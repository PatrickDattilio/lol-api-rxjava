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
 * @since 1.0.0
 * @see org.dc.riot.lol.rx.service.interfaces.ApiFactory ApiFactory
 * @see Region
 * @see ApiKey#getTicketBucket(Region)
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
	 * @throws InterruptedException if cancelled
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
	 * @throws InterruptedException if cancelled
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
	
	/**
	 * Set additional buffer time to wait between valid requests.
	 * 
	 * @param buffer time buffer
	 * @param unit time unit
	 */
	public void setBuffer(int buffer, TimeUnit unit) {
		if (buffer > -1) {
			this.bufferMS = unit.toMillis(buffer);
		}
	}
	
	/**
	 * @return the current time buffer
	 */
	public long getBuffer() {
		return bufferMS;
	}
	
	/**
	 * @param delay pause this {@link TicketBucket} for this many time units
	 * @param timeUnit time unit, usually seconds
	 */
	public void stall(long delay, TimeUnit timeUnit) {
		for (Bucket b : buckets) {
			b.stall(delay, timeUnit);
		}
	}
	
	/**
	 * Android subclasses can override this to provide a more
	 * Android appropriate method.
	 * 
	 * @return the current system time
	 */
	protected long getTime() {
		return System.currentTimeMillis();
	}

	/**
	 * Structured queue of {@link Ticket} objects.
	 * 
	 * @author Dc
	 * @since 1.0.0
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
		 * @throws InterruptedException if cancelled
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
		 * @throws InterruptedException if cancelled
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
		 * @param delay time to wait
		 * @param unit time unit
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
	 * <br>
	 * <br>
	 * It is very important that tickets be returned via {@link TicketBucket#put(Ticket[])}
	 * else the {@link TicketBucket} will have no tickets to give and the application will deadlock.
	 * <br>
	 * <br>
	 * Using {@link org.dc.riot.lol.rx.service.interfaces.ApiFactory ApiFactory}'s
	 * <code>new*Interface({@link Region},true);</code>
	 * will produce interface accessors with all rate control and Ticket management already set up.
	 * 
	 * @author Dc
	 * @since 1.0.0
	 * @see org.dc.riot.lol.rx.service.interfaces.ApiFactory ApiFactory
	 */
	public static class Ticket {
		private UUID name = UUID.randomUUID();
		private int index = -1;
		private UUID parentName;

		private Ticket(UUID parentName, int index) {
			this.parentName = parentName;
			this.index = index;
		}

		/**
		 * @return unique name of this {@link Ticket}
		 */
		public UUID getName() {
			return name;
		}

		/**
		 * @return unique parent name of this {@link Ticket}
		 */
		public UUID getParent() {
			return parentName;
		}

		/**
		 * @return unique index of this {@link Ticket} with its parent
		 */
		public int getIndex() {
			return index;
		}
		
		@Override
		public String toString() {
			return "[Ticket " + name + "]";
		}
	}

}
