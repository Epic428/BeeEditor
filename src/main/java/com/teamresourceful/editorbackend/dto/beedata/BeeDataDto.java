package com.teamresourceful.editorbackend.dto.beedata;

import com.teamresourceful.editorbackend.dto.beedata.breeding.BreedDataDto;
import com.teamresourceful.editorbackend.dto.beedata.combat.CombatDataDto;
import com.teamresourceful.editorbackend.dto.beedata.mutation.MutationDataDto;
import com.teamresourceful.editorbackend.dto.beedata.render.RenderDataDto;
import com.teamresourceful.editorbackend.dto.beedata.spawning.SpawnDataDto;
import com.teamresourceful.editorbackend.dto.beedata.trait.TraitDataDto;
import lombok.Data;

import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Data
public class BeeDataDto implements Serializable {
    @Id
    private UUID id;
    @NotNull
    private String jsonVersion;
    @Valid
    @NotNull
    private CoreDataDto coreData;
    private String honeycombVariation;
    @Valid
    @NotNull
    private RenderDataDto renderData;
    @Valid
    private BreedDataDto breedData;
    @Valid
    private CombatDataDto combatData;
    @Valid
    private MutationDataDto mutationData;
    @Valid
    private SpawnDataDto spawnData;
    @Valid
    private TraitDataDto traitData;
}
