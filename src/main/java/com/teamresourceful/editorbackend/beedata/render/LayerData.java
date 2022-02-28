package com.teamresourceful.editorbackend.beedata.render;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LayerData {

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String texture; // BeeTexture
    private Boolean isGlowing;
    private Boolean isEnchanted;
    private Boolean isPollen;
    @Range(min = 5, max = 100, message = "Pulse frequency must be between 5 and 100 ticks!")
    private Float pulseFrequency;

    public LayerData() {
    }

    public LayerData(String color, String texture, Boolean isGlowing, Boolean isEnchanted, Boolean isPollen, Float pulseFrequency) {
        this.color = color;
        this.texture = texture;
        this.isGlowing = isGlowing;
        this.isEnchanted = isEnchanted;
        this.isPollen = isPollen;
        this.pulseFrequency = pulseFrequency;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public Boolean getGlowing() {
        return isGlowing;
    }

    public void setGlowing(Boolean glowing) {
        isGlowing = glowing;
    }

    public Boolean getEnchanted() {
        return isEnchanted;
    }

    public void setEnchanted(Boolean enchanted) {
        isEnchanted = enchanted;
    }

    public Boolean getPollen() {
        return isPollen;
    }

    public void setPollen(Boolean pollen) {
        isPollen = pollen;
    }

    public Float getPulseFrequency() {
        return pulseFrequency;
    }

    public void setPulseFrequency(Float pulseFrequency) {
        this.pulseFrequency = pulseFrequency;
    }

    @Override
    public String toString() {
        return "LayerData{" +
                "color='" + color + '\'' +
                ", texture=" + texture +
                ", isGlowing=" + isGlowing +
                ", isEnchanted=" + isEnchanted +
                ", isPollen=" + isPollen +
                ", pulseFrequency=" + pulseFrequency +
                '}';
    }
}