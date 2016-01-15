package org.dc.riot.lol.rx;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.dc.riot.lol.rx.model.SummonerDto;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.Region;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.error.HttpException;
import org.dc.riot.lol.rx.service.interfaces.ApiFactory;
import org.junit.Before;
import org.junit.Test;

public class EndpointTests {
	
	private final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");

	final String[] names = { "HuskarDc","Nightblue3","TheOddOne","feed l0rd"};
	final Region region = Region.NORTH_AMERICA;
	
	private ApiKey apiKey = null;
	private ApiFactory factory = null;
	private TestPrints prints = TestPrints.getInstance();
	
	@Before
	public void setup() throws FileNotFoundException {
		apiKey = ApiKey.loadApiKeys()[0];
		factory = ApiFactory.newDefaultFactory(apiKey);
	}

	@Test
	public void testAll() throws IOException, InterruptedException, HttpException {
		RiotApi.Summoner summonerInterface = factory.newSummonerInterface(region, true);
		Map<String,SummonerDto> summonersDto = summonerInterface.getByNames(names);
		
		assertNotNull("RiotApi.Summoner.getByNames(String[]) returned null", summonersDto);
		assertTrue("No summoners found", summonersDto.values().size() > 0);

		for (SummonerDto summonerDto : summonersDto.values()) {
			long summonerId = testSummonerDatas(summonerDto);
		}
	}
	
	private long testSummonerDatas(SummonerDto dto) {
		assertNotNull("Name is null", dto.getName());
		prints.println(dto.getName());
		
		assertNotNull("Region is null", dto.getRegion());
		prints.println(dto.getRegion());
		
		long iconId = dto.getProfileIconId();
		assertTrue("No icon id", iconId > 0);

		assertTrue("Revision date not set", dto.getRevisionDate() > 0);
		Date date = new Date(dto.getRevisionDate());
		prints.println(sdf.format(date));

		long level = dto.getSummonerLevel();
		assertTrue("Level not set", level > 0);
		
		long summonerId = dto.getId();
		assertTrue("No summonerId", summonerId > 0);
		
		return summonerId;
	}
}
