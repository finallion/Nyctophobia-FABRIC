package com.finallion.nyctophobia.config;

import java.util.List;

public class BiomeConfigEntry {
    public final boolean canGenerate;
    public final List<String> replaceableBiomes;

    private BiomeConfigEntry(List<String> replaceableBiomes) {
        this(true, replaceableBiomes);
    }

    private BiomeConfigEntry(boolean canGenerate, List<String> replaceableBiomes) {
        this.canGenerate = canGenerate;
        this.replaceableBiomes = replaceableBiomes;
    }

    public static BiomeConfigEntry of(List<String> replaceableBiomes) {
        return new BiomeConfigEntry(replaceableBiomes);
    }
}
