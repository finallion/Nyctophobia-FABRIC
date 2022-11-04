package com.finallion.graveyard_biomes.world.biomes;

import com.finallion.graveyard_biomes.TheGraveyardBiomes;
import com.finallion.graveyard_biomes.init.TGBiomes;
import com.finallion.graveyard_biomes.world.surfacerules.TGSurfaceRules;
import com.mojang.datafixers.util.Pair;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.List;
import java.util.Map;
import java.util.Optional;
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
                    builder.replaceBiome(parseBiomeKeys(configBiome), TGBiomes.HAUNTED_FOREST_KEY);
                }
            }

            if (TheGraveyardBiomes.config.getBiome(new Identifier(TheGraveyardBiomes.MOD_ID, "eroded_haunted_forest")).canGenerate) {
                List<String> configBiomes = TheGraveyardBiomes.config.biomeConfigEntries.get("eroded_haunted_forest").replaceableBiomes;
                for (String configBiome : configBiomes) {
                    builder.replaceBiome(parseBiomeKeys(configBiome), TGBiomes.ERODED_HAUNTED_FOREST_KEY);
                }
            }

            if (TheGraveyardBiomes.config.getBiome(new Identifier(TheGraveyardBiomes.MOD_ID,"haunted_lakes")).canGenerate) {
                List<String> configBiomes = TheGraveyardBiomes.config.biomeConfigEntries.get("haunted_lakes").replaceableBiomes;
                for (String configBiome : configBiomes) {
                    builder.replaceBiome(parseBiomeKeys(configBiome), TGBiomes.HAUNTED_LAKES_KEY);
                }
            }

            if (TheGraveyardBiomes.config.getBiome(new Identifier(TheGraveyardBiomes.MOD_ID,"ancient_dead_coral_reef")).canGenerate) {
                List<String> configBiomes = TheGraveyardBiomes.config.biomeConfigEntries.get("ancient_dead_coral_reef").replaceableBiomes;
                for (String configBiome : configBiomes) {
                    builder.replaceBiome(parseBiomeKeys(configBiome), TGBiomes.ANCIENT_DEAD_CORAL_REEF_KEY);
                }
            }

            if (TheGraveyardBiomes.config.getBiome(new Identifier(TheGraveyardBiomes.MOD_ID,"deep_dark_forest")).canGenerate) {
                List<String> configBiomes = TheGraveyardBiomes.config.biomeConfigEntries.get("deep_dark_forest").replaceableBiomes;
                for (String configBiome : configBiomes) {
                    builder.replaceBiome(parseBiomeKeys(configBiome), TGBiomes.DEEP_DARK_FOREST);
                }
            }

        });

    }

    /*

        @Override
        public Optional<MaterialRules.MaterialRule> getOverworldSurfaceRules() {
            return Optional.of(TGSurfaceRules.makeRules());
        }

         */
    private RegistryKey<Biome> parseBiomeKeys(String configKey) {
        List<RegistryKey<Biome>> biomeKeys = BuiltinRegistries.BIOME.getEntrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());
        for (RegistryKey<Biome> key : biomeKeys) {
            String biomeName = key.getValue().getPath();

            if (biomeName.equals(configKey)) {
                return key;
            }
        }

        TheGraveyardBiomes.LOGGER.error("Wrong biome key \"" + configKey + "\" in config!");
        return null;
    }
}


