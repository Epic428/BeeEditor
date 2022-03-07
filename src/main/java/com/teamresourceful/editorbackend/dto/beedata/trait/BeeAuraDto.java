package com.teamresourceful.editorbackend.dto.beedata.trait;

import com.teamresourceful.editorbackend.lib.enums.AuraType;
import lombok.Data;

import javax.validation.Valid;
import java.io.Serializable;

@Data
public class BeeAuraDto implements Serializable {
    @Valid
    private AuraType auraType;
    @Valid
    private DamageEffectDto damageEffect;
    @Valid
    private PotionEffectDto potionEffect;
    private Integer modifier;
    private Boolean calmingDisabled;
}
