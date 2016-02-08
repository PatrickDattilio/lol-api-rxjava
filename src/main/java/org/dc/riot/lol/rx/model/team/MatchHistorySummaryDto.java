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
    private Integer mapId;
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
     * @return Map ID.
     */
    public int getMapId() {
        return mapId;
    }

    /**
     * @return This team's assists.
     */
    public int getAssists() {
        return assists;
    }

    /**
     * @return Opposing team's name.
     */
    public String getOpposingTeamName() {
        return opposingTeamName;
    }

    /**
     * @return Something is invalid.
     */
    public boolean isInvalid() {
        return invalid;
    }

    /**
     * @return This team's deaths.
     */
    public int getDeaths() {
        return deaths;
    }

    /**
     * @return Game ID.
     */
    public long getGameId() {
        return gameId;
    }

    /**
     * @return This team's kills.
     */
    public int getKills() {
        return kills;
    }

    /**
     * @return Flag if this team won.
     */
    public boolean isWin() {
        return win;
    }

    /**
     * @return 	Date that match was completed
     * specified as epoch milliseconds.
     */
    public long getDate() {
        return date;
    }

    /**
     * @return Opposing team's kills.
     */
    public int getOpposingTeamKills() {
        return opposingTeamKills;
    }
}