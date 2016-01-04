package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.dc.riot.lol.rx.service.RiotApi;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Unused at the moment
 * @author Dc
 * @since 1.0
 */
class TooFastRetryInterceptor implements Interceptor {
	
	private long defaultWait;
	private int retryCount;
	
	private TooFastRetryInterceptor() {
		this(2000, 5);
	}
	
	private TooFastRetryInterceptor(long defaultWait, int retryCount) {
		this.defaultWait = defaultWait;
		this.retryCount = retryCount;
	}

	@Override
	public Response intercept(Chain chain) throws IOException {
		Request request = chain.request();
        Response response = null;
        boolean responseOK = false;
        int tryCount = 0;

        while (!responseOK && tryCount < retryCount) {
            try {
            	response = chain.proceed(request);

				if (response.code() == 429) {
					String type = response.header("X-Rate-Limit-Type");
					RiotApi.RateType rt = RiotApi.RateType.from(type);
					switch (rt) {
					case PERSONAL:
						// not sure how to throttle broadly in this case
					case SERVICE:
						String waitSeconds = response.header("Retry-After");
						if (waitSeconds == null) {
							try { Thread.sleep(defaultWait); } catch (InterruptedException e) { }
						} else {
							int seconds = Integer.parseInt(waitSeconds);
							long sleep = TimeUnit.SECONDS.toMillis(seconds);
							try { Thread.sleep(sleep); } catch (InterruptedException e) { }
						}
						
						break;
					default:
						try { Thread.sleep(defaultWait); } catch (InterruptedException e) { }
					}
				}

				responseOK = response.isSuccessful();                  
            }catch (Exception e){
            }finally{
                 tryCount++;      
            }
        }

        // otherwise just pass the original response on
        return response;
	}

}
