package org.dc.riot.lol.rx.service;

import java.io.IOException;

import org.dc.riot.lol.rx.service.RiotApiTokenBucket.Token;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Response;

public class RiotApiHttpThrottle implements Interceptor {
	
	private RiotApiTokenBucket bucket;
	
	public RiotApiHttpThrottle(RiotApiRateRule... rules) {
		bucket = new RiotApiTokenBucket(rules);
	}
	
	public void start() {
		bucket.start();
	}
	
	public void stop() {
		bucket.stop();
	}

	@Override
	public Response intercept(Chain chain) throws IOException {
		try {
			Token[] tokens = bucket.take();
			Response response = chain.proceed(chain.request());
			bucket.put(tokens);
			return response;
		} catch (InterruptedException e) {
			throw new IOException(e);
		}
	}

}
