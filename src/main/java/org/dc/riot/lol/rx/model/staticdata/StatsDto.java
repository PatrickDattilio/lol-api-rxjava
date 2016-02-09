package org.dc.riot.lol.rx.model.staticdata;

/**
 * This object contains champion stats data.<br>
 * <br>
 * Getters of this class will return <code>-1</code>
 * for undefined values.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class StatsDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Double armor;
    private Double armorperlevel;
    private Double attackdamage;
    private Double attackdamageperlevel;
    private Double attackrange;
    private Double attackspeedoffset;
    private Double attackspeedperlevel;
    private Double crit;
    private Double critperlevel;
    private Double hp;
    private Double hpperlevel;
    private Double hpregen;
    private Double hpregenperlevel;
    private Double movespeed;
    private Double mp;
    private Double mpperlevel;
    private Double mpregen;
    private Double mpregenperlevel;
    private Double spellblock;
    private Double spellblockperlevel;
    
    public StatsDto() {
    	COUNT++;
    }

    /**
     * @return Armor.
     */
    public double getArmor() {
    	if (armor == null) {
    		return -1;
    	}

        return armor;
    }

    /**
     * @return Armor per level.
     */
    public double getArmorperlevel() {
    	if (armorperlevel == null) {
    		return -1;
    	}

        return armorperlevel;
    }

    /**
     * @return Attack damage.
     */
    public double getAttackdamage() {
    	if (attackdamage == null) {
    		return -1;
    	}

        return attackdamage;
    }

    /**
     * @return Attack damage per level.
     */
    public double getAttackdamageperlevel() {
    	if (attackdamageperlevel == null) {
    		return -1;
    	}

        return attackdamageperlevel;
    }

    /**
     * @return Attack range.
     */
    public double getAttackrange() {
    	if (attackrange == null) {
    		return -1;
    	}

        return attackrange;
    }
    
    /**
     * What is AS offset?
     * 
     * @return Attack speed offset.
     */
    public double getAttackspeedoffset() {
    	if (attackspeedoffset == null) {
    		return -1;
    	}
    	
    	return attackspeedoffset.doubleValue();
    }

    /**
     * @return Attack speed per level.
     */
    public double getAttackspeedperlevel() {
    	if (attackspeedperlevel == null) {
    		return -1;
    	}

        return attackspeedperlevel;
    }

    /**
     * @return Critical chance.
     */
    public double getCrit() {
    	if (crit == null) {
    		return -1;
    	}

        return crit;
    }

    /**
     * @return Critical chance per level.
     */
    public double getCritperlevel() {
    	if (critperlevel == null) {
    		return -1;
    	}

        return critperlevel;
    }

    /**
     * @return HP.
     */
    public double getHp() {
    	if (hp == null) {
    		return -1;
    	}

        return hp;
    }

    /**
     * @return HP per level.
     */
    public double getHpperlevel() {
    	if (hpperlevel == null) {
    		return -1;
    	}

        return hpperlevel;
    }

    /**
     * @return HP regen.
     */
    public double getHpregen() {
    	if (hpregen == null) {
    		return -1;
    	}

        return hpregen;
    }

    /**
     * @return HP regen per level.
     */
    public double getHpregenperlevel() {
    	if (hpregenperlevel == null) {
    		return -1;
    	}

        return hpregenperlevel;
    }

    /**
     * @return Move speed.
     */
    public double getMovespeed() {
    	if (movespeed == null) {
    		return -1;
    	}

        return movespeed;
    }

    /**
     * @return MP.
     */
    public double getMp() {
    	if (mp == null) {
    		return -1;
    	}

        return mp;
    }

    /**
     * @return MP per level.
     */
    public double getMpperlevel() {
    	if (mpperlevel == null) {
    		return -1;
    	}

        return mpperlevel;
    }

    /**
     * @return MP regen.
     */
    public double getMpregen() {
    	if (mpregen == null) {
    		return -1;
    	}

        return mpregen;
    }

    /**
     * @return MP regen per level.
     */
    public double getMpregenperlevel() {
    	if (mpregenperlevel == null) {
    		return -1;
    	}

        return mpregenperlevel;
    }

    /**
     * @return Spell block.
     */
    public double getSpellblock() {
    	if (spellblock == null) {
    		return -1;
    	}

        return spellblock;
    }

    /**
     * @return Spell block per level.
     */
    public double getSpellblockperlevel() {
    	if (spellblockperlevel == null) {
    		return -1;
    	}

        return spellblockperlevel;
    }
}