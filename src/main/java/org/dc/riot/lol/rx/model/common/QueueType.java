package org.dc.riot.lol.rx.model.common;

/**
 * Queue types.
 * 
 * @author Dc
 * @since 1.0.0
 */
public enum QueueType {
	CUSTOM,
	NORMAL_5x5_BLIND,
	RANKED_SOLO_5x5,
	@Deprecated
	RANKED_PREMADE_5x5,
	BOT_5x5,
	NORMAL_3x3,
	@Deprecated
	RANKED_PREMADE_3x3,
	NORMAL_5x5_DRAFT,
	ODIN_5x5_BLIND,
	ODIN_5x5_DRAFT,
	BOT_ODIN_5x5,
	BOT_5x5_INTRO,
	BOT_5x5_BEGINNER,
	BOT_5x5_INTERMEDIATE,
	RANKED_TEAM_3x3,
	RANKED_TEAM_5x5,
	BOT_TT_3x3,
	GROUP_FINDER_5x5,
	ARAM_5x5,
	ONEFORALL_5x5,
	FIRSTBLOOD_1x1,
	FIRSTBLOOD_2x2,
	SR_6x6,
	URF_5x5,
	ONEFORALL_MIRRORMODE_5x5,
	BOT_URF_5x5,
	NIGHTMARE_BOT_5x5_RANK1,
	NIGHTMARE_BOT_5x5_RANK2,
	NIGHTMARE_BOT_5x5_RANK5,
	ASCENSION_5x5,
	HEXAKILL,
	BILGEWATER_ARAM_5x5,
	KING_PORO_5x5,
	COUNTER_PICK,
	BILGEWATER_5x5,
	
	/**
	 * This looks like the new dynamic queue.
	 */
	TEAM_BUILDER_DRAFT_RANKED_5x5;
	
	public boolean isRanked() {
		return toString().contains("RANKED");
	}
	
	public enum ChallengerMaster {
		RANKED_SOLO_5x5,
		RANKED_TEAM_3x3,
		RANKED_TEAM_5x5,
	
		/**
		 * This looks like the new dynamic queue.
		 */
		TEAM_BUILDER_DRAFT_RANKED_5x5;
	}
}
