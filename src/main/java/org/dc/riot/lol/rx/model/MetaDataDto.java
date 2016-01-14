package org.dc.riot.lol.rx.model;

/**
 * This object contains meta data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MetaDataDto {
    private boolean isRune;
    private String tier;
    private String type;

    public boolean isRune() {
        return isRune;
    }

    public void setIsRune(boolean isRune) {
        this.isRune = isRune;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
