package org.dc.riot.lol.rx.model.game;

/**
 * Player roles, not sure this is really used much.
 * 
 * @author Dc
 * @since 1.0.0
 */
public enum PlayerRole {
    DUO(1), SUPPORT(2), CARRY(3), SOLO(4);

    private final int code;
    PlayerRole(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    
    @Override
    public String toString() {
    	return String.valueOf(code);
    }

    public static PlayerRole from(int code) {
        for (PlayerRole pr : PlayerRole.values()) {
            if (pr.code == code) {
                return pr;
            }
        }

        return null;
    }
}
