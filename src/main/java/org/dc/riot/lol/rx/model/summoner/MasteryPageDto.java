package org.dc.riot.lol.rx.model.summoner;

import org.dc.riot.lol.rx.model.MasteryMetaDto;

/**
 * This object contains mastery page information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MasteryPageDto {

    private MasteryMetaDto[] masteries;
    private long id;
    private String name;
    private boolean current;

    /**
     * @return Collection of masteries associated with the mastery page.
     */
    public MasteryMetaDto[] getMasteries() {
    	if (masteries == null) {
    		return new MasteryMetaDto[0];
    	}

        return masteries;
    }

    /**
     * @return Mastery page ID.
     */
    public long getId() {
        return id;
    }

    /**
     * @return Mastery page name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return Indicates if the mastery page is the current mastery page.
     */
    public boolean isCurrent() {
        return current;
    }
}
