package org.dc.riot.lol.rx;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.dc.riot.lol.rx.model.Mastery;
import org.dc.riot.lol.rx.model.MasteryPage;
import org.dc.riot.lol.rx.model.MasteryPagesDto;
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
	
	private RiotApi.Summoner summonerInterface = null;
	private ApiKey apiKey = null;
	private ApiFactory factory = null;
	private TestPrints prints = TestPrints.getInstance();
	
	@Before
	public void setup() throws FileNotFoundException {
		apiKey = ApiKey.loadApiKeys()[0];
		factory = ApiFactory.newDefaultFactory(apiKey);
		summonerInterface = factory.newSummonerInterface(region, true);
	}

	@Test
	public void testAll() throws IOException, InterruptedException, HttpException {
		Map<String,SummonerDto> summonersDto = summonerInterface.getByNames(names);
		
		assertNotNull("RiotApi.Summoner.getByNames(String[]) returned null", summonersDto);
		assertTrue("No summoners found", summonersDto.values().size() > 0);

		for (SummonerDto summonerDto : summonersDto.values()) {
			long summonerId = testSummonerDatas(summonerDto);
			testSummonerDatas(summonerId);
			testSummonerMasteries(summonerId);
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
	
	private void testSummonerDatas(long summonerId) throws IOException, HttpException {
		Map<String,SummonerDto> mapDto = summonerInterface.getByIds(summonerId);
		SummonerDto dto = mapDto.values().toArray(new SummonerDto[mapDto.values().size()])[0];
		
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
		
		long id = dto.getId();
		assertTrue("No summonerId", id == summonerId);
	}
	
	private void testSummonerMasteries(long summonerId) throws IOException, HttpException {
		Map<String,MasteryPagesDto> mapDto = summonerInterface.getMasteries(summonerId);
		MasteryPagesDto dto = mapDto.values().toArray(new MasteryPagesDto[mapDto.values().size()])[0];
		
		assertNotNull("Dto is null", dto);
		assertTrue("Mismatch summoner ID", dto.getSummonerId() == summonerId);
		
		for (MasteryPage mp : dto.getPages()) {
			long pageId = mp.getId();
			assertTrue("No mastery page ID", pageId > 0);
			
			String pageName = mp.getName();
			assertNotNull("Mastery page has no name", pageName);
			
			Mastery[] masteries = mp.getMasteries();
			assertNotNull("Mastery page is null", masteries);
			for (Mastery m : masteries) {
				assertTrue("No mastery rank", m.getRank() > 0);
				assertTrue("No mastery id", m.getMasterId() > 0);
			}
		}
	}
}
