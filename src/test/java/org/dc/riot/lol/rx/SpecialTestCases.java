package org.dc.riot.lol.rx;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.dc.riot.lol.rx.model.match.MatchListDto;
import org.dc.riot.lol.rx.model.staticdata.RuneListDto;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.Regions;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.error.HttpException;
import org.dc.riot.lol.rx.service.interfaces.ApiFactory;
import org.dc.riot.lol.rx.service.request.RuneListDataTag;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SpecialTestCases {
	
	private RiotApi.StaticData staticData = null;
	private RiotApi.MatchList matchListInterface = null;
	
	@Ignore
	@Before
	public void setup() throws FileNotFoundException {
		ApiKey apiKey = ApiKey.loadApiKeys()[0];
		ApiFactory factory = ApiFactory.newDefaultFactory(apiKey);
		staticData = factory.newStaticDataInterface(Regions.getByCode("NA"), true);
		matchListInterface = factory.newMatchListInterface(Regions.getByCode("NA"), false);
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
	
	@Test
	@Ignore
	public void testMatchList() throws IOException, HttpException {
		MatchListDto matchListDto = matchListInterface.getMatchList(20976644, null, null, null, -1, -1, 0, 99);
	}

}
