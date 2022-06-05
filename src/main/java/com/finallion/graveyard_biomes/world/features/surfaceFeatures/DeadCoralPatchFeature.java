package com.finallion.graveyard_biomes.world.features.surfaceFeatures;

import com.finallion.graveyard_biomes.util.TGTags;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;

public class DeadCoralPatchFeature extends Feature<DefaultFeatureConfig> {


    public DeadCoralPatchFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        Random random = context.getRandom();
        context.getConfig();
        BlockPos.Mutable mutable = new BlockPos.Mutable().set(blockPos);


        for (int i = 61; i < 80; i++) {
            mutable.set(blockPos);
            mutable.move(random.nextInt(3) - random.nextInt(3), 0, random.nextInt(3) - random.nextInt(3));
            mutable.setY(i);
            if (world.getBlockState(mutable).isSolidBlock(world, mutable) && world.getBlockState(mutable.up()).isAir() && world.getBiome(mutable).getKey().get().getValue().getPath().contains("ancient_dead_coral_reef")) {
                if (random.nextInt(7) == 0) {
                    Registry.BLOCK.getEntryList(TGTags.DEAD_CORALS).flatMap((blocks) -> {
                        return blocks.getRandom(random);
                    }).map(RegistryEntry::value).ifPresent((block) -> {
                        world.setBlockState(mutable.up(), block.getDefaultState().with(Properties.WATERLOGGED, false), 2);
                    });
                    break;
                }
            } else if (world.getBlockState(mutable).isSolidBlock(world, mutable) && world.getBlockState(mutable.up()).isOf(Blocks.WATER) && world.getBiome(mutable).getKey().get().getValue().getPath().contains("ancient_dead_coral_reef")) {
                if (random.nextBoolean()) {
                    Registry.BLOCK.getEntryList(TGTags.DEAD_CORALS).flatMap((blocks) -> {
                        return blocks.getRandom(random);
                    }).map(RegistryEntry::value).ifPresent((block) -> {
                        world.setBlockState(mutable.up(), block.getDefaultState().with(Properties.WATERLOGGED, true), 2);
                    });
                    break;
                }
            }
        }

        return true;

    }

}

