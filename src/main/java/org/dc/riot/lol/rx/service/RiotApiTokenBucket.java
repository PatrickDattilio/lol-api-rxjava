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

class RiotApiTokenBucket {

	private ArrayList<Bucket> buckets;

	RiotApiTokenBucket(RiotApiRateRule... rules) {
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
	
	public synchronized void start() {
		for (Bucket b : buckets) {
			b.start();
		}
	}
	
	public synchronized void stop() {
		for (Bucket b : buckets) {
			b.stop();
		}
	}

	/**
	 * Takes a {@link Token} from each {@link Bucket} in this bucket.
	 * Blocks until each {@link Bucket} yields a {@link Token}
	 * 
	 * @return a {@link Token} from each {@link Bucket}
	 */
	public Token[] take() throws InterruptedException {
		Token[] tokens = new Token[buckets.size()];
		for (int i=0; i<tokens.length; i++) {
			tokens[i] = buckets.get(i).take();
		}
		
		return tokens;
	}

	/**
	 * Return a set of {@link Token} to the appropriate {@link Bucket}(s)
	 * 
	 * @param tokens
	 */
	public void put(Token... tokens) throws InterruptedException {
		long timeNow = onGetTime();
		for (Token t : tokens) {
			for (Bucket b : buckets) {
				if (b.put(t, timeNow)) {
					break;
				}
			}
		}
	}
	
	protected long onGetTime() {
		return System.currentTimeMillis();
	}

	/**
	 * Structured list of {@link Token} objects
	 * 
	 * @author Dc
	 */
	private class Bucket {

		private UUID name = UUID.randomUUID();
		private RiotApiRateRule rule;

		private ScheduledExecutorService librarian;
		private ArrayBlockingQueue<Token> inbox;
		private ArrayBlockingQueue<Token> availableTokens;

		/**
		 * Generates the {@link Token} items contained in this {@link Bucket}
		 * 
		 * @param rule
		 */
		Bucket(RiotApiRateRule rule) {
			this.rule = rule;

			availableTokens = new ArrayBlockingQueue<>(rule.getRequests());
			inbox = new ArrayBlockingQueue<>(rule.getRequests());
			try {
				for (int i=0; i<rule.getRequests(); i++) {
					availableTokens.put(new Token(name));
				}
			} catch (InterruptedException e) {
				// eat this, won't ever happen
			}
		}
		
		synchronized void start() {
			if (librarian != null) {
				return;
			}

			librarian = Executors.newScheduledThreadPool(1, new ThreadFactory() {
				@Override
				public Thread newThread(Runnable r) {
					return new Thread(r, "LIBRARIAN-" + name);
				}
			});

			librarian.scheduleAtFixedRate(() -> {
				Token next = inbox.peek();
				while (next != null) {
					long timeNow = onGetTime();
					if (next.getValidTime() < timeNow) {
						try {
							availableTokens.put(next);
							inbox.take();
							next = inbox.peek();
						} catch (Exception e) {
							break;
						}
					} else {
						break;
					}
				}
			}, 0, 1, TimeUnit.SECONDS);
		}
		
		synchronized void stop() {
			if (librarian != null) {
				librarian.shutdownNow();
				librarian = null;
			}
		}

		/**
		 * Take a single {@link Token}. Blocks until a {@link Token} is available.
		 * 
		 * @return next available {@link Token}
		 * @throws InterruptedException
		 */
		Token take() throws InterruptedException {
			return availableTokens.take();
		}

		/**
		 * Handles necessary <code>Thread.sleep</code> calls to ensure rates are maintained
		 * 
		 * @param t {@link Token} to return
		 * @param timeNow the current time
		 * @return <code>true</code> if the supplied {@link Token} was returned, <code>false</code> otherwise
		 * @throws InterruptedException
		 */
		boolean put(Token t, long timeNow) throws InterruptedException {
			if (t.getParent().equals(name)) {
				t.setValidTime(timeNow + rule.getMilliseconds());
				inbox.put(t);
				return true;
			} else {
				return false;
			}
		}

		RiotApiRateRule getRule() {
			return rule;
		}
		
		@Override
		public String toString() {
			return "[" + Bucket.class.getSimpleName() + " " + name + " " + rule + "]";
		}
	}

	/**
	 * 
	 * @author Dc
	 */
	static class Token {
		private UUID name = UUID.randomUUID();
		private long nextTime = -1;
		private UUID parentName;

		Token(UUID parentName) {
			this.parentName = parentName;
		}

		UUID getName() {
			return name;
		}

		UUID getParent() {
			return parentName;
		}
		
		long getValidTime() {
			return nextTime;
		}
		
		void setValidTime(long nextTime) {
			if (nextTime < this.nextTime) {
				throw new IllegalArgumentException("Can't go backward in time");
			}
			
			this.nextTime = nextTime;
		}
		
		@Override
		public String toString() {
			return "[Token " + name + "]";
		}
	}

}
