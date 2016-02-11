package org.dc.riot.lol.rx.model.match;

/**
 * This object contains game event information.
 * Note that not all legal type values documented below
 * are valid for all games. Event data evolves over
 * time and certain values may be relevant only for
 * older or newer games.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Event {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

	private AscendedType ascendedType;
	private long[] assistingParticipantIds;
	private BuildingType buildingType;
	private Long creatorId;
	private EventType eventType;
	private Long itemAfter;
	private Long itemBefore;
	private Long itemId;
	private Long killerId;
	private LaneType laneType;
	private LevelUpType levelUpType;
	private MonsterType monsterType;
	private Long participantId;
	private CapturePoint pointCaptured;
	private Position position;
	private Integer skillSlot;
	private Integer teamId;
	private Long timestamp;
	private TowerType towerType;
	private Long victimId;
	private WardType wardType;
	
	public Event() {
		COUNT++;
	}

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
	 * @return The assisting participant IDs of the event.
	 * Only present if relevant.
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
	 * @return The creator ID of the event or
	 * <code>-1</code> if not defined.
	 */
	public long getCreatorId() {
		if (creatorId == null) {
			return -1;
		}

		return creatorId.longValue();
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
	 * @return The ending item ID of the event or
	 * <code>-1</code> if not defined.
	 */
	public long getItemAfter() {
		if (itemAfter == null) {
			return -1;
		}

		return itemAfter.longValue();
	}

	/**
	 * @return The starting item ID of the event or
	 * <code>-1</code> if not defined.
	 */
	public long getItemBefore() {
		if (itemBefore == null) {
			return -1;
		}

		return itemBefore.longValue();
	}

	/**
	 * @return The item ID of the event or
	 * <code>-1</code> if not defined.
	 */
	public long getItemId() {
		if (itemId == null) {
			return -1;
		}

		return itemId.longValue();
	}

	/**
	 * @return The killer ID of the event or
	 * <code>-1</code> if not defined.
	 * Killer ID <code>0</code> indicates a minion.
	 */
	public long getKillerId() {
		if (killerId == null) {
			return -1;
		}

		return killerId.longValue();
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
	 * @return The participant ID of the event or
	 * <code>-1</code> if not defined.
	 */
	public long getParticipantId() {
		if (participantId == null) {
			return -1;
		}

		return participantId.longValue();
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
	 * @return The skill slot of the event or
	 * <code>-1</code> if not defined.
	 */
	public int getSkillSlot() {
		if (skillSlot == null) {
			return -1;
		}

		return skillSlot.intValue();
	}

	/**
	 * @return The team ID of the event or
	 * <code>-1</code> if not defined.
	 */
	public int getTeamId() {
		if (teamId == null) {
			return -1;
		}

		return teamId.intValue();
	}

	/**
	 * @return Represents how many milliseconds into
	 * the game the event occurred or
	 * <code>-1</code> if not defined.
	 */
	public long getTimestamp() {
		if (timestamp == null) {
			return -1;
		}

		return timestamp.longValue();
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
	 * @return The victim ID of the event or
	 * <code>-1</code> if not defined.
	 */
	public long getVictimId() {
		if (victimId == null) {
			return -1;
		}

		return victimId.longValue();
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