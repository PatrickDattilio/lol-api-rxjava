package org.dc.riot.lol.rx.model;

/**
 * Used to generate the nifty graph in the
 * client showing the strengths of each character and
 * their difficulty.
 * Created by Dc on 9/30/15.
 */
public class InfoDto {
    private int attack;
    private int defense;
    private int difficulty;
    private int magic;

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }
}
