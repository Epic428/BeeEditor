package com.teamresourceful.editorbackend.beedata.trait;

import javax.persistence.Embeddable;

@Embeddable
public class PotionEffect {

    private String effect;
    private Integer strength;

    public PotionEffect() {
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "PotionEffect{" +
                "effect='" + effect + '\'' +
                ", strength=" + strength +
                '}';
    }
}