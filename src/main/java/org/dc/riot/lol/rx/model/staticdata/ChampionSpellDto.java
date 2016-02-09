package org.dc.riot.lol.rx.model.staticdata;

import java.util.ArrayList;
import java.util.List;

import org.dc.riot.lol.rx.model.SpellVarsDto;

/**
 * This object contains champion spell data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ChampionSpellDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private ImageDto[] altimages;
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
    private Integer maxrank;
    private String name;
    private RangeDto range;
    private String rangeBurn;
    private String resource;
    private String sanitizedDescription;
    private String sanitizedTooltip;
    private String tooltip;
    private SpellVarsDto[] vars;
    
    public ChampionSpellDto() {
    	COUNT++;
    }

    /**
     * @return Alt images.
     */
    public ImageDto[] getAltimages() {
    	if (altimages == null) {
    		return new ImageDto[0];
    	}

        return altimages;
    }

    /**
     * @return Cooldowns.
     */
    public double[] getCooldown() {
    	if (cooldown == null) {
    		return new double[0];
    	}

        return cooldown;
    }

    /**
     * Cooldown reduction for leveling up a skill, or
     * cooldown at each subsequent skill level.
     * E.g. 2 or 16/15/14/13/12 or 120/110/100.
     * 
     * @return Cooldown burn.
     */
    public String getCooldownBurn() {
        return cooldownBurn;
    }

    /**
     * @return Costs.
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
     * Implementation note: it is OK for this value to
     * return empty.
     * 
     * @return Effects.
     */
    public List<double[]> getEffect() {
    	if (effect == null) {
    		return new ArrayList<double[]>();
    	}

        return effect;
    }

    /**
     * @return Effect burns.
     */
    public String[] getEffectBurn() {
    	if (effectBurn == null) {
    		return new String[0];
    	}
    	
        return effectBurn;
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
     * @return Level tip data.
     */
    public LevelTipDto getLeveltip() {
        return leveltip;
    }

    /**
     * @return Max rank or <code>-1</code> if not defined.
     */
    public int getMaxrank() {
    	if (maxrank == null) {
    		return -1;
    	}

        return maxrank.intValue();
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
     * Some sort of resource type description.
     * E.g. No cost, {{ cost }} Mana, {{ cost }} Mana Per Second,
     * {{ e2 }}% of Current Health, etc. Looks like they're expecting
     * pages to be using Angular JS.
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
     * @return Sanitized tooltip.
     */
    public String getSanitizedTooltip() {
        return sanitizedTooltip;
    }

    /**
     * @return Tooltip.
     */
    public String getTooltip() {
        return tooltip;
    }

    /**
     * May or may not exist. It is perfectly OK for this
     * list to be empty.
     * 
     * @return Spell vars.
     */
    public SpellVarsDto[] getVars() {
    	if (vars == null) {
    		return new SpellVarsDto[0];
    	}

        return vars;
    }
}