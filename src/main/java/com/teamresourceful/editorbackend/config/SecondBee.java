package com.teamresourceful.editorbackend.config;

import com.teamresourceful.editorbackend.lib.enums.LightLevel;
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

public class SecondBee {

    //TODO remove these after app is finished

    public static BeeData generate() {
        CoreData coreData = new CoreData("second_bee",
                new HashSet<>(Arrays.asList("stone", "minecraft:diamond_block", "minecraft:cobblestone")),
                null,
                2200,
                null,
                Arrays.asList("this bee makes diamonds", "seriously", "it does", "it does"));

        RenderData renderData = new RenderData(new HashSet<>(Arrays.asList(
                new LayerData("#222222", "dragon/dragon_bee_primary", null, null, null, null),
                new LayerData("#171717", "dragon/dragon_bee_secondary", null, null, null, null))),
                new ColorData("#171717", "#E400FF", "#222222"),
                "resourcefulbees:geo/dragon.geo.json",
                "dragon/dragon_bee",
                null,
                new BigDecimal("0.6"));

        BreedData breedData = new BreedData(
                Collections.singleton(new BeeFamily(new BigDecimal(3), BigDecimal.valueOf(3), "coal", "stone")),
                Collections.singleton("minecraft:poppy"),
                new ItemStack("minecraft:bucket", 1, null),
                2,
                2000,
                200
        );

        CombatData combatData = new CombatData(true, null, null, null, new BigDecimal(60), new BigDecimal(8), new BigDecimal(12), null, false);

        MutationData mutationData = new MutationData(null);

        SpawnData spawnData = new SpawnData(true, 16, 1, 3,
                new HashSet<>(Arrays.asList("plains", "hills", "desert")), null, LightLevel.ANY, null, null);

        TraitData traitData = new TraitData(Collections.singleton("ender"), null, null, null, null, null, null, null);
        //breed
        //combat
        //mutation
        //spawn
        //trait

        BeeData secondBee = new BeeData(
                "1.0.0",
                coreData,
                "diamond",
                renderData,
                breedData,
                combatData,
                mutationData,
                spawnData,
                traitData);

        coreData.setBeeData(secondBee);
        renderData.setBeeData(secondBee);
        breedData.setBeeData(secondBee);
        combatData.setBeeData(secondBee);
        mutationData.setBeeData(secondBee);
        spawnData.setBeeData(secondBee);
        traitData.setBeeData(secondBee);

        return secondBee;
    }
}
