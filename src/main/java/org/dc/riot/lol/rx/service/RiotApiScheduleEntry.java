package org.dc.riot.lol.rx.service;

public class RiotApiScheduleEntry {

	private boolean isScheduled = false;
	private boolean isExecuted = false;
	private long scheduledTime = -1;
	private long executedTime = -1;
	
	private Runnable action;
	
	public RiotApiScheduleEntry(Runnable action) {
		this.action = action;
	}
	
	public Runnable getAction() {
		return action;
	}
	
	public boolean isScheduled() {
		return isScheduled;
	}
	
	public long getScheduledTime() {
		return scheduledTime;
	}
	
	public void setScheduledTime(long scheduledTime) {
		if (isScheduled) {
			throw new IllegalStateException("Can't schedule more than once");
		}
		if (scheduledTime < 1) {
			throw new IllegalArgumentException("Invalid time: " + scheduledTime);
		}
		
		isScheduled = true;
		this.scheduledTime = scheduledTime;
	}
	
	public boolean isExecuted() {
		return isExecuted;
	}
	
	public long getExecutedTime() {
		return executedTime;
	}
	
	public long getTime() {
		if (isExecuted) {
			return executedTime;
		}
		
		return scheduledTime;
	}
	
	public void setExecutedTime(long executedTime) {
		if (isExecuted) {
			throw new IllegalStateException("Can't execute more than once");
		}
		if (executedTime < 1 || executedTime < scheduledTime) {
			throw new IllegalArgumentException("Invalid time: " + executedTime);
		}
		
		isExecuted = true;
		this.executedTime = executedTime;
	}
	
	@Override
	public String toString() {
		return "[" + RiotApiScheduleEntry.class.getSimpleName() + "] " +
				(isExecuted ? "exec: " + executedTime : (isScheduled ? "sched: " + scheduledTime : "waiting"));
	}
}
