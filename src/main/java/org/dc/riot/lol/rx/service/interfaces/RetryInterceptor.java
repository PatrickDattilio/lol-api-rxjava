package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.Region;
import org.dc.riot.lol.rx.service.RiotApi;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Unused at the moment
 * @author Dc
 * @since 1.0
 */
class RetryInterceptor implements Interceptor {
	
	private ApiKey apiKey;
	private Region region;
	private long defaultWait;
	private int retryCount;
	
	private RetryInterceptor(ApiKey apiKey, Region region) {
		this(apiKey, region, 2000, 5);
	}
	
	private RetryInterceptor(ApiKey apiKey, Region region, long defaultWait, int retryCount) {
		this.apiKey = apiKey;
		this.region = region;
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
					String waitSeconds = response.header("Retry-After");

					RiotApi.RateType rt = RiotApi.RateType.from(type);
					switch (rt) {
					case PERSONAL:
						if (waitSeconds == null) {
							apiKey.getTicketBucket(region).stall(defaultWait, TimeUnit.MILLISECONDS);
						} else {
							try {
								int wait = Integer.parseInt(waitSeconds);
								apiKey.getTicketBucket(region).stall(wait, TimeUnit.SECONDS);
							} catch (NumberFormatException e) {
								apiKey.getTicketBucket(region).stall(defaultWait, TimeUnit.MILLISECONDS);
							}
						}
						break;
					case SERVICE:
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
				} else {
					break;
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
