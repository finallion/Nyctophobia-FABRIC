package com.finallion.graveyard_biomes.init;

import com.finallion.graveyard_biomes.TheGraveyardBiomes;
import com.finallion.graveyard_biomes.world.features.surfaceFeatures.*;
import com.finallion.graveyard_biomes.world.features.surfaceFeatures.coralFeatures.DeadCoralClawFeature;
import com.finallion.graveyard_biomes.world.features.surfaceFeatures.coralFeatures.DeadCoralMushroomFeature;
import com.finallion.graveyard_biomes.world.features.surfaceFeatures.coralFeatures.DeadCoralTreeFeature;
import com.finallion.graveyard_biomes.world.features.trees.*;
import com.finallion.graveyard_biomes.world.features.trees.config.TGTreeFeatureConfig;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class TGFeatures {


    public static void init() {

    }

    // tree features
    public static final Feature<TGTreeFeatureConfig> SMALL_SPRUCE_TREE_01 = registerFeature("small_spruce_tree_01", new SmallSpruceTree01(TGTreeFeatureConfig.CODEC));
    public static final Feature<TGTreeFeatureConfig> SMALL_SPRUCE_TREE_02 = registerFeature("small_spruce_tree_02", new SmallSpruceTree02(TGTreeFeatureConfig.CODEC));
    public static final Feature<TGTreeFeatureConfig> SMALL_SPRUCE_TREE_03 = registerFeature("small_spruce_tree_03", new SmallSpruceTree03(TGTreeFeatureConfig.CODEC));
    public static final Feature<TGTreeFeatureConfig> SMALL_SPRUCE_TREE_04 = registerFeature("small_spruce_tree_04", new SmallSpruceTree04(TGTreeFeatureConfig.CODEC));
    public static final Feature<TGTreeFeatureConfig> SMALL_SPRUCE_TREE_05 = registerFeature("small_spruce_tree_05", new SmallSpruceTree05(TGTreeFeatureConfig.CODEC));
    public static final Feature<TGTreeFeatureConfig> SMALL_SPRUCE_TREE_06 = registerFeature("small_spruce_tree_06", new SmallSpruceTree06(TGTreeFeatureConfig.CODEC));
    public static final Feature<TGTreeFeatureConfig> SMALL_BENT_SPRUCE_TREE_01 = registerFeature("small_bent_spruce_tree_01", new SmallBentSpruceTree01(TGTreeFeatureConfig.CODEC));
    public static final Feature<TGTreeFeatureConfig> FALLEN_SPRUCE_TREE = registerFeature("fallen_spruce_tree", new FallenSpruceTree(TGTreeFeatureConfig.CODEC));
    public static final Feature<TGTreeFeatureConfig> LARGE_BENT_SPRUCE_TREE_01 = registerFeature("large_bent_spruce_tree_01", new LargeBentSpruceTree01(TGTreeFeatureConfig.CODEC));
    public static final Feature<TGTreeFeatureConfig> LARGE_BENT_SPRUCE_TREE_02 = registerFeature("large_bent_spruce_tree_02", new LargeBentSpruceTree02(TGTreeFeatureConfig.CODEC));
    public static final Feature<TGTreeFeatureConfig> LARGE_SPRUCE_TREE_01 = registerFeature("large_spruce_tree_01", new LargeSpruceTree01(TGTreeFeatureConfig.CODEC));
    public static final Feature<TGTreeFeatureConfig> LARGE_SPRUCE_TREE_02 = registerFeature("large_spruce_tree_02", new LargeSpruceTree02(TGTreeFeatureConfig.CODEC));
    public static final Feature<TGTreeFeatureConfig> LARGE_SPRUCE_TREE_03 = registerFeature("large_spruce_tree_03", new LargeSpruceTree03(TGTreeFeatureConfig.CODEC));

    // other features
    public static final Feature<DefaultFeatureConfig> MOSS_CARPET_FEATURE = registerFeature("moss_carpet_feature", new MossCarpetFeature(DefaultFeatureConfig.CODEC));
    public static final Feature<DefaultFeatureConfig> COBWEB_FEATURE = registerFeature("cobweb_feature", new CobwebFeature(DefaultFeatureConfig.CODEC));
    public static final Feature<DefaultFeatureConfig> BUSH_FEATURE = registerFeature("bush_feature", new BushFeature(DefaultFeatureConfig.CODEC, (LeavesBlock) Blocks.SPRUCE_LEAVES));
    public static final Feature<DefaultFeatureConfig> DEEP_DARK_FOREST_BUSH_FEATURE = registerFeature("deep_dark_forest_bush_feature", new BushFeature(DefaultFeatureConfig.CODEC, (LeavesBlock) Blocks.DARK_OAK_LEAVES));
    public static final Feature<DefaultFeatureConfig> SOUL_LIGHT_FEATURE = registerFeature("soul_light_feature", new SoulLightFeature(DefaultFeatureConfig.CODEC));
    public static final Feature<DefaultFeatureConfig> FALLEN_TREE_FEATURE = registerFeature("fallen_tree_feature", new FallenTreeFeature(DefaultFeatureConfig.CODEC));
    public static final Feature<DefaultFeatureConfig> DEAD_CORAL_TREE_FEATURE = registerFeature("dead_coral_tree_feature", new DeadCoralTreeFeature(DefaultFeatureConfig.CODEC));
    public static final Feature<DefaultFeatureConfig> DEAD_CORAL_CLAW_FEATURE = registerFeature("dead_coral_claw_feature", new DeadCoralClawFeature(DefaultFeatureConfig.CODEC));
    public static final Feature<DefaultFeatureConfig> DEAD_CORAL_MUSHROOM_FEATURE = registerFeature("dead_coral_mushroom_feature", new DeadCoralMushroomFeature(DefaultFeatureConfig.CODEC));
    public static final Feature<DefaultFeatureConfig> DEAD_CORAL_PATCH_FEATURE = registerFeature("dead_coral_patch_feature", new DeadCoralPatchFeature(DefaultFeatureConfig.CODEC));


    private static <C extends FeatureConfig, F extends Feature<C>> F registerFeature(String id, F feature) {
        return Registry.register(Registries.FEATURE, new Identifier(TheGraveyardBiomes.MOD_ID, id), feature);
    }
}
