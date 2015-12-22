package org.dc.riot.lol.rx.service.interfaces;

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
	 * @return {@link Call} object
	 */
	Call<T> call();
    
    /**
     * @param caller
     * @return
     */
    static <T> Observable<T> makeObservable(final RetroRxCaller<T> caller) {
    	return Observable.create((Subscriber<? super T> t) -> {
    		try {
    			Call<T> call = caller.call();
    			Response<T> response = call.execute();
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
