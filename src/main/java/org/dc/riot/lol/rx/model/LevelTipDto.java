package org.dc.riot.lol.rx.model;

/**
 * This object contains champion level tip data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class LevelTipDto {
    private String[] effect;
    private String[] label;

    public String[] getEffect() {
        return effect;
    }

    public void setEffect(String[] effect) {
        this.effect = effect;
    }

    public String[] getLabel() {
        return label;
    }

    public void setLabel(String[] label) {
        this.label = label;
    }
}
