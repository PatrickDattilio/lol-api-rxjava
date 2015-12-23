package org.dc.riot.lol.rx.service.interfaces;

import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.RiotApiTicketBucket;

public class RiotApiBase implements RiotApi {
	
	protected final ApiKey apiKey;
	protected final Region region;
	
	private RiotApiTicketBucket ticketBucket = null;
	
	RiotApiBase(ApiKey apiKey, Region region) {
		this.apiKey = apiKey;
		this.region = region;
	}

	@Override
	public Region getRegion() {
		return region;
	}
	
	@Override
	public ApiKey getApiKey() {
		return apiKey;
	}
	
	public RiotApiTicketBucket getTicketBucket() {
		return ticketBucket;
	}
	
	@Override
	public void setTicketBucket(RiotApiTicketBucket ticketBucket) {
		this.ticketBucket = ticketBucket;
	}

}
