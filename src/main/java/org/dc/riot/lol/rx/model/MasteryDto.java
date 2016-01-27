package org.dc.riot.lol.rx.model;

/**
 * This object contains mastery data.
 * 
 * @author Dc
 * @since 1.0.0
 * @see org.dc.riot.lol.rx.service.RiotApi.StaticData#getMastery RiotApi.StaticData.getMastery(...)
 */
public class MasteryDto {
    private String[] description;
    private long id;
    private ImageDto image;
    private String masteryTree;
    private String name;
    private String prereq;
    private int ranks;
    private String[] santizedDescription;

    public String[] getDescription() {
        return description;
    }

    public void setDescription(String[] description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ImageDto getImage() {
        return image;
    }

    public void setImage(ImageDto image) {
        this.image = image;
    }

    public String getMasteryTree() {
        return masteryTree;
    }

    public void setMasteryTree(String masteryTree) {
        this.masteryTree = masteryTree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrereq() {
        return prereq;
    }

    public void setPrereq(String prereq) {
        this.prereq = prereq;
    }

    public int getRanks() {
        return ranks;
    }

    public void setRanks(int ranks) {
        this.ranks = ranks;
    }

    public String[] getSantizedDescription() {
        return santizedDescription;
    }

    public void setSantizedDescription(String[] santizedDescription) {
        this.santizedDescription = santizedDescription;
    }
}
