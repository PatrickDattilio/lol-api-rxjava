package org.dc.riot.lol.rx.model.staticdata;

import java.util.HashMap;
import java.util.Map;

/**
 * This object contains rune data.<br>
 * <br>
 * Getters of this class will return <code>-1</code>
 * or <code>false</code> as appropriate for undefined
 * values.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class RuneDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private String colloq;
    private Boolean consumeOnFull;
    private Boolean consumed;
    private Integer depth;
    private String description;
    private String[] from;
    private String group;
    private Boolean hideFromAll;
    private Integer id;
    private ImageDto image;
    private Boolean inStore;
    private String[] into;
    private Map<String, Boolean> maps;
    private String name;
    private String plaintext;
    private String requiredChampion;
    private MetaDataDto rune;
    private String sanitizedDescription;
    private Integer specialRecipe;
    private Integer stacks;
    private BasicDataStatsDto stats;
    private String[] tags;
    
    public RuneDto() {
    	COUNT++;
    }

    /**
     * @return colloquial or <code>null</code>
     */
    public String getColloq() {
        return colloq;
    }

    public boolean isConsumeOnFull() {
    	if (consumeOnFull == null) {
    		return false;
    	}

        return consumeOnFull;
    }

    public boolean isConsumed() {
    	if (consumed == null) {
    		return false;
    	}

        return consumed;
    }

    public int getDepth() {
    	if (depth == null) {
    		return -1;
    	}

        return depth;
    }

    public String getDescription() {
        return description;
    }

    public String[] getFrom() {
    	if (from == null) {
    		return new String[0];
    	}

        return from;
    }

    /**
     * @return group string (e.g. 'rune') or <code>null</code>
     */
    public String getGroup() {
        return group;
    }

    public boolean isHideFromAll() {
    	if (hideFromAll == null) {
    		return false;
    	}

        return hideFromAll;
    }

    public int getId() {
    	if (id == null) {
    		return -1;
    	}

        return id;
    }

    public ImageDto getImage() {
        return image;
    }

    public boolean isInStore() {
    	if (inStore == null) {
    		return false;
    	}

        return inStore;
    }

    public String[] getInto() {
    	if (into == null) {
    		return new String[0];
    	}

        return into;

    }

    public Map<String, Boolean> getMaps() {
    	if (maps == null) {
    		return new HashMap<String,Boolean>();
    	}

        return maps;
    }

    public String getName() {
        return name;
    }

    /**
     * @return plain text or <code>null</code>
     */
    public String getPlaintext() {
        return plaintext;
    }

    /**
     * @return required champion or <code>null</code>
     */
    public String getRequiredChampion() {
        return requiredChampion;
    }

    public MetaDataDto getRune() {
        return rune;
    }

    public String getSanitizedDescription() {
        return sanitizedDescription;
    }

    public int getSpecialRecipe() {
    	if (specialRecipe == null) {
    		return -1;
    	}

        return specialRecipe;
    }

    public int getStacks() {
    	if (stacks == null) {
    		return -1;
    	}

        return stacks;
    }

    public BasicDataStatsDto getStats() {
        return stats;
    }

    /**
     * @return tags
     */
    public String[] getTags() {
    	if (tags == null) {
    		return new String[0];
    	}

        return tags;
    }
}