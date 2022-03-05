package com.teamresourceful.editorbackend.model.beedata.combat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamresourceful.editorbackend.model.beedata.BeeData;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.UUID;

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
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "bee_id")
    @JsonIgnore
    private BeeData beeData;

    //TODO min values might need to be tweaked/modified for better form presentation

    private Boolean isPassive;
    @DecimalMin(value = "1.0", message = "Attack damage must not be less than 1!")
    @Digits(integer = 10, fraction = 3)
    private BigDecimal attackDamage;
    private Boolean removeStingerOnAttack;
    private Boolean inflictsPoison;
    @DecimalMin(value = "1.0", message = "Base health must not be less than 1!")
    @Digits(integer = 10, fraction = 3)
    private BigDecimal baseHealth;
    @DecimalMin(value = "1.0", message = "Armor must not be less than 1!")
    @Digits(integer = 10, fraction = 3)
    private BigDecimal armor;
    @DecimalMin(value = "1.0", message = "Armor toughness must not be less than 1!")
    @Digits(integer = 10, fraction = 3)
    private BigDecimal armorToughness;
    @DecimalMin(value = "1.0", message = "Knockback must not be less than 1!")
    @Digits(integer = 10, fraction = 3)
    private BigDecimal knockback;
    private Boolean isInvulnerable;

    @Builder
    public CombatData(Boolean isPassive, BigDecimal attackDamage, Boolean removeStingerOnAttack, Boolean inflictsPoison, BigDecimal baseHealth, BigDecimal armor, BigDecimal armorToughness, BigDecimal knockback, Boolean isInvulnerable) {
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