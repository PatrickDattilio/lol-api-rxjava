package org.dc.riot.lol.rx.service;

@FunctionalInterface
public interface RateExceededListener {
	
	void onRateExceeded(RiotApi api, ApiKey apiKey);

}
