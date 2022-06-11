package com.finallion.graveyard_biomes.init;

import com.finallion.graveyard_biomes.TheGraveyardBiomes;
import com.finallion.graveyard_biomes.world.features.surfaceFeatures.*;
import com.finallion.graveyard_biomes.world.features.surfaceFeatures.coralFeatures.DeadCoralClawFeature;
import com.finallion.graveyard_biomes.world.features.surfaceFeatures.coralFeatures.DeadCoralMushroomFeature;
import com.finallion.graveyard_biomes.world.features.surfaceFeatures.coralFeatures.DeadCoralTreeFeature;
import com.finallion.graveyard_biomes.world.features.trees.*;
import com.finallion.graveyard_biomes.world.features.trees.config.TGTreeFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.registry.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

import java.util.List;

public class TGConfiguredFeatures {


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
    private static final Feature<DefaultFeatureConfig> MOSS_CARPET_FEATURE = registerFeature("moss_carpet_feature", new MossCarpetFeature(DefaultFeatureConfig.CODEC));
    private static final Feature<DefaultFeatureConfig> COBWEB_FEATURE = registerFeature("cobweb_feature", new CobwebFeature(DefaultFeatureConfig.CODEC));
    private static final Feature<DefaultFeatureConfig> BUSH_FEATURE = registerFeature("bush_feature", new BushFeature(DefaultFeatureConfig.CODEC));
    private static final Feature<DefaultFeatureConfig> SOUL_LIGHT_FEATURE = registerFeature("soul_light_feature", new SoulLightFeature(DefaultFeatureConfig.CODEC));
    private static final Feature<DefaultFeatureConfig> FALLEN_TREE_FEATURE = registerFeature("fallen_tree_feature", new FallenTreeFeature(DefaultFeatureConfig.CODEC));
    private static final Feature<DefaultFeatureConfig> DEAD_CORAL_TREE_FEATURE = registerFeature("dead_coral_tree_feature", new DeadCoralTreeFeature(DefaultFeatureConfig.CODEC));
    private static final Feature<DefaultFeatureConfig> DEAD_CORAL_CLAW_FEATURE = registerFeature("dead_coral_claw_feature", new DeadCoralClawFeature(DefaultFeatureConfig.CODEC));
    private static final Feature<DefaultFeatureConfig> DEAD_CORAL_MUSHROOM_FEATURE = registerFeature("dead_coral_mushroom_feature", new DeadCoralMushroomFeature(DefaultFeatureConfig.CODEC));
    private static final Feature<DefaultFeatureConfig> DEAD_CORAL_PATCH_FEATURE = registerFeature("dead_coral_patch_feature", new DeadCoralPatchFeature(DefaultFeatureConfig.CODEC));

    // configured features registry keys
    public static final RegistryEntry<ConfiguredFeature<DefaultFeatureConfig, ?>> MOSS_CARPET_FEATURE_CONFIG = registerConfiguredFeature("moss_carpet_feature", MOSS_CARPET_FEATURE, FeatureConfig.DEFAULT);
    public static final RegistryEntry<ConfiguredFeature<DefaultFeatureConfig, ?>> COBWEB_FEATURE_CONFIG = registerConfiguredFeature("cobweb_feature", COBWEB_FEATURE, FeatureConfig.DEFAULT);
    public static final RegistryEntry<ConfiguredFeature<DefaultFeatureConfig, ?>> BUSH_FEATURE_CONFIG = registerConfiguredFeature("bush_feature", BUSH_FEATURE, FeatureConfig.DEFAULT);
    public static final RegistryEntry<ConfiguredFeature<DefaultFeatureConfig, ?>> SOUL_LIGHT_FEATURE_CONFIG = registerConfiguredFeature("soul_light_feature", SOUL_LIGHT_FEATURE, FeatureConfig.DEFAULT);
    public static final RegistryEntry<ConfiguredFeature<DefaultFeatureConfig, ?>> FALLEN_TREE_FEATURE_CONFIG = registerConfiguredFeature("fallen_tree_feature", FALLEN_TREE_FEATURE, FeatureConfig.DEFAULT);
    public static final RegistryEntry<ConfiguredFeature<DefaultFeatureConfig, ?>> DEAD_CORAL_PATCH_FEATURE_CONFIG = registerConfiguredFeature("dead_coral_patch_feature", DEAD_CORAL_PATCH_FEATURE, FeatureConfig.DEFAULT);

    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> SMALL_SPRUCE_TREE_01_STRIPPED_CONFIG = registerConfiguredFeature("small_spruce_tree_stripped_01", SMALL_SPRUCE_TREE_01, new TGTreeFeatureConfig(Blocks.STRIPPED_SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> SMALL_SPRUCE_TREE_01_CONFIG = registerConfiguredFeature("small_spruce_tree_01", SMALL_SPRUCE_TREE_01, new TGTreeFeatureConfig(Blocks.SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> SMALL_SPRUCE_TREE_02_STRIPPED_CONFIG = registerConfiguredFeature("small_spruce_tree_stripped_02", SMALL_SPRUCE_TREE_02, new TGTreeFeatureConfig(Blocks.STRIPPED_SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> SMALL_SPRUCE_TREE_02_CONFIG = registerConfiguredFeature("small_spruce_tree_02", SMALL_SPRUCE_TREE_02, new TGTreeFeatureConfig(Blocks.SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> SMALL_SPRUCE_TREE_03_STRIPPED_CONFIG = registerConfiguredFeature("small_spruce_tree_stripped_03", SMALL_SPRUCE_TREE_03, new TGTreeFeatureConfig(Blocks.STRIPPED_SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> SMALL_SPRUCE_TREE_03_CONFIG = registerConfiguredFeature("small_spruce_tree_03", SMALL_SPRUCE_TREE_03, new TGTreeFeatureConfig(Blocks.SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> SMALL_SPRUCE_TREE_04_STRIPPED_CONFIG = registerConfiguredFeature("small_spruce_tree_stripped_04", SMALL_SPRUCE_TREE_04, new TGTreeFeatureConfig(Blocks.STRIPPED_SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> SMALL_SPRUCE_TREE_04_CONFIG = registerConfiguredFeature("small_spruce_tree_04", SMALL_SPRUCE_TREE_04, new TGTreeFeatureConfig(Blocks.SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> SMALL_SPRUCE_TREE_05_STRIPPED_CONFIG = registerConfiguredFeature("small_spruce_tree_stripped_05", SMALL_SPRUCE_TREE_05, new TGTreeFeatureConfig(Blocks.STRIPPED_SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> SMALL_SPRUCE_TREE_05_CONFIG = registerConfiguredFeature("small_spruce_tree_05", SMALL_SPRUCE_TREE_05, new TGTreeFeatureConfig(Blocks.SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> SMALL_SPRUCE_TREE_06_STRIPPED_CONFIG = registerConfiguredFeature("small_spruce_tree_stripped_06", SMALL_SPRUCE_TREE_06, new TGTreeFeatureConfig(Blocks.STRIPPED_SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> SMALL_SPRUCE_TREE_06_CONFIG = registerConfiguredFeature("small_spruce_tree_06", SMALL_SPRUCE_TREE_06, new TGTreeFeatureConfig(Blocks.SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> SMALL_BENT_SPRUCE_TREE_01_STRIPPED_CONFIG = registerConfiguredFeature("small_bent_spruce_tree_stripped_01", SMALL_BENT_SPRUCE_TREE_01, new TGTreeFeatureConfig(Blocks.STRIPPED_SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> SMALL_BENT_SPRUCE_TREE_01_CONFIG = registerConfiguredFeature("small_bent_spruce_tree_01", SMALL_BENT_SPRUCE_TREE_01, new TGTreeFeatureConfig(Blocks.SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> FALLEN_SPRUCE_TREE_STRIPPED_CONFIG = registerConfiguredFeature("fallen_spruce_stripped_tree", FALLEN_SPRUCE_TREE, new TGTreeFeatureConfig(Blocks.STRIPPED_SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> FALLEN_SPRUCE_TREE_CONFIG = registerConfiguredFeature("fallen_spruce_tree", FALLEN_SPRUCE_TREE, new TGTreeFeatureConfig(Blocks.SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> LARGE_SPRUCE_TREE_01_STRIPPED_CONFIG = registerConfiguredFeature("large_spruce_tree_stripped_01", LARGE_SPRUCE_TREE_01, new TGTreeFeatureConfig(Blocks.STRIPPED_SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> LARGE_SPRUCE_TREE_01_CONFIG = registerConfiguredFeature("large_spruce_tree_01", LARGE_SPRUCE_TREE_01, new TGTreeFeatureConfig(Blocks.SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> LARGE_SPRUCE_TREE_02_STRIPPED_CONFIG = registerConfiguredFeature("large_spruce_tree_stripped_02", LARGE_SPRUCE_TREE_02, new TGTreeFeatureConfig(Blocks.STRIPPED_SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> LARGE_SPRUCE_TREE_02_CONFIG = registerConfiguredFeature("large_spruce_tree_02", LARGE_SPRUCE_TREE_02, new TGTreeFeatureConfig(Blocks.SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> LARGE_SPRUCE_TREE_03_STRIPPED_CONFIG = registerConfiguredFeature("large_spruce_tree_stripped_03", LARGE_SPRUCE_TREE_03, new TGTreeFeatureConfig(Blocks.STRIPPED_SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> LARGE_SPRUCE_TREE_03_CONFIG = registerConfiguredFeature("large_spruce_tree_03", LARGE_SPRUCE_TREE_03, new TGTreeFeatureConfig(Blocks.SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> LARGE_BENT_SPRUCE_TREE_01_STRIPPED_CONFIG = registerConfiguredFeature("large_bent_spruce_tree_stripped_01", LARGE_BENT_SPRUCE_TREE_01, new TGTreeFeatureConfig(Blocks.STRIPPED_SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> LARGE_BENT_SPRUCE_TREE_01_CONFIG = registerConfiguredFeature("large_bent_spruce_tree_01", LARGE_BENT_SPRUCE_TREE_01, new TGTreeFeatureConfig(Blocks.SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> LARGE_BENT_SPRUCE_TREE_02_STRIPPED_CONFIG = registerConfiguredFeature("large_bent_spruce_tree_stripped_02", LARGE_BENT_SPRUCE_TREE_02, new TGTreeFeatureConfig(Blocks.STRIPPED_SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<TGTreeFeatureConfig, ?>> LARGE_BENT_SPRUCE_TREE_02_CONFIG = registerConfiguredFeature("large_bent_spruce_tree_02", LARGE_BENT_SPRUCE_TREE_02, new TGTreeFeatureConfig(Blocks.SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()));


    // placed features
    public static RegistryEntry<PlacedFeature> MOSS_CARPET_PLACED_FEATURE = registerPlacedFeature("moss_carpet_feature", MOSS_CARPET_FEATURE_CONFIG, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, CountPlacementModifier.of(100));
    public static RegistryEntry<PlacedFeature> COBWEB_PLACED_FEATURE = registerPlacedFeature("cobweb_feature", COBWEB_FEATURE_CONFIG, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, CountPlacementModifier.of(40));
    public static RegistryEntry<PlacedFeature> BUSH_PLACED_FEATURE = registerPlacedFeature("bush_feature", BUSH_FEATURE_CONFIG, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, CountPlacementModifier.of(35));
    public static RegistryEntry<PlacedFeature> SOUL_LIGHT_PLACED_FEATURE = registerPlacedFeature("soul_light_feature", SOUL_LIGHT_FEATURE_CONFIG, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, CountPlacementModifier.of(100));
    public static RegistryEntry<PlacedFeature> FALLEN_TREE_PLACED_FEATURE = registerPlacedFeature("fallen_tree_feature", FALLEN_TREE_FEATURE_CONFIG, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, CountPlacementModifier.of(20));
    public static RegistryEntry<PlacedFeature> DEAD_CORAL_PATCH_PLACED_FEATURE = registerPlacedFeature("dead_coral_patch_feature", DEAD_CORAL_PATCH_FEATURE_CONFIG, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, CountPlacementModifier.of(35));

    // configured tree feature collections
    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> HAUNTED_FOREST_TREES = registerConfiguredFeature("haunted_forest_trees", Feature.RANDOM_SELECTOR,
            new RandomFeatureConfig(List.of(
                    new RandomFeatureEntry(PlacedFeatures.createEntry(SMALL_SPRUCE_TREE_01_CONFIG, new PlacementModifier[0]), 0.25F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(SMALL_SPRUCE_TREE_02_CONFIG, new PlacementModifier[0]), 0.25F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(SMALL_SPRUCE_TREE_03_CONFIG, new PlacementModifier[0]), 0.375F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(SMALL_SPRUCE_TREE_04_CONFIG, new PlacementModifier[0]), 0.1F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(SMALL_SPRUCE_TREE_05_CONFIG, new PlacementModifier[0]), 0.1F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(SMALL_SPRUCE_TREE_06_CONFIG, new PlacementModifier[0]), 0.1F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(SMALL_BENT_SPRUCE_TREE_01_CONFIG, new PlacementModifier[0]), 0.1F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(FALLEN_SPRUCE_TREE_CONFIG, new PlacementModifier[0]), 0.1F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(LARGE_SPRUCE_TREE_01_CONFIG, new PlacementModifier[0]), 0.25F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(LARGE_SPRUCE_TREE_02_CONFIG, new PlacementModifier[0]), 0.1F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(LARGE_SPRUCE_TREE_03_CONFIG, new PlacementModifier[0]), 0.1F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(SMALL_SPRUCE_TREE_01_STRIPPED_CONFIG, new PlacementModifier[0]), 0.25F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(SMALL_SPRUCE_TREE_02_STRIPPED_CONFIG, new PlacementModifier[0]), 0.25F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(SMALL_SPRUCE_TREE_03_STRIPPED_CONFIG, new PlacementModifier[0]), 0.375F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(SMALL_SPRUCE_TREE_04_STRIPPED_CONFIG, new PlacementModifier[0]), 0.1F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(SMALL_SPRUCE_TREE_05_STRIPPED_CONFIG, new PlacementModifier[0]), 0.1F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(SMALL_SPRUCE_TREE_06_STRIPPED_CONFIG, new PlacementModifier[0]), 0.1F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(SMALL_BENT_SPRUCE_TREE_01_STRIPPED_CONFIG, new PlacementModifier[0]), 0.1F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(FALLEN_SPRUCE_TREE_STRIPPED_CONFIG, new PlacementModifier[0]), 0.1F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(LARGE_SPRUCE_TREE_01_STRIPPED_CONFIG, new PlacementModifier[0]), 0.25F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(LARGE_SPRUCE_TREE_02_STRIPPED_CONFIG, new PlacementModifier[0]), 0.1F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(LARGE_SPRUCE_TREE_03_STRIPPED_CONFIG, new PlacementModifier[0]), 0.1F)),
                    TreePlacedFeatures.SPRUCE_CHECKED)
    );


    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> ERODED_HAUNTED_FOREST_TREES = registerConfiguredFeature("eroded_haunted_forest_trees", Feature.RANDOM_SELECTOR,
            new RandomFeatureConfig(List.of(
                    new RandomFeatureEntry(PlacedFeatures.createEntry(SMALL_BENT_SPRUCE_TREE_01_CONFIG, new PlacementModifier[0]), 0.1F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(FALLEN_SPRUCE_TREE_CONFIG, new PlacementModifier[0]), 0.0075F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(LARGE_BENT_SPRUCE_TREE_01_CONFIG, new PlacementModifier[0]), 0.1F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(LARGE_BENT_SPRUCE_TREE_02_CONFIG, new PlacementModifier[0]), 0.1F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(LARGE_SPRUCE_TREE_01_CONFIG, new PlacementModifier[0]), 0.5F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(LARGE_SPRUCE_TREE_02_CONFIG, new PlacementModifier[0]), 0.1F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(LARGE_SPRUCE_TREE_03_CONFIG, new PlacementModifier[0]), 0.1F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(SMALL_BENT_SPRUCE_TREE_01_STRIPPED_CONFIG, new PlacementModifier[0]), 0.1F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(FALLEN_SPRUCE_TREE_STRIPPED_CONFIG, new PlacementModifier[0]), 0.0075F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(LARGE_BENT_SPRUCE_TREE_01_STRIPPED_CONFIG, new PlacementModifier[0]), 0.1F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(LARGE_BENT_SPRUCE_TREE_02_STRIPPED_CONFIG, new PlacementModifier[0]), 0.1F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(LARGE_SPRUCE_TREE_01_STRIPPED_CONFIG, new PlacementModifier[0]), 0.5F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(LARGE_SPRUCE_TREE_02_STRIPPED_CONFIG, new PlacementModifier[0]), 0.1F),
                    new RandomFeatureEntry(PlacedFeatures.createEntry(LARGE_SPRUCE_TREE_03_STRIPPED_CONFIG, new PlacementModifier[0]), 0.1F)),
                    TreePlacedFeatures.SPRUCE_CHECKED)
    );

    public static final RegistryEntry<ConfiguredFeature<SimpleRandomFeatureConfig, ?>> ANCIENT_DEAD_REEF_VEGETATION = registerConfiguredFeature("ancient_dead_reef_vegetation", Feature.SIMPLE_RANDOM_SELECTOR,
            new SimpleRandomFeatureConfig(RegistryEntryList.of(
                    PlacedFeatures.createEntry(DEAD_CORAL_TREE_FEATURE, FeatureConfig.DEFAULT, new PlacementModifier[0]),
                    PlacedFeatures.createEntry(DEAD_CORAL_CLAW_FEATURE, FeatureConfig.DEFAULT, new PlacementModifier[0]),
                    PlacedFeatures.createEntry(DEAD_CORAL_MUSHROOM_FEATURE, FeatureConfig.DEFAULT, new PlacementModifier[0]))));

    public static RegistryEntry<PlacedFeature> ERODED_HAUNTED_FOREST_TREES_PLACED_FEATURE = registerPlacedFeature("eroded_haunted_forest_trees", ERODED_HAUNTED_FOREST_TREES, PlacedFeatures.createCountExtraModifier(10, 0.1F, 1), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
    public static RegistryEntry<PlacedFeature> HAUNTED_FOREST_TREES_PLACED_FEATURE = registerPlacedFeature("haunted_forest_trees", HAUNTED_FOREST_TREES, PlacedFeatures.createCountExtraModifier(15, 0.1F, 1), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
    public static RegistryEntry<PlacedFeature> ANCIENT_DEAD_CORAL_REEF_WATER_PLACED_FEATURE = registerPlacedFeature("ancient_dead_reef_water_vegetation", ANCIENT_DEAD_REEF_VEGETATION, NoiseBasedCountPlacementModifier.of(20, 400.0D, 0.0D), SquarePlacementModifier.of(), PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP, BiomePlacementModifier.of());
    public static RegistryEntry<PlacedFeature> ANCIENT_DEAD_CORAL_REEF_PLACED_FEATURE = registerPlacedFeature("ancient_dead_reef_vegetation", ANCIENT_DEAD_REEF_VEGETATION, NoiseBasedCountPlacementModifier.of(20, 200.0D, 0.0D), SquarePlacementModifier.of(), PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP, BiomePlacementModifier.of());



    public static RegistryEntry<PlacedFeature> registerPlacedFeature(String id, RegistryEntry<? extends ConfiguredFeature<?, ?>> registryEntry, PlacementModifier... modifiers) {
        return BuiltinRegistries.add(BuiltinRegistries.PLACED_FEATURE, new Identifier(TheGraveyardBiomes.MOD_ID, id), new PlacedFeature(RegistryEntry.upcast(registryEntry), List.of(modifiers)));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> RegistryEntry<ConfiguredFeature<FC, ?>> registerConfiguredFeature(String id, F feature, FC config) {
        return BuiltinRegistries.addCasted(BuiltinRegistries.CONFIGURED_FEATURE, id, new ConfiguredFeature<>(feature, config));
    }

    private static <C extends FeatureConfig, F extends Feature<C>> F registerFeature(String id, F feature) {
        return Registry.register(Registry.FEATURE, new Identifier(TheGraveyardBiomes.MOD_ID, id), feature);
    }

}
