package org.dc.riot.lol.rx.model.summoner;

/**
 * This object contains rune pages information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class RunePagesDto {

    private RunePageDto[] pages;
    private long summonerId;

    /**
     * @return Collection of rune pages associated with the summoner.
     */
    public RunePageDto[] getPages() {
        return pages;
    }

    /**
     * @return Summoner ID.
     */
    public long getSummonerId() {
        return summonerId;
    }
}
