package com.finallion.graveyard_biomes.data;

import com.finallion.graveyard_biomes.init.TGBiomes;
import com.finallion.graveyard_biomes.init.TGConfiguredFeatures;
import com.finallion.graveyard_biomes.init.TGPlacedFeatures;
import com.finallion.graveyard_biomes.util.TGTags;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class TGDataGen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
        FabricDataGenerator.Pack pack = dataGenerator.createPack();
        pack.addProvider(TGDynamicRegistryProvider::new);
    }

}
