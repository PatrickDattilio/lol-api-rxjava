package org.dc.riot.lol.rx.model.staticdata;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
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
	public static long getInstanceCount() {
		return COUNT;
	}

    private String colloq;
    private Boolean consumeOnFull;
    private Boolean consumed;
    private Integer depth;
    private String description;
    private String[] from;
    private GoldDto gold;
    private String group;
    private Boolean hideFromAll;
    private Long id;
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

	/**
	 * @return Consume on full or <code>false</code>
	 * if not defined.
	 */
    public boolean isConsumeOnFull() {
    	if (consumeOnFull == null) {
    		return false;
    	}

        return consumeOnFull.booleanValue();
    }

    /**
     * @return Is consumed or <code>false</code> if not
     * defined.
     */
    public boolean isConsumed() {
    	if (consumed == null) {
    		return false;
    	}

        return consumed.booleanValue();
    }

    /**
     * @return Depth or <code>-1</code> if not defined.
     */
    public int getDepth() {
    	if (depth == null) {
    		return 0;
    	}

        return depth.intValue();
    }

    /**
     * @return Description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return From or empty if not defined.
     */
    public String[] getFrom() {
    	if (from == null) {
    		return new String[0];
    	}

        return from;
    }

    /**
     * Data Dragon includes the gold
     * field for basic data, which is shared
     * by both rune and item. However, only
     * items have a gold field on them,
     * representing their gold cost in the
     * store. Since runes are not sold in the
     * store, they have no gold cost.
     * 
     * @return Gold cost data or <code>null</code> if not applicable.
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

    /**
     * @return Hide from all or <code>false</code>
     * if not defined.
     */
    public boolean isHideFromAll() {
    	if (hideFromAll == null) {
    		return false;
    	}

        return hideFromAll.booleanValue();
    }

    /**
     * @return ID or <code>-1</code> if not defined.
     */
    public long getId() {
    	if (id == null) {
    		return -1;
    	}

        return id.longValue();
    }

    /**
     * @return Image data.
     */
    public ImageDto getImage() {
        return image;
    }

    /**
     * @return In store or <code>false</code>
     * if not defined.
     */
    public boolean isInStore() {
    	if (inStore == null) {
    		return false;
    	}

        return inStore;
    }

    /**
     * @return Into or empty if not applicable.
     */
    public String[] getInto() {
    	if (into == null) {
    		return new String[0];
    	}

        return into;
    }

    /**
     * @return Maps or empty if not applicable.
     */
    public Map<String, Boolean> getMaps() {
    	if (maps == null) {
    		return new HashMap<String, Boolean>();
    	}

        return maps;
    }

    /**
     * @return Name.
     */
    public String getName() {
        return name;
    }

    /**
     * Implementation note: might be <code>null</code>
     * (e.g. Devourer enchant has no plain text).
     * 
     * @return Plain text.
     */
    public String getPlaintext() {
        return plaintext;
    }

    /**
     * @return Required champion or <code>null</code>
     * if not applicable.
     */
    public String getRequiredChampion() {
        return requiredChampion;
    }

    /**
     * @return Rune data or <code>null</code> if not applicable.
     */
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

    /**
     * @return Special recipe or <code>-1</code>
     * if not defined.
     */
    public int getSpecialRecipe() {
    	if (specialRecipe == null) {
    		return -1;
    	}

        return specialRecipe.intValue();
    }

    /**
     * @return Stacks or <code>-1</code>
     * if not applicable.
     */
    public int getStacks() {
    	if (stacks == null) {
    		return -1;
    	}

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
    	String retVal = "";
    	
    	retVal += "[" + this.getClass().getSimpleName();
    	
    	Field[] fields = this.getClass().getDeclaredFields();
    	for (Field f : fields) {
    		if (Modifier.isStatic(f.getModifiers())) {
    			continue;
    		}
    		
    		try {
				retVal += " " + f.getName() + "=" + f.get(this);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// won't happen inside the class under reflection, I hope
			}
    	}
    	
    	retVal += "]";
    	
    	return retVal;
    }
}