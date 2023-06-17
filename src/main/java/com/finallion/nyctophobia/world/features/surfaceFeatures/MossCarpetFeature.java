package com.finallion.nyctophobia.world.features.surfaceFeatures;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class MossCarpetFeature extends Feature<DefaultFeatureConfig> {


    public MossCarpetFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        Random random = context.getRandom();
        context.getConfig();
        BlockPos.Mutable mutable = new BlockPos.Mutable().set(blockPos);

        // cap at height 128
        for (int i = 62; i < 128; i++) {
            mutable.set(blockPos);
            mutable.move(random.nextInt(10) - random.nextInt(10), 0, random.nextInt(10) - random.nextInt(10));
            mutable.setY(i);
            if (world.getBlockState(mutable).getBlock() instanceof LeavesBlock && world.getBlockState(mutable.up()).isAir() && FeatureHelper.isCorrectBiome(world.getBiome(mutable).getKey().get())) {
                world.setBlockState(mutable.up(), Blocks.MOSS_CARPET.getDefaultState(), 2);
                break;

            } else if (world.getBlockState(mutable).isOf(Blocks.MOSS_BLOCK) && world.getBlockState(mutable.up()).isAir()) {
                if (random.nextInt(5) == 0) {
                    world.setBlockState(mutable.up(), Blocks.MOSS_CARPET.getDefaultState(), 2);
                    break;
                }
            }

        }

        return true;

    }

}
