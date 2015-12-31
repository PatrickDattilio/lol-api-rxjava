package org.dc.riot.lol.rx;

import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.RateRule;
import org.junit.Test;

public class ApiKeyTest {

	@Test
	public void testApiKeyLoading() {
		ApiKey[] apiKeys = ApiKey.getApiKeys();
		for (ApiKey k : apiKeys) {
			System.out.print("{ " + k + " ");
			for (RateRule r : k.getRules()) {
				System.out.print(r + " ");
			}
			
			System.out.println("}");
		}
	}
}
