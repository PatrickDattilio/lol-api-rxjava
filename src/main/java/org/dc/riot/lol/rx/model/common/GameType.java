package org.dc.riot.lol.rx.model;

/**
 * Game type enumeration
 * 
 * @author Dc
 * @since 1.0.0
 */
public enum GameType {
	/**
	 * Custom game
	 */
    CUSTOM_GAME,
    
    /**
     * Matched game (e.g. normals, ranked, bots)
     */
    MATCHED_GAME,
    
    /**
     * Tutorial
     */
    TUTORIAL_GAME;
}
