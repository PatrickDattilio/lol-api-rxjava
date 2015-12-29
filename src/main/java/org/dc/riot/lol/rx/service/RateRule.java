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

    public static RateRule[] getDevelopmentRates() {
        RateRule[] rules = new RateRule[2];
        rules[0] = new RateRule(500, 10, TimeUnit.MINUTES);
        rules[1] = new RateRule(10, 10, TimeUnit.SECONDS);
        return rules;
    }

    public static RateRule[] getProductionRates() {
        RateRule[] rules = new RateRule[1];
        rules[0] = new RateRule(300, 10, TimeUnit.SECONDS);
        rules[1] = new RateRule(180000, 10, TimeUnit.MINUTES);
        return rules;
    }
}
