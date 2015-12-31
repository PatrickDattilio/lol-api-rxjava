package org.dc.riot.lol.rx.service;

import java.util.concurrent.TimeUnit;

/**
 * Generic object containing request per time frame
 * @author Dc
 * @since 10/29/15
 */
public class RateRule {

    private int requests;
    private int per;
    private TimeUnit timeUnit;

    /**
     * @param requests requests allowed to make
     * @param seconds  window span in seconds allowed
     */
    public RateRule(int requests, int per, TimeUnit timeUnit) {
        this.requests = requests;
        this.per = per;
        this.timeUnit = timeUnit;
    }

    public int getRequests() {
        return requests;
    }

    public int getPer() {
        return per;
    }
    
    public TimeUnit getTimeUnit() {
    	return timeUnit;
    }
    
    public long getMilliseconds() {
    	return timeUnit.toMillis(per);
    }

    @Override
    public String toString() {
        return "[" + RateRule.class.getSimpleName() + " " + requests + "/" + per + " " + timeUnit + "]";
    }

    @Override
    public boolean equals(Object o) {
    	if (o instanceof RateRule) {
    		RateRule ro = (RateRule) o;
    		return ro.requests == this.requests &&
    				ro.getMilliseconds() == this.getMilliseconds();
    	} else {
    		return this == o;	// should always be false
    	}
    }
    
    /**
     * 
     * @param string REQUESTS PER TimeUnit (e.g. 500 10 MINUTES, read as 500 requests per 10 minutes)
     * @return a {@link RateRule} with the specified rate
     * @throws IllegalArgumentException if the given String cannot be parsed
     */
    public static RateRule from(String string) {
    	String[] parts = string.split(" ");
    	if (parts.length != 3) {
    		throw new IllegalArgumentException("RateRule.from(String) must be passed a String formatted as REQUESTS PER TimeUnit");
    	}

    	int requests = Integer.parseInt(parts[0]);
    	int per = Integer.parseInt(parts[1]);
    	TimeUnit timeUnit = TimeUnit.valueOf(parts[2]);
    	return new RateRule(requests, per, timeUnit);
    }

    public static RateRule[] getDevelopmentRates() {
        RateRule[] rules = new RateRule[2];
        rules[0] = new RateRule(500, 10, TimeUnit.MINUTES);
        rules[1] = new RateRule(10, 10, TimeUnit.SECONDS);
        return rules;
    }

    public static RateRule[] getProductionRates() {
        RateRule[] rules = new RateRule[2];
        rules[0] = new RateRule(300, 10, TimeUnit.SECONDS);
        rules[1] = new RateRule(180000, 10, TimeUnit.MINUTES);
        return rules;
    }
}
