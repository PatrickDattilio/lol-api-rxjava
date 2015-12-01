package org.dc.riot.lol.rx.model;

import java.util.ArrayList;
import java.util.List;

public class RunePagesDto {

    private List<RunePage> pages = new ArrayList<>();
    private long summonerId;

    /**
     * @return The pages
     */
    public List<RunePage> getPages() {
        return pages;
    }

    /**
     * @param pages The pages
     */
    public void setPages(List<RunePage> pages) {
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
