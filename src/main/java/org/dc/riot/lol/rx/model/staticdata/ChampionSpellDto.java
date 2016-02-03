package org.dc.riot.lol.rx.model.staticdata;

import java.util.List;

import org.dc.riot.lol.rx.model.LevelTipDto;
import org.dc.riot.lol.rx.model.RangeDto;
import org.dc.riot.lol.rx.model.SpellVarsDto;

/**
 * This object contains champion spell data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ChampionSpellDto {
    private List<ImageDto> altimages;
    private double[] cooldown;
    private String cooldownBurn;
    private int[] cost;
    private String costBurn;
    private String costType;
    private String description;
    private List<double[]> effect;
    private String[] effectBurn;
    private ImageDto image;
    private String key;
    private LevelTipDto leveltip;
    private int maxrank;
    private String name;
    private RangeDto range;
    private String rangeBurn;
    private String resource;
    private String sanitizedDescription;
    private String sanitizedTooltip;
    private String tooltip;
    private List<SpellVarsDto> vars;

    public List<ImageDto> getAltimages() {
        return altimages;
    }

    public void setAltimages(List<ImageDto> altimages) {
        this.altimages = altimages;
    }

    public double[] getCooldown() {
        return cooldown;
    }

    public void setCooldown(double[] cooldown) {
        this.cooldown = cooldown;
    }

    public String getCooldownBurn() {
        return cooldownBurn;
    }

    public void setCooldownBurn(String cooldownBurn) {
        this.cooldownBurn = cooldownBurn;
    }

    public int[] getCost() {
        return cost;
    }

    public void setCost(int[] cost) {
        this.cost = cost;
    }

    public String getCostBurn() {
        return costBurn;
    }

    public void setCostBurn(String costBurn) {
        this.costBurn = costBurn;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<double[]> getEffect() {
        return effect;
    }

    public void setEffect(List<double[]> effect) {
        this.effect = effect;
    }

    public String[] getEffectBurn() {
        return effectBurn;
    }

    public void setEffectBurn(String[] effectBurn) {
        this.effectBurn = effectBurn;
    }

    public ImageDto getImage() {
        return image;
    }

    public void setImage(ImageDto image) {
        this.image = image;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public LevelTipDto getLeveltip() {
        return leveltip;
    }

    public void setLeveltip(LevelTipDto leveltip) {
        this.leveltip = leveltip;
    }

    public int getMaxrank() {
        return maxrank;
    }

    public void setMaxrank(int maxrank) {
        this.maxrank = maxrank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RangeDto getRange() {
        return range;
    }

    public void setRange(RangeDto range) {
        this.range = range;
    }

    public String getRangeBurn() {
        return rangeBurn;
    }

    public void setRangeBurn(String rangeBurn) {
        this.rangeBurn = rangeBurn;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getSanitizedDescription() {
        return sanitizedDescription;
    }

    public void setSanitizedDescription(String sanitizedDescription) {
        this.sanitizedDescription = sanitizedDescription;
    }

    public String getSanitizedTooltip() {
        return sanitizedTooltip;
    }

    public void setSanitizedTooltip(String sanitizedTooltip) {
        this.sanitizedTooltip = sanitizedTooltip;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public List<SpellVarsDto> getVars() {
        return vars;
    }

    public void setVars(List<SpellVarsDto> vars) {
        this.vars = vars;
    }
}
