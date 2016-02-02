package org.dc.riot.lol.rx.model.game;

/**
 * Player position used by the {@link RawStatsDto}.
 * 
 * @author Dc
 * @since 1.0.0
 */
public enum PlayerPosition {
    TOP(1), MIDDLE(2), JUNGLE(3), BOT(4);

    private final int code;
    PlayerPosition(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    
    @Override
    public String toString() {
    	return String.valueOf(code);
    }

    public static PlayerPosition from(int code) {
        for (PlayerPosition pp : PlayerPosition.values()) {
            if (pp.code == code) {
                return pp;
            }
        }

        return null;
    }
}
