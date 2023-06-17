package com.finallion.nyctophobia.data;

import com.finallion.nyctophobia.init.NBiomes;
import com.finallion.nyctophobia.init.NConfiguredFeatures;
import com.finallion.nyctophobia.init.NPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class NDynamicRegistryProvider extends FabricDynamicRegistryProvider {

    protected NDynamicRegistryProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        NConfiguredFeatures.populate(entries);
        NPlacedFeatures.populate(entries);
        NBiomes.populate(entries);
    }

    @Override
    public String getName() {
        return "Nyctophobia";
    }
}
