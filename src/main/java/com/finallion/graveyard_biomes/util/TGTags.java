package com.finallion.graveyard_biomes.util;

import com.finallion.graveyard_biomes.TheGraveyardBiomes;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;


public class TGTags {
    public static void init() {}

    public static final TagKey<Block> DEAD_CORAL_BLOCKS = TagKey.of(RegistryKeys.BLOCK, new Identifier(TheGraveyardBiomes.MOD_ID, "dead_coral_blocks"));
    public static final TagKey<Block> DEAD_CORAL_PLANTS = TagKey.of(RegistryKeys.BLOCK, new Identifier(TheGraveyardBiomes.MOD_ID, "dead_coral_plants"));
    public static final TagKey<Block> DEAD_CORALS = TagKey.of(RegistryKeys.BLOCK, new Identifier(TheGraveyardBiomes.MOD_ID, "dead_corals"));
    public static final TagKey<Block> DEAD_WALL_CORALS = TagKey.of(RegistryKeys.BLOCK, new Identifier(TheGraveyardBiomes.MOD_ID, "dead_wall_corals"));
    public static final TagKey<Biome> MUSHROOM_BIOMES = TagKey.of(RegistryKeys.BIOME, new Identifier(TheGraveyardBiomes.MOD_ID, "/has_structure/mushroom_biomes"));

}
