package com.teamresourceful.editorbackend.beedata.trait;

import javax.persistence.Embeddable;

@Embeddable
public class DamageEffect {

    private String source;
    private Integer str; //TODO when named as Strength this column clashes with the one in PotionEffect - fix this!

    public DamageEffect() {
    }

    public DamageEffect(String source, Integer str) {
        this.source = source;
        this.str = str;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getStr() {
        return str;
    }

    public void setStr(Integer strength) {
        this.str = strength;
    }

    @Override
    public String toString() {
        return "DamageEffect{" +
                "source='" + source + '\'' +
                ", strength=" + str +
                '}';
    }
}