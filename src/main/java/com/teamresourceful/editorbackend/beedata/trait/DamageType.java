package com.teamresourceful.editorbackend.beedata.trait;

import javax.persistence.Embeddable;

@Embeddable
public class DamageType {

    private String type;
    private Integer amplifier;

    public DamageType() {
    }

    public DamageType(String type, Integer amplifier) {
        this.type = type;
        this.amplifier = amplifier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAmplifier() {
        return amplifier;
    }

    public void setAmplifier(Integer amplifier) {
        this.amplifier = amplifier;
    }

    @Override
    public String toString() {
        return "DamageType{" +
                "type='" + type + '\'' +
                ", amplifier=" + amplifier +
                '}';
    }
}