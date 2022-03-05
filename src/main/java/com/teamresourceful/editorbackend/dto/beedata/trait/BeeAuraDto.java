package com.teamresourceful.editorbackend.dto.beedata.trait;

import com.teamresourceful.editorbackend.lib.enums.AuraType;
import lombok.Data;

import java.io.Serializable;

@Data
public class BeeAuraDto implements Serializable {
    private AuraType auraType;
    private DamageEffectDto damageEffect;
    private PotionEffectDto potionEffect;
    private Integer modifier;
    private Boolean calmingDisabled;
}
