package com.teamresourceful.editorbackend.dto.beedata.spawning;

import com.teamresourceful.editorbackend.lib.enums.LightLevel;
import com.teamresourceful.editorbackend.utils.EditorUtils;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Set;

@Data
public class SpawnDataDto implements Serializable {
    private Boolean canSpawnInWorld;
    @Range(min = 0, max = 1000, message = "Spawn weight must be be between 0 and 1000, inclusively!")
    private Integer spawnWeight;
    @Range(min = 0, max = 8, message = "Min group size must be between 0 and 8, inclusively!")
    private Integer minGroupSize;
    @Range(min = 0, max = 8, message = "Max group size must be between 0 and 8, inclusively!")
    private Integer maxGroupSize;
    private Set<@Pattern(message = EditorUtils.RL_ERROR_MSG, regexp = EditorUtils.RESOURCE_LOCATION) String> biomeWhitelist;
    private Set<@Pattern(message = EditorUtils.RL_ERROR_MSG, regexp = EditorUtils.RESOURCE_LOCATION) String> biomeBlacklist;
    @Valid
    private LightLevel lightLevel;
    private Integer minYLevel;
    private Integer maxYLevel;
}
