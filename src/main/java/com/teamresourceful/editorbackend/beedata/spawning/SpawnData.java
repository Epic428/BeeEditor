package com.teamresourceful.editorbackend.beedata.spawning;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.teamresourceful.editorbackend.beedata.CustomBeeData;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Embeddable
@Entity
@Table(name = "spawn_data")
public class SpawnData {

    @Id
    @Column(name = "bee_id")
    @JsonIgnore
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "bee_id")
    @JsonIgnore
    private CustomBeeData beeData;

    private Boolean canSpawnInWorld;
    private Integer spawnWeight;
    private Integer minGroupSize;
    private Integer maxGroupSize;

    @ElementCollection
    @CollectionTable(name = "biome_whitelist", joinColumns = @JoinColumn(name = "bee_id"))
    @Column(name = "biome", nullable = false)
    @JsonProperty("biomeWhitelist")
    private Set<String> biomeWhitelist = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "biome_blacklist", joinColumns = @JoinColumn(name = "bee_id"))
    @Column(name = "biome", nullable = false)
    @JsonProperty("biomeBlacklist")
    private Set<String> biomeBlacklist = new HashSet<>();

    private String lightLevel; //switch to an enum value instead
    private Integer minYLevel;
    private Integer maxYLevel;

    public SpawnData() {
    }

    public SpawnData(Boolean canSpawnInWorld, Integer spawnWeight, Integer minGroupSize, Integer maxGroupSize, Set<String> biomeWhitelist, Set<String> biomeBlacklist, String lightLevel, Integer minYLevel, Integer maxYLevel) {
        this.canSpawnInWorld = canSpawnInWorld;
        this.spawnWeight = spawnWeight;
        this.minGroupSize = minGroupSize;
        this.maxGroupSize = maxGroupSize;
        this.biomeWhitelist = biomeWhitelist;
        this.biomeBlacklist = biomeBlacklist;
        this.lightLevel = lightLevel;
        this.minYLevel = minYLevel;
        this.maxYLevel = maxYLevel;
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

    public Boolean getCanSpawnInWorld() {
        return canSpawnInWorld;
    }

    public void setCanSpawnInWorld(Boolean canSpawnInWorld) {
        this.canSpawnInWorld = canSpawnInWorld;
    }

    public Integer getSpawnWeight() {
        return spawnWeight;
    }

    public void setSpawnWeight(Integer spawnWeight) {
        this.spawnWeight = spawnWeight;
    }

    public Integer getMinGroupSize() {
        return minGroupSize;
    }

    public void setMinGroupSize(Integer minGroupSize) {
        this.minGroupSize = minGroupSize;
    }

    public Integer getMaxGroupSize() {
        return maxGroupSize;
    }

    public void setMaxGroupSize(Integer maxGroupSize) {
        this.maxGroupSize = maxGroupSize;
    }

    public Set<String> getBiomeWhitelist() {
        return biomeWhitelist;
    }

    public void setBiomeWhitelist(Set<String> biomeWhitelist) {
        this.biomeWhitelist = biomeWhitelist;
    }

    public Set<String> getBiomeBlacklist() {
        return biomeBlacklist;
    }

    public void setBiomeBlacklist(Set<String> biomeBlacklist) {
        this.biomeBlacklist = biomeBlacklist;
    }

    public String getLightLevel() {
        return lightLevel;
    }

    public void setLightLevel(String lightLevel) {
        this.lightLevel = lightLevel;
    }

    public Integer getMinYLevel() {
        return minYLevel;
    }

    public void setMinYLevel(Integer minYLevel) {
        this.minYLevel = minYLevel;
    }

    public Integer getMaxYLevel() {
        return maxYLevel;
    }

    public void setMaxYLevel(Integer maxYLevel) {
        this.maxYLevel = maxYLevel;
    }

    @Override
    public String toString() {
        return "SpawnData{" +
                "canSpawnInWorld=" + canSpawnInWorld +
                ", spawnWeight=" + spawnWeight +
                ", minGroupSize=" + minGroupSize +
                ", maxGroupSize=" + maxGroupSize +
                ", biomeWhitelist='" + biomeWhitelist + '\'' +
                ", biomeBlacklist='" + biomeBlacklist + '\'' +
                ", lightLevel='" + lightLevel + '\'' +
                ", minYLevel=" + minYLevel +
                ", maxYLevel=" + maxYLevel +
                '}';
    }
}