package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;

import org.dc.riot.lol.rx.service.error.HttpException;

import retrofit.Call;
import retrofit.Response;
import rx.Observable;

/**
 * {@link Observable} creator helper
 * @author Dc
 *
 * @param <T>
 */
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
	static <T> T handleCaller(final RetrofitCaller<T> caller) throws IOException, HttpException {
		Call<T> call = caller.call();
		Response<T> response = call.execute();
		switch (response.code()) {
		case 200:
			return response.body();
		default:
			throw new HttpException(response.code(), response.headers().toMultimap());
		}
	}
}
