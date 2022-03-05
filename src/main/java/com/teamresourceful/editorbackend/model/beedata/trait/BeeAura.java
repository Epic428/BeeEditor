package com.teamresourceful.editorbackend.model.beedata.trait;

import com.teamresourceful.editorbackend.lib.enums.AuraType;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Embeddable
public class BeeAura {

    @Enumerated(EnumType.STRING)
    @Type(type = "psql_enum")
    @Column(columnDefinition = "aura_type")
    private AuraType auraType;
    @Embedded
    @AttributeOverride(name = "strength", column = @Column(name = "de_strength"))
    private DamageEffect damageEffect;
    @Embedded
    @AttributeOverride(name = "strength", column = @Column(name = "pe_strength"))
    private PotionEffect potionEffect;
    private Integer modifier; //TODO determine a range for this value as one is not defined in the mod.
    private Boolean calmingDisabled;
}