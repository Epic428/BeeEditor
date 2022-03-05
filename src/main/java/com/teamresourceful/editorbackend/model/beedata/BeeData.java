package com.teamresourceful.editorbackend.model.beedata;

import com.teamresourceful.editorbackend.model.beedata.breeding.BreedData;
import com.teamresourceful.editorbackend.model.beedata.combat.CombatData;
import com.teamresourceful.editorbackend.model.beedata.mutation.MutationData;
import com.teamresourceful.editorbackend.model.beedata.render.RenderData;
import com.teamresourceful.editorbackend.model.beedata.spawning.SpawnData;
import com.teamresourceful.editorbackend.model.beedata.trait.TraitData;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name = "Bee_Data")
@Table(name = "bee_data")
public class BeeData {
    @Id
    @GeneratedValue
    //@SequenceGenerator()
    @Column(name = "bee_id", updatable = false)
    //@JsonIgnore TODO Should we have the bee ID's in the generated json output??
    private UUID id;

    @Column(name = "json_version", nullable = false)
    private String jsonVersion; //Maybe convert to ENUM instead??

    @OneToOne(mappedBy = "beeData", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private CoreData coreData;

    private String honeycombVariation;

    @OneToOne(mappedBy = "beeData", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private RenderData renderData;

    @OneToOne(mappedBy = "beeData", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private BreedData breedData;

    @OneToOne(mappedBy = "beeData", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private CombatData combatData;

    @OneToOne(mappedBy = "beeData", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private MutationData mutationData;

    @OneToOne(mappedBy = "beeData", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private SpawnData spawnData;

    @OneToOne(mappedBy = "beeData", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private TraitData traitData;

    public BeeData(String jsonVersion, CoreData coreData, String honeycombVariation, RenderData renderData, BreedData breedData, CombatData combatData, MutationData mutationData, SpawnData spawnData, TraitData traitData) {
        this.jsonVersion = jsonVersion;
        this.coreData = coreData;
        this.honeycombVariation = honeycombVariation;
        this.renderData = renderData;
        this.breedData = breedData;
        this.combatData = combatData;
        this.mutationData = mutationData;
        this.spawnData = spawnData;
        this.traitData = traitData;
    }
}