package org.dc.riot.lol.rx.model.staticdata;

/**
 * This object contains champion skin data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class SkinDto {
    private int id;
    private String name;
    private int num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
