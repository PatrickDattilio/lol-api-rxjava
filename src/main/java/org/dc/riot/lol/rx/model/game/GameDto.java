package org.dc.riot.lol.rx.model.game;

import org.dc.riot.lol.rx.model.common.GameMode;
import org.dc.riot.lol.rx.model.common.GameType;

/**
 * This object contains game information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class GameDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private PlayerDto[] fellowPlayers;
    private GameType gameType;
    private RawStatsDto stats;
    private Long gameId;
    private Integer ipEarned;
    private Long spell1;
    private Integer teamId;
    private Long spell2;
    private GameMode gameMode;
    private Integer mapId;
    private Integer level;
    private Boolean invalid;
    private GameSubType subType;
    private Long createDate;
    private Long championId;

    public GameDto() {
    	COUNT++;
    }

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
    	if (gameId == null) {
    		return -1;
    	}

        return gameId.longValue();
    }

    /**
     * @return IP Earned.
     */
    public int getIpEarned() {
    	if (ipEarned == null) {
    		return -1;
    	}

        return ipEarned.intValue();
    }

    /**
     * @return 	ID of first summoner spell.
     */
    public long getSpell1() {
    	if (spell1 == null) {
    		return -1;
    	}

        return spell1.longValue();
    }

    /**
     * @return Team ID associated with game.
     * Team ID 100 is blue team. Team ID 200 is purple team.
     */
    public int getTeamId() {
    	if (teamId == null) {
    		return -1;
    	}

        return teamId.intValue();
    }

    /**
     * @return ID of second summoner spell.
     */
    public long getSpell2() {
    	if (spell2 == null) {
    		return -1;
    	}

        return spell2.longValue();
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
    	if (mapId == null) {
    		return -1;
    	}

        return mapId.intValue();
    }

    /**
     * @return Level.
     */
    public int getLevel() {
    	if (level == null) {
    		return -1;
    	}

        return level.intValue();
    }

    /**
     * @return 	Invalid flag.
     */
    public boolean isInvalid() {
    	if (invalid == null) {
    		return false;
    	}

        return invalid.booleanValue();
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
    	if (createDate == null) {
    		return -1;
    	}

        return createDate.longValue();
    }

    /**
     * @return 	Champion ID associated with game.
     */
    public long getChampionId() {
    	if (championId == null) {
    		return -1;
    	}

        return championId.longValue();
    }
}
