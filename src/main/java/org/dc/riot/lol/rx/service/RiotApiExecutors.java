package org.dc.riot.lol.rx.service;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class RiotApiExecutors {
	
	private static final int DEFAULT_FIXED_POOL_SIZE = 10;

	private RiotApiExecutors() { }

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

	public static Executor newCachedThreadPool(RateRule... rules) {
		return Executors.newCachedThreadPool();
	}
}
