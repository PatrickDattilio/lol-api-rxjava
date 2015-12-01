package org.dc.riot.lol.rx.model;

/**
 * This object contains champion level tip data.
 * Created by Dc on 9/30/15.
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
