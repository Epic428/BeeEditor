package com.teamresourceful.editorbackend.beedata.trait;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class BeeAura {

    private String auraType; //create enum and switch to enum
    @Embedded
    private DamageEffect damageEffect;
    @Embedded
    private PotionEffect potionEffect;
    private Integer modifier;
    private Boolean calmingDisabled;

    public BeeAura() {
    }

    public BeeAura(String auraType, DamageEffect damageEffect, PotionEffect potionEffect, Integer modifier, Boolean calmingDisabled) {
        this.auraType = auraType;
        this.damageEffect = damageEffect;
        this.potionEffect = potionEffect;
        this.modifier = modifier;
        this.calmingDisabled = calmingDisabled;
    }

    public String getAuraType() {
        return auraType;
    }

    public void setAuraType(String auraType) {
        this.auraType = auraType;
    }

    public DamageEffect getDamageEffect() {
        return damageEffect;
    }

    public void setDamageEffect(DamageEffect damageEffect) {
        this.damageEffect = damageEffect;
    }

    public PotionEffect getPotionEffect() {
        return potionEffect;
    }

    public void setPotionEffect(PotionEffect potionEffect) {
        this.potionEffect = potionEffect;
    }

    public Integer getModifier() {
        return modifier;
    }

    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }

    public Boolean getCalmingDisabled() {
        return calmingDisabled;
    }

    public void setCalmingDisabled(Boolean calmingDisabled) {
        this.calmingDisabled = calmingDisabled;
    }

    @Override
    public String toString() {
        return "BeeAura{" +
                "auraType='" + auraType + '\'' +
                ", damageEffect=" + damageEffect +
                ", potionEffect=" + potionEffect +
                ", modifier=" + modifier +
                ", calmingDisabled=" + calmingDisabled +
                '}';
    }
}