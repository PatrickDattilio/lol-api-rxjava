package org.dc.riot.lol.rx.service;

/**
 * Generic object containing request per time frame
 * @author Dc
 * @since 10/29/15
 */
public class RiotApiRateRule {

    private int requests;
    private int seconds;

    /**
     * @param requests requests allowed to make
     * @param seconds  window span in seconds allowed
     */
    public RiotApiRateRule(int requests, int seconds) {
        this.requests = requests;
        this.seconds = seconds;
    }

    public int getRequests() {
        return requests;
    }

    public int getSeconds() {
        return seconds;
    }

    /**
     * @param timeNow current time in epoch ms
     * @param offset index to start searching the timeline
     * @param entries the request timeline
     * @return the next epoch ms time in the timeline that could be a valid request time to satisfy
     * this rule
     */
    public long getNextTime(long timeNow, int offset, RiotApiTime ... entries) {
    	if (entries.length < requests) {
    		return timeNow;
    	}

    	long nextValidTime = timeNow;
    	for (int i=0; i<entries.length; i++) {
    		RiotApiTime ei = entries[i];
    		if (ei.getTime() < timeNow - seconds*1000) {
    			// this entry is older than this rule cares about
    			continue;
    		}

    		long timeWindowEnd = ei.getTime() + seconds*1000;
    		int count = 1;	// e is the first entry in the window
    		for (int j=i+1; j<entries.length; j++) {
    			RiotApiTime ej = entries[j];
    			if (ej.getTime() < timeWindowEnd) {
    				count++;
    				if (count == requests) {
    					long candidateTime = timeWindowEnd;
    					if (candidateTime >= nextValidTime) {
    						nextValidTime = candidateTime;
    					}
    					break;
    				}
    			}
    		}
    		
    		
    	}
    	
    	return nextValidTime;
    }

    @Override
    public String toString() {
        return "[" + RiotApiRateRule.class.getSimpleName() + "] " + requests + "/" + seconds;
    }

    public static RiotApiRateRule[] getDevelopmentRates() {
        RiotApiRateRule[] rules = new RiotApiRateRule[2];
        rules[0] = new RiotApiRateRule(500, 600);
        rules[1] = new RiotApiRateRule(10, 10);
        return rules;
    }

    public static RiotApiRateRule[] getProductionRates() {
        RiotApiRateRule[] rules = new RiotApiRateRule[1];
        rules[0] = new RiotApiRateRule(300, 10);
//        rules[1] = new RiotApiScheduleRule(180000, 600);  // commented out because it's linearly
                                                            // related to the previous rule
        return rules;
    }
}
