package org.dc.riot.lol.rx.model.staticdata;

import java.util.HashMap;
import java.util.Map;

/**
 * This object contains basic data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class BasicDataDto {
	private static long COUNT = 0;
	public static long getCount() {
		return COUNT;
	}

    private String colloq;
    private boolean consumeOnFull;
    private boolean consumed;
    private int depth;
    private String description;
    private String[] from;
    private GoldDto gold;
    private String group;
    private boolean hideFromAll;
    private long id;
    private ImageDto image;
    private boolean inStore;
    private String[] into;
    private Map<String, Boolean> maps;
    private String name;
    private String plaintext;
    private String requiredChampion;
    private MetaDataDto rune;
    private String sanitizedDescription;
    private int specialRecipe;
    private int stacks;
    private BasicDataStatsDto stats;
    private String[] tags;
    
    public BasicDataDto() {
    	COUNT++;
    }

    protected BasicDataDto(boolean alreadyCounted) {
    	if (!alreadyCounted) {
    		COUNT++;
    	}
	}

    /**
     * Implementation note: may be <code>null</code> (e.g.
     * Devourer enchant is has no colloq string.
     * 
     * @return Colloq.
     */
	public String getColloq() {
        return colloq;
    }

    public boolean isConsumeOnFull() {
        return consumeOnFull;
    }

    public boolean isConsumed() {
        return consumed;
    }

    public int getDepth() {
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
     * @return Data Dragon includes the gold
     * field for basic data, which is shared
     * by both rune and item. However, only
     * items have a gold field on them,
     * representing their gold cost in the
     * store. Since runes are not sold in the
     * store, they have no gold cost.
     */
    public GoldDto getGold() {
        return gold;
    }

    /**
     * Implementation note: might be <code>null</code> (e.g.
     * Total Biscuit of Rejuvenation has no group).
     * 
     * @return Group.
     */
    public String getGroup() {
        return group;
    }

    public boolean isHideFromAll() {
        return hideFromAll;
    }

    public long getId() {
        return id;
    }

    public ImageDto getImage() {
        return image;
    }

    public boolean isInStore() {
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
    		return new HashMap<String, Boolean>();
    	}

        return maps;
    }

    public String getName() {
        return name;
    }

    /**
     * Implementation note: might be <code>null</code>
     * (e.g. Devourer enchant has no sanitized description).
     * 
     * @return Plain text.
     */
    public String getPlaintext() {
        return plaintext;
    }

    public String getRequiredChampion() {
        return requiredChampion;
    }

    public MetaDataDto getRune() {
        return rune;
    }

    /**
     * Implementation note: might be <code>null</code>
     * (e.g. Devourer enchant has no sanitized description).
     * 
     * @return Sanitized description.
     */
    public String getSanitizedDescription() {
        return sanitizedDescription;
    }

    public int getSpecialRecipe() {
        return specialRecipe;
    }

    public int getStacks() {
    	return stacks;
    }

    /**
     * Implementation note: might be <code>null</code>.
     * 
     * @return Stats.
     */
    public BasicDataStatsDto getStats() {
    	return stats;
    }

    /**
     * Implementation note: might be empty (e.g. Devourer enchant
     * has no tags).
     * 
     * @return Tags.
     */
    public String[] getTags() {
    	if (tags == null) {
    		return new String[0];
    	}

    	return tags;
    }

    @Override
    public String toString() {
    	return colloq + " " +
    			consumeOnFull + " " +
    			consumed + " " +
    			depth + " " +
    			description + " " +
    			from + " " +
    			gold + " " +
    			group + " " +
    			hideFromAll + " " +
    			id + " " +
    			image + " " +
    			inStore + " " +
    			into + " " +
    			maps + " " +
    			name + " " +
    			plaintext + " " +
    			requiredChampion + " " +
    			rune + " " +
    			sanitizedDescription + " " +
    			specialRecipe + " " +
    			stacks + " " +
    			stats + " " +
    			tags;
    }
}