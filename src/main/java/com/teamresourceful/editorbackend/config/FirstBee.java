package com.teamresourceful.editorbackend.config;

import com.teamresourceful.editorbackend.model.ItemStack;
import com.teamresourceful.editorbackend.model.beedata.CoreData;
import com.teamresourceful.editorbackend.model.beedata.BeeData;
import com.teamresourceful.editorbackend.model.beedata.breeding.BeeFamily;
import com.teamresourceful.editorbackend.model.beedata.breeding.BreedData;
import com.teamresourceful.editorbackend.model.beedata.combat.CombatData;
import com.teamresourceful.editorbackend.model.beedata.mutation.MutationData;
import com.teamresourceful.editorbackend.model.beedata.render.ColorData;
import com.teamresourceful.editorbackend.model.beedata.render.LayerData;
import com.teamresourceful.editorbackend.model.beedata.render.RenderData;
import com.teamresourceful.editorbackend.model.beedata.spawning.SpawnData;
import com.teamresourceful.editorbackend.model.beedata.trait.TraitData;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class FirstBee {

    //TODO remove these after app is finished

    public static BeeData generate() {
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
                Collections.singleton("minecraft:poppy"),
                new ItemStack("minecraft:bucket", 1, null),
                2,
                2000,
                200
        );

        CombatData combatData = new CombatData(false, new BigDecimal(2), true, true, new BigDecimal(20), new BigDecimal(2), new BigDecimal(4), null, false);

        MutationData mutationData = new MutationData(10);

        SpawnData spawnData = new SpawnData(false, null, null, null, null, null, null, null, null);

        TraitData traitData = new TraitData(Collections.singleton("oreo"), null, null, null, null, null, null, null);
        //breed
        //combat
        //mutation
        //spawn
        //trait

        BeeData firstBee = new BeeData(
                "1.0.0",
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
