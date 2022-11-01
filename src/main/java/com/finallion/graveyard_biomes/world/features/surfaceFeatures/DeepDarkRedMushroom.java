package com.finallion.graveyard_biomes.world.features.surfaceFeatures;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PlantBlock;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ModifiableWorld;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeMushroomFeature;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class DeepDarkRedMushroom extends HugeMushroomFeature {


    public DeepDarkRedMushroom(Codec<HugeMushroomFeatureConfig> codec) {
        super(codec);
    }

    @Override
    protected void generateCap(WorldAccess world, Random random, BlockPos start, int y, BlockPos.Mutable mutable, HugeMushroomFeatureConfig config) {

    }

    @Override
    protected void generateStem(WorldAccess world, Random random, BlockPos pos, HugeMushroomFeatureConfig config, int height, BlockPos.Mutable mutablePos) {
        mutablePos.move(Direction.DOWN, 5);

        for (int i = -2; i < 3; i++) {
            if (!world.getBlockState(mutablePos.down().offset(Direction.Axis.X, i)).isOf(Blocks.GRASS_BLOCK)) {
                return;
            }

            if (!world.getBlockState(mutablePos.down().offset(Direction.Axis.Z, i)).isOf(Blocks.GRASS_BLOCK)) {
                return;
            }
        }

        // first layer
        this.setBlock(world, mutablePos, config.stemProvider.getBlockState(random, pos));
        for (int i = 1; i <= 3; i++) {
            this.setBlock(world, mutablePos.offset(Direction.EAST, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.WEST, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.NORTH, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.SOUTH, i), config.stemProvider.getBlockState(random, pos));

            this.setBlock(world, mutablePos.offset(Direction.EAST, 1).offset(Direction.SOUTH, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.WEST, 1).offset(Direction.NORTH, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.NORTH, 1).offset(Direction.EAST, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.SOUTH, 1).offset(Direction.WEST, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.SOUTH, 1).offset(Direction.EAST, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.NORTH, 1).offset(Direction.WEST, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.EAST, 1).offset(Direction.NORTH, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.WEST, 1).offset(Direction.SOUTH, i), config.stemProvider.getBlockState(random, pos));
        }
        this.setBlock(world, mutablePos.offset(Direction.EAST, 2).offset(Direction.SOUTH, 2), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.WEST, 2).offset(Direction.NORTH, 2), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.NORTH, 2).offset(Direction.EAST, 2), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.SOUTH, 2).offset(Direction.WEST, 2), config.stemProvider.getBlockState(random, pos));

        mutablePos.move(Direction.UP);

        // second layer
        this.setBlock(world, mutablePos, config.stemProvider.getBlockState(random, pos));
        for (int i = 1; i <= 3; i++) {
            this.setBlock(world, mutablePos.offset(Direction.EAST, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.WEST, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.NORTH, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.SOUTH, i), config.stemProvider.getBlockState(random, pos));
        }

        this.setBlock(world, mutablePos.offset(Direction.EAST, 1).offset(Direction.SOUTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.WEST, 1).offset(Direction.NORTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.NORTH, 1).offset(Direction.EAST, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.SOUTH, 1).offset(Direction.WEST, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.EAST, 1).offset(Direction.SOUTH, 2), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.WEST, 1).offset(Direction.NORTH, 2), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.NORTH, 1).offset(Direction.EAST, 2), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.SOUTH, 1).offset(Direction.WEST, 2), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.EAST, 2).offset(Direction.SOUTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.WEST, 2).offset(Direction.NORTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.NORTH, 2).offset(Direction.EAST, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.SOUTH, 2).offset(Direction.WEST, 1), config.stemProvider.getBlockState(random, pos));

        this.setBlock(world, mutablePos.offset(Direction.WEST, 2).offset(Direction.NORTH, 2), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.EAST, 3).offset(Direction.NORTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.EAST, 2).offset(Direction.SOUTH, 2), config.stemProvider.getBlockState(random, pos));

        // third layer
        mutablePos.move(Direction.UP);
        this.setBlock(world, mutablePos, config.stemProvider.getBlockState(random, pos));
        for (int i = 1; i <= 2; i++) {
            this.setBlock(world, mutablePos.offset(Direction.EAST, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.WEST, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.NORTH, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.SOUTH, i), config.stemProvider.getBlockState(random, pos));

            this.setBlock(world, mutablePos.offset(Direction.EAST, 1).offset(Direction.SOUTH, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.WEST, 1).offset(Direction.NORTH, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.NORTH, 1).offset(Direction.EAST, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.SOUTH, 1).offset(Direction.WEST, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.SOUTH, 1).offset(Direction.EAST, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.NORTH, 1).offset(Direction.WEST, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.EAST, 1).offset(Direction.NORTH, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.WEST, 1).offset(Direction.SOUTH, i), config.stemProvider.getBlockState(random, pos));
        }
        this.setBlock(world, mutablePos.offset(Direction.EAST, 3), config.stemProvider.getBlockState(random, pos));

        // forth layer
        mutablePos.move(Direction.UP);
        this.setBlock(world, mutablePos, config.stemProvider.getBlockState(random, pos));
        for (int i = 1; i <= 2; i++) {
            this.setBlock(world, mutablePos.offset(Direction.EAST, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.WEST, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.NORTH, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.SOUTH, i), config.stemProvider.getBlockState(random, pos));
        }

        this.setBlock(world, mutablePos.offset(Direction.EAST, 1).offset(Direction.SOUTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.WEST, 1).offset(Direction.NORTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.NORTH, 1).offset(Direction.EAST, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.SOUTH, 1).offset(Direction.WEST, 1), config.stemProvider.getBlockState(random, pos));

        this.setBlock(world, mutablePos.offset(Direction.NORTH, 2).offset(Direction.WEST, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.NORTH, 2).offset(Direction.EAST, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.EAST, 2).offset(Direction.SOUTH, 1), config.stemProvider.getBlockState(random, pos));

        // fifth layer
        mutablePos.move(Direction.UP);
        this.setBlock(world, mutablePos, config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.EAST, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.WEST, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.NORTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.SOUTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.EAST, 1).offset(Direction.SOUTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.WEST, 1).offset(Direction.NORTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.NORTH, 1).offset(Direction.EAST, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.SOUTH, 1).offset(Direction.WEST, 1), config.stemProvider.getBlockState(random, pos));

        this.setBlock(world, mutablePos.offset(Direction.NORTH, 2), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.EAST, 2), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.NORTH, 2).offset(Direction.WEST, 1), config.stemProvider.getBlockState(random, pos));

        //sixth layer
        mutablePos.move(Direction.UP);
        this.setBlock(world, mutablePos, config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.EAST, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.WEST, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.NORTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.SOUTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.EAST, 1).offset(Direction.SOUTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.WEST, 1).offset(Direction.NORTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.NORTH, 1).offset(Direction.EAST, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.SOUTH, 1).offset(Direction.WEST, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.NORTH, 2), config.stemProvider.getBlockState(random, pos));

        mutablePos.move(Direction.UP);
        this.setBlock(world, mutablePos, config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.EAST, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.WEST, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.NORTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.SOUTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.EAST, 1).offset(Direction.SOUTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.WEST, 1).offset(Direction.NORTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.NORTH, 1).offset(Direction.EAST, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.SOUTH, 1).offset(Direction.WEST, 1), config.stemProvider.getBlockState(random, pos));

        int bound = random.nextInt(6) + 1;
        for (int i = 0; i <= bound; i++) {
            mutablePos.move(Direction.UP);
            if (i == 0) {
                this.setBlock(world, mutablePos.offset(Direction.EAST, 1).offset(Direction.SOUTH, 1), config.stemProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.WEST, 1).offset(Direction.NORTH, 1), config.stemProvider.getBlockState(random, pos));
            }

            this.setBlock(world, mutablePos, config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.EAST, 1), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.WEST, 1), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.NORTH, 1), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.SOUTH, 1), config.stemProvider.getBlockState(random, pos));

            if (i == bound) {
                this.setBlock(world, mutablePos.offset(Direction.NORTH, 1).offset(Direction.EAST, 1), config.stemProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.SOUTH, 1).offset(Direction.WEST, 1), config.stemProvider.getBlockState(random, pos));
            }
        }

        mutablePos.move(Direction.UP);
        this.setBlock(world, mutablePos, config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.EAST, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.WEST, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.NORTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.SOUTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.EAST, 1).offset(Direction.SOUTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.WEST, 1).offset(Direction.NORTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.NORTH, 1).offset(Direction.EAST, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.SOUTH, 1).offset(Direction.WEST, 1), config.stemProvider.getBlockState(random, pos));

        for (int i = 0; i < 2; i++) {
            mutablePos.move(Direction.UP);
            this.setBlock(world, mutablePos, config.stemProvider.getBlockState(random, pos));
            for (int ii = 1; ii <= 2; ii++) {
                this.setBlock(world, mutablePos.offset(Direction.EAST, ii), config.stemProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.WEST, ii), config.stemProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.NORTH, ii), config.stemProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.SOUTH, ii), config.stemProvider.getBlockState(random, pos));
            }

            this.setBlock(world, mutablePos.offset(Direction.EAST, 1).offset(Direction.SOUTH, 1), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.WEST, 1).offset(Direction.NORTH, 1), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.NORTH, 1).offset(Direction.EAST, 1), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.SOUTH, 1).offset(Direction.WEST, 1), config.stemProvider.getBlockState(random, pos));
        }

        mutablePos.move(Direction.UP);
        this.setBlock(world, mutablePos, config.stemProvider.getBlockState(random, pos));
        for (int i = 1; i <= 3; i++) {
            this.setBlock(world, mutablePos.offset(Direction.EAST, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.WEST, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.NORTH, i), config.stemProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.SOUTH, i), config.stemProvider.getBlockState(random, pos));
        }

        this.setBlock(world, mutablePos.offset(Direction.EAST, 1).offset(Direction.SOUTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.WEST, 1).offset(Direction.NORTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.NORTH, 1).offset(Direction.EAST, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.SOUTH, 1).offset(Direction.WEST, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.EAST, 1).offset(Direction.SOUTH, 2), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.WEST, 1).offset(Direction.NORTH, 2), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.NORTH, 1).offset(Direction.EAST, 2), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.SOUTH, 1).offset(Direction.WEST, 2), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.EAST, 2).offset(Direction.SOUTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.WEST, 2).offset(Direction.NORTH, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.NORTH, 2).offset(Direction.EAST, 1), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.SOUTH, 2).offset(Direction.WEST, 1), config.stemProvider.getBlockState(random, pos));


        // cap
        // layer 1
        for (int i = -3; i <= 3; i++) {
            if (Math.abs(i) == 3) {
                this.setBlock(world, mutablePos.offset(Direction.EAST, 4).offset(Direction.NORTH, i), config.capProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.WEST, 4).offset(Direction.SOUTH, i), config.capProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.NORTH, 4).offset(Direction.WEST, i), config.capProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.SOUTH, 4).offset(Direction.EAST, i), config.capProvider.getBlockState(random, pos));
            } else {
                this.setBlock(world, mutablePos.offset(Direction.EAST, 5).offset(Direction.NORTH, i), config.capProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.WEST, 5).offset(Direction.SOUTH, i), config.capProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.NORTH, 5).offset(Direction.WEST, i), config.capProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.SOUTH, 5).offset(Direction.EAST, i), config.capProvider.getBlockState(random, pos));
            }
        }

        // layer 2
        mutablePos.move(Direction.UP);
        for (int i = -2; i <= 3; i++) {
            if (Math.abs(i) == 2) {
                this.setBlock(world, mutablePos.offset(Direction.EAST, 4).offset(Direction.NORTH, i), config.capProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.WEST, 4).offset(Direction.SOUTH, i), config.capProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.NORTH, 4).offset(Direction.WEST, i), config.capProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.SOUTH, 4).offset(Direction.EAST, i), config.capProvider.getBlockState(random, pos));
            } else if (i == 3) {
                this.setBlock(world, mutablePos.offset(Direction.EAST, 3).offset(Direction.NORTH, i), config.capProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.WEST, 3).offset(Direction.SOUTH, i), config.capProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.NORTH, 3).offset(Direction.WEST, i), config.capProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.SOUTH, 3).offset(Direction.EAST, i), config.capProvider.getBlockState(random, pos));
            } else {
                this.setBlock(world, mutablePos.offset(Direction.EAST, 5).offset(Direction.NORTH, i), config.capProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.WEST, 5).offset(Direction.SOUTH, i), config.capProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.NORTH, 5).offset(Direction.WEST, i), config.capProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.SOUTH, 5).offset(Direction.EAST, i), config.capProvider.getBlockState(random, pos));
            }
        }

        // connector stem to cap
        this.setBlock(world, mutablePos.offset(Direction.EAST, 4), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.WEST, 4), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.NORTH, 4), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.SOUTH, 4), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.EAST, 2).offset(Direction.NORTH, 2), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.WEST, 2).offset(Direction.SOUTH, 2), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.NORTH, 2).offset(Direction.WEST, 2), config.stemProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.SOUTH, 2).offset(Direction.EAST, 2), config.stemProvider.getBlockState(random, pos));


        // layer 3
        mutablePos.move(Direction.UP);
        for (int i = -2; i <= 2; i++) {
            if (Math.abs(i) == 2) {
                this.setBlock(world, mutablePos.offset(Direction.EAST, 3).offset(Direction.NORTH, i), config.capProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.WEST, 3).offset(Direction.SOUTH, i), config.capProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.NORTH, 3).offset(Direction.WEST, i), config.capProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.SOUTH, 3).offset(Direction.EAST, i), config.capProvider.getBlockState(random, pos));
            } else {
                this.setBlock(world, mutablePos.offset(Direction.EAST, 4).offset(Direction.NORTH, i), config.capProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.WEST, 4).offset(Direction.SOUTH, i), config.capProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.NORTH, 4).offset(Direction.WEST, i), config.capProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.SOUTH, 4).offset(Direction.EAST, i), config.capProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.EAST, 3).offset(Direction.NORTH, i), config.capProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.WEST, 3).offset(Direction.SOUTH, i), config.capProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.NORTH, 3).offset(Direction.WEST, i), config.capProvider.getBlockState(random, pos));
                this.setBlock(world, mutablePos.offset(Direction.SOUTH, 3).offset(Direction.EAST, i), config.capProvider.getBlockState(random, pos));
            }
        }

        this.setBlock(world, mutablePos.offset(Direction.EAST, 2).offset(Direction.NORTH, 2), config.capProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.WEST, 2).offset(Direction.SOUTH, 2), config.capProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.NORTH, 2).offset(Direction.WEST, 2), config.capProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.SOUTH, 2).offset(Direction.EAST, 2), config.capProvider.getBlockState(random, pos));

        // layer 4
        mutablePos.move(Direction.UP);
        this.setBlock(world, mutablePos, config.capProvider.getBlockState(random, pos));
        for (int i = 1; i <= 3; i++) {
            this.setBlock(world, mutablePos.offset(Direction.EAST, i), config.capProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.WEST, i), config.capProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.NORTH, i), config.capProvider.getBlockState(random, pos));
            this.setBlock(world, mutablePos.offset(Direction.SOUTH, i), config.capProvider.getBlockState(random, pos));
        }

        this.setBlock(world, mutablePos.offset(Direction.EAST, 1).offset(Direction.SOUTH, 1), config.capProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.WEST, 1).offset(Direction.NORTH, 1), config.capProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.NORTH, 1).offset(Direction.EAST, 1), config.capProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.SOUTH, 1).offset(Direction.WEST, 1), config.capProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.EAST, 1).offset(Direction.SOUTH, 2), config.capProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.WEST, 1).offset(Direction.NORTH, 2), config.capProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.NORTH, 1).offset(Direction.EAST, 2), config.capProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.SOUTH, 1).offset(Direction.WEST, 2), config.capProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.EAST, 2).offset(Direction.SOUTH, 1), config.capProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.WEST, 2).offset(Direction.NORTH, 1), config.capProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.NORTH, 2).offset(Direction.EAST, 1), config.capProvider.getBlockState(random, pos));
        this.setBlock(world, mutablePos.offset(Direction.SOUTH, 2).offset(Direction.WEST, 1), config.capProvider.getBlockState(random, pos));

    }

    protected void setBlock(WorldAccess world, BlockPos pos, BlockState state) {
        if (!world.getBlockState(pos).isOpaqueFullCube(world, pos)) {
            this.setBlockState(world, pos, state);
        }

    }

    @Override
    protected int getCapSize(int i, int j, int capSize, int y) {
        return 0;
    }


}

