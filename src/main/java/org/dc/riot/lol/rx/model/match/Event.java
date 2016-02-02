package org.dc.riot.lol.rx.model.match;

public class Event {
	private AscendedType ascendedType;
	private long[] assistingParticipantIds;
	private BuildingType buildingType;
	private long creatorId;
	private EventType eventType;
	private long itemAfter;
	private long itemBefore;
	private long itemId;
	private long killerId;
	private LaneType laneType;
	private LevelUpType levelUpType;
	private MonsterType monsterType;
	private long participantId;
	private CapturePoint pointCaptured;
	private Position position;
	private int skillSlot;
	private int teamId;
	private long timestamp;
	private TowerType towerType;
	private long victimId;
	private WardType wardType;

	/**
	 * @return The ascended type of the event.
	 * Only present if relevant.
	 * Note that CLEAR_ASCENDED refers to when a participants kills the ascended player.
	 * (Legal values: CHAMPION_ASCENDED, CLEAR_ASCENDED, MINION_ASCENDED)
	 */
	public AscendedType getAscendedType() {
		return ascendedType;
	}

	/**
	 * @return The assisting participant IDs of the event. Only present if relevant.
	 */
	public long[] getAssistingParticipantIds() {
		if (assistingParticipantIds == null) {
			return new long[0];
		}

		return assistingParticipantIds;
	}

	/**
	 * @return The building type of the event.
	 * Only present if relevant.
	 * (Legal values: INHIBITOR_BUILDING, TOWER_BUILDING)
	 */
	public BuildingType getBuildingType() {
		return buildingType;
	}

	/**
	 * @return The creator ID of the event. Only present if relevant.
	 */
	public long getCreatorId() {
		return creatorId;
	}

	/**
	 * @return Event type.
	 * (Legal values: ASCENDED_EVENT, BUILDING_KILL,
	 * CAPTURE_POINT, CHAMPION_KILL, ELITE_MONSTER_KILL,
	 * ITEM_DESTROYED, ITEM_PURCHASED, ITEM_SOLD,
	 * ITEM_UNDO, PORO_KING_SUMMON, SKILL_LEVEL_UP,
	 * WARD_KILL, WARD_PLACED)
	 */
	public EventType getEventType() {
		return eventType;
	}

	/**
	 * @return The ending item ID of the event. Only present if relevant.
	 */
	public long getItemAfter() {
		return itemAfter;
	}

	/**
	 * @return The starting item ID of the event. Only present if relevant.
	 */
	public long getItemBefore() {
		return itemBefore;
	}

	/**
	 * @return The item ID of the event. Only present if relevant.
	 */
	public long getItemId() {
		return itemId;
	}

	/**
	 * @return The killer ID of the event. Only present if relevant.
	 * Killer ID <code>0</code> indicates a minion.
	 */
	public long getKillerId() {
		return killerId;
	}

	/**
	 * @return The lane type of the event. Only present if relevant.
	 * (Legal values: BOT_LANE, MID_LANE, TOP_LANE)
	 */
	public LaneType getLaneType() {
		return laneType;
	}

	/**
	 * @return The level up type of the event.
	 * Only present if relevant.
	 * (Legal values: EVOLVE, NORMAL)
	 */
	public LevelUpType getLevelUpType() {
		return levelUpType;
	}

	/**
	 * @return The monster type of the event. Only present if relevant.
	 * (Legal values: BARON_NASHOR, BLUE_GOLEM,
	 * DRAGON, RED_LIZARD, RIFTHERALD, VILEMAW)
	 */
	public MonsterType getMonsterType() {
		return monsterType;
	}

	/**
	 * @return The participant ID of the event. Only present if relevant.
	 */
	public long getParticipantId() {
		return participantId;
	}

	/**
	 * @return The point captured in the event. Only present if relevant.
	 * (Legal values: POINT_A, POINT_B, POINT_C, POINT_D, POINT_E)
	 */
	public CapturePoint getPointCaptured() {
		return pointCaptured;
	}

	/**
	 * @return The position of the event. Only present if relevant.
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @return The skill slot of the event. Only present if relevant.
	 */
	public int getSkillSlot() {
		return skillSlot;
	}

	/**
	 * @return The team ID of the event. Only present if relevant.
	 */
	public int getTeamId() {
		return teamId;
	}

	/**
	 * @return Represents how many milliseconds into
	 * the game the event occurred.
	 */
	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * @return The tower type of the event.
	 * Only present if relevant.
	 * (Legal values: BASE_TURRET, FOUNTAIN_TURRET,
	 * INNER_TURRET, NEXUS_TURRET, OUTER_TURRET,
	 * UNDEFINED_TURRET)
	 */
	public TowerType getTowerType() {
		return towerType;
	}

	/**
	 * @return The victim ID of the event. Only present if relevant.
	 */
	public long getVictimId() {
		return victimId;
	}

	/**
	 * @return The ward type of the event.
	 * Only present if relevant.
	 * (Legal values: BLUE_TRINKET, SIGHT_WARD,
	 * TEEMO_MUSHROOM, UNDEFINED, VISION_WARD,
	 * YELLOW_TRINKET, YELLOW_TRINKET_UPGRADE)
	 */
	public WardType getWardType() {
		return wardType;
	}
}

