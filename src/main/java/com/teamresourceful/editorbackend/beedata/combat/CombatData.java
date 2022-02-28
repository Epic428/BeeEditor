package com.teamresourceful.editorbackend.beedata.combat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamresourceful.editorbackend.beedata.CustomBeeData;

import javax.persistence.*;

//@Embeddable
@Entity
@Table(name = "combat_data")
public class CombatData {

    @Id
    @Column(name = "bee_id")
    @JsonIgnore
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "bee_id")
    @JsonIgnore
    private CustomBeeData beeData;

    private Boolean isPassive;
    private Double attackDamage;
    private Boolean removeStingerOnAttack;
    private Boolean inflictsPoison;
    private Double baseHealth;
    private Double armor;
    private Double armorToughness;
    private Double knockback;
    private Boolean isInvulnerable;

    public CombatData() {
    }

    public CombatData(Boolean isPassive, Double attackDamage, Boolean removeStingerOnAttack, Boolean inflictsPoison, Double baseHealth, Double armor, Double armorToughness, Double knockback, Boolean isInvulnerable) {
        this.isPassive = isPassive;
        this.attackDamage = attackDamage;
        this.removeStingerOnAttack = removeStingerOnAttack;
        this.inflictsPoison = inflictsPoison;
        this.baseHealth = baseHealth;
        this.armor = armor;
        this.armorToughness = armorToughness;
        this.knockback = knockback;
        this.isInvulnerable = isInvulnerable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomBeeData getBeeData() {
        return beeData;
    }

    public void setBeeData(CustomBeeData beeData) {
        this.beeData = beeData;
    }

    public Boolean getPassive() {
        return isPassive;
    }

    public void setPassive(Boolean passive) {
        isPassive = passive;
    }

    public Double getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(Double attackDamage) {
        this.attackDamage = attackDamage;
    }

    public Boolean getRemoveStingerOnAttack() {
        return removeStingerOnAttack;
    }

    public void setRemoveStingerOnAttack(Boolean removeStingerOnAttack) {
        this.removeStingerOnAttack = removeStingerOnAttack;
    }

    public Boolean getInflictsPoison() {
        return inflictsPoison;
    }

    public void setInflictsPoison(Boolean inflictsPoison) {
        this.inflictsPoison = inflictsPoison;
    }

    public Double getBaseHealth() {
        return baseHealth;
    }

    public void setBaseHealth(Double baseHealth) {
        this.baseHealth = baseHealth;
    }

    public Double getArmor() {
        return armor;
    }

    public void setArmor(Double armor) {
        this.armor = armor;
    }

    public Double getArmorToughness() {
        return armorToughness;
    }

    public void setArmorToughness(Double armorToughness) {
        this.armorToughness = armorToughness;
    }

    public Double getKnockback() {
        return knockback;
    }

    public void setKnockback(Double knockback) {
        this.knockback = knockback;
    }

    public Boolean getInvulnerable() {
        return isInvulnerable;
    }

    public void setInvulnerable(Boolean invulnerable) {
        isInvulnerable = invulnerable;
    }


    @Override
    public String toString() {
        return "CombatData{" +
                "isPassive=" + isPassive +
                ", attackDamage=" + attackDamage +
                ", removeStingerOnAttack=" + removeStingerOnAttack +
                ", inflictsPoison=" + inflictsPoison +
                ", baseHealth=" + baseHealth +
                ", armor=" + armor +
                ", armorToughness=" + armorToughness +
                ", knockback=" + knockback +
                ", isInvulnerable=" + isInvulnerable +
                '}';
    }
}