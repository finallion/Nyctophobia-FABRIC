package com.finallion.graveyard_biomes.init;


import com.finallion.graveyard_biomes.TheGraveyardBiomes;
import com.finallion.graveyard_biomes.world.biomes.AncientBattlegrounds;
import com.finallion.graveyard_biomes.world.biomes.AncientDeadCoralReef;
import com.finallion.graveyard_biomes.world.biomes.DeepDarkForest;
import com.finallion.graveyard_biomes.world.biomes.HauntedForestBiomes;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.PlacedFeature;

public class TGBiomes {
    public static final RegistryKey<Biome> ERODED_HAUNTED_FOREST_KEY = registerBiomeKeys("eroded_haunted_forest");
    public static final RegistryKey<Biome> HAUNTED_LAKES_KEY = registerBiomeKeys("haunted_lakes");
    public static final RegistryKey<Biome> HAUNTED_FOREST_KEY = registerBiomeKeys("haunted_forest");
    public static final RegistryKey<Biome> ANCIENT_DEAD_CORAL_REEF_KEY = registerBiomeKeys("ancient_dead_coral_reef");
    public static final RegistryKey<Biome> DEATH_MARCHES = registerBiomeKeys("death_marches");
    public static final RegistryKey<Biome> DEEP_DARK_FOREST = registerBiomeKeys("deep_dark_forest");
    public static final RegistryKey<Biome> ANCIENT_BATTLEGROUNDS = registerBiomeKeys("ancient_battlegrounds");

    private static RegistryKey<Biome> registerBiomeKeys(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, new Identifier(TheGraveyardBiomes.MOD_ID, name));
    }

    public static void init() {}


    public static void populate(FabricDynamicRegistryProvider.Entries entries) {
        entries.add(HAUNTED_FOREST_KEY, HauntedForestBiomes.createHauntedForest(entries));
        entries.add(ERODED_HAUNTED_FOREST_KEY, HauntedForestBiomes.createErodedHauntedForest(entries));
        entries.add(HAUNTED_LAKES_KEY, HauntedForestBiomes.createHauntedLakes(entries));
        entries.add(ANCIENT_DEAD_CORAL_REEF_KEY, AncientDeadCoralReef.createAncientDeadCoralReef(entries));
        entries.add(DEEP_DARK_FOREST, DeepDarkForest.createDeepDarkForest(entries));

    }
}
