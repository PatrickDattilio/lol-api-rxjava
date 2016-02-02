package org.dc.riot.lol.rx.model.summoner;

import org.dc.riot.lol.rx.model.common.Mastery;

/**
 * This object contains mastery page information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MasteryPageDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Mastery[] masteries;
    private long id;
    private String name;
    private boolean current;
    
    public MasteryPageDto() {
    	COUNT++;
    }

    /**
     * @return Collection of masteries associated with the mastery page.
     */
    public Mastery[] getMasteries() {
    	if (masteries == null) {
    		return new Mastery[0];
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
