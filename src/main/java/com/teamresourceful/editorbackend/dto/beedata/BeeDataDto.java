package com.teamresourceful.editorbackend.dto.beedata;

import com.teamresourceful.editorbackend.dto.beedata.breeding.BreedDataDto;
import com.teamresourceful.editorbackend.dto.beedata.combat.CombatDataDto;
import com.teamresourceful.editorbackend.dto.beedata.mutation.MutationDataDto;
import com.teamresourceful.editorbackend.dto.beedata.render.RenderDataDto;
import com.teamresourceful.editorbackend.dto.beedata.spawning.SpawnDataDto;
import com.teamresourceful.editorbackend.dto.beedata.trait.TraitDataDto;
import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Data
public class BeeDataDto implements Serializable {
    @Id
    private UUID id;
    @NotNull
    private String jsonVersion;
    @NotNull
    private CoreDataDto coreData;
    private String honeycombVariation;
    @NotNull
    private RenderDataDto renderData;
    private BreedDataDto breedData;
    private CombatDataDto combatData;
    private MutationDataDto mutationData;
    private SpawnDataDto spawnData;
    private TraitDataDto traitData;
}
