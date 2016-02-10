package org.dc.riot.lol.rx.model.staticdata;

import org.dc.riot.lol.rx.model.common.GameMode;

/**
 * This object contains summoner spell data.<br>
 * <br>
 * Shares many fields with {@link ChampionSpellDto} but
 * the classes look different enough
 * to preclude inheritance.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class SummonerSpellDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private double[] cooldown;
    private String cooldownBurn;
    private int[] cost;
    private String costBurn;
    private String costType;
    private String description;
    private double[][] effect;
    private String[] effectBurn;
    private Long id;
    private ImageDto image;
    private String key;
    private LevelTipDto leveltip;
    private Integer maxrank;
    private GameMode[] modes;
    private String name;
    private RangeDto range;
    private String rangeBurn;
    private String resource;
    private String sanitizedDescription;
    private String sanitizedTooltip;
    private Integer summonerLevel;
    private String tooltip;
    private SpellVarsDto[] vars;
    
    public SummonerSpellDto() {
    	COUNT++;
    }

    /**
     * @return Cooldown data.
     */
    public double[] getCooldown() {
    	if (cooldown == null) {
    		return new double[0];
    	}

        return cooldown;
    }

    /**
     * @return Cooldown burn.
     */
    public String getCooldownBurn() {
        return cooldownBurn;
    }

    /**
     * @return Cost data.
     */
    public int[] getCost() {
    	if (cost == null) {
    		return new int[0];
    	}

        return cost;
    }

    /**
     * @return Cost burn.
     */
    public String getCostBurn() {
        return costBurn;
    }

    /**
     * @return Cost type.
     */
    public String getCostType() {
        return costType;
    }

    /**
     * @return Description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Implementation note: not applicable to all
     * summoner spells, so some will return empty.
     * 
     * @return Effect data.
     */
    public double[][] getEffect() {
    	if (effect == null) {
    		return new double[0][0];
    	}

        return effect;
    }

    /**
     * @return Effect burn.
     */
    public String[] getEffectBurn() {
    	if (effectBurn == null) {
    		return new String[0];
    	}

        return effectBurn;
    }

    /**
     * @return ID or <code>-1</code> if not defined.
     */
    public long getId() {
        return id;
    }

    /**
     * @return Image data.
     */
    public ImageDto getImage() {
        return image;
    }

    /**
     * @return Key.
     */
    public String getKey() {
        return key;
    }

    /**
     * Implementation note: not all summoner spells
     * define a level tip.
     * 
     * @return Level tip data or <code>null</code> if
     * not defined.
     */
    public LevelTipDto getLeveltip() {
        return leveltip;
    }

    /**
     * @return Max rank or <code>-1</code> if not
     * defined.
     */
    public int getMaxrank() {
    	if (maxrank == null) {
    		return -1;
    	}

        return maxrank.intValue();
    }

    /**
     * @return Game modes.
     */
    public GameMode[] getModes() {
    	if (modes == null) {
    		return new GameMode[0];
    	}

        return modes;
    }

    /**
     * @return Name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return Range data.
     */
    public RangeDto getRange() {
        return range;
    }

    /**
     * @return Range burn.
     */
    public String getRangeBurn() {
        return rangeBurn;
    }

    /**
     * @return Resource.
     */
    public String getResource() {
        return resource;
    }

    /**
     * @return Sanitized description.
     */
    public String getSanitizedDescription() {
        return sanitizedDescription;
    }

    /**
     * @return Sanitized tool tip.
     */
    public String getSanitizedTooltip() {
        return sanitizedTooltip;
    }

    /**
     * @return Summoner level to unlock this spell.
     */
    public int getSummonerLevel() {
    	if (summonerLevel == null) {
    		return -1;
    	}

        return summonerLevel.intValue();
    }

    /**
     * @return Tool tip.
     */
    public String getTooltip() {
        return tooltip;
    }

    /**
     * Implementation note: not all summoner spells
     * define vars.
     * 
     * @return Vars or empty if not defined.
     */
    public SpellVarsDto[] getVars() {
    	if (vars == null) {
    		return new SpellVarsDto[0];
    	}

        return vars;
    }
}