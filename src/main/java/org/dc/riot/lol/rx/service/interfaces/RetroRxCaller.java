package org.dc.riot.lol.rx.service.interfaces;

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
    			t.onNext(response.body());
    			t.onCompleted();
    		} catch (Exception e) {
    			t.onError(e);
    		}
    	});
    }
}
