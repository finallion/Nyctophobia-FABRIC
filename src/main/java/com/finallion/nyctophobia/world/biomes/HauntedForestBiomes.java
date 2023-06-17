package com.finallion.nyctophobia.world.biomes;

import com.finallion.nyctophobia.init.NPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.OceanPlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class HauntedForestBiomes {

    public static Biome createHauntedForest(FabricDynamicRegistryProvider.Entries entries) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FOX, 8, 2, 3));
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 8, 3, 5));
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.SHEEP, 10, 3, 5));
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.PIG, 10, 3, 5));
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.CAT, 1, 1, 1));
        DefaultBiomeFeatures.addBatsAndMonsters(spawnSettings);

        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(entries.placedFeatures(), entries.configuredCarvers());

        addBasicFeatures(generationSettings);
        addTaigaFeatures(generationSettings);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, entries.ref(NPlacedFeatures.HAUNTED_FOREST_TREES_PLACED));
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, entries.ref(NPlacedFeatures.MOSS_CARPET_FEATURE));
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, entries.ref(NPlacedFeatures.COBWEB_FEATURE));
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, entries.ref(NPlacedFeatures.BUSH_FEATURE));

        return (new Biome.Builder())
                .precipitation(true)
                .temperature(0.6F)
                .downfall(0.9F)
                .effects((new BiomeEffects.Builder())
                        .grassColor(0x6F932A)
                        .foliageColor(0x6F932A)
                        .waterColor(0xAEC1BE)
                        .waterFogColor(0xC9DDDA)
                        .fogColor(0x878787)
                        .skyColor(0x878787)
                        .music(MusicType.GAME)
                        .loopSound(SoundEvents.AMBIENT_WARPED_FOREST_LOOP)
                        .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D))
                        .additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D))
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }


    public static Biome createHauntedLakes(FabricDynamicRegistryProvider.Entries entries) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FOX, 8, 2, 3));
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 8, 3, 5));
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.SHEEP, 10, 3, 5));
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.PIG, 10, 3, 5));
        DefaultBiomeFeatures.addBatsAndMonsters(spawnSettings);

        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(entries.placedFeatures(), entries.configuredCarvers());
        addBasicFeatures(generationSettings);
        addHauntedLakesFeatures(generationSettings);

        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, entries.ref(NPlacedFeatures.HAUNTED_FOREST_TREES_PLACED));
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, entries.ref(NPlacedFeatures.MOSS_CARPET_FEATURE));
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, entries.ref(NPlacedFeatures.COBWEB_FEATURE));
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, entries.ref(NPlacedFeatures.BUSH_FEATURE));
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, entries.ref(NPlacedFeatures.SOUL_LIGHT_FEATURE));

        return (new Biome.Builder())
                .precipitation(true)
                .temperature(0.6F)
                .downfall(0.9F)
                .effects((new BiomeEffects.Builder())
                        .grassColor(0x7EA530)
                        .foliageColor(0x7EA530)
                        .waterColor(0x9B091C)
                        .waterFogColor(0xD80D28)
                        .fogColor(0xB2B2B2)
                        .skyColor(0xB2B2B2)
                        .music(MusicType.GAME)
                        .loopSound(SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP)
                        .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D))
                        .additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D))
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();

    }


    public static Biome createErodedHauntedForest(FabricDynamicRegistryProvider.Entries entries) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.WITHER_SKELETON, 8, 2, 3));
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SKELETON, 8, 1, 2));
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.BAT, 10, 1, 1));
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.CAT, 1, 1, 1));

        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(entries.placedFeatures(), entries.configuredCarvers());

        addBasicFeatures(generationSettings);
        addTaigaFeatures(generationSettings);


        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, entries.ref(NPlacedFeatures.ERODED_HAUNTED_FOREST_TREES_PLACED));
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, entries.ref(NPlacedFeatures.FALLEN_TREE_FEATURE));
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, entries.ref(NPlacedFeatures.COBWEB_FEATURE));
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, entries.ref(NPlacedFeatures.BUSH_FEATURE));
         

        return (new Biome.Builder())
                .precipitation(true)
                .temperature(0.4F)
                .downfall(0.4F)
                .effects((new BiomeEffects.Builder())
                        .grassColor(0x77AB2F)
                        .foliageColor(0x77AB2F)
                        .waterColor(0xAEC1BE)
                        .waterFogColor(0xC9DDDA)
                        .fogColor(0x6B6B6B)
                        .skyColor(0x6B6B6B)
                        .music(MusicType.GAME)
                        .loopSound(SoundEvents.AMBIENT_BASALT_DELTAS_LOOP)
                        .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D))
                        .additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D))
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();

    }

    private static void addBasicFeatures(GenerationSettings.LookupBackedBuilder generationSettings) {
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addAmethystGeodes(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addSprings(generationSettings);
        DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);
    }

    private static void addTaigaFeatures(GenerationSettings.LookupBackedBuilder generationSettings) {
        DefaultBiomeFeatures.addMossyRocks(generationSettings);
        DefaultBiomeFeatures.addLargeFerns(generationSettings);
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        DefaultBiomeFeatures.addDefaultDisks(generationSettings);
        DefaultBiomeFeatures.addGiantTaigaGrass(generationSettings);
        DefaultBiomeFeatures.addDefaultMushrooms(generationSettings);
        DefaultBiomeFeatures.addDefaultVegetation(generationSettings);

    }


    private static void addHauntedLakesFeatures(GenerationSettings.LookupBackedBuilder generationSettings) {
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        DefaultBiomeFeatures.addClayDisk(generationSettings);
        DefaultBiomeFeatures.addMossyRocks(generationSettings);
        DefaultBiomeFeatures.addLargeFerns(generationSettings);
        DefaultBiomeFeatures.addGiantTaigaGrass(generationSettings);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_WATERLILY);
        DefaultBiomeFeatures.addDefaultMushrooms(generationSettings);
        DefaultBiomeFeatures.addSwampVegetation(generationSettings);
        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, OceanPlacedFeatures.SEAGRASS_SWAMP);
    }



}
