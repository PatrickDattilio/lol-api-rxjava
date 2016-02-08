package org.dc.riot.lol.rx.model.summoner;

/**
 * This object contains masteries information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MasteryPagesDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Long summonerId;
    private MasteryPageDto[] pages;
    
    public MasteryPagesDto() {
    	COUNT++;
    }

    /**
     * @return Summoner ID or <code>-1</code> if not
     * defined.
     */
    public long getSummonerId() {
    	if (summonerId == null) {
    		return -1;
    	}

        return summonerId.longValue();
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
