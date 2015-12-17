package org.dc.riot.lol.rx.service;

import java.util.concurrent.TimeUnit;

/**
 * Generic object containing request per time frame
 * @author Dc
 * @since 10/29/15
 */
public class RiotApiRateRule {

    private int requests;
    private int per;
    private TimeUnit timeUnit;

    /**
     * @param requests requests allowed to make
     * @param seconds  window span in seconds allowed
     */
    public RiotApiRateRule(int requests, int per, TimeUnit timeUnit) {
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
        return "[" + RiotApiRateRule.class.getSimpleName() + " " + requests + "/" + per + " " + timeUnit + "]";
    }

    public static RiotApiRateRule[] getDevelopmentRates() {
        RiotApiRateRule[] rules = new RiotApiRateRule[2];
        rules[0] = new RiotApiRateRule(500, 10, TimeUnit.MINUTES);
        rules[1] = new RiotApiRateRule(10, 10, TimeUnit.SECONDS);
        return rules;
    }

    public static RiotApiRateRule[] getProductionRates() {
        RiotApiRateRule[] rules = new RiotApiRateRule[1];
        rules[0] = new RiotApiRateRule(300, 10, TimeUnit.SECONDS);
        rules[1] = new RiotApiRateRule(180000, 10, TimeUnit.MINUTES);
        return rules;
    }
}
