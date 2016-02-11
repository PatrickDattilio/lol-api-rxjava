package org.dc.riot.lol.rx.model.staticdata;

/**
 * Detailed statistics for champions.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ChampionDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

	private String[] allytips;
	private String blurb;
	private String[] enemytips;
	private Long id;
	private ImageDto image;
	private InfoDto info;
	private String key;
	private String lore;
	private String name;
	private String partype;
	private PassiveDto passive;
	private RecommendedDto[] recommended;
	private SkinDto[] skins;
	private ChampionSpellDto[] spells;
	private StatsDto stats;
	private String[] tags;
	private String title;
	
	public ChampionDto() {
		COUNT++;
	}

	/**
	 * @return Ally tips.
	 */
	public String[] getAllytips() {
		if (allytips == null) {
			return new String[0];
		}

		return allytips;
	}

	/**
	 * @return Blurb.
	 */
	public String getBlurb() {
		return blurb;
	}

	/**
	 * @return Enemy tips.
	 */
	public String[] getEnemytips() {
		if (enemytips == null) {
			return new String[0];
		}

		return enemytips;
	}

	/**
	 * @return Id or <code>-1</code> if not defined.
	 */
	public long getId() {
		if (id == null) {
			return -1;
		}

		return id;
	}

	/**
	 * @return Image.
	 */
	public ImageDto getImage() {
		return image;
	}

	/**
	 * @return Info.
	 */
	public InfoDto getInfo() {
		return info;
	}

	/**
	 * @return Key.
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @return Lore.
	 */
	public String getLore() {
		return lore;
	}

	/**
	 * @return Name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return Partype.
	 */
	public String getPartype() {
		return partype;
	}

	/**
	 * @return Passive.
	 */
	public PassiveDto getPassive() {
		return passive;
	}

	/**
	 * @return Recommended.
	 */
	public RecommendedDto[] getRecommended() {
		if (recommended == null) {
			return new RecommendedDto[0];
		}

		return recommended;
	}

	/**
	 * @return Skins.
	 */
	public SkinDto[] getSkins() {
		if (skins == null) {
			return new SkinDto[0];
		}

		return skins;
	}

	/**
	 * @return Spells.
	 */
	public ChampionSpellDto[] getSpells() {
		if (spells == null) {
			return new ChampionSpellDto[0];
		}

		return spells;
	}

	/**
	 * @return Stats.
	 */
	public StatsDto getStats() {
		return stats;
	}

	/**
	 * @return Tags.
	 */
	public String[] getTags() {
		if (tags == null) {
			return new String[0];
		}

		return tags;
	}

	/**
	 * @return Title.
	 */
	public String getTitle() {
		return title;
	}
}
