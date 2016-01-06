package org.dc.riot.lol.rx.service.interfaces;

import java.net.Proxy;

import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.RiotApi;

import com.squareup.okhttp.OkHttpClient;

/**
 * Base class for all RiotApi.* interface implementers
 * @author Dc
 * @since 1.0
 */
abstract class RiotApiBase implements RiotApi {
	
	protected final ApiKey apiKey;
	protected final Region region;
	protected final OkHttpClient client;
	
	private TicketedInterceptor ticketer = null;
	
	protected RiotApiBase(ApiKey apiKey, Region region, OkHttpClient client) {
		this.apiKey = apiKey;
		this.region = region;
		this.client = client;
	}
	
	RiotApiBase(ApiKey apiKey, Region region) {
		this.apiKey = apiKey;
		this.region = region;
		this.client = new OkHttpClient();
	}

	@Override
	public Region getRegion() {
		return region;
	}
	
	@Override
	public ApiKey getApiKey() {
		return apiKey;
	}
	
	@Override
	public void setProxy(Proxy proxy) {
		client.setProxy(proxy);
	}
	
	@Override
	public void setRateControl(boolean control) {
		if (control) {
			if (ticketer == null) {
				ticketer = new TicketedInterceptor(apiKey.getTicketBucket(region));
				if (client != null) {
					client.interceptors().add(0, ticketer);
				}
			}
		} else {
			if (ticketer != null && client != null) {
				client.interceptors().remove(ticketer);
			}

			ticketer = null;
		}
	}
	
}
