package com.finallion.nyctophobia.world.biomes;

import com.finallion.nyctophobia.Nyctophobia;
import com.finallion.nyctophobia.init.NBiomes;
import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;



public class NBiomeProvider extends Region {

    public NBiomeProvider(Identifier name, int overworldWeight) {
        super(name, RegionType.OVERWORLD, overworldWeight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {

            if (Nyctophobia.config.getBiome(new Identifier(Nyctophobia.MOD_ID,"haunted_forest")).canGenerate) {
                List<String> configBiomes = Nyctophobia.config.biomeConfigEntries.get("haunted_forest").replaceableBiomes;
                for (String configBiome : configBiomes) {
                    builder.replaceBiome(parseBiomeKeys(configBiome, registry.getEntrySet()), NBiomes.HAUNTED_FOREST_KEY);
                }
            }

            if (Nyctophobia.config.getBiome(new Identifier(Nyctophobia.MOD_ID, "eroded_haunted_forest")).canGenerate) {
                List<String> configBiomes = Nyctophobia.config.biomeConfigEntries.get("eroded_haunted_forest").replaceableBiomes;
                for (String configBiome : configBiomes) {
                    builder.replaceBiome(parseBiomeKeys(configBiome, registry.getEntrySet()), NBiomes.ERODED_HAUNTED_FOREST_KEY);
                }
            }

            if (Nyctophobia.config.getBiome(new Identifier(Nyctophobia.MOD_ID,"haunted_lakes")).canGenerate) {
                List<String> configBiomes = Nyctophobia.config.biomeConfigEntries.get("haunted_lakes").replaceableBiomes;
                for (String configBiome : configBiomes) {
                    builder.replaceBiome(parseBiomeKeys(configBiome, registry.getEntrySet()), NBiomes.HAUNTED_LAKES_KEY);
                }
            }

            if (Nyctophobia.config.getBiome(new Identifier(Nyctophobia.MOD_ID,"ancient_dead_coral_reef")).canGenerate) {
                List<String> configBiomes = Nyctophobia.config.biomeConfigEntries.get("ancient_dead_coral_reef").replaceableBiomes;
                for (String configBiome : configBiomes) {
                    builder.replaceBiome(parseBiomeKeys(configBiome, registry.getEntrySet()), NBiomes.ANCIENT_DEAD_CORAL_REEF_KEY);
                }
            }

            if (Nyctophobia.config.getBiome(new Identifier(Nyctophobia.MOD_ID,"deep_dark_forest")).canGenerate) {
                List<String> configBiomes = Nyctophobia.config.biomeConfigEntries.get("deep_dark_forest").replaceableBiomes;
                for (String configBiome : configBiomes) {
                    builder.replaceBiome(parseBiomeKeys(configBiome, registry.getEntrySet()), NBiomes.DEEP_DARK_FOREST);
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

        Nyctophobia.LOGGER.error("Wrong biome key \"" + configBiome + "\" in config!");
        return null;
    }
}


