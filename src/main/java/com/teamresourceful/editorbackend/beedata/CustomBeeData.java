package com.teamresourceful.editorbackend.beedata;

import com.teamresourceful.editorbackend.beedata.breeding.BreedData;
import com.teamresourceful.editorbackend.beedata.combat.CombatData;
import com.teamresourceful.editorbackend.beedata.mutation.MutationData;
import com.teamresourceful.editorbackend.beedata.render.RenderData;
import com.teamresourceful.editorbackend.beedata.spawning.SpawnData;
import com.teamresourceful.editorbackend.beedata.trait.TraitData;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name = "Bee_Data")
@Table(name = "bee_data")
public class CustomBeeData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bee_id", updatable = false)
    //@JsonIgnore TODO Should we have the bee ID's in the generated json output??
    private Long id;

    //@Embedded
    @OneToOne(mappedBy = "beeData", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private CoreData coreData;

    private String honeycombVariation;

    //@Embedded
    @OneToOne(mappedBy = "beeData", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private RenderData renderData;

    //@Embedded
    @OneToOne(mappedBy = "beeData", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private BreedData breedData;

    //@Embedded
    @OneToOne(mappedBy = "beeData", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private CombatData combatData;

    //@Embedded
    @OneToOne(mappedBy = "beeData", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private MutationData mutationData;

    //@Embedded
    @OneToOne(mappedBy = "beeData", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private SpawnData spawnData;

    //@Embedded
    @OneToOne(mappedBy = "beeData", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private TraitData traitData;

    public CustomBeeData(CoreData coreData, String honeycombVariation, RenderData renderData, BreedData breedData, CombatData combatData, MutationData mutationData, SpawnData spawnData, TraitData traitData) {
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