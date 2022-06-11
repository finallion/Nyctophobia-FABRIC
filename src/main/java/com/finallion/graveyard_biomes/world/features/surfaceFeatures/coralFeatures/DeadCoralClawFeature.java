package com.finallion.graveyard_biomes.world.features.surfaceFeatures.coralFeatures;

import com.finallion.graveyard_biomes.world.features.surfaceFeatures.DeadCoralFeature;
import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DeadCoralClawFeature extends DeadCoralFeature {
    public DeadCoralClawFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    protected boolean generateCoral(WorldAccess world, Random random, BlockPos pos, BlockState state) {
        if (!this.generateCoralPiece(world, random, pos, state)) {
            return false;
        } else {
            Direction direction = Direction.Type.HORIZONTAL.random(world.getRandom());
            int i = random.nextInt(2) + 2;
            List<Direction> list = Lists.newArrayList(new Direction[]{direction, direction.rotateYClockwise(), direction.rotateYCounterclockwise()});
            Collections.shuffle(list, new java.util.Random());
            List<Direction> list2 = list.subList(0, i);
            Iterator var9 = list2.iterator();

            while(var9.hasNext()) {
                Direction direction2 = (Direction)var9.next();
                BlockPos.Mutable mutable = pos.mutableCopy();
                int j = random.nextInt(2) + 1;
                mutable.move(direction2);
                int k;
                Direction direction3;
                if (direction2 == direction) {
                    direction3 = direction;
                    k = random.nextInt(3) + 2;
                } else {
                    mutable.move(Direction.UP);
                    Direction[] directions = new Direction[]{direction2, Direction.UP};
                    direction3 = (Direction) Util.getRandom(directions, world.getRandom());
                    k = random.nextInt(3) + 3;
                }

                int directions;
                for(directions = 0; directions < j && this.generateCoralPiece(world, random, mutable, state); ++directions) {
                    mutable.move(direction3);
                }

                mutable.move(direction3.getOpposite());
                mutable.move(Direction.UP);

                for(directions = 0; directions < k; ++directions) {
                    mutable.move(direction);
                    if (!this.generateCoralPiece(world, random, mutable, state)) {
                        break;
                    }

                    if (random.nextFloat() < 0.25F) {
                        mutable.move(Direction.UP);
                    }
                }
            }

            return true;
        }
    }
}
