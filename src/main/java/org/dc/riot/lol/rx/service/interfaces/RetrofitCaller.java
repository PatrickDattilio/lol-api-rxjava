package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;

import org.dc.riot.lol.rx.service.error.HttpException;

import retrofit.Call;
import retrofit.Response;

/**
 * {@link Call} unpacking helper
 * 
 * @author Dc
 * @since 1.0.0
 *
 * @param <T>
 */
@FunctionalInterface
interface RetrofitCaller<T> {

	public static boolean DEBUG = false;
	static final Object PRINT_LOCK = new Object();

	/**
	 * Make a single Retrofit call
	 * @return {@link Call} object
	 */
	Call<T> call();

	/**
	 * @param caller caller to wrap
	 * @return deserialized JSON object
	 * @throws IOException network issue
	 * @throws HttpException - any non 2XX response code
	 */
	static <T> T processCall(final RetrofitCaller<T> caller) throws IOException, HttpException {
		Call<T> call = caller.call();
		Response<T> response = call.execute();
		switch (response.code()) {
		case 200:
			return response.body();
		default:
			throw new HttpException(response.code(), response.headers().toMultimap());
		}
	}
	
	/**
	 * @param caller caller to wrap
	 * @param completer any custom processing that needs to happen on the received object
	 * 			before returning to calling code 
	 * @return json object
	 * @throws IOException network issue
	 * @throws HttpException - any non 2XX response code
	 */
	static <T> T processCall(final RetrofitCaller<T> caller, final Completer<T> completer) throws IOException, HttpException {
		T t = processCall(caller);
		return completer.fill(t);
	}
}
