package com.finallion.nyctophobia;

import com.finallion.nyctophobia.config.NyctophobiaConfig;
import com.finallion.nyctophobia.init.*;
import com.finallion.nyctophobia.util.NTags;
import com.finallion.nyctophobia.world.biomes.NBiomeProvider;
import com.finallion.nyctophobia.world.surfacerules.NSurfaceRules;
import draylar.omegaconfig.OmegaConfig;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class Nyctophobia implements ModInitializer, TerraBlenderApi {
    public static final String MOD_ID = "nyctophobia";
    public static final NyctophobiaConfig config = OmegaConfig.register(NyctophobiaConfig.class);
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize() {
        NTrunkPlacer.init();
        NFeatures.init();
        NTags.init();
        NConfiguredFeatures.init();
        NPlacedFeatures.init();
        //TGNoiseParameters.init();
        NBiomes.init();
        NStructures.registerStructureFeatures();
    }

    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new NBiomeProvider(new Identifier(MOD_ID, "biome_provider"), Nyctophobia.config.biomeGeneration.get("nyctophobiaBiomeWeight")));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, "nyctophobia", NSurfaceRules.makeRules());

    }

}
