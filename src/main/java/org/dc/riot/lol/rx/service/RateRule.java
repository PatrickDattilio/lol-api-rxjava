package org.dc.riot.lol.rx.service;

import java.util.concurrent.TimeUnit;

/**
 * Generic object containing request per time frame.
 * 
 * @author Dc
 * @since 1.0
 */
public class RateRule {

    private int requests;
    private int per;
    private TimeUnit timeUnit;

    /**
     * Requests / unit-time (e.g. 500 requests per 10 minutes)
     * 
     * @param requests number of requests
     * @param per count of time units
     * @param timeUnit time unit
     */
    public RateRule(int requests, int per, TimeUnit timeUnit) {
        this.requests = requests;
        this.per = per;
        this.timeUnit = timeUnit;
    }

    /**
     * @return request count
     */
    public int getRequests() {
        return requests;
    }

    /**
     * @return number of time units`
     */
    public int getPer() {
        return per;
    }
    
    /**
     * @return time unit
     */
    public TimeUnit getTimeUnit() {
    	return timeUnit;
    }
    
    /**
     * @return convenience method to retrieve number of milliseconds this {@link RateRule}
     * specifies
     */
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
    		return super.equals(o);
    	}
    }
    
    /**
     * 
     * @param string REQUESTS PER TimeUnit (e.g. 500 10 MINUTES, read as 500 requests per 10 minutes)
     * @return a {@link RateRule} with the specified rate
     * @throws IllegalArgumentException if the given String cannot be parsed or contains invalid values
     * @throws NumberFormatException if the either the requests or per values are not valid integers
     */
    public static RateRule from(String string) {
    	String[] parts = string.split(" ");
    	if (parts.length != 3) {
    		throw new IllegalArgumentException("RateRule.from(String) must be passed a String formatted as REQUESTS PER TimeUnit");
    	}

    	int requests = Integer.parseInt(parts[0]);
    	if (requests < 0) {
    		throw new IllegalArgumentException();
    	}

    	int per = Integer.parseInt(parts[1]);
    	if (per < 0) {
    		throw new IllegalArgumentException();
    	}

    	TimeUnit timeUnit = TimeUnit.valueOf(parts[2]);
    	return new RateRule(requests, per, timeUnit);
    }

    /**
     * @return two {@link RateRule}s 500 10 minutes and 10 10 seconds
     * @see <a href="https://developer.riotgames.com/">Your Dashboard</a>
     */
    public static RateRule[] getDevelopmentRates() {
        RateRule[] rules = new RateRule[2];
        rules[0] = new RateRule(500, 10, TimeUnit.MINUTES);
        rules[1] = new RateRule(10, 10, TimeUnit.SECONDS);
        return rules;
    }

    /**
     * @return two {@link RateRule}s 180,000 10 MINUTES and 300 10 seconds
     * @see <a href="https://developer.riotgames.com/">Your Dashboard</a>
     */
    public static RateRule[] getProductionRates() {
        RateRule[] rules = new RateRule[2];
        rules[0] = new RateRule(180000, 10, TimeUnit.MINUTES);
        rules[1] = new RateRule(300, 10, TimeUnit.SECONDS);
        return rules;
    }
}
