package org.dc.riot.lol.rx;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;

import org.dc.riot.lol.rx.model.staticdata.RuneListDto;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.Region;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.interfaces.ApiFactory;
import org.dc.riot.lol.rx.service.request.RuneListDataTag;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SpecialTestCases {
	
	private RiotApi.StaticData staticData = null;
	
	@Ignore
	@Before
	public void setup() throws FileNotFoundException {
		ApiKey apiKey = ApiKey.loadApiKeys()[0];
		ApiFactory factory = ApiFactory.newDefaultFactory(apiKey);
		staticData = factory.newStaticDataInterface(Region.NORTH_AMERICA, true);
	}

	@Ignore
	@Test
	public void testSpecialCase() {
		try {
			RuneListDto dto = staticData.getRunes(null, null, RuneListDataTag.ALL);
			assertNotNull(dto);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
