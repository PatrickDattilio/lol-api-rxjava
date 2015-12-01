package org.dc.riot.lol.rx.model;

/**
 * This object contains spell vars data.
 * Created by Dc on 9/30/15.
 */
public class SpellVarsDto {
    private double[] coeff;
    private String dyn;
    private String key;
    private String link;
    private String ranksWith;

    public double[] getCoeff() {
        return coeff;
    }

    public void setCoeff(double[] coeff) {
        this.coeff = coeff;
    }

    public String getDyn() {
        return dyn;
    }

    public void setDyn(String dyn) {
        this.dyn = dyn;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRanksWith() {
        return ranksWith;
    }

    public void setRanksWith(String ranksWith) {
        this.ranksWith = ranksWith;
    }
}
