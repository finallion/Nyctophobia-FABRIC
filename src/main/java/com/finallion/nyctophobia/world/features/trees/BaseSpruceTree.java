package com.finallion.nyctophobia.world.features.trees;

import com.finallion.nyctophobia.world.features.trees.config.NTreeFeatureConfig;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public abstract class BaseSpruceTree extends Feature<NTreeFeatureConfig> {


    public BaseSpruceTree(Codec<NTreeFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<NTreeFeatureConfig> context) {
        return false;
    }


    public void setLeaves(FeatureContext<NTreeFeatureConfig> context, BlockPos pos, BlockState state) {
        if (canReplace(context.getWorld(), pos)) {
            context.getWorld().setBlockState(pos, state, 2);
        }
    }

    public void setLeavesRandomized(FeatureContext<NTreeFeatureConfig> context, BlockPos pos, BlockState state, int chance) {
        if (canReplace(context.getWorld(), pos) && context.getRandom().nextInt(chance) == 0) {
            context.getWorld().setBlockState(pos, state, 2);
        }
    }

    public void setBranchRandomized(FeatureContext<NTreeFeatureConfig> context, BlockPos pos, BlockState state, int chance) {
        if (canReplace(context.getWorld(), pos) && context.getRandom().nextInt(chance) == 0) {
            context.getWorld().setBlockState(pos, state, 2);
        }
    }

    public static boolean canReplace(TestableWorld world, BlockPos pos) {
        return world.testBlockState(pos, (state) -> {
            return state.isAir() || state.isIn(BlockTags.REPLACEABLE_BY_TREES);
        });
    }

    public void generateBranchesOne(FeatureContext<NTreeFeatureConfig> context, BlockPos pos, int chance) {

        setBranchRandomized(context, pos.add(1, 0, 0), context.getConfig().woodState.with(Properties.AXIS, Direction.Axis.X), chance);
        setBranchRandomized(context, pos.add(0, 0, 1), context.getConfig().woodState.with(Properties.AXIS, Direction.Axis.Z), chance);
        setBranchRandomized(context, pos.add(-1, 0, 0), context.getConfig().woodState.with(Properties.AXIS, Direction.Axis.X), chance);
        setBranchRandomized(context, pos.add(0, 0, -1), context.getConfig().woodState.with(Properties.AXIS, Direction.Axis.Z), chance);

    }

    public void generateBranchesTwo(FeatureContext<NTreeFeatureConfig> context, BlockPos pos, int chance) {
        setBranchRandomized(context, pos.add(1, 0, 0), context.getConfig().woodState.with(Properties.AXIS, Direction.Axis.X), chance);
        setBranchRandomized(context, pos.add(0, 0, 1), context.getConfig().woodState.with(Properties.AXIS, Direction.Axis.Z), chance);
        setBranchRandomized(context, pos.add(-1, 0, 0), context.getConfig().woodState.with(Properties.AXIS, Direction.Axis.X), chance);
        setBranchRandomized(context, pos.add(0, 0, -1), context.getConfig().woodState.with(Properties.AXIS, Direction.Axis.Z), chance);
        setBranchRandomized(context, pos.add(2, 0, 0), context.getConfig().woodState.with(Properties.AXIS, Direction.Axis.X), chance);
        setBranchRandomized(context, pos.add(0, 0, 2), context.getConfig().woodState.with(Properties.AXIS, Direction.Axis.Z), chance);
        setBranchRandomized(context, pos.add(-2, 0, 0), context.getConfig().woodState.with(Properties.AXIS, Direction.Axis.X), chance);
        setBranchRandomized(context, pos.add(0, 0, -2), context.getConfig().woodState.with(Properties.AXIS, Direction.Axis.Z), chance);
    }



    public void randomSpreadOne(FeatureContext<NTreeFeatureConfig> context, BlockPos pos, boolean beSquare, int chance) {
        setLeavesRandomized(context, pos.add(1, 0, 0), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(0, 0, 1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-1, 0, 0), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(0, 0, -1), context.getConfig().leafState, chance);

    }

    public void randomSpreadTwo(FeatureContext<NTreeFeatureConfig> context, BlockPos pos, boolean beSquare, int chance) {
        setLeavesRandomized(context, pos.add(1, 0, 0), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(0, 0, 1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-1, 0, 0), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(0, 0, -1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-1, 0, -1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(1, 0, 1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-1, 0, 1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(1, 0, -1), context.getConfig().leafState, chance);

        if (!beSquare) {
            setLeavesRandomized(context, pos.add(2, 0, 0), context.getConfig().leafState, chance);
            setLeavesRandomized(context, pos.add(0, 0, 2), context.getConfig().leafState, chance);
            setLeavesRandomized(context, pos.add(-2, 0, 0), context.getConfig().leafState, chance);
            setLeavesRandomized(context, pos.add(0, 0, -2), context.getConfig().leafState, chance);
        }
    }

    public void randomSpreadThree(FeatureContext<NTreeFeatureConfig> context, BlockPos pos, boolean beSquare, int chance) {
        setLeavesRandomized(context, pos.add(1, 0, 0), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(0, 0, 1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-1, 0, 0), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(0, 0, -1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-1, 0, -1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(1, 0, 1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-1, 0, 1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(1, 0, -1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(2, 0, 0), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(0, 0, 2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-2, 0, 0), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(0, 0, -2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(2, 0, 1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(1, 0, 2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-2, 0, 1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(1, 0, -2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(2, 0, -1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-1, 0, 2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-2, 0, -1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-1, 0, -2), context.getConfig().leafState, chance);

        if (!beSquare) {
            setLeavesRandomized(context, pos.add(3, 0, 0), context.getConfig().leafState, chance);
            setLeavesRandomized(context, pos.add(0, 0, 3), context.getConfig().leafState, chance);
            setLeavesRandomized(context, pos.add(-3, 0, 0), context.getConfig().leafState, chance);
            setLeavesRandomized(context, pos.add(0, 0, -3), context.getConfig().leafState, chance);
        }
    }

    public void randomSpreadFour(FeatureContext<NTreeFeatureConfig> context, BlockPos pos, boolean beSquare, int chance) {
        setLeavesRandomized(context, pos.add(1, 0, 0), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(0, 0, 1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-1, 0, 0), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(0, 0, -1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-1, 0, -1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(1, 0, 1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-1, 0, 1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(1, 0, -1), context.getConfig().leafState, chance);

        setLeavesRandomized(context, pos.add(2, 0, 0), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(0, 0, 2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-2, 0, 0), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(0, 0, -2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(2, 0, 1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(1, 0, 2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-2, 0, 1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(1, 0, -2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(2, 0, -1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-1, 0, 2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-2, 0, -1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-1, 0, -2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(2, 0, 2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-2, 0, 2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-2, 0, -2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(2, 0, -2), context.getConfig().leafState, chance);

        setLeavesRandomized(context, pos.add(3, 0, 0), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(0, 0, 3), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-3, 0, 0), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(0, 0, -3), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(3, 0, 1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(1, 0, 3), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-3, 0, 1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(1, 0, -3), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(3, 0, -1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-1, 0, 3), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-3, 0, -1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-1, 0, -3), context.getConfig().leafState, chance);

        if (!beSquare) {
            setLeavesRandomized(context, pos.add(4, 0, 0), context.getConfig().leafState, chance);
            setLeavesRandomized(context, pos.add(0, 0, 4), context.getConfig().leafState, chance);
            setLeavesRandomized(context, pos.add(-4, 0, 0), context.getConfig().leafState, chance);
            setLeavesRandomized(context, pos.add(0, 0, -4), context.getConfig().leafState, chance);
        }
    }

    public void randomSpreadFive(FeatureContext<NTreeFeatureConfig> context, BlockPos pos, boolean beSquare, int chance) {
        setLeavesRandomized(context, pos.add(1, 0, 0), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(0, 0, 1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-1, 0, 0), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(0, 0, -1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-1, 0, -1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(1, 0, 1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-1, 0, 1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(1, 0, -1), context.getConfig().leafState, chance);

        setLeavesRandomized(context, pos.add(2, 0, 0), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(0, 0, 2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-2, 0, 0), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(0, 0, -2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(2, 0, 1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(1, 0, 2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-2, 0, 1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(1, 0, -2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(2, 0, -1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-1, 0, 2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-2, 0, -1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-1, 0, -2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(2, 0, 2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-2, 0, 2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-2, 0, -2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(2, 0, -2), context.getConfig().leafState, chance);

        setLeavesRandomized(context, pos.add(3, 0, 0), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(0, 0, 3), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-3, 0, 0), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(0, 0, -3), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(3, 0, 1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(1, 0, 3), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-3, 0, 1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(1, 0, -3), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(3, 0, -1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-1, 0, 3), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-3, 0, -1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-1, 0, -3), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(3, 0, 2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(2, 0, 3), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-3, 0, 2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(2, 0, -3), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(3, 0, -2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-2, 0, 3), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-3, 0, -2), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-2, 0, -3), context.getConfig().leafState, chance);

        setLeavesRandomized(context, pos.add(4, 0, 0), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(0, 0, 4), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-4, 0, 0), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(0, 0, -4), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(4, 0, 1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(1, 0, 4), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-4, 0, 1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(1, 0, -4), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(4, 0, -1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-1, 0, 4), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-4, 0, -1), context.getConfig().leafState, chance);
        setLeavesRandomized(context, pos.add(-1, 0, -4), context.getConfig().leafState, chance);

        if (!beSquare) {
            setLeavesRandomized(context, pos.add(5, 0, 0), context.getConfig().leafState, chance);
            setLeavesRandomized(context, pos.add(0, 0, 5), context.getConfig().leafState, chance);
            setLeavesRandomized(context, pos.add(-5, 0, 0), context.getConfig().leafState, chance);
            setLeavesRandomized(context, pos.add(0, 0, -5), context.getConfig().leafState, chance);
        }
    }

    public void generateOneStar(FeatureContext<NTreeFeatureConfig> context, BlockPos pos, boolean beSquare) {
        /*
                #
              # o #
                #
         */
        setLeaves(context, pos.add(1, 0, 0), context.getConfig().leafState);
        setLeaves(context, pos.add(0, 0, 1), context.getConfig().leafState);
        setLeaves(context, pos.add(-1, 0, 0), context.getConfig().leafState);
        setLeaves(context, pos.add(0, 0, -1), context.getConfig().leafState);

    }


    public void generateTwoStar(FeatureContext<NTreeFeatureConfig> context, BlockPos pos, boolean beSquare) {
        /*
                #
              # # #
            # # o # #
              # # #
                #
         */

        setLeaves(context, pos.add(1, 0, 0), context.getConfig().leafState);
        setLeaves(context, pos.add(0, 0, 1), context.getConfig().leafState);
        setLeaves(context, pos.add(-1, 0, 0), context.getConfig().leafState);
        setLeaves(context, pos.add(0, 0, -1), context.getConfig().leafState);
        setLeaves(context, pos.add(-1, 0, -1), context.getConfig().leafState);
        setLeaves(context, pos.add(1, 0, 1), context.getConfig().leafState);
        setLeaves(context, pos.add(-1, 0, 1), context.getConfig().leafState);
        setLeaves(context, pos.add(1, 0, -1), context.getConfig().leafState);

        if (!beSquare) {
            setLeaves(context, pos.add(2, 0, 0), context.getConfig().leafState);
            setLeaves(context, pos.add(0, 0, 2), context.getConfig().leafState);
            setLeaves(context, pos.add(-2, 0, 0), context.getConfig().leafState);
            setLeaves(context, pos.add(0, 0, -2), context.getConfig().leafState);
        }
    }



    public void generateThreeStar(FeatureContext<NTreeFeatureConfig> context, BlockPos pos, boolean beSquare) {
        /*
                #
              # # #
            # # # # #
          # # # o # # #
            # # # # #
              # # #
                #
         */

        setLeaves(context, pos.add(1, 0, 0), context.getConfig().leafState);
        setLeaves(context, pos.add(0, 0, 1), context.getConfig().leafState);
        setLeaves(context, pos.add(-1, 0, 0), context.getConfig().leafState);
        setLeaves(context, pos.add(0, 0, -1), context.getConfig().leafState);
        setLeaves(context, pos.add(-1, 0, -1), context.getConfig().leafState);
        setLeaves(context, pos.add(1, 0, 1), context.getConfig().leafState);
        setLeaves(context, pos.add(-1, 0, 1), context.getConfig().leafState);
        setLeaves(context, pos.add(1, 0, -1), context.getConfig().leafState);
        setLeaves(context, pos.add(2, 0, 0), context.getConfig().leafState);
        setLeaves(context, pos.add(0, 0, 2), context.getConfig().leafState);
        setLeaves(context, pos.add(-2, 0, 0), context.getConfig().leafState);
        setLeaves(context, pos.add(0, 0, -2), context.getConfig().leafState);
        setLeaves(context, pos.add(2, 0, 1), context.getConfig().leafState);
        setLeaves(context, pos.add(1, 0, 2), context.getConfig().leafState);
        setLeaves(context, pos.add(-2, 0, 1), context.getConfig().leafState);
        setLeaves(context, pos.add(1, 0, -2), context.getConfig().leafState);
        setLeaves(context, pos.add(2, 0, -1), context.getConfig().leafState);
        setLeaves(context, pos.add(-1, 0, 2), context.getConfig().leafState);
        setLeaves(context, pos.add(-2, 0, -1), context.getConfig().leafState);
        setLeaves(context, pos.add(-1, 0, -2), context.getConfig().leafState);

        if (!beSquare) {
            setLeaves(context, pos.add(3, 0, 0), context.getConfig().leafState);
            setLeaves(context, pos.add(0, 0, 3), context.getConfig().leafState);
            setLeaves(context, pos.add(-3, 0, 0), context.getConfig().leafState);
            setLeaves(context, pos.add(0, 0, -3), context.getConfig().leafState);
        }

    }


    public void generateFourStar(FeatureContext<NTreeFeatureConfig> context, BlockPos pos, boolean beSquare) {
        /*
                  #
                # # #
              # # # # #
            # # # # # # #
          # # # # o # # # #
            # # # # # # #
              # # # # #
                # # #
                  #
         */

        setLeaves(context, pos.add(1, 0, 0), context.getConfig().leafState);
        setLeaves(context, pos.add(0, 0, 1), context.getConfig().leafState);
        setLeaves(context, pos.add(-1, 0, 0), context.getConfig().leafState);
        setLeaves(context, pos.add(0, 0, -1), context.getConfig().leafState);
        setLeaves(context, pos.add(-1, 0, -1), context.getConfig().leafState);
        setLeaves(context, pos.add(1, 0, 1), context.getConfig().leafState);
        setLeaves(context, pos.add(-1, 0, 1), context.getConfig().leafState);
        setLeaves(context, pos.add(1, 0, -1), context.getConfig().leafState);

        setLeaves(context, pos.add(2, 0, 0), context.getConfig().leafState);
        setLeaves(context, pos.add(0, 0, 2), context.getConfig().leafState);
        setLeaves(context, pos.add(-2, 0, 0), context.getConfig().leafState);
        setLeaves(context, pos.add(0, 0, -2), context.getConfig().leafState);
        setLeaves(context, pos.add(2, 0, 1), context.getConfig().leafState);
        setLeaves(context, pos.add(1, 0, 2), context.getConfig().leafState);
        setLeaves(context, pos.add(-2, 0, 1), context.getConfig().leafState);
        setLeaves(context, pos.add(1, 0, -2), context.getConfig().leafState);
        setLeaves(context, pos.add(2, 0, -1), context.getConfig().leafState);
        setLeaves(context, pos.add(-1, 0, 2), context.getConfig().leafState);
        setLeaves(context, pos.add(-2, 0, -1), context.getConfig().leafState);
        setLeaves(context, pos.add(-1, 0, -2), context.getConfig().leafState);
        setLeaves(context, pos.add(2, 0, 2), context.getConfig().leafState);
        setLeaves(context, pos.add(-2, 0, 2), context.getConfig().leafState);
        setLeaves(context, pos.add(-2, 0, -2), context.getConfig().leafState);
        setLeaves(context, pos.add(2, 0, -2), context.getConfig().leafState);

        setLeaves(context, pos.add(3, 0, 0), context.getConfig().leafState);
        setLeaves(context, pos.add(0, 0, 3), context.getConfig().leafState);
        setLeaves(context, pos.add(-3, 0, 0), context.getConfig().leafState);
        setLeaves(context, pos.add(0, 0, -3), context.getConfig().leafState);
        setLeaves(context, pos.add(3, 0, 1), context.getConfig().leafState);
        setLeaves(context, pos.add(1, 0, 3), context.getConfig().leafState);
        setLeaves(context, pos.add(-3, 0, 1), context.getConfig().leafState);
        setLeaves(context, pos.add(1, 0, -3), context.getConfig().leafState);
        setLeaves(context, pos.add(3, 0, -1), context.getConfig().leafState);
        setLeaves(context, pos.add(-1, 0, 3), context.getConfig().leafState);
        setLeaves(context, pos.add(-3, 0, -1), context.getConfig().leafState);
        setLeaves(context, pos.add(-1, 0, -3), context.getConfig().leafState);

        if (!beSquare) {
            setLeaves(context, pos.add(4, 0, 0), context.getConfig().leafState);
            setLeaves(context, pos.add(0, 0, 4), context.getConfig().leafState);
            setLeaves(context, pos.add(-4, 0, 0), context.getConfig().leafState);
            setLeaves(context, pos.add(0, 0, -4), context.getConfig().leafState);
        }
    }

    public void generateFiveStar(FeatureContext<NTreeFeatureConfig> context, BlockPos pos, boolean beSquare) {
        /*
                    #
                  # # #
                # # # # #
              # # # # # # #
            # # # # # # # # #
          # # # # # o # # # # #
            # # # # # # # # #
              # # # # # # #
                # # # # #
                  # # #
                    #
         */
        setLeaves(context, pos.add(1, 0, 0), context.getConfig().leafState);
        setLeaves(context, pos.add(0, 0, 1), context.getConfig().leafState);
        setLeaves(context, pos.add(-1, 0, 0), context.getConfig().leafState);
        setLeaves(context, pos.add(0, 0, -1), context.getConfig().leafState);
        setLeaves(context, pos.add(-1, 0, -1), context.getConfig().leafState);
        setLeaves(context, pos.add(1, 0, 1), context.getConfig().leafState);
        setLeaves(context, pos.add(-1, 0, 1), context.getConfig().leafState);
        setLeaves(context, pos.add(1, 0, -1), context.getConfig().leafState);

        setLeaves(context, pos.add(2, 0, 0), context.getConfig().leafState);
        setLeaves(context, pos.add(0, 0, 2), context.getConfig().leafState);
        setLeaves(context, pos.add(-2, 0, 0), context.getConfig().leafState);
        setLeaves(context, pos.add(0, 0, -2), context.getConfig().leafState);
        setLeaves(context, pos.add(2, 0, 1), context.getConfig().leafState);
        setLeaves(context, pos.add(1, 0, 2), context.getConfig().leafState);
        setLeaves(context, pos.add(-2, 0, 1), context.getConfig().leafState);
        setLeaves(context, pos.add(1, 0, -2), context.getConfig().leafState);
        setLeaves(context, pos.add(2, 0, -1), context.getConfig().leafState);
        setLeaves(context, pos.add(-1, 0, 2), context.getConfig().leafState);
        setLeaves(context, pos.add(-2, 0, -1), context.getConfig().leafState);
        setLeaves(context, pos.add(-1, 0, -2), context.getConfig().leafState);
        setLeaves(context, pos.add(2, 0, 2), context.getConfig().leafState);
        setLeaves(context, pos.add(-2, 0, 2), context.getConfig().leafState);
        setLeaves(context, pos.add(-2, 0, -2), context.getConfig().leafState);
        setLeaves(context, pos.add(2, 0, -2), context.getConfig().leafState);

        setLeaves(context, pos.add(3, 0, 0), context.getConfig().leafState);
        setLeaves(context, pos.add(0, 0, 3), context.getConfig().leafState);
        setLeaves(context, pos.add(-3, 0, 0), context.getConfig().leafState);
        setLeaves(context, pos.add(0, 0, -3), context.getConfig().leafState);
        setLeaves(context, pos.add(3, 0, 1), context.getConfig().leafState);
        setLeaves(context, pos.add(1, 0, 3), context.getConfig().leafState);
        setLeaves(context, pos.add(-3, 0, 1), context.getConfig().leafState);
        setLeaves(context, pos.add(1, 0, -3), context.getConfig().leafState);
        setLeaves(context, pos.add(3, 0, -1), context.getConfig().leafState);
        setLeaves(context, pos.add(-1, 0, 3), context.getConfig().leafState);
        setLeaves(context, pos.add(-3, 0, -1), context.getConfig().leafState);
        setLeaves(context, pos.add(-1, 0, -3), context.getConfig().leafState);
        setLeaves(context, pos.add(3, 0, 2), context.getConfig().leafState);
        setLeaves(context, pos.add(2, 0, 3), context.getConfig().leafState);
        setLeaves(context, pos.add(-3, 0, 2), context.getConfig().leafState);
        setLeaves(context, pos.add(2, 0, -3), context.getConfig().leafState);
        setLeaves(context, pos.add(3, 0, -2), context.getConfig().leafState);
        setLeaves(context, pos.add(-2, 0, 3), context.getConfig().leafState);
        setLeaves(context, pos.add(-3, 0, -2), context.getConfig().leafState);
        setLeaves(context, pos.add(-2, 0, -3), context.getConfig().leafState);

        setLeaves(context, pos.add(4, 0, 0), context.getConfig().leafState);
        setLeaves(context, pos.add(0, 0, 4), context.getConfig().leafState);
        setLeaves(context, pos.add(-4, 0, 0), context.getConfig().leafState);
        setLeaves(context, pos.add(0, 0, -4), context.getConfig().leafState);
        setLeaves(context, pos.add(4, 0, 1), context.getConfig().leafState);
        setLeaves(context, pos.add(1, 0, 4), context.getConfig().leafState);
        setLeaves(context, pos.add(-4, 0, 1), context.getConfig().leafState);
        setLeaves(context, pos.add(1, 0, -4), context.getConfig().leafState);
        setLeaves(context, pos.add(4, 0, -1), context.getConfig().leafState);
        setLeaves(context, pos.add(-1, 0, 4), context.getConfig().leafState);
        setLeaves(context, pos.add(-4, 0, -1), context.getConfig().leafState);
        setLeaves(context, pos.add(-1, 0, -4), context.getConfig().leafState);

        if (!beSquare) {
            setLeaves(context, pos.add(5, 0, 0), context.getConfig().leafState);
            setLeaves(context, pos.add(0, 0, 5), context.getConfig().leafState);
            setLeaves(context, pos.add(-5, 0, 0), context.getConfig().leafState);
            setLeaves(context, pos.add(0, 0, -5), context.getConfig().leafState);
        }

    }


}
