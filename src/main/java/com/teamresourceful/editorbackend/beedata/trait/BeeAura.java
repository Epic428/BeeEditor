package com.teamresourceful.editorbackend.beedata.trait;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Embeddable
public class BeeAura {

    private String auraType; //create enum and switch to enum
    @Embedded
    private DamageEffect damageEffect;
    @Embedded
    private PotionEffect potionEffect;
    private Integer modifier;
    private Boolean calmingDisabled;
}