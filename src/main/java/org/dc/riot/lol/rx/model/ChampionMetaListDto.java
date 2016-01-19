package org.dc.riot.lol.rx.model;

public class ChampionMetaListDto {
	
	private ChampionMetaDto[] champions = null;
	
	public ChampionMetaDto[] getChampions() {
		if (champions == null) {
			return new ChampionMetaDto[0];
		}
		
		return champions;
	}
	
	public void setChampions(ChampionMetaDto[] champions) {
		this.champions = champions;
	}
}
