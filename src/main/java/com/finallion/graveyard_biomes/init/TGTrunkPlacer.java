package com.finallion.graveyard_biomes.init;

import com.finallion.graveyard_biomes.mixin.TrunkPlacerTypeInvoker;
import com.finallion.graveyard_biomes.world.trunk.DeepDarkOakTrunkPlacer;
import com.mojang.serialization.Codec;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.trunk.*;

public class TGTrunkPlacer {

    public static final TrunkPlacerType<DeepDarkOakTrunkPlacer> DEEP_DARK_OAK_TRUNK_PLACER =
            TrunkPlacerTypeInvoker.callRegister("deep_dark_oak_trunk_placer", DeepDarkOakTrunkPlacer.CODEC);

    public static void init() {}
}