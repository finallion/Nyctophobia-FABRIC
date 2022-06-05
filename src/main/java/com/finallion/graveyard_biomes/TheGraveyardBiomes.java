package com.finallion.graveyard_biomes;

import com.finallion.graveyard_biomes.config.GraveyardBiomesConfig;
import com.finallion.graveyard_biomes.init.TGBiomes;
import com.finallion.graveyard_biomes.init.TGConfiguredFeatures;
import com.finallion.graveyard_biomes.world.biomes.TGBiomeProvider;
import com.finallion.graveyard_biomes.world.noise.TGNoiseParameters;
import com.finallion.graveyard_biomes.world.surfacerules.TGSurfaceRules;
import draylar.omegaconfig.OmegaConfig;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class TheGraveyardBiomes implements ModInitializer, TerraBlenderApi {
    public static final String MOD_ID = "graveyard_biomes";
    public static final GraveyardBiomesConfig config = OmegaConfig.register(GraveyardBiomesConfig.class);
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize() {
        TGConfiguredFeatures.init();
        TGNoiseParameters.init();
        TGBiomes.registerBiomes();
    }

    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new TGBiomeProvider(new Identifier(MOD_ID, "biome_provider"), TheGraveyardBiomes.config.biomeGeneration.get("theGraveyardBiomesWeight")));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, "graveyard_biomes", TGSurfaceRules.makeRules());

    }

}
