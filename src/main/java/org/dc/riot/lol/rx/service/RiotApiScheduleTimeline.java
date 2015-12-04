package org.dc.riot.lol.rx.service;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 
 * @author Dc
 * @since 11/16/2015
 */
class RiotApiScheduleTimeline {
	
	private ArrayList<RiotApiScheduleEntry> entries = new ArrayList<>();
	private Comparator<RiotApiScheduleEntry> comparator = new Comparator<RiotApiScheduleEntry>() {
		@Override
		public int compare(RiotApiScheduleEntry lhs, RiotApiScheduleEntry rhs) {
			if (lhs.isExecuted() && !rhs.isExecuted()) {
				return -1;
			} else if (!lhs.isExecuted() && rhs.isExecuted()) {
				return 1;
			} else if (!lhs.isExecuted() && !rhs.isExecuted()) {
				if (lhs.isScheduled() && rhs.isScheduled()) {
					if (lhs.getScheduledTime() > rhs.getScheduledTime()) {
						return 1;
					} else if (lhs.getScheduledTime() < rhs.getScheduledTime()) {
						return -1;
					} else {
						return 0;
					}
				} else if (!lhs.isScheduled() && !rhs.isScheduled()) {
					return 0;
				} else if (lhs.isScheduled() && !rhs.isScheduled()) {
					return -1;
				} else {
					return 1;
				}
			} else {
				if (lhs.getExecutedTime() > rhs.getExecutedTime()) {
					return 1;
				} else if (lhs.getExecutedTime() < rhs.getExecutedTime()) {
					return -1;
				} else {
					return 0;
				}
			}
		}
	};

	public synchronized void add(RiotApiScheduleEntry entry) {
		if (entry != null) {
			entries.add(entry);
			entries.sort(comparator);
		}
	}
	
	public synchronized RiotApiScheduleEntry[] getEntries() {
		return entries.toArray(new RiotApiScheduleEntry[entries.size()]);
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
				RiotApiScheduleEntry entry = entries.get(i);
				if (!(entry.isExecuted() && entry.getExecutedTime() < oldestTime)) {
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
}
