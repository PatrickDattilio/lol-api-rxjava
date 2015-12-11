package org.dc.riot.lol.rx.service;

class RiotApiTime {
	
	private long time;
	private boolean isExecuted = false;
	
	public RiotApiTime(long time) {
		if (time < 0) {
			throw new IllegalArgumentException("Time can't be less than 0");
		}

		this.time = time;
	}

	public synchronized long getTime() {
		return time;
	}
	
	public synchronized void shiftTime(long dxTime) {
		if (dxTime < 0) {
			throw new IllegalArgumentException("Can't push schedule to the left");
		}
		setTime(time + dxTime);
	}
	
	public synchronized void setTime(long time) {
		if (isExecuted) {
			throw new IllegalStateException("This object has already been executed");
		}
		
		this.time = time;
	}
	
	public synchronized boolean isExecuted() {
		return isExecuted;
	}

	public synchronized void executed() {
		if (isExecuted) {
			throw new IllegalStateException("Already executed");
		}
		
		isExecuted = true;
	}

}
