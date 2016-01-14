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
 * Implements the custom headers responses found on the Riot API
 * documentation. Reads the LoL API custom headers and responds
 * appropriately. All {@link RiotApi} instances should probably
 * use this intercepter.
 * 
 * @author Dc
 * @since 1.0.0
 */
class RetryInterceptor implements Interceptor {
	
	private ApiKey apiKey;
	private Region region;
	private long wait = 2000;
	private int retryCount = 5;
	
	RetryInterceptor(ApiKey apiKey, Region region) {
		this.apiKey = apiKey;
		this.region = region;
	}

	@Override
	public Response intercept(Chain chain) throws IOException {
		Request request = chain.request();
        Response response = null;
        boolean success = false;
        int tryCount = 0;

        while (!success && tryCount < retryCount) {
            try {
            	response = chain.proceed(request);

				if (response.code() == 429) {
					String type = response.header("X-Rate-Limit-Type");
					String waitSeconds = response.header("Retry-After");

					RiotApi.RateType rt = RiotApi.RateType.from(type);
					switch (rt) {
					case PERSONAL:
						if (waitSeconds == null) {
							apiKey.getTicketBucket(region).stall(wait, TimeUnit.MILLISECONDS);
							try { Thread.sleep(wait); } catch (InterruptedException e) { }
						} else {
							try {
								int wait = Integer.parseInt(waitSeconds);
								apiKey.getTicketBucket(region).stall(wait, TimeUnit.SECONDS);
								try { Thread.sleep(TimeUnit.SECONDS.toMillis(wait)); } catch (InterruptedException e) { }
							} catch (NumberFormatException e) {
								apiKey.getTicketBucket(region).stall(wait, TimeUnit.MILLISECONDS);
								try { Thread.sleep(wait); } catch (InterruptedException ex) { }
							}
						}
						
						break;
					case SERVICE:
						if (waitSeconds == null) {
							try { Thread.sleep(wait); } catch (InterruptedException e) { }
						} else {
							try {
								int wait = Integer.parseInt(waitSeconds);
								try { Thread.sleep(TimeUnit.SECONDS.toMillis(wait)); } catch (InterruptedException e) { }
							} catch (NumberFormatException e) {
								try { Thread.sleep(wait); } catch (InterruptedException ex) { }
							}
						}
						
						break;
					default:
						try { Thread.sleep(wait); } catch (InterruptedException e) { }
					}
				} else {
					break;
				}

				success = response.isSuccessful();                  
            } catch (Exception e) {
            	// just swallow this error and keep trying, we have other error handling up above this
            } finally {
                 tryCount++;      
            }
        }

        return response;
	}

	void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}
	
	void setWait(long wait) {
		this.wait = wait;
	}

}
