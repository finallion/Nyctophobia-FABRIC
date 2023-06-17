package com.finallion.nyctophobia.config;


import draylar.omegaconfig.api.Comment;
import draylar.omegaconfig.api.Config;
import net.minecraft.util.Identifier;


import java.util.*;

public class NyctophobiaConfig implements Config {
    @Comment("""
             Welcome to the Nyctophobia Config!
             
             Configure the weight of the biomes by changing "nyctophobiaBiomeWeight".
             Configure which minecraft biomes can be replaced by Nyctophobia Biomes.
             A full list of all the biomes can be found here https:minecraft.fandom.com/wiki/Biome#Biome_IDs.
             Configure fog density and fog height.
             
            """)


    public final Map<String, BiomeConfigEntry> biomeConfigEntries = new HashMap<>();
    public final Map<String, BiomeFogConfigEntry> biomeFogConfigEntries = new HashMap<>();
    public final Map<String, Boolean> miscConfigEntries = new HashMap<>();

    public final Map<String, Integer> biomeGeneration = new HashMap<>();

    @Override
    public String getName() {
        return "nyctophobia_config";
    }

    @Override
    public String getExtension() {
        return "json5";
    }

    // generation booleans
    public boolean biomeFogSpawn(Identifier id) {
        return getFog(id).enabled;
    }


    // biome spawn config
    public BiomeConfigEntry getBiome(Identifier id) {
        for (Map.Entry<String, BiomeConfigEntry> entry : biomeConfigEntries.entrySet()) {
            if (entry.getKey().equals(id.getPath())) {
                return entry.getValue();
            }
        }
        throw new NullPointerException("Tried BiomeConfigEntry with id: " + id + ", but it was null!");
    }


    // fog spawn config
    public BiomeFogConfigEntry getFog(Identifier id) {
        for (Map.Entry<String, BiomeFogConfigEntry> entry : biomeFogConfigEntries.entrySet()) {
            if (entry.getKey().equals(id.getPath())) {
                return entry.getValue();
            }
        }
        throw new NullPointerException("Tried BiomeFogConfigEntry with id: " + id + ", but it was null!");
    }

    @Override
    public void save() {
        biomeGeneration.putIfAbsent("nyctophobiaBiomeWeight", 1);
        miscConfigEntries.putIfAbsent("useSoulLanternsInHauntedLakes", false);

        biomeConfigEntries.putIfAbsent("haunted_forest", BiomeConfigEntry.of(Arrays.asList("windswept_forest")));
        biomeConfigEntries.putIfAbsent("haunted_lakes", BiomeConfigEntry.of(Arrays.asList("swamp")));
        biomeConfigEntries.putIfAbsent("eroded_haunted_forest", BiomeConfigEntry.of(Arrays.asList("meadow")));
        biomeConfigEntries.putIfAbsent("ancient_dead_coral_reef", BiomeConfigEntry.of(Arrays.asList("beach")));
        biomeConfigEntries.putIfAbsent("deep_dark_forest", BiomeConfigEntry.of(Arrays.asList("dark_forest")));

        biomeFogConfigEntries.putIfAbsent("haunted_forest_fog", BiomeFogConfigEntry.of(0.35F, 63, 148));
        biomeFogConfigEntries.putIfAbsent("haunted_lakes_fog", BiomeFogConfigEntry.of(0.3F, 63, 128));
        biomeFogConfigEntries.putIfAbsent("eroded_haunted_forest_fog", BiomeFogConfigEntry.of(0.35F, 93, 160));

        Config.super.save();
    }

}


