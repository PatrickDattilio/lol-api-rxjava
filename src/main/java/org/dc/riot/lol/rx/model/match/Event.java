package org.dc.riot.lol.rx.model.match;

public class Event {
	private String ascendedType;	// The ascended type of the event. Only present if relevant. Note that CLEAR_ASCENDED refers to when a participants kills the ascended player. (Legal values: CHAMPION_ASCENDED, CLEAR_ASCENDED, MINION_ASCENDED)
	private long[] assistingParticipantIds;	// The assisting participant IDs of the event. Only present if relevant.
	private String buildingType;	// The building type of the event. Only present if relevant. (Legal values: INHIBITOR_BUILDING, TOWER_BUILDING)
	private long creatorId;	// The creator ID of the event. Only present if relevant.
	private String eventType;	// Event type. (Legal values: ASCENDED_EVENT, BUILDING_KILL, CAPTURE_POINT, CHAMPION_KILL, ELITE_MONSTER_KILL, ITEM_DESTROYED, ITEM_PURCHASED, ITEM_SOLD, ITEM_UNDO, PORO_KING_SUMMON, SKILL_LEVEL_UP, WARD_KILL, WARD_PLACED)
	private long itemAfter;	// The ending item ID of the event. Only present if relevant.
	private long itemBefore;	// The starting item ID of the event. Only present if relevant.
	private long itemId;	// The item ID of the event. Only present if relevant.
	private long killerId;	// The killer ID of the event. Only present if relevant. Killer ID 0 indicates a minion.
	private String laneType;	// The lane type of the event. Only present if relevant. (Legal values: BOT_LANE, MID_LANE, TOP_LANE)
	private String levelUpType;	// The level up type of the event. Only present if relevant. (Legal values: EVOLVE, NORMAL)
	private String monsterType;	// The monster type of the event. Only present if relevant. (Legal values: BARON_NASHOR, BLUE_GOLEM, DRAGON, RED_LIZARD, RIFTHERALD, VILEMAW)
	private long participantId;	// The participant ID of the event. Only present if relevant.
	private String pointCaptured;	// The point captured in the event. Only present if relevant. (Legal values: POINT_A, POINT_B, POINT_C, POINT_D, POINT_E)
	private Position position;	// The position of the event. Only present if relevant.
	private int skillSlot;	// The skill slot of the event. Only present if relevant.
	private int teamId;	// The team ID of the event. Only present if relevant.
	private long timestamp;	// Represents how many milliseconds into the game the event occurred.
	private String towerType;	// The tower type of the event. Only present if relevant. (Legal values: BASE_TURRET, FOUNTAIN_TURRET, INNER_TURRET, NEXUS_TURRET, OUTER_TURRET, UNDEFINED_TURRET)
	private long victimId;	// The victim ID of the event. Only present if relevant.
	private String wardType;	// The ward type of the event. Only present if relevant. (Legal values: BLUE_TRINKET, SIGHT_WARD, TEEMO_MUSHROOM, UNDEFINED, VISION_WARD, YELLOW_TRINKET, YELLOW_TRINKET_UPGRADE)

	public String getAscendedType() {
		return ascendedType;
	}

	public long[] getAssistingParticipantIds() {
		return assistingParticipantIds;
	}

	public String getBuildingType() {
		return buildingType;
	}

	public long getCreatorId() {
		return creatorId;
	}

	public String getEventType() {
		return eventType;
	}

	public long getItemAfter() {
		return itemAfter;
	}

	public long getItemBefore() {
		return itemBefore;
	}

	public long getItemId() {
		return itemId;
	}

	public long getKillerId() {
		return killerId;
	}

	public String getLaneType() {
		return laneType;
	}

	public String getLevelUpType() {
		return levelUpType;
	}

	public String getMonsterType() {
		return monsterType;
	}

	public long getParticipantId() {
		return participantId;
	}

	public String getPointCaptured() {
		return pointCaptured;
	}

	public Position getPosition() {
		return position;
	}

	public int getSkillSlot() {
		return skillSlot;
	}

	public int getTeamId() {
		return teamId;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public String getTowerType() {
		return towerType;
	}

	public long getVictimId() {
		return victimId;
	}

	public String getWardType() {
		return wardType;
	}
}

