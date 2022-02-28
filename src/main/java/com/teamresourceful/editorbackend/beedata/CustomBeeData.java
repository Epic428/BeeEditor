package com.teamresourceful.editorbackend.beedata;

import com.teamresourceful.editorbackend.beedata.breeding.BreedData;
import com.teamresourceful.editorbackend.beedata.combat.CombatData;
import com.teamresourceful.editorbackend.beedata.mutation.MutationData;
import com.teamresourceful.editorbackend.beedata.render.RenderData;
import com.teamresourceful.editorbackend.beedata.spawning.SpawnData;
import com.teamresourceful.editorbackend.beedata.trait.TraitData;

import javax.persistence.*;

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

    public CustomBeeData() {
    }

    public CustomBeeData(Long id, CoreData coreData, String honeycombVariation, RenderData renderData, BreedData breedData, CombatData combatData, MutationData mutationData, SpawnData spawnData, TraitData traitData) {
        this.id = id;
        this.coreData = coreData;
        this.honeycombVariation = honeycombVariation;
        this.renderData = renderData;
        this.breedData = breedData;
        this.combatData = combatData;
        this.mutationData = mutationData;
        this.spawnData = spawnData;
        this.traitData = traitData;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CoreData getCoreData() {
        return coreData;
    }

    public void setCoreData(CoreData coreData) {
        this.coreData = coreData;
    }

    public String getHoneycombVariation() {
        return honeycombVariation;
    }

    public void setHoneycombVariation(String honeycombVariation) {
        this.honeycombVariation = honeycombVariation;
    }

    public RenderData getRenderData() {
        return renderData;
    }

    public void setRenderData(RenderData renderData) {
        this.renderData = renderData;
    }

    public BreedData getBreedData() {
        return breedData;
    }

    public void setBreedData(BreedData breedData) {
        this.breedData = breedData;
    }

    public CombatData getCombatData() {
        return combatData;
    }

    public void setCombatData(CombatData combatData) {
        this.combatData = combatData;
    }

    public MutationData getMutationData() {
        return mutationData;
    }

    public void setMutationData(MutationData mutationData) {
        this.mutationData = mutationData;
    }

    public SpawnData getSpawnData() {
        return spawnData;
    }

    public void setSpawnData(SpawnData spawnData) {
        this.spawnData = spawnData;
    }

    public TraitData getTraitData() {
        return traitData;
    }

    public void setTraitData(TraitData traitData) {
        this.traitData = traitData;
    }


    @Override
    public String toString() {
        return "CustomBeeData{" +
                "id=" + id +
                ", coreData=" + coreData +
                ", honeycombVariation=" + honeycombVariation +
                ", renderData=" + renderData +
                ", breedData=" + breedData +
                ", combatData=" + combatData +
                ", mutationData=" + mutationData +
                ", spawnData=" + spawnData +
                ", traitData=" + traitData +
                '}';
    }





    /*
        @Column(name = "id", updatable = false) //sets name for column. updatable says the value cannot be changed
    private Long id;
    @Column(name = "first_name", nullable = false, columnDefinition = "TEXT") //nullable says the value cannot be null
    private String firstName;
    @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")// TEXT says column contains text
    private String lasName;
    @Column(name = "email", nullable = false, columnDefinition = "TEXT")
    private String email;
    @Column(name = "age", nullable = false)
    private Integer age;
     */
}