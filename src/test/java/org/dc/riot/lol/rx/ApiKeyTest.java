package org.dc.riot.lol.rx;

import java.io.FileNotFoundException;

import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.RateRule;
import org.junit.Ignore;
import org.junit.Test;

public class ApiKeyTest {

	@Ignore
	@Test
	public void testApiKeyLoading() throws FileNotFoundException {
		ApiKey[] apiKeys = ApiKey.loadApiKeys();
		for (ApiKey k : apiKeys) {
			System.out.print("{ " + k + " ");
			for (RateRule r : k.getRules()) {
				System.out.print(r + " ");
			}
			
			System.out.println("}");
		}
	}
}
