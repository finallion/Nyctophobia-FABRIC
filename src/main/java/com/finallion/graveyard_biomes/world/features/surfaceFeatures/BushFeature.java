package com.finallion.graveyard_biomes.world.features.surfaceFeatures;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;

public class BushFeature extends Feature<DefaultFeatureConfig> {


    public BushFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
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
                    world.setBlockState(mutable.up(), Blocks.SPRUCE_LEAVES.getDefaultState().with(Properties.PERSISTENT, true), 2);
                    break;
                }
            }
        }

        return true;

    }

}

