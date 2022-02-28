package com.teamresourceful.editorbackend.beedata.breeding;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class BeeFamily {

    private BigDecimal weight;
    private BigDecimal chance;
    private String parent1;
    private String parent2;

    public BeeFamily() {
    }

    public BeeFamily(BigDecimal weight, BigDecimal chance, String parent1, String parent2) {
        this.weight = weight;
        this.chance = chance;
        this.parent1 = parent1;
        this.parent2 = parent2;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getChance() {
        return chance;
    }

    public void setChance(BigDecimal chance) {
        this.chance = chance;
    }

    public String getParent1() {
        return parent1;
    }

    public void setParent1(String parent1) {
        this.parent1 = parent1;
    }

    public String getParent2() {
        return parent2;
    }

    public void setParent2(String parent2) {
        this.parent2 = parent2;
    }

    @Override
    public String toString() {
        return "BeeFamily{" +
                "weight=" + weight +
                ", chance=" + chance +
                ", parent1='" + parent1 + '\'' +
                ", parent2='" + parent2 + '\'' +
                '}';
    }


}