package org.dc.riot.lol.rx.model;

public class ChampionMetaDto {

	private long id;
    private boolean botMmEnabled;
    private boolean rankedPlayEnabled;
    private boolean botEnabled;
    private boolean active;
    
    /**
     * @return Champion ID. For static information correlating to champion IDs, please refer to the LoL Static Data API.
     * @see org.dc.riot.lol.rx.service.RiotApi.Champion RiotApi.Champion
     * @see org.dc.riot.lol.rx.service.RiotApi.StaticData RiotApi.StaticData
     */
    public long getId() {
    	return id;
    }
    
    public void setId(long id) {
    	this.id = id;
    }

    public boolean isBotMmEnabled() {
		return botMmEnabled;
	}
	public void setBotMmEnabled(boolean botMmEnabled) {
		this.botMmEnabled = botMmEnabled;
	}
	public boolean isRankedPlayEnabled() {
		return rankedPlayEnabled;
	}
	public void setRankedPlayEnabled(boolean rankedPlayEnabled) {
		this.rankedPlayEnabled = rankedPlayEnabled;
	}
	public boolean isBotEnabled() {
		return botEnabled;
	}
	public void setBotEnabled(boolean botEnabled) {
		this.botEnabled = botEnabled;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isFreeToPlay() {
		return freeToPlay;
	}
	public void setFreeToPlay(boolean freeToPlay) {
		this.freeToPlay = freeToPlay;
	}
	private boolean freeToPlay;

}
