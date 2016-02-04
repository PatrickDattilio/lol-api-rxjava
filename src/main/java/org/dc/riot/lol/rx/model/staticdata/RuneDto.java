package org.dc.riot.lol.rx.model.staticdata;

import java.util.HashMap;
import java.util.Map;

/**
 * This object contains rune data.
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
    private boolean consumeOnFull;
    private boolean consumed;
    private int depth;
    private String description;
    private String[] from;
    private String group;
    private boolean hideFromAll;
    private int id;
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
    
    public RuneDto() {
    	COUNT++;
    }

    /**
     * @return colloquial or <code>null</code>
     */
    public String getColloq() {
        return colloq;
    }

    public void setColloq(String colloq) {
        this.colloq = colloq;
    }

    public boolean isConsumeOnFull() {
        return consumeOnFull;
    }

    public void setConsumeOnFull(boolean consumeOnFull) {
        this.consumeOnFull = consumeOnFull;
    }

    public boolean isConsumed() {
        return consumed;
    }

    public void setConsumed(boolean consumed) {
        this.consumed = consumed;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getFrom() {
    	if (from == null) {
    		return new String[0];
    	}

        return from;
    }

    public void setFrom(String[] from) {
        this.from = from;
    }

    /**
     * @return group string (e.g. 'rune') or <code>null</code>
     */
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public boolean isHideFromAll() {
        return hideFromAll;
    }

    public void setHideFromAll(boolean hideFromAll) {
        this.hideFromAll = hideFromAll;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ImageDto getImage() {
        return image;
    }

    public void setImage(ImageDto image) {
        this.image = image;
    }

    public boolean isInStore() {
        return inStore;
    }

    public void setInStore(boolean inStore) {
        this.inStore = inStore;
    }

    public String[] getInto() {
    	if (into == null) {
    		return new String[0];
    	}

        return into;

    }

    public void setInto(String[] into) {
        this.into = into;
    }

    public Map<String, Boolean> getMaps() {
    	if (maps == null) {
    		return new HashMap<String,Boolean>();
    	}

        return maps;
    }

    public void setMaps(Map<String, Boolean> maps) {
        this.maps = maps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return plain text or <code>null</code>
     */
    public String getPlaintext() {
        return plaintext;
    }

    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }

    /**
     * @return required champion or <code>null</code>
     */
    public String getRequiredChampion() {
        return requiredChampion;
    }

    public void setRequiredChampion(String requiredChampion) {
        this.requiredChampion = requiredChampion;
    }

    public MetaDataDto getRune() {
        return rune;
    }

    public void setRune(MetaDataDto rune) {
        this.rune = rune;
    }

    public String getSanitizedDescription() {
        return sanitizedDescription;
    }

    public void setSanitizedDescription(String sanitizedDescription) {
        this.sanitizedDescription = sanitizedDescription;
    }

    public int getSpecialRecipe() {
        return specialRecipe;
    }

    public void setSpecialRecipe(int specialRecipe) {
        this.specialRecipe = specialRecipe;
    }

    public int getStacks() {
        return stacks;
    }

    public void setStacks(int stacks) {
        this.stacks = stacks;
    }

    public BasicDataStatsDto getStats() {
        return stats;
    }

    public void setStats(BasicDataStatsDto stats) {
        this.stats = stats;
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

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}