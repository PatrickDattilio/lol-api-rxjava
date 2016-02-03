package org.dc.riot.lol.rx.model;

import org.dc.riot.lol.rx.model.staticdata.ImageDto;

/**
 * This object contains summoner spell data. Shares many fields with {@link ChampionSpellDto} but
 * the classes look different enough to preclude inheritance.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class SummonerSpellDto {
    private double[] cooldown;
    private String cooldownBurn;
    private int[] cost;
    private String costBurn;
    private String costType;
    private String description;
    private double[] effect;
    private String effectBurn;
    private long id;
    private ImageDto image;
    private String key;
    private LevelTipDto leveltip;
    private int maxrank;
    private String[] modes;
    private String name;
    private RangeDto range;
    private String rangeBurn;
    private String resource;
    private String sanitizedDescription;
    private String sanitizedTooltip;
    private int summonerLevel;
    private String tooltip;
    private SpellVarsDto[] vars;

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

    public double[] getEffect() {
        return effect;
    }

    public void setEffect(double[] effect) {
        this.effect = effect;
    }

    public String getEffectBurn() {
        return effectBurn;
    }

    public void setEffectBurn(String effectBurn) {
        this.effectBurn = effectBurn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String[] getModes() {
        return modes;
    }

    public void setModes(String[] modes) {
        this.modes = modes;
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

    public int getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(int summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public SpellVarsDto[] getVars() {
        return vars;
    }

    public void setVars(SpellVarsDto[] vars) {
        this.vars = vars;
    }
}
