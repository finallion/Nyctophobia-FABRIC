package com.finallion.graveyard_biomes.world.biomes;

import com.finallion.graveyard_biomes.init.TGConfiguredFeatures;
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


public class DeepDarkForest {

    public static Biome createDeepDarkForest() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FOX, 8, 2, 3));
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 8, 3, 5));
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.SHEEP, 10, 3, 5));
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.PIG, 10, 3, 5));
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.CAT, 1, 1, 1));
        DefaultBiomeFeatures.addBatsAndMonsters(spawnSettings);

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();

        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, TGConfiguredFeatures.DEEP_DARK_FOREST_PLACED_VEGETATION);

        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.RAIN)
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
}
