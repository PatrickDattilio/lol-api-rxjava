package org.dc.riot.lol.rx.model.game;

import org.dc.riot.lol.rx.model.GameMode;
import org.dc.riot.lol.rx.model.GameType;

/**
 * @author Dc
 * @since 1.0.0
 */
public class GameDto {
    private PlayerDto[] fellowPlayers;
    private GameType gameType;
    private RawStatsDto stats;
    private long gameId;
    private int ipEarned;
    private int spell1;
    private int teamId;
    private int spell2;
    private GameMode gameMode;
    private int mapId;
    private int level;
    private boolean invalid;
    private GameSubType subType;
    private long createDate;
    private int championId;

    /**
     * @return Other players associated with the game.
     */
    public PlayerDto[] getFellowPlayers() {
    	if (fellowPlayers == null) {
    		return new PlayerDto[0];
    	}

        return fellowPlayers;
    }

    /**
     * @return Game type.
     */
    public GameType getGameType() {
        return gameType;
    }

    /**
     * @return Statistics associated with the game for this summoner.
     */
    public RawStatsDto getStats() {
        return stats;
    }

    /**
     * @return 	Game ID.
     */
    public long getGameId() {
        return gameId;
    }

    /**
     * @return IP Earned.
     */
    public int getIpEarned() {
        return ipEarned;
    }

    /**
     * @return 	ID of first summoner spell.
     */
    public int getSpell1() {
        return spell1;
    }

    /**
     * @return Team ID associated with game.
     * Team ID 100 is blue team. Team ID 200 is purple team.
     */
    public int getTeamId() {
        return teamId;
    }

    /**
     * @return ID of second summoner spell.
     */
    public int getSpell2() {
        return spell2;
    }

    /**
     * @return Game mode.
     */
    public GameMode getGameMode() {
        return gameMode;
    }

    /**
     * @return Map ID.
     */
    public int getMapId() {
        return mapId;
    }

    /**
     * @return Level.
     */
    public int getLevel() {
        return level;
    }

    /**
     * @return 	Invalid flag.
     */
    public boolean isInvalid() {
        return invalid;
    }

    /**
     * @return Game sub-type.
     */
    public GameSubType getSubType() {
        return subType;
    }

    /**
     * @return 	Date that end game data was
     * recorded, specified as epoch milliseconds.
     */
    public long getCreateDate() {
        return createDate;
    }

    /**
     * @return 	Champion ID associated with game.
     */
    public int getChampionId() {
        return championId;
    }
}
