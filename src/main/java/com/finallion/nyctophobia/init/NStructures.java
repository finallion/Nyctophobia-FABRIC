package com.finallion.nyctophobia.init;

import com.finallion.nyctophobia.Nyctophobia;
import com.finallion.nyctophobia.world.structures.MushroomStructure;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.structure.StructureType;

public class NStructures {

    public static StructureType<MushroomStructure> MUSHROOM_STRUCTURE;

    public static void registerStructureFeatures() {
        MUSHROOM_STRUCTURE = Registry.register(Registries.STRUCTURE_TYPE, new Identifier(Nyctophobia.MOD_ID, "mushroom_structure"), () -> MushroomStructure.CODEC);
    }
}
