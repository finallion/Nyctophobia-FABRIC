package com.finallion.graveyard_biomes.init;

import com.finallion.graveyard_biomes.TheGraveyardBiomes;
import com.finallion.graveyard_biomes.config.GraveyardBiomesConfig;
import com.finallion.graveyard_biomes.world.structures.MushroomStructure;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.structure.StructureType;

public class TGStructures {

    public static StructureType<MushroomStructure> MUSHROOM_STRUCTURE;

    public static void registerStructureFeatures() {
        MUSHROOM_STRUCTURE = Registry.register(Registries.STRUCTURE_TYPE, new Identifier(TheGraveyardBiomes.MOD_ID, "mushroom_structure"), () -> MushroomStructure.CODEC);
    }
}
