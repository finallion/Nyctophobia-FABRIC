package com.finallion.nyctophobia.world.surfacerules;


import com.finallion.nyctophobia.init.NBiomes;
import com.finallion.nyctophobia.world.noise.NNoiseParameters;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class NSurfaceRules {
    //private static final MaterialRules.MaterialRule TG_MOSS_BLOCK = block(TGBlocks.TG_MOSS_BLOCK);
    private static final MaterialRules.MaterialRule MOSS_BLOCK = block(Blocks.MOSS_BLOCK);
    private static final MaterialRules.MaterialRule ROOTED_DIRT = block(Blocks.ROOTED_DIRT);
    private static final MaterialRules.MaterialRule COARSE_DIRT = block(Blocks.COARSE_DIRT);
    private static final MaterialRules.MaterialRule SOUL_SAND = block(Blocks.SOUL_SAND);
    private static final MaterialRules.MaterialRule SOUL_SOIL = block(Blocks.SOUL_SOIL);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = block(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule WATER = block(Blocks.WATER);
    private static final MaterialRules.MaterialRule CALCITE = block(Blocks.CALCITE);
    private static final MaterialRules.MaterialRule TUFF = block(Blocks.TUFF);
    private static final MaterialRules.MaterialRule SAND = block(Blocks.SAND);
    private static final MaterialRules.MaterialRule SANDSTONE = block(Blocks.SANDSTONE);
    private static final MaterialRules.MaterialRule BONE_BLOCK = block(Blocks.BONE_BLOCK.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y).getBlock());
    private static final MaterialRules.MaterialRule NETHER_WART = block(Blocks.NETHER_WART_BLOCK);
    private static final MaterialRules.MaterialRule MOSSY_COBBLESTONE = block(Blocks.MOSSY_COBBLESTONE);
    private static final MaterialRules.MaterialRule GREEN_TERRACOTTA = block(Blocks.GREEN_TERRACOTTA);
    private static final MaterialRules.MaterialRule DIRT = block(Blocks.DIRT);
    private static final MaterialRules.MaterialRule AIR = block(Blocks.AIR);
    private static final MaterialRules.MaterialRule STONE = block(Blocks.STONE);
    private static final MaterialRules.MaterialRule DEEPSLATE = block(Blocks.DEEPSLATE);

    public static MaterialRules.MaterialRule makeRules() {
        // TODO: take material rules together for example STONE_DEPTH_FLOOR
        // TODO: remove redundant boxing

        MaterialRules.MaterialRule noiseGrass = MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR,
                        MaterialRules.sequence(MaterialRules.condition(MaterialRules.aboveY(YOffset.fixed(62), 0),
                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, -0.2, 0.0), GRASS_BLOCK)))));

        MaterialRules.MaterialRule noiseGrass93 = MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR,
                        MaterialRules.sequence(MaterialRules.condition(MaterialRules.aboveY(YOffset.fixed(93), 3),
                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, -0.2, 0.0), GRASS_BLOCK)))));

        MaterialRules.MaterialRule noiseCoarseDirt = MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR,
                        MaterialRules.sequence(MaterialRules.condition(MaterialRules.aboveY(YOffset.fixed(62), 0),
                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, 0.2, 0.4), COARSE_DIRT)))));

        MaterialRules.MaterialRule noiseMossCobble =
                MaterialRules.sequence(
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR,
                                MaterialRules.sequence(
                                        MaterialRules.condition(MaterialRules.aboveY(YOffset.fixed(62), 0),
                                                MaterialRules.sequence(
                                                        MaterialRules.sequence(
                                                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE_SWAMP, -0.4D, 0.2D), MOSS_BLOCK),
                                                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.PATCH, 0.5D, 0.6D), MOSSY_COBBLESTONE)),
                                                        MaterialRules.sequence(
                                                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE_SWAMP, -0.4D, 0.3D), GRASS_BLOCK),
                                                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE_SWAMP, -0.5D, 0.5D), COARSE_DIRT),
                                                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.NETHER_WART, -1.0D, 1.0D), ROOTED_DIRT),
                                                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.CLAY_BANDS_OFFSET, -0.3D, 0.4D), MOSSY_COBBLESTONE),
                                                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.PATCH, -0.3D, 0.3D), MOSSY_COBBLESTONE)),
                                                        MaterialRules.sequence(
                                                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, 0.2D, 0.5D), GRASS_BLOCK),
                                                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.PATCH, -0.8D, 0.8D), ROOTED_DIRT)))),
                                        MaterialRules.sequence(
                                                MaterialRules.condition(MaterialRules.aboveY(YOffset.fixed(61), 0), DIRT),
                                                MaterialRules.condition(MaterialRules.aboveY(YOffset.fixed(0), 0), STONE),
                                                MaterialRules.condition(MaterialRules.aboveY(YOffset.fixed(-64), 0), DEEPSLATE)
                                        ))
                                        //MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, -2.0, 2.0), AIR))
                                        ));

        MaterialRules.MaterialRule noiseErosion = MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, // YOffset.fixed(62)
                        MaterialRules.sequence(MaterialRules.condition(MaterialRules.aboveY(YOffset.fixed(93), 0),
                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, -0.1, 1.15),
                                        MaterialRules.sequence(
                                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, -0.1, 0.15), COARSE_DIRT),
                                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, 0.15, 0.5), SOUL_SAND),
                                                //MaterialRules.sequence(MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.ICE, -0.2, 0.2), SOUL_SOIL), SOUL_SAND)),
                                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, 0.5, 0.75), SOUL_SOIL),
                                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, 0.75, 0.9), SOUL_SAND),
                                                //MaterialRules.sequence(MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.ICE, -0.2, 0.2), SOUL_SOIL), SOUL_SAND)),
                                                MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, 0.9, 1.15), COARSE_DIRT)
                                        ))))));

        MaterialRules.MaterialRule noiseMoss = MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR,
                        MaterialRules.sequence(MaterialRules.condition(MaterialRules.aboveY(YOffset.fixed(62), 0),
                                MaterialRules.condition(MaterialRules.noiseThreshold(NNoiseParameters.HAUNTED_FOREST_NOISE, -0.2, 2.0), MOSS_BLOCK)))));

        MaterialRules.MaterialRule noiseMoss93 = MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR,
                        MaterialRules.sequence(MaterialRules.condition(MaterialRules.aboveY(YOffset.fixed(93), 2),
                                MaterialRules.condition(MaterialRules.noiseThreshold(NNoiseParameters.HAUNTED_FOREST_NOISE, -0.2, 2.0), MOSS_BLOCK)))));


        /* ACTUAL BIOME SURFACE */
        MaterialRules.MaterialCondition above62 = MaterialRules.aboveY(YOffset.fixed(62), 0);
        MaterialRules.MaterialCondition above63_0 = MaterialRules.aboveY(YOffset.fixed(63), 0);
        MaterialRules.MaterialRule waterErosionRule = MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR,
                        MaterialRules.sequence(MaterialRules.condition(
                                        MaterialRules.biome(NBiomes.HAUNTED_LAKES_KEY), MaterialRules.condition(above62,
                                                MaterialRules.condition(MaterialRules.not(above63_0),
                                                        MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE_SWAMP, 1.0D), WATER
                                                        )
                                                )
                                        )
                                )
                        )
                ));

        MaterialRules.MaterialCondition above68_0 = MaterialRules.aboveY(YOffset.fixed(68), 0);

        MaterialRules.MaterialRule erodedHauntedForestRule =
                MaterialRules.condition(MaterialRules.biome(NBiomes.ERODED_HAUNTED_FOREST_KEY),
                        MaterialRules.sequence(
                                noiseGrass93,
                                noiseErosion,
                                noiseMoss93));

        MaterialRules.MaterialRule deepDarkForestRule =
                MaterialRules.condition(MaterialRules.biome(NBiomes.DEEP_DARK_FOREST), noiseMossCobble);

        MaterialRules.MaterialRule hauntedForestRule =
                MaterialRules.sequence(
                        MaterialRules.condition(MaterialRules.biome(NBiomes.HAUNTED_FOREST_KEY, NBiomes.HAUNTED_LAKES_KEY),
                                MaterialRules.sequence(
                                        noiseGrass,
                                        noiseCoarseDirt,
                                        noiseMoss)),
                        MaterialRules.condition(MaterialRules.biome(NBiomes.HAUNTED_LAKES_KEY), waterErosionRule));


        MaterialRules.MaterialRule ancientReefRule =
                MaterialRules.sequence(
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH,
                                MaterialRules.sequence(
                                        MaterialRules.condition(MaterialRules.aboveY(YOffset.fixed(53), 2),
                                                MaterialRules.sequence(
                                                        MaterialRules.condition(above63_0, MaterialRules.condition(
                                                                MaterialRules.not(above68_0), MaterialRules.condition(
                                                                        MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE_SWAMP, -1.0D, -0.55), WATER))),
                                                        MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, -0.1D, 0.2D), CALCITE),
                                                        MaterialRules.condition(MaterialRules.steepSlope(), TUFF),
                                                        MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, 0.2D, 0.5D), SANDSTONE),
                                                        SAND
                                                )
                                        ))));


        return MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.biome(NBiomes.ERODED_HAUNTED_FOREST_KEY), erodedHauntedForestRule),
                MaterialRules.condition(MaterialRules.biome(NBiomes.HAUNTED_LAKES_KEY), hauntedForestRule),
                MaterialRules.condition(MaterialRules.biome(NBiomes.HAUNTED_FOREST_KEY), hauntedForestRule),
                MaterialRules.condition(MaterialRules.biome(NBiomes.ANCIENT_DEAD_CORAL_REEF_KEY), ancientReefRule),
                MaterialRules.condition(MaterialRules.biome(NBiomes.DEEP_DARK_FOREST), deepDarkForestRule)
        );
    }

    private static MaterialRules.MaterialRule block(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }

}
