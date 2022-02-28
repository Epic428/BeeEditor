package com.teamresourceful.editorbackend.config;

import com.teamresourceful.editorbackend.beedata.CoreData;
import com.teamresourceful.editorbackend.beedata.CustomBeeData;
import com.teamresourceful.editorbackend.beedata.breeding.BeeFamily;
import com.teamresourceful.editorbackend.beedata.breeding.BreedData;
import com.teamresourceful.editorbackend.beedata.combat.CombatData;
import com.teamresourceful.editorbackend.beedata.mutation.MutationData;
import com.teamresourceful.editorbackend.beedata.render.ColorData;
import com.teamresourceful.editorbackend.beedata.render.LayerData;
import com.teamresourceful.editorbackend.beedata.render.RenderData;
import com.teamresourceful.editorbackend.beedata.spawning.SpawnData;
import com.teamresourceful.editorbackend.beedata.trait.TraitData;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class FirstBee {

    public static CustomBeeData generate() {
        CoreData coreData = new CoreData("diamond",
                new HashSet<>(Arrays.asList("minecraft:stone", "minecraft:diamond_block", "minecraft:cobblestone")),
                null,
                2400,
                10,
                Arrays.asList("this bee makes diamonds", "seriously", "it does", "it does"));

        RenderData renderData = new RenderData(new HashSet<>(Arrays.asList(
                new LayerData("#222222", "dragon/dragon_bee_primary", null, null, null, null),
                new LayerData("#171717", "dragon/dragon_bee_secondary", null, null, null, null),
                new LayerData("#E400FF", "dragon/dragon_bee_emissive", true, null, null, null))),
                new ColorData("#171717", "#E400FF", "#222222"),
                "resourcefulbees:geo/dragon.geo.json",
                "dragon/dragon_bee",
                null,
                new BigDecimal("1.5"));

        BreedData breedData = new BreedData(
                new HashSet<>(Arrays.asList(
                        new BeeFamily(new BigDecimal(3), BigDecimal.valueOf(3), "coal", "stone"),
                        new BeeFamily(new BigDecimal(10), BigDecimal.valueOf(.6), "emerald", "diamond")
                )),
                "minecraft:poppy",
                "minecraft:bucket",
                2,
                2000,
                200
        );

        CombatData combatData = new CombatData(false, 2d, true, true, 20d, 2d, 4d, null, false);

        MutationData mutationData = new MutationData(10);

        SpawnData spawnData = new SpawnData(false, null, null, null, null, null, null, null, null);

        TraitData traitData = new TraitData(Collections.singleton("oreo"), null, null, null, null, null, null, null);
        //breed
        //combat
        //mutation
        //spawn
        //trait

        CustomBeeData firstBee = new CustomBeeData(1L,
                coreData,
                "diamond",
                renderData,
                breedData,
                combatData,
                mutationData,
                spawnData,
                traitData);

        coreData.setBeeData(firstBee);
        renderData.setBeeData(firstBee);
        breedData.setBeeData(firstBee);
        combatData.setBeeData(firstBee);
        mutationData.setBeeData(firstBee);
        spawnData.setBeeData(firstBee);
        traitData.setBeeData(firstBee);

        return firstBee;
    }
}
