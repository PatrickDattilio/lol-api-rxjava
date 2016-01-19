package org.dc.riot.lol.rx.model;

/**
 * Used in the FeaturedGames API
 * 
 * @author Dc
 * @since 1.0.0
 * @see org.dc.riot.lol.rx.service.RiotApi.FeaturedGames RiotApi.FeaturedGames
 */
public class Participant {
	private boolean bot;	// Flag indicating whether or not this participant is a bot
	private long championId;	// The ID of the champion played by this participant
	private long profileIconId;	// The ID of the profile icon used by this participant
	private long spell1Id;	// The ID of the first summoner spell used by this participant
	private long spell2Id;	// The ID of the second summoner spell used by this participant
	private String summonerName;	// The summoner name of this participant
	private long teamId;	// The team ID of this participant, indicating the participant's team

	public boolean isBot() {
		return bot;
	}

	public void setBot(boolean bot) {
		this.bot = bot;
	}

	public long getChampionId() {
		return championId;
	}

	public void setChampionId(long championId) {
		this.championId = championId;
	}

	public long getProfileIconId() {
		return profileIconId;
	}
	
	public void setProfileIconId(long profileIconId) {
		this.profileIconId = profileIconId;
	}
	
	public long getSpell1Id() {
		return spell1Id;
	}
	
	public void setSpell1Id(long spell1Id) {
		this.spell1Id = spell1Id;
	}
	
	public long getSpell2Id() {
		return spell2Id;
	}
	
	public void setSpell2Id(long spell2Id) {
		this.spell2Id = spell2Id;
	}
	
	public String getSummonerName() {
		return summonerName;
	}
	
	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}
	
	public long getTeamId() {
		return teamId;
	}
	
	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}
}
