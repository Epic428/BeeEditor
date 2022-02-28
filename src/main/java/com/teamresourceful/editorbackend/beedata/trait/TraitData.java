package com.teamresourceful.editorbackend.beedata.trait;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.teamresourceful.editorbackend.beedata.CustomBeeData;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Embeddable
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

    public TraitData() {
    }

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

    public Set<String> getTraits() {
        return traits;
    }

    public void setTraits(Set<String> traits) {
        this.traits = traits;
    }

    public Set<PotionEffect> getPotionEffects() {
        return potionEffects;
    }

    public void setPotionEffects(Set<PotionEffect> potionEffects) {
        this.potionEffects = potionEffects;
    }

    public Set<String> getDamageImmunities() {
        return damageImmunities;
    }

    public void setDamageImmunities(Set<String> damageImmunities) {
        this.damageImmunities = damageImmunities;
    }

    public Set<String> getPotionImmunities() {
        return potionImmunities;
    }

    public void setPotionImmunities(Set<String> potionImmunities) {
        this.potionImmunities = potionImmunities;
    }

    public Set<DamageType> getDamageTypes() {
        return damageTypes;
    }

    public void setDamageTypes(Set<DamageType> damageTypes) {
        this.damageTypes = damageTypes;
    }

    public Set<String> getSpecialAbilities() {
        return specialAbilities;
    }

    public void setSpecialAbilities(Set<String> specialAbilities) {
        this.specialAbilities = specialAbilities;
    }

    public Set<String> getParticles() {
        return particles;
    }

    public void setParticles(Set<String> particles) {
        this.particles = particles;
    }

    public Set<BeeAura> getAuras() {
        return auras;
    }

    public void setAuras(Set<BeeAura> auras) {
        this.auras = auras;
    }

    @Override
    public String toString() {
        return "TraitData{" +
                "traits=" + traits +
                ", potionEffects=" + potionEffects +
                ", damageImmunities=" + damageImmunities +
                ", potionImmunities=" + potionImmunities +
                ", damageTypes=" + damageTypes +
                ", specialAbilities=" + specialAbilities +
                ", particles=" + particles +
                ", auras=" + auras +
                '}';
    }

    /*
    CodecUtils.createSetCodec(DamageType.CODEC).fieldOf("damageTypes").orElse(new HashSet<>()).forGetter(BeeTrait::getDamageTypes),
                CodecUtils.createSetCodec(Codec.STRING).fieldOf("specialAbilities").orElse(new HashSet<>()).forGetter(BeeTrait::getSpecialAbilities),
                CodecUtils.createSetCodec(Registry.PARTICLE_TYPE.byNameCodec()).fieldOf("particles").orElse(new HashSet<>()).forGetter(BeeTrait::getParticleEffects),
                CodecUtils.createSetCodec(BeeAura.CODEC).fieldOf("auras").orElse(new HashSet<>()).forGetter(BeeTrait::getAuras)
     */
}