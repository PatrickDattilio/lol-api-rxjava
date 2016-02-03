package org.dc.riot.lol.rx.model.staticdata;

/**
 * This object contains champion passive data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class PassiveDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private String description;
    private ImageDto image;
    private String name;
    private String sanitizedDescription;
    
    public PassiveDto() {
    	COUNT++;
    }

    /**
     * @return Description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return Image data.
     */
    public ImageDto getImage() {
        return image;
    }

    /**
     * @return Name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return Sanitized description.
     */
    public String getSanitizedDescription() {
        return sanitizedDescription;
    }
}
