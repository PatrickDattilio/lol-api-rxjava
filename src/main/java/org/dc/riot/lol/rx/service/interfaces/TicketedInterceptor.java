package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;

import org.dc.riot.lol.rx.service.TicketBucket;
import org.dc.riot.lol.rx.service.TicketBucket.Ticket;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * {@link Intereptor} for all OkHttpClients used to retrieve data
 * from the LoL APIs. This should always be added to the beginning
 * of the intercepters list. Note: according to Riot's documentation
 * not all services need to be rate throttled. Only attach this
 * intercepter to instances that really need it.
 * 
 * @author Dc
 * @since 1.0.0
 */
class TicketedInterceptor implements Interceptor {
	
	private TicketBucket bucket;

	TicketedInterceptor(TicketBucket bucket) {
		this.bucket = bucket;
	}

	@Override
	public Response intercept(Chain chain) throws IOException {
		try {
			Ticket[] tickets = bucket.take();
			Response response = null;
			try {
				Request r = chain.request();
				response = chain.proceed(r);
			} finally {
				bucket.put(tickets);
			}

			return response;
		} catch (InterruptedException e) {
			throw new IOException(e);
		}
	}

}
