package org.dc.riot.lol.rx.model.summoner;

/**
 * This object contains rune pages information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class RunePagesDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private RunePageDto[] pages;
    private Long summonerId;
    
    public RunePagesDto() {
    	COUNT++;
    }

    /**
     * @return Collection of rune pages associated with the summoner
     * or empty if not defined.
     */
    public RunePageDto[] getPages() {
        return pages;
    }

    /**
     * @return Summoner ID or <code>-1</code> if not defined.
     */
    public long getSummonerId() {
    	if (summonerId == null) {
    		return -1;
    	}

        return summonerId.longValue();
    }
}
