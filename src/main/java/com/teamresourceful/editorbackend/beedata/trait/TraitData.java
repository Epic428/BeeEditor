package com.teamresourceful.editorbackend.beedata.trait;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.teamresourceful.editorbackend.beedata.CustomBeeData;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "trait_data")
public class TraitData {

    @Id
    @Column(name = "bee_id")
    @JsonIgnore
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "bee_id")
    @JsonIgnore
    private CustomBeeData beeData;

    @ElementCollection
    @CollectionTable(name = "traits", joinColumns = @JoinColumn(name = "bee_id"))
    @Column(name = "trait", nullable = false)
    @JsonProperty("traits")
    private Set<String> traits = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "potion_effects", joinColumns = @JoinColumn(name = "bee_id"))
    @Column(name = "effect", nullable = false)
    @JsonProperty("potionEffects")
    private Set<PotionEffect> potionEffects = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "damage_immunities", joinColumns = @JoinColumn(name = "bee_id"))
    @Column(name = "damage", nullable = false)
    @JsonProperty("damageImmunities")
    private Set<String> damageImmunities = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "potion_immunities", joinColumns = @JoinColumn(name = "bee_id"))
    @Column(name = "potion", nullable = false)
    @JsonProperty("potionImmunities")
    private Set<String> potionImmunities = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "damage_types", joinColumns = @JoinColumn(name = "bee_id"))
    @Column(name = "type", nullable = false)
    @JsonProperty("damageTypes")
    private Set<DamageType> damageTypes = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "special_abilities", joinColumns = @JoinColumn(name = "bee_id"))
    @Column(name = "ability", nullable = false)
    @JsonProperty("specialAbilities")
    private Set<String> specialAbilities = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "particles", joinColumns = @JoinColumn(name = "bee_id"))
    @Column(name = "particle", nullable = false)
    @JsonProperty("particles")
    private Set<String> particles = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "auras", joinColumns = @JoinColumn(name = "bee_id"))
    @Column(name = "aura", nullable = false)
    @JsonProperty("auras")
    private Set<BeeAura> auras = new HashSet<>();

    @Builder
    public TraitData(Set<String> traits, Set<PotionEffect> potionEffects, Set<String> damageImmunities, Set<String> potionImmunities, Set<DamageType> damageTypes, Set<String> specialAbilities, Set<String> particles, Set<BeeAura> auras) {
        this.traits = traits;
        this.potionEffects = potionEffects;
        this.damageImmunities = damageImmunities;
        this.potionImmunities = potionImmunities;
        this.damageTypes = damageTypes;
        this.specialAbilities = specialAbilities;
        this.particles = particles;
        this.auras = auras;
    }
}