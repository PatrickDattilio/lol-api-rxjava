package org.dc.riot.lol.rx.service.interfaces;

import java.net.Proxy;

import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.Region;
import org.dc.riot.lol.rx.service.RiotApi;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Interceptor.Chain;

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
	private boolean printUrls = false;
	
	RiotApiBase(ApiKey apiKey, Region region) {
		this.apiKey = apiKey;
		this.region = region;
		this.client = new OkHttpClient();
		client.interceptors().add((Chain chain) -> {
			Request request = chain.request();
			if (printUrls) {
				System.out.println(request.urlString());
			}
			
			return chain.proceed(request);
		});
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
	public void setPrintUrl(boolean printUrls) {
		this.printUrls = printUrls;
	}
	
	@Override
	public synchronized void setAutoRetry(boolean autoRetry) {
		if (autoRetry && retry == null && client != null) {
			client.interceptors().add(retry = new RetryInterceptor(apiKey, region));
			retry.setRetryCount(retryCount);
		} else if (!autoRetry && retry != null && client != null) {
			client.interceptors().remove(retry);
			retry = null;
		}
	}
	
	@Override
	public synchronized void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
		if (retry != null) {
			retry.setRetryCount(retryCount);
		}
	}
	
	@Override
	public synchronized void setRateControl(boolean control) {
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
