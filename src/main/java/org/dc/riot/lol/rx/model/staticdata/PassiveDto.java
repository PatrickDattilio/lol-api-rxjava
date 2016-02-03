package org.dc.riot.lol.rx.model.staticdata;

/**
 * This object contains champion passive data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class PassiveDto {
    private String description;
    private ImageDto image;
    private String name;
    private String sanitizedDescription;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ImageDto getImage() {
        return image;
    }

    public void setImage(ImageDto image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSanitizedDescription() {
        return sanitizedDescription;
    }

    public void setSanitizedDescription(String sanitizedDescription) {
        this.sanitizedDescription = sanitizedDescription;
    }
}
