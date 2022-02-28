package com.teamresourceful.editorbackend.beedata.combat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamresourceful.editorbackend.beedata.CustomBeeData;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
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

    @Builder
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
}