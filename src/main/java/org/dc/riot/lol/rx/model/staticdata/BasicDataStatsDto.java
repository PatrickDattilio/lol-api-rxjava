package org.dc.riot.lol.rx.model.staticdata;

/**
 * This object contains basic data stats.<br>
 * <br>
 * Getters of this class will return <code>0</code>
 * for undefined values.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class BasicDataStatsDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Double FlatArmorMod;
    private Double FlatAttackSpeedMod = new Double(0);
    private Double FlatBlockMod;
    private Double FlatCritChanceMod;
    private Double FlatCritDamageMod;
    private Double FlatEXPBonus;
    private Double FlatEnergyPoolMod;
    private Double FlatEnergyRegenMod;
    private Double FlatHPPoolMod;
    private Double FlatHPRegenMod;
    private Double FlatMPPoolMod;
    private Double FlatMPRegenMod;
    private Double FlatMagicDamageMod;
    private Double FlatMovementSpeedMod;
    private Double FlatPhysicalDamageMod;
    private Double FlatSpellBlockMod;
    private Double PercentArmorMod;
    private Double PercentAttackSpeedMod;
    private Double PercentBlockMod;
    private Double PercentCritChanceMod;
    private Double PercentCritDamageMod;
    private Double PercentDodgeMod;
    private Double PercentEXPBonus;
    private Double PercentHPPoolMod;
    private Double PercentHPRegenMod;
    private Double PercentLifeStealMod;
    private Double PercentMPPoolMod;
    private Double PercentMPRegenMod;
    private Double PercentMagicDamageMod;
    private Double PercentMovementSpeedMod;
    private Double PercentPhysicalDamageMod;
    private Double PercentSpellBlockMod;
    private Double PercentSpellVampMod;
    private Double rFlatArmorModPerLevel;
    private Double rFlatArmorPenetrationMod;
    private Double rFlatArmorPenetrationModPerLevel;
    private Double rFlatCritChanceModPerLevel;
    private Double rFlatCritDamageModPerLevel;
    private Double rFlatDodgeMod;
    private Double rFlatDodgeModPerLevel;
    private Double rFlatEnergyModPerLevel;
    private Double rFlatEnergyRegenModPerLevel;
    private Double rFlatGoldPer10Mod;
    private Double rFlatHPModPerLevel;
    private Double rFlatHPRegenModPerLevel;
    private Double rFlatMPModPerLevel;
    private Double rFlatMPRegenModPerLevel;
    private Double rFlatMagicDamageModPerLevel;
    private Double rFlatMagicPenetrationMod;
    private Double rFlatMagicPenetrationModPerLevel;
    private Double rFlatMovementSpeedModPerLevel;
    private Double rFlatPhysicalDamageModPerLevel;
    private Double rFlatSpellBlockModPerLevel;
    private Double rFlatTimeDeadMod;
    private Double rFlatTimeDeadModPerLevel;
    private Double rPercentArmorPenetrationMod;
    private Double rPercentArmorPenetrationModPerLevel;
    private Double rPercentAttackSpeedModPerLevel;
    private Double rPercentCooldownMod;
    private Double rPercentCooldownModPerLevel;
    private Double rPercentMagicPenetrationMod;
    private Double rPercentMagicPenetrationModPerLevel;
    private Double rPercentMovementSpeedModPerLevel;
    private Double rPercentTimeDeadMod;
    private Double rPercentTimeDeadModPerLevel;
    
    public BasicDataStatsDto() {
    	COUNT++;
    }

    public double getFlatArmorMod() {
    	if (FlatArmorMod == null) {
    		return 0;
    	}

        return FlatArmorMod.doubleValue();
    }

    public double getFlatAttackSpeedMod() {
    	if (FlatAttackSpeedMod == null) {
    		return 0;
    	}

        return FlatAttackSpeedMod.doubleValue();
    }

    public double getFlatBlockMod() {
    	if (FlatBlockMod == null) {
    		return 0;
    	}

        return FlatBlockMod.doubleValue();
    }

    public double getFlatCritChanceMod() {
    	if (FlatCritChanceMod == null) {
    		return 0;
    	}

        return FlatCritChanceMod.doubleValue();
    }

    public double getFlatCritDamageMod() {
    	if (FlatCritDamageMod == null) {
    		return 0;
    	}

        return FlatCritDamageMod.doubleValue();
    }

    public double getFlatEXPBonus() {
    	if (FlatEXPBonus == null) {
    		return 0;
    	}

        return FlatEXPBonus.doubleValue();
    }

    public double getFlatEnergyPoolMod() {
    	if (FlatEnergyPoolMod == null) {
    		return 0;
    	}

        return FlatEnergyPoolMod.doubleValue();
    }

    public double getFlatEnergyRegenMod() {
    	if (FlatEnergyRegenMod == null) {
    		return 0;
    	}

        return FlatEnergyRegenMod.doubleValue();
    }

    public double getFlatHPPoolMod() {
    	if (FlatHPPoolMod == null) {
    		return 0;
    	}

        return FlatHPPoolMod.doubleValue();
    }

    public double getFlatHPRegenMod() {
    	if (FlatHPRegenMod == null) {
    		return 0;
    	}

        return FlatHPRegenMod.doubleValue();
    }

    public double getFlatMPPoolMod() {
    	if (FlatMPPoolMod == null) {
    		return 0;
    	}

        return FlatMPPoolMod.doubleValue();
    }

    public double getFlatMPRegenMod() {
    	if (FlatMPRegenMod == null) {
    		return 0;
    	}

        return FlatMPRegenMod.doubleValue();
    }

    public double getFlatMagicDamageMod() {
    	if (FlatMagicDamageMod == null) {
    		return 0;
    	}

        return FlatMagicDamageMod.doubleValue();
    }

    public double getFlatMovementSpeedMod() {
    	if (FlatMovementSpeedMod == null) {
    		return 0;
    	}

        return FlatMovementSpeedMod.doubleValue();
    }

    public double getFlatPhysicalDamageMod() {
    	if (FlatPhysicalDamageMod == null) {
    		return 0;
    	}

        return FlatPhysicalDamageMod.doubleValue();
    }

    public double getFlatSpellBlockMod() {
    	if (FlatSpellBlockMod == null) {
    		return 0;
    	}

        return FlatSpellBlockMod.doubleValue();
    }

    public double getPercentArmorMod() {
    	if (PercentArmorMod == null) {
    		return 0;
    	}

        return PercentArmorMod.doubleValue();
    }

    public double getPercentAttackSpeedMod() {
    	if (PercentAttackSpeedMod == null) {
    		return 0;
    	}

        return PercentAttackSpeedMod.doubleValue();
    }

    public double getPercentBlockMod() {
    	if (PercentBlockMod == null) {
    		return 0;
    	}

        return PercentBlockMod.doubleValue();
    }

    public double getPercentCritChanceMod() {
    	if (PercentCritChanceMod == null) {
    		return 0;
    	}

        return PercentCritChanceMod.doubleValue();
    }

    public double getPercentCritDamageMod() {
    	if (PercentCritDamageMod == null) {
    		return 0;
    	}

        return PercentCritDamageMod.doubleValue();
    }

    public double getPercentDodgeMod() {
    	if (PercentDodgeMod == null) {
    		return 0;
    	}

        return PercentDodgeMod.doubleValue();
    }

    public double getPercentEXPBonus() {
    	if (PercentEXPBonus == null) {
    		return 0;
    	}

        return PercentEXPBonus.doubleValue();
    }

    public double getPercentHPPoolMod() {
    	if (PercentHPPoolMod == null) {
    		return 0;
    	}

        return PercentHPPoolMod.doubleValue();
    }

    public double getPercentHPRegenMod() {
    	if (PercentHPRegenMod == null) {
    		return 0;
    	}

        return PercentHPRegenMod.doubleValue();
    }

    public double getPercentLifeStealMod() {
    	if (PercentLifeStealMod == null) {
    		return 0;
    	}

        return PercentLifeStealMod.doubleValue();
    }

    public double getPercentMPPoolMod() {
    	if (PercentMPPoolMod == null) {
    		return 0;
    	}

        return PercentMPPoolMod.doubleValue();
    }

    public double getPercentMPRegenMod() {
    	if (PercentMPRegenMod == null) {
    		return 0;
    	}

        return PercentMPRegenMod.doubleValue();
    }

    public double getPercentMagicDamageMod() {
    	if (PercentMagicDamageMod == null) {
    		return 0;
    	}

        return PercentMagicDamageMod.doubleValue();
    }

    public double getPercentMovementSpeedMod() {
    	if (PercentMovementSpeedMod == null) {
    		return 0;
    	}

        return PercentMovementSpeedMod.doubleValue();
    }

    public double getPercentPhysicalDamageMod() {
    	if (PercentPhysicalDamageMod == null) {
    		return 0;
    	}

        return PercentPhysicalDamageMod.doubleValue();
    }

    public double getPercentSpellBlockMod() {
    	if (PercentSpellBlockMod == null) {
    		return 0;
    	}

        return PercentSpellBlockMod.doubleValue();
    }

    public double getPercentSpellVampMod() {
    	if (PercentSpellVampMod == null) {
    		return 0;
    	}

        return PercentSpellVampMod.doubleValue();
    }

    public double getrFlatArmorModPerLevel() {
    	if (rFlatArmorModPerLevel == null) {
    		return 0;
    	}

        return rFlatArmorModPerLevel.doubleValue();
    }

    public double getrFlatArmorPenetrationMod() {
    	if (rFlatArmorPenetrationMod == null) {
    		return 0;
    	}

        return rFlatArmorPenetrationMod.doubleValue();
    }

    public double getrFlatArmorPenetrationModPerLevel() {
    	if (rFlatArmorPenetrationModPerLevel == null) {
    		return 0;
    	}

        return rFlatArmorPenetrationModPerLevel.doubleValue();
    }

    public double getrFlatCritChanceModPerLevel() {
    	if (rFlatCritChanceModPerLevel == null) {
    		return 0;
    	}

        return rFlatCritChanceModPerLevel.doubleValue();
    }

    public double getrFlatCritDamageModPerLevel() {
    	if (rFlatCritDamageModPerLevel == null) {
    		return 0;
    	}

        return rFlatCritDamageModPerLevel.doubleValue();
    }

    public double getrFlatDodgeMod() {
    	if (rFlatDodgeMod == null) {
    		return 0;
    	}

        return rFlatDodgeMod.doubleValue();
    }

    public double getrFlatDodgeModPerLevel() {
    	if (rFlatDodgeModPerLevel == null) {
    		return 0;
    	}

        return rFlatDodgeModPerLevel.doubleValue();
    }

    public double getrFlatEnergyModPerLevel() {
    	if (rFlatEnergyModPerLevel == null) {
    		return 0;
    	}

        return rFlatEnergyModPerLevel.doubleValue();
    }

    public double getrFlatEnergyRegenModPerLevel() {
    	if (rFlatEnergyRegenModPerLevel == null) {
    		return 0;
    	}

        return rFlatEnergyRegenModPerLevel.doubleValue();
    }

    public double getrFlatGoldPer10Mod() {
    	if (rFlatGoldPer10Mod == null) {
    		return 0;
    	}

        return rFlatGoldPer10Mod.doubleValue();
    }

    public double getrFlatHPModPerLevel() {
    	if (rFlatHPModPerLevel == null) {
    		return 0;
    	}

        return rFlatHPModPerLevel.doubleValue();
    }

    public double getrFlatHPRegenModPerLevel() {
    	if (rFlatHPRegenModPerLevel == null) {
    		return 0;
    	}

        return rFlatHPRegenModPerLevel.doubleValue();
    }

    public double getrFlatMPModPerLevel() {
    	if (rFlatMPModPerLevel == null) {
    		return 0;
    	}

        return rFlatMPModPerLevel.doubleValue();
    }

    public double getrFlatMPRegenModPerLevel() {
    	if (rFlatMPRegenModPerLevel == null) {
    		return 0;
    	}

        return rFlatMPRegenModPerLevel.doubleValue();
    }

    public double getrFlatMagicDamageModPerLevel() {
    	if (rFlatMagicDamageModPerLevel == null) {
    		return 0;
    	}

        return rFlatMagicDamageModPerLevel.doubleValue();
    }

    public double getrFlatMagicPenetrationMod() {
    	if (rFlatMagicPenetrationMod == null) {
    		return 0;
    	}

        return rFlatMagicPenetrationMod.doubleValue();
    }

    public double getrFlatMagicPenetrationModPerLevel() {
    	if (rFlatMagicPenetrationModPerLevel == null) {
    		return 0;
    	}

        return rFlatMagicPenetrationModPerLevel.doubleValue();
    }

    public double getrFlatMovementSpeedModPerLevel() {
    	if (rFlatMovementSpeedModPerLevel == null) {
    		return 0;
    	}

        return rFlatMovementSpeedModPerLevel.doubleValue();
    }

    public double getrFlatPhysicalDamageModPerLevel() {
    	if (rFlatPhysicalDamageModPerLevel == null) {
    		return 0;
    	}

        return rFlatPhysicalDamageModPerLevel.doubleValue();
    }

    public double getrFlatSpellBlockModPerLevel() {
    	if (rFlatSpellBlockModPerLevel == null) {
    		return 0;
    	}

        return rFlatSpellBlockModPerLevel.doubleValue();
    }

    public double getrFlatTimeDeadMod() {
    	if (rFlatTimeDeadMod == null) {
    		return 0;
    	}

        return rFlatTimeDeadMod.doubleValue();
    }

    public double getrFlatTimeDeadModPerLevel() {
    	if (rFlatTimeDeadModPerLevel == null) {
    		return 0;
    	}

        return rFlatTimeDeadModPerLevel.doubleValue();
    }

    public double getrPercentArmorPenetrationMod() {
    	if (rPercentArmorPenetrationMod == null) {
    		return 0;
    	}

        return rPercentArmorPenetrationMod.doubleValue();
    }

    public double getrPercentArmorPenetrationModPerLevel() {
    	if (rPercentArmorPenetrationModPerLevel == null) {
    		return 0;
    	}

        return rPercentArmorPenetrationModPerLevel.doubleValue();
    }

    public double getrPercentAttackSpeedModPerLevel() {
    	if (rPercentAttackSpeedModPerLevel == null) {
    		return 0;
    	}

        return rPercentAttackSpeedModPerLevel.doubleValue();
    }

    public double getrPercentCooldownMod() {
    	if (rPercentCooldownMod == null) {
    		return 0;
    	}

        return rPercentCooldownMod.doubleValue();
    }

    public double getrPercentCooldownModPerLevel() {
    	if (rPercentCooldownModPerLevel == null) {
    		return 0;
    	}

        return rPercentCooldownModPerLevel.doubleValue();
    }

    public double getrPercentMagicPenetrationMod() {
    	if (rPercentMagicPenetrationMod == null) {
    		return 0;
    	}

        return rPercentMagicPenetrationMod.doubleValue();
    }

    public double getrPercentMagicPenetrationModPerLevel() {
    	if (rPercentMagicPenetrationModPerLevel == null) {
    		return 0;
    	}

        return rPercentMagicPenetrationModPerLevel.doubleValue();
    }

    public double getrPercentMovementSpeedModPerLevel() {
    	if (rPercentMovementSpeedModPerLevel == null) {
    		return 0;
    	}

        return rPercentMovementSpeedModPerLevel.doubleValue();
    }

    public double getrPercentTimeDeadMod() {
    	if (rPercentTimeDeadMod == null) {
    		return 0;
    	}

        return rPercentTimeDeadMod.doubleValue();
    }

    public double getrPercentTimeDeadModPerLevel() {
    	if (rPercentTimeDeadModPerLevel == null) {
    		return 0;
    	}

        return rPercentTimeDeadModPerLevel.doubleValue();
    }
}