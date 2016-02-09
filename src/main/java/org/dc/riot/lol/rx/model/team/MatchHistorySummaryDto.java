package org.dc.riot.lol.rx.model.team;

import org.dc.riot.lol.rx.model.common.GameMode;

/**
 * This object contains match history summary information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MatchHistorySummaryDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private GameMode gameMode;
    private Long mapId;
    private Integer assists;
    private String opposingTeamName;
    private Boolean invalid;
    private Integer deaths;
    private Long gameId;
    private Integer kills;
    private Boolean win;
    private Long date;
    private Integer opposingTeamKills;
    
    public MatchHistorySummaryDto() {
    	COUNT++;
    }

    /**
     * @return Game mode.
     */
    public GameMode getGameMode() {
        return gameMode;
    }

    /**
     * @return Map ID or <code>-1</code> if not
     * defined.
     */
    public long getMapId() {
    	if (mapId == null) {
    		return -1;
    	}

        return mapId.longValue();
    }

    /**
     * @return This team's assists or <code>-1</code> if not
     * defined.
     */
    public int getAssists() {
    	if (assists == null) {
    		return -1;
    	}

        return assists.intValue();
    }

    /**
     * @return Opposing team's name.
     */
    public String getOpposingTeamName() {
        return opposingTeamName;
    }

    /**
     * @return Something is invalid or <code>false</code>
     * if not defined.
     */
    public boolean isInvalid() {
    	if (invalid == null) {
    		return false;
    	}

        return invalid.booleanValue();
    }

    /**
     * @return This team's deaths or <code>-1</code> if not
     * defined.
     */
    public int getDeaths() {
    	if (deaths == null) {
    		return -1;
    	}

        return deaths.intValue();
    }

    /**
     * @return Game ID or <code>-1</code> if not
     * defined.
     */
    public long getGameId() {
    	if (gameId == null) {
    		return -1;
    	}

        return gameId.longValue();
    }

    /**
     * @return This team's kills or <code>-1</code> if not
     * defined.
     */
    public int getKills() {
    	if (kills == null) {
    		return -1;
    	}

        return kills.intValue();
    }

    /**
     * @return Flag if this team won or <code>false</code>
     * if not defined.
     */
    public boolean isWin() {
    	if (win == null) {
    		return false;
    	}

        return win.booleanValue();
    }

    /**
     * @return 	Date that match was completed
     * specified as epoch milliseconds or <code>-1</code> if not
     * defined.
     */
    public long getDate() {
    	if (date == null) {
    		return -1;
    	}

        return date.longValue();
    }

    /**
     * @return Opposing team's kills or <code>-1</code> if not
     * defined.
     */
    public int getOpposingTeamKills() {
    	if (opposingTeamKills == null) {
    		return -1;
    	}

        return opposingTeamKills.intValue();
    }
}