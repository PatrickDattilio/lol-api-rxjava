package org.dc.riot.lol.rx.model.staticdata;

/**
 * This object contains mastery tree data. i.e. mastery pages.<br>
 * <br>
 * Getters of this class will return empty lists for undefined
 * values.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MasteryTreeDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private MasteryTreeListDto[] Resolve;
    private MasteryTreeListDto[] Ferocity;
    private MasteryTreeListDto[] Cunning;
    
    public MasteryTreeDto() {
    	COUNT++;
    }

    /**
     * @return Defense masteries.
     */
    public MasteryTreeListDto[] getResolve() {
    	if (Resolve == null) {
    		return new MasteryTreeListDto[0];
    	}

        return Resolve;
    }

    /**
     * @return Offense masteries.
     */
    public MasteryTreeListDto[] getFerocity() {
    	if (Ferocity == null) {
    		return new MasteryTreeListDto[0];
    	}

        return Ferocity;
    }

    /**
     * @return Utility masteries.
     */
    public MasteryTreeListDto[] getCunning() {
    	if (Cunning == null) {
    		return new MasteryTreeListDto[0];
    	}

        return Cunning;
    }
}