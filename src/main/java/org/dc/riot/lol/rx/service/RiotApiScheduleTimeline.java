package org.dc.riot.lol.rx.service;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 
 * @author Dc
 * @since 11/16/2015
 */
class RiotApiScheduleTimeline {
	
	private ArrayList<RiotApiTime> entries = new ArrayList<>();
	private Comparator<RiotApiTime> comparator = new Comparator<RiotApiTime>() {
		@Override
		public int compare(RiotApiTime lhs, RiotApiTime rhs) {
			if (lhs.isExecuted() && !rhs.isExecuted()) {
				return -1;
			} else if (!lhs.isExecuted() && rhs.isExecuted()) {
				return 1;
			} else {
				if (lhs.getTime() > rhs.getTime()) {
					return 1;
				} else if (lhs.getTime() < rhs.getTime()) {
					return -1;
				} else {
					return 0;
				}
			}
		}
	};

	public synchronized void add(RiotApiTime entry) {
		if (entry != null) {
			entries.add(entry);
			entries.sort(comparator);
		}
	}
	
	public synchronized RiotApiTime[] getEntries() {
		return entries.toArray(new RiotApiTime[entries.size()]);
	}

	/**
	 * Remove old schedule entries according to the given {@link RiotApiRateRule}
	 * @param rule generally the longest time window you care about
	 */
	public synchronized void clean(RiotApiRateRule rule, long timeNow) {
		if (entries.size() > 0) {
			long oldestTime = timeNow - rule.getSeconds() * 1000;
			int trimToIndex = entries.size()-1;
			for (int i=entries.size()-1; i>=0; i--) {
				RiotApiTime entry = entries.get(i);
				if (!(entry.isExecuted() && entry.getTime() < oldestTime)) {
					trimToIndex = i+1;
					break;
				}
			}

			if (trimToIndex < entries.size()-1) {
				entries.removeAll(entries.subList(trimToIndex, entries.size()-1));
				entries.trimToSize();
			}
		}
	}

	public synchronized void clear() {
		entries.clear();
	}
}
