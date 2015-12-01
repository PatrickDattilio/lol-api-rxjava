package org.dc.riot.lol.rx.model;

/**
 * Player position used by the {@link RawStatsDto}
 * Created by Dc on 9/16/15.
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

    public static PlayerPosition from(int code) {
        for (PlayerPosition pp : PlayerPosition.values()) {
            if (pp.code == code) {
                return pp;
            }
        }

        return null;
    }
}
