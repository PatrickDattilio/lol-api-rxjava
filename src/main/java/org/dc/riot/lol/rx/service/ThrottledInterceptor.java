package org.dc.riot.lol.rx.service;

import java.io.IOException;

import org.dc.riot.lol.rx.service.RiotApiSemaphore.Ticket;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Response;

public class ThrottledInterceptor implements Interceptor {
	
	private RiotApiSemaphore ticketMaster;
	
	ThrottledInterceptor(RiotApiRateRule... rules) {
		ticketMaster = new RiotApiSemaphore(rules);
	}

	@Override
	public Response intercept(Chain chain) throws IOException {
		Ticket[] tickets = null;
		try {
			tickets = ticketMaster.take();
			Response response = chain.proceed(chain.request());
			ticketMaster.put(tickets);
			return response;
		} catch (InterruptedException e) {
			throw new IOException(e);
		} finally {
			if (tickets != null) {
				try {
					ticketMaster.put(tickets);
				} catch (InterruptedException e) {
					e.printStackTrace();
					throw new IOException(e);
				}
			}
		}
	}

}
