package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;

import org.dc.riot.lol.rx.service.TicketBucket;
import org.dc.riot.lol.rx.service.TicketBucket.Ticket;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

class TicketedInterceptor implements Interceptor {
	
	private TicketBucket bucket;

	TicketedInterceptor(TicketBucket bucket) {
		this.bucket = bucket;
	}

	@Override
	public Response intercept(Chain chain) throws IOException {
		try {
			Ticket[] tickets = bucket.take();
			Request r = chain.request();
			Response response = chain.proceed(r);
			bucket.put(tickets);
			return response;
		} catch (InterruptedException e) {
			throw new IOException(e);
		}
	}

}
