package com.teamresourceful.editorbackend.beedata.spawning;

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

    @Builder
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
}