package org.dc.riot.lol.rx.service.interfaces;

import java.net.Proxy;

import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.Region;
import org.dc.riot.lol.rx.service.RiotApi;

import com.squareup.okhttp.OkHttpClient;

/**
 * Base class for all RiotApi.* interface implementers
 * 
 * @author Dc
 * @since 1.0.0
 */
abstract class RiotApiBase implements RiotApi {
	
	protected final ApiKey apiKey;
	protected final Region region;
	protected final OkHttpClient client;
	
	private TicketedInterceptor ticketer = null;
	private RetryInterceptor retry = null;
	private int retryCount = 5;
	
	protected RiotApiBase(ApiKey apiKey, Region region, OkHttpClient client) {
		this.apiKey = apiKey;
		this.region = region;
		this.client = client;
	}
	
	RiotApiBase(ApiKey apiKey, Region region) {
		this(apiKey, region, new OkHttpClient());
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
	public void setAutoRetry(boolean autoRetry) {
		if (autoRetry && retry == null && client != null) {
			client.interceptors().add(retry = new RetryInterceptor(apiKey, region));
			retry.setRetryCount(retryCount);
		} else if (!autoRetry && retry != null && client != null) {
			client.interceptors().remove(retry);
			retry = null;
		}
	}
	
	@Override
	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
		if (retry != null) {
			retry.setRetryCount(retryCount);
		}
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
