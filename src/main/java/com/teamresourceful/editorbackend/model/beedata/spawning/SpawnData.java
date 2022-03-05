package com.teamresourceful.editorbackend.model.beedata.spawning;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamresourceful.editorbackend.lib.enums.LightLevel;
import com.teamresourceful.editorbackend.model.beedata.BeeData;
import com.teamresourceful.editorbackend.utils.EditorUtils;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "spawn_data")
//@TypeDef(name = "pgsql_enum", typeClass = PsqlEnumType.class)
public class SpawnData {

    @Id
    @Column(name = "bee_id")
    @JsonIgnore
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "bee_id")
    @JsonIgnore
    private BeeData beeData;

    private Boolean canSpawnInWorld;
    @Range(min = 0, max = 1000, message = "Spawn weight must be be between 0 and 1000, inclusively!")
    private Integer spawnWeight;
    @Range(min = 0, max = 8, message = "Min group size must be between 0 and 8, inclusively!")
    private Integer minGroupSize;
    @Range(min = 0, max = 8, message = "Max group size must be between 0 and 8, inclusively!")
    private Integer maxGroupSize;

    @ElementCollection
    @CollectionTable(name = "biome_whitelist", joinColumns = @JoinColumn(name = "bee_id"))
    @Column(name = "biome", nullable = false)
    private Set<@Pattern(message = EditorUtils.RL_ERROR_MSG, regexp = EditorUtils.RESOURCE_LOCATION)String> biomeWhitelist = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "biome_blacklist", joinColumns = @JoinColumn(name = "bee_id"))
    @Column(name = "biome", nullable = false)
    private Set<@Pattern(message = EditorUtils.RL_ERROR_MSG, regexp = EditorUtils.RESOURCE_LOCATION)String> biomeBlacklist = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Type( type = "psql_enum" )
    @Column(columnDefinition = "light_level")
    private LightLevel lightLevel; //switch to an enum value instead
    //TODO min and max y levels should have checks to ensure one value does not exceed the other and vice-versa
    private Integer minYLevel;
    private Integer maxYLevel;

    @Builder
    public SpawnData(Boolean canSpawnInWorld, Integer spawnWeight, Integer minGroupSize, Integer maxGroupSize, Set<String> biomeWhitelist, Set<String> biomeBlacklist, LightLevel lightLevel, Integer minYLevel, Integer maxYLevel) {
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