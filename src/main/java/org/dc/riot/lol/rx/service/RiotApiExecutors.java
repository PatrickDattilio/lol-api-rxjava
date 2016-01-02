package org.dc.riot.lol.rx.service;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Convenience class for creating {@link Executor} instances. It is
 * generally preferred to use {@link RiotApiExecutors#newFixedThreadPool(RateRule...)}
 * for an optimal number of threads.
 * 
 * @author Dc
 * @since 1.0
 *
 */
public final class RiotApiExecutors {
	
	private static final int DEFAULT_FIXED_POOL_SIZE = 10;

	private RiotApiExecutors() { }

	/**
	 * A new {@link Executor} fixed size thread pool optimized to
	 * work with the specified rates.
	 * 
	 * @param rules {@link RateRule}s to conform with
	 * @return a thread pool of ideal thread count
	 */
	public static Executor newFixedThreadPool(RateRule... rules) {
		int nThreads = Integer.MAX_VALUE;
		
		for (RateRule r : rules) {
			if (r.getRequests() < nThreads) {
				nThreads = r.getRequests();
			}
		}
		
		if (nThreads == Integer.MAX_VALUE) {
			nThreads = DEFAULT_FIXED_POOL_SIZE;
		}
		
		return Executors.newFixedThreadPool(nThreads);
	}

	/**
	 * A new {@link Executor} fixed size thread pool optimized to
	 * work with the specified rates.
	 * 
	 * @param factory {@link ThreadFactory} to use
	 * @param rules {@link RateRule}s to conform with
	 * @return a thread pool of ideal thread count
	 */
	public static Executor newFixedThreadPool(ThreadFactory factory, RateRule... rules ) {
		int nThreads = Integer.MAX_VALUE;
		
		for (RateRule r : rules) {
			if (r.getRequests() < nThreads) {
				nThreads = r.getRequests();
			}
		}
		
		if (nThreads == Integer.MAX_VALUE) {
			nThreads = DEFAULT_FIXED_POOL_SIZE;
		}
		
		return Executors.newFixedThreadPool(nThreads, factory);
	}

	/**
	 * @return {@link Executors#newCachedThreadPool()}
	 */
	public static Executor newCachedThreadPool() {
		return Executors.newCachedThreadPool();
	}

	/**
	 * @param factory {@link ThreadFactory} to use
	 * @return {@link Executors#newCachedThreadPool(ThreadFactory)}
	 */
	public static Executor newCachedThreadPool(ThreadFactory factory) {
		return Executors.newCachedThreadPool(factory);
	}
}
