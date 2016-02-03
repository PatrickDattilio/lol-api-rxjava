package org.dc.riot.lol.rx.model.staticdata;

/**
 * This object contains champion stats data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class StatsDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private double armor;
    private double armorperlevel;
    private double attackdamage;
    private double attackdamageperlevel;
    private double attackrange;
    private double attackspeedoffset;
    private double attackspeedperlevel;
    private double crit;
    private double critperlevel;
    private double hp;
    private double hpperlevel;
    private double hpregen;
    private double hpregenperlevel;
    private double movespeed;
    private double mp;
    private double mpperlevel;
    private double mpregen;
    private double mpregenperlevel;
    private double spellblock;
    private double spellblockperlevel;
    
    public StatsDto() {
    	COUNT++;
    }

    /**
     * @return Armor.
     */
    public double getArmor() {
        return armor;
    }

    /**
     * @return Armor per level.
     */
    public double getArmorperlevel() {
        return armorperlevel;
    }

    /**
     * @return Attack damage.
     */
    public double getAttackdamage() {
        return attackdamage;
    }

    /**
     * @return Attack damage per level.
     */
    public double getAttackdamageperlevel() {
        return attackdamageperlevel;
    }

    /**
     * @return Attack range.
     */
    public double getAttackrange() {
        return attackrange;
    }

    /**
     * @return Attack speed per level.
     */
    public double getAttackspeedperlevel() {
        return attackspeedperlevel;
    }

    /**
     * @return Critical chance.
     */
    public double getCrit() {
        return crit;
    }

    /**
     * @return Critical chance per level.
     */
    public double getCritperlevel() {
        return critperlevel;
    }

    /**
     * @return HP.
     */
    public double getHp() {
        return hp;
    }

    /**
     * @return HP per level.
     */
    public double getHpperlevel() {
        return hpperlevel;
    }

    /**
     * @return HP regen.
     */
    public double getHpregen() {
        return hpregen;
    }

    /**
     * @return HP regen per level.
     */
    public double getHpregenperlevel() {
        return hpregenperlevel;
    }

    /**
     * @return Move speed.
     */
    public double getMovespeed() {
        return movespeed;
    }

    /**
     * @return MP.
     */
    public double getMp() {
        return mp;
    }

    /**
     * @return MP per level.
     */
    public double getMpperlevel() {
        return mpperlevel;
    }

    /**
     * @return MP regen.
     */
    public double getMpregen() {
        return mpregen;
    }

    /**
     * @return MP regen per level.
     */
    public double getMpregenperlevel() {
        return mpregenperlevel;
    }

    /**
     * @return Spell block.
     */
    public double getSpellblock() {
        return spellblock;
    }

    /**
     * @return Spell block per level.
     */
    public double getSpellblockperlevel() {
        return spellblockperlevel;
    }
    
    /**
     * @return The sum of all fields. Intended
     * to make this class reasonably unit testable.
     */
    public double sum() {
    	return armor +
    			armorperlevel +
    			attackdamage +
    			attackdamageperlevel +
    			attackrange +
    			attackspeedoffset +
    			attackspeedperlevel +
    			crit +
    			critperlevel +
    			hp +
    			hpperlevel +
    			hpregen +
    			hpregenperlevel +
    			movespeed +
    			mp +
    			mpperlevel +
    			mpregen +
    			mpregenperlevel +
    			spellblock +
    			spellblockperlevel;	
    }
}