package org.dc.riot.lol.rx.service.interfaces;

import org.dc.riot.lol.rx.service.RiotApiTicketBucket;
import org.dc.riot.lol.rx.service.RiotApiTicketBucket.Ticket;
import org.dc.riot.lol.rx.service.error.HttpException;

import retrofit.Call;
import retrofit.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * {@link Observable} creator helper
 * @author Dc
 *
 * @param <T>
 */
interface RetroRxCaller<T> {
	
	public static boolean DEBUG = false;
	static final Object PRINT_LOCK = new Object();
	
	/**
	 * Make a single Retrofit call
	 * @param ticketHolder rate throttling {@link RiotApiTicketBucket}, <code>null</code> if no rate
	 * controls are desired
	 * @return {@link Call} object
	 */
	Call<T> call(RiotApiTicketBucket ticketHolder);
	
    /**
     * @param caller
     * @return
     */
    static <T> Observable<T> makeObservable(final RetroRxCaller<T> caller, final RiotApiTicketBucket bucket) {
    	return Observable.create((Subscriber<? super T> t) -> {
    		try {
    			Ticket[] tickets = null;
    			if (bucket != null) {
    				tickets = bucket.take();
    			}
    			
    			Call<T> call = caller.call(bucket);
    			Response<T> response = call.execute();
    			
    			if (tickets != null) {
    				bucket.put(tickets);
    			}

    			switch (response.code()) {
    			case 200:
					t.onNext(response.body());
					t.onCompleted();
					break;
    			 default:
    				throw new HttpException(response.code(), response.headers().toMultimap());
    			}
    		} catch (Exception e) {
    			t.onError(e);
    		}
    	});
    }
}
