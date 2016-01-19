package org.dc.riot.lol.rx.model;

/**
 * @author Dc
 * @since 1.0.0
 */
public class RunePagesDto {

    private RunePage[] pages;
    private long summonerId;

    /**
     * @return The pages
     */
    public RunePage[] getPages() {
        return pages;
    }

    /**
     * @param pages The pages
     */
    public void setPages(RunePage[] pages) {
        this.pages = pages;
    }

    /**
     * @return The summonerId
     */
    public long getSummonerId() {
        return summonerId;
    }

    /**
     * @param summonerId The summonerId
     */
    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
    }
}
