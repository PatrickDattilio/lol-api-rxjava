package org.dc.riot.lol.rx.model.staticdata;

/**
 * This object contains champion information.<br>
 * <br>
 * Used to generate the nifty graph in the
 * client showing the strengths of each character and
 * their difficulty.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class InfoDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Integer attack;
    private Integer defense;
    private Integer difficulty;
    private Integer magic;
    
    public InfoDto() {
    	COUNT++;
    }

    /**
     * @return Attack strength.
     */
    public int getAttack() {
    	if (attack == null) {
    		return 0;
    	}

        return attack.intValue();
    }

    /**
     * @return Defense strength.
     */
    public int getDefense() {
    	if (defense == null) {
    		return 0;
    	}

        return defense.intValue();
    }

    /**
     * @return Difficulty rating.
     */
    public int getDifficulty() {
    	if (difficulty == null) {
    		return 0;
    	}

        return difficulty.intValue();
    }

    /**
     * @return Magic strength.
     */
    public int getMagic() {
    	if (magic == null) {
    		return 0;
    	}

        return magic.intValue();
    }
}