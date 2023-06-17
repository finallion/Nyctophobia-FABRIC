package com.finallion.nyctophobia.init;

import com.finallion.nyctophobia.mixin.TrunkPlacerTypeInvoker;
import com.finallion.nyctophobia.world.trunk.DeepDarkOakTrunkPlacer;
import net.minecraft.world.gen.trunk.*;

public class NTrunkPlacer {

    public static final TrunkPlacerType<DeepDarkOakTrunkPlacer> DEEP_DARK_OAK_TRUNK_PLACER =
            TrunkPlacerTypeInvoker.callRegister("deep_dark_oak_trunk_placer", DeepDarkOakTrunkPlacer.CODEC);

    public static void init() {}
}