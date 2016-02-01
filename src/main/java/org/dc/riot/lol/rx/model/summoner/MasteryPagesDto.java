package org.dc.riot.lol.rx.model.summoner;

/**
 * This object contains masteries information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MasteryPagesDto {
    private long summonerId;
    private MasteryPageDto[] pages;

    /**
     * @return Summoner ID.
     */
    public long getSummonerId() {
        return summonerId;
    }

    /**
     * @return Collection of mastery pages associated with the summoner.
     */
    public MasteryPageDto[] getPages() {
    	if (pages == null) {
    		return new MasteryPageDto[0];
    	}

        return pages;
    }
}
