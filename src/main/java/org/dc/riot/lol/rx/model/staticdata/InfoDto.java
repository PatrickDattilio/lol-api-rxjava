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

    private int attack;
    private int defense;
    private int difficulty;
    private int magic;
    
    public InfoDto() {
    	COUNT++;
    }

    /**
     * @return Attack strength.
     */
    public int getAttack() {
        return attack;
    }

    /**
     * @return Defense strength.
     */
    public int getDefense() {
        return defense;
    }

    /**
     * @return Difficulty rating.
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * @return Magic strength.
     */
    public int getMagic() {
        return magic;
    }
    
    /**
     * Unit testing only. Client code should not
     * use this method.
     * 
     * @return Sum of all fields.
     */
    public int sum() {
    	return attack + defense + difficulty + magic;
    }
}