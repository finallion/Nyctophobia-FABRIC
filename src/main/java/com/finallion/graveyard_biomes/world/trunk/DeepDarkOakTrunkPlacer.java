package com.finallion.graveyard_biomes.world.trunk;

import com.finallion.graveyard_biomes.init.TGTrunkPlacer;
import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import javax.swing.tree.TreeNode;
import java.util.List;
import java.util.function.BiConsumer;

public class DeepDarkOakTrunkPlacer extends TrunkPlacer {
    public static final Codec<DeepDarkOakTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) -> {
        return fillTrunkPlacerFields(instance).apply(instance, DeepDarkOakTrunkPlacer::new);
    });

    public DeepDarkOakTrunkPlacer(int i, int j, int k) {
        super(i, j, k);
    }

    protected TrunkPlacerType<?> getType() {
        return TGTrunkPlacer.DEEP_DARK_OAK_TRUNK_PLACER;
    }

    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        List<FoliagePlacer.TreeNode> list = Lists.newArrayList();
        BlockPos blockPos = startPos.down();
        setToDirt(world, replacer, random, blockPos, config);
        setToDirt(world, replacer, random, blockPos.east(), config);
        setToDirt(world, replacer, random, blockPos.south(), config);
        setToDirt(world, replacer, random, blockPos.south().east(), config);
        setToDirt(world, replacer, random, blockPos.east().east(), config);
        setToDirt(world, replacer, random, blockPos.north().east(), config);
        setToDirt(world, replacer, random, blockPos.north(), config);
        setToDirt(world, replacer, random, blockPos.south().south().east(), config);
        setToDirt(world, replacer, random, blockPos.south().east().east(), config);
        setToDirt(world, replacer, random, blockPos.south().south(), config);
        setToDirt(world, replacer, random, blockPos.west(), config);
        setToDirt(world, replacer, random, blockPos.south().west(), config);

        int startPosX = startPos.getX();
        int startPosY = startPos.getY();
        int startPosZ = startPos.getZ();

        // lower extra trunk
        for (int i = -1; i <= 2; ++i) {
            for (int ii = -1; ii <= 2; ++ii) {
                // corner cases
                if ((i == -1 && ii == -1) || (i == -1 && ii == 2) || (i == 2 && ii == -1) || (i == 2 && ii == 2)) {
                    continue;
                }

                if ((i < 0 || i > 1 || ii < 0 || ii > 1)) {
                    int extraTrunkLength = random.nextInt(6) + 5;

                    for(int trunkCounter = 0; trunkCounter < extraTrunkLength; ++trunkCounter) {
                        this.getAndSetState(world, replacer, random, new BlockPos(startPosX + i, startPosY + trunkCounter, startPosZ + ii), config);
                    }
                }

            }
        }

        // main trunk
        for(int heightCounter = 0; heightCounter < height; ++heightCounter) {
            BlockPos blockPos2 = new BlockPos(startPosX, startPosY + heightCounter, startPosZ);
            if (TreeFeature.isAirOrLeaves(world, blockPos2)) {
                this.getAndSetState(world, replacer, random, blockPos2, config);
                this.getAndSetState(world, replacer, random, blockPos2.east(), config);
                this.getAndSetState(world, replacer, random, blockPos2.south(), config);
                this.getAndSetState(world, replacer, random, blockPos2.east().south(), config);
            }
        }

        // outwards reaching branches
        for (int i = 1; i <= 8; i++) {
            BlockPos.Mutable blockPos3 = new BlockPos.Mutable(startPosX, startPosY + height - 1, startPosZ);
            Direction[] branchDir = new Direction[2];
            if (i <= 2) {
                blockPos3.east();
                branchDir[0] = Direction.NORTH;
                branchDir[1] = Direction.EAST;
            } else if (i <= 4) {
                blockPos3.south();
                branchDir[0] = Direction.SOUTH;
                branchDir[1] = Direction.WEST;
            } else if (i <= 6) {
                blockPos3.east().south();
                branchDir[0] = Direction.EAST;
                branchDir[1] = Direction.SOUTH;
            } else {
                branchDir[0] = Direction.WEST;
                branchDir[1] = Direction.NORTH;
            }

            int branchLength = 5;
            for (int ii = 0; ii < branchLength; ii++) {
                blockPos3.move(Direction.UP);

                if (i % 2 == 0) {
                    blockPos3.move(branchDir[0]);
                } else {
                    blockPos3.move(branchDir[random.nextInt(2)]);
                }

                if (TreeFeature.canReplace(world, blockPos3)) {
                    this.getAndSetState(world, replacer, random, blockPos3, config);
                }

            }
            list.add(new FoliagePlacer.TreeNode(blockPos3.up(), 0, true));
        }

        // straight up branches
        for (int i = 1; i <= 4; i++) {
            BlockPos.Mutable blockPos3 = new BlockPos.Mutable(startPosX, startPosY + height - 1, startPosZ);
            Direction[] branchDir = new Direction[2];

            if (i <= 1) {
                blockPos3.east();
                branchDir[0] = Direction.EAST;
                branchDir[1] = Direction.NORTH;
            } else if (i <= 2) {
                blockPos3.south();
                branchDir[0] = Direction.SOUTH;
                branchDir[1] = Direction.WEST;
            } else if (i <= 3) {
                blockPos3.east().south();
                branchDir[0] = Direction.EAST;
                branchDir[1] = Direction.SOUTH;
            } else {
                branchDir[0] = Direction.WEST;
                branchDir[1] = Direction.NORTH;
            }

            int branchLength = 6;
            for (int ii = 0; ii < branchLength; ii++) {
                blockPos3.move(Direction.UP);
                if (random.nextInt(2) == 0) {
                    blockPos3.move(branchDir[random.nextInt(2)]);
                }

                if (TreeFeature.canReplace(world, blockPos3)) {
                    this.getAndSetState(world, replacer, random, blockPos3, config);
                }

            }
            list.add(new FoliagePlacer.TreeNode(blockPos3.up(), 0, true));
        }
        /*
        int numberOfBranches = 11;
        for (int i = 0; i < numberOfBranches; i++) {
            BlockPos.Mutable blockPos3 = new BlockPos.Mutable(startPosX, startPosY + height - 1, startPosZ);
            Direction[] branchDir = new Direction[2];

            int branchLength;
            if (i % 3 == 0) {
                branchLength = random.nextInt(4) + 5;
            } else {
                branchLength = random.nextInt(4) + 8;
            }

            int minHeightForLeaves = 4;

            // generate branches only outwards facing from trunk
            if (i < 3) {
                blockPos3.east();
                branchDir[0] = Direction.EAST;
                branchDir[1] = Direction.NORTH;
            } else if (i < 6) {
                blockPos3.south();
                branchDir[0] = Direction.SOUTH;
                branchDir[1] = Direction.WEST;
            } else if (i < 9) {
                blockPos3.east().south();
                branchDir[0] = Direction.EAST;
                branchDir[1] = Direction.SOUTH;
            } else {
                branchDir[0] = Direction.WEST;
                branchDir[1] = Direction.NORTH;
            }

            for (int ii = 0; ii < branchLength; ii++) {
                if (random.nextInt(3) == 0 || i % 3 == 0) {
                    blockPos3.move(Direction.UP);
                }
                if (random.nextInt(2) == 0) {
                    blockPos3.move(branchDir[random.nextInt(2)]);
                }

                if (TreeFeature.canReplace(world, blockPos3)) {
                    this.getAndSetState(world, replacer, random, blockPos3, config);
                }

                if (ii > minHeightForLeaves + random.nextInt(6)) {
                    //list.add(new FoliagePlacer.TreeNode(blockPos3.up(), 0, true));
                }
            }
            //list.add(new FoliagePlacer.TreeNode(blockPos3.up(), 0, true));
        }

         */


        return list;
    }
}
