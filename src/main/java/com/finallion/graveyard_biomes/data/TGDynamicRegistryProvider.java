package com.finallion.graveyard_biomes.data;

import com.finallion.graveyard_biomes.init.TGBiomes;
import com.finallion.graveyard_biomes.init.TGConfiguredFeatures;
import com.finallion.graveyard_biomes.init.TGPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class TGDynamicRegistryProvider extends FabricDynamicRegistryProvider {

    protected TGDynamicRegistryProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        TGConfiguredFeatures.populate(entries);
        TGPlacedFeatures.populate(entries);
        TGBiomes.populate(entries);
    }

    @Override
    public String getName() {
        return "Graveyard Biomes";
    }
}
