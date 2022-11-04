package com.finallion.graveyard_biomes.world.features.surfaceFeatures;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class BushFeature extends Feature<DefaultFeatureConfig> {
    private LeavesBlock leavesBlock;

    public BushFeature(Codec<DefaultFeatureConfig> configCodec, LeavesBlock block) {
        super(configCodec);
        this.leavesBlock = block;
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        Random random = context.getRandom();
        context.getConfig();
        BlockPos.Mutable mutable = new BlockPos.Mutable().set(blockPos);


        for (int i = 64; i < world.getHeight(); i++) {
            mutable.set(blockPos);
            mutable.move(random.nextInt(3) - random.nextInt(3), 0, random.nextInt(3) - random.nextInt(3));
            mutable.setY(i);
            if (FeatureHelper.canBePlaced(world.getBlockState(mutable)) && world.getBlockState(mutable.up()).isAir() && FeatureHelper.isCorrectBiome(world.getBiome(mutable).getKey().get())) {
                if (random.nextInt(7) == 0) {
                    world.setBlockState(mutable.up(), leavesBlock.getDefaultState().with(Properties.PERSISTENT, true), 2);
                    break;
                }
            }
        }

        return true;

    }

}

