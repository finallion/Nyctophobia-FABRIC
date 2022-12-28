package com.finallion.graveyard_biomes.world.biomes;

import com.finallion.graveyard_biomes.TheGraveyardBiomes;
import com.finallion.graveyard_biomes.init.TGBiomes;
import com.finallion.graveyard_biomes.world.surfacerules.TGSurfaceRules;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.event.registry.DynamicRegistrySetupCallback;
import net.fabricmc.fabric.api.event.registry.DynamicRegistryView;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;



public class TGBiomeProvider extends Region {

    public TGBiomeProvider(Identifier name, int overworldWeight) {
        super(name, RegionType.OVERWORLD, overworldWeight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {

            if (TheGraveyardBiomes.config.getBiome(new Identifier(TheGraveyardBiomes.MOD_ID,"haunted_forest")).canGenerate) {
                List<String> configBiomes = TheGraveyardBiomes.config.biomeConfigEntries.get("haunted_forest").replaceableBiomes;
                for (String configBiome : configBiomes) {
                    builder.replaceBiome(parseBiomeKeys(configBiome, registry.getEntrySet()), TGBiomes.HAUNTED_FOREST_KEY);
                }
            }

            if (TheGraveyardBiomes.config.getBiome(new Identifier(TheGraveyardBiomes.MOD_ID, "eroded_haunted_forest")).canGenerate) {
                List<String> configBiomes = TheGraveyardBiomes.config.biomeConfigEntries.get("eroded_haunted_forest").replaceableBiomes;
                for (String configBiome : configBiomes) {
                    builder.replaceBiome(parseBiomeKeys(configBiome, registry.getEntrySet()), TGBiomes.ERODED_HAUNTED_FOREST_KEY);
                }
            }

            if (TheGraveyardBiomes.config.getBiome(new Identifier(TheGraveyardBiomes.MOD_ID,"haunted_lakes")).canGenerate) {
                List<String> configBiomes = TheGraveyardBiomes.config.biomeConfigEntries.get("haunted_lakes").replaceableBiomes;
                for (String configBiome : configBiomes) {
                    builder.replaceBiome(parseBiomeKeys(configBiome, registry.getEntrySet()), TGBiomes.HAUNTED_LAKES_KEY);
                }
            }

            if (TheGraveyardBiomes.config.getBiome(new Identifier(TheGraveyardBiomes.MOD_ID,"ancient_dead_coral_reef")).canGenerate) {
                List<String> configBiomes = TheGraveyardBiomes.config.biomeConfigEntries.get("ancient_dead_coral_reef").replaceableBiomes;
                for (String configBiome : configBiomes) {
                    builder.replaceBiome(parseBiomeKeys(configBiome, registry.getEntrySet()), TGBiomes.ANCIENT_DEAD_CORAL_REEF_KEY);
                }
            }

            if (TheGraveyardBiomes.config.getBiome(new Identifier(TheGraveyardBiomes.MOD_ID,"deep_dark_forest")).canGenerate) {
                List<String> configBiomes = TheGraveyardBiomes.config.biomeConfigEntries.get("deep_dark_forest").replaceableBiomes;
                for (String configBiome : configBiomes) {
                    builder.replaceBiome(parseBiomeKeys(configBiome, registry.getEntrySet()), TGBiomes.DEEP_DARK_FOREST);
                }
            }

        });
    }

    private RegistryKey<Biome> parseBiomeKeys(String configBiome, Set<Map.Entry<RegistryKey<Biome>, Biome>> entrySet) {
        List<RegistryKey<Biome>> biomeKeys = entrySet.stream().map(Map.Entry::getKey).collect(Collectors.toList());
        for (RegistryKey<Biome> key : biomeKeys) {
            String biomeName = key.getValue().getPath();

            if (biomeName.equals(configBiome)) {
                return key;
            }
        }

        TheGraveyardBiomes.LOGGER.error("Wrong biome key \"" + configBiome + "\" in config!");
        return null;
    }
}


