package org.dc.riot.lol.rx.model;

/**
 * Player roles, not sure this is really used much
 * Created by Dc on 9/16/15.
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

    public static PlayerRole from(int code) {
        for (PlayerRole pr : PlayerRole.values()) {
            if (pr.code == code) {
                return pr;
            }
        }

        return null;
    }
}
