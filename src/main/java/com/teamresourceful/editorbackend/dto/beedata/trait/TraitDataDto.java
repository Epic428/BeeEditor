package com.teamresourceful.editorbackend.dto.beedata.trait;

import lombok.Data;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Set;

@Data
public class TraitDataDto implements Serializable {
    private Set<String> traits;
    private Set<@Valid PotionEffectDto> potionEffects;
    private Set<String> damageImmunities;
    private Set<String> potionImmunities;
    private Set<@Valid DamageTypeDto> damageTypes;
    private Set<String> specialAbilities;
    private Set<String> particles;
    private Set<@Valid BeeAuraDto> auras;
}
