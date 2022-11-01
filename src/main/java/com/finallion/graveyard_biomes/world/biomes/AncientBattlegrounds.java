package com.finallion.graveyard_biomes.world.biomes;

import com.finallion.graveyard_biomes.init.TGConfiguredFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.OceanPlacedFeatures;


public class AncientBattlegrounds {

    public static Biome createAncientBattlegrounds() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        //DefaultBiomeFeatures.addOceanMobs(spawnSettings, 3, 4, 15);
        //spawnSettings.spawn(SpawnGroup.WATER_AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SALMON, 15, 1, 5));
        //spawnSettings.spawn(SpawnGroup.WATER_AMBIENT, new SpawnSettings.SpawnEntry(EntityType.PUFFERFISH, 15, 1, 3));
        DefaultBiomeFeatures.addBatsAndMonsters(spawnSettings);

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addAmethystGeodes(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addSprings(generationSettings);
        DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);


        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.RAIN)
                .temperature(0.5F)
                .downfall(0.5F)
                .effects((new BiomeEffects.Builder())
                        .waterColor(0xFFFFFF)
                        .waterFogColor(0xFFFFFF)
                        .fogColor(12638463) // default
                        .skyColor(12638463) // default
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();

    }
}
