package com.finallion.graveyard_biomes.util;

import com.finallion.graveyard_biomes.TheGraveyardBiomes;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;


public class TGTags {

    public static final TagKey<Block> DEAD_CORAL_BLOCKS = TagKey.of(Registry.BLOCK_KEY, new Identifier(TheGraveyardBiomes.MOD_ID, "dead_coral_blocks"));
    public static final TagKey<Block> DEAD_CORAL_PLANTS = TagKey.of(Registry.BLOCK_KEY, new Identifier(TheGraveyardBiomes.MOD_ID, "dead_coral_plants"));
    public static final TagKey<Block> DEAD_CORALS = TagKey.of(Registry.BLOCK_KEY, new Identifier(TheGraveyardBiomes.MOD_ID, "dead_corals"));
    public static final TagKey<Block> DEAD_WALL_CORALS = TagKey.of(Registry.BLOCK_KEY, new Identifier(TheGraveyardBiomes.MOD_ID, "dead_wall_corals"));
}
