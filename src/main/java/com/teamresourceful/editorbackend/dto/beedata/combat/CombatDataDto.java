package com.teamresourceful.editorbackend.dto.beedata.combat;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CombatDataDto implements Serializable {
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
}
