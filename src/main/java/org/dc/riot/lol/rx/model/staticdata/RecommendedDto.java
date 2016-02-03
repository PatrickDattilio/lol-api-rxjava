package org.dc.riot.lol.rx.model.staticdata;

/**
 * This object contains champion recommended data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class RecommendedDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private BlockDto[] blocks;
    private String champion;
    private String map;
    private String mode;
    private boolean priority;
    private String title;
    private String type;
    
    public RecommendedDto() {
    	COUNT++;
    }

    public BlockDto[] getBlocks() {
    	if (blocks == null) {
    		return new BlockDto[0];
    	}

        return blocks;
    }

    public String getChampion() {
        return champion;
    }

    public String getMap() {
        return map;
    }

    public String getMode() {
        return mode;
    }

    public boolean isPriority() {
        return priority;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }
}