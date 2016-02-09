package org.dc.riot.lol.rx.model.staticdata;

public class MasteryDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

	private String[] description;
	private Long id;
	private ImageDto image;
	private String masteryTree;
	private String name;
	private String prereq;
	private Integer ranks;
	private String[] sanitizedDescription;
	
	public MasteryDto() {
		COUNT++;
	}

	/**
	 * @return Descriptions.
	 */
	public String[] getDescription() {
		if (description == null) {
			return new String[0];
		}

		return description;
	}
	
	/**
	 * @return Mastery ID or <code>-1</code> if
	 * not defined.
	 */
	public long getId() {
		if (id == null) {
			return -1;
		}
		
		return id.longValue();
	}
	
	/**
	 * @return Image data.
	 */
	public ImageDto getImage() {
		return image;
	}
	
	/**
	 * Season 6 values: Cunning, Ferocity, Resolve. Could
	 * be an enum but who knows how this will change.
	 * 
	 * @return Mastery tree name.
	 */
	public String getMasteryTree() {
		return masteryTree;
	}
	
	/**
	 * @return Name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return Prerequisite.
	 */
	public String getPrereq() {
		return prereq;
	}
	
	/**
	 * @return Ranks or <code>0</code> if not
	 * defined.
	 */
	public int getRanks() {
		if (ranks == null) {
			return 0;
		}

		return ranks.intValue();
	}
	
	/**
	 * @return Sanitized descriptions.
	 */
	public String[] getSanitizedDescription() {
		if (sanitizedDescription == null) {
			return new String[0];
		}

		return sanitizedDescription;
	}
}
