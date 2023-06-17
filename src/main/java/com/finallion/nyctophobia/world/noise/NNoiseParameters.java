package com.finallion.nyctophobia.world.noise;

import com.finallion.nyctophobia.Nyctophobia;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;

public class NNoiseParameters {

    public static final RegistryKey<DoublePerlinNoiseSampler.NoiseParameters> HAUNTED_FOREST_NOISE = registerNoiseParameter("haunted_forest_noise");
    /*

    public static DoublePerlinNoiseSampler.NoiseParameters init() {
        register(HAUNTED_FOREST_SURFACE, -5, 1.1, 0.5, 1.25, 1.4);
        register(HAUNTED_FOREST_PARTICLE_MOSS, -2, 1.0, 0.75);
        register(HAUNTED_FOREST_SOUL_SOIL, -6, 1.2, 0.5);
        register(HAUNTED_FOREST_NOISE, -1, 1.0);
        register(HAUNTED_FOREST_MOSS, -3, 1.0, 1.25);
        return BuiltinRegistries.NOISE_PARAMETERS.iterator().next();
    }



    private static void register(RegistryKey<DoublePerlinNoiseSampler.NoiseParameters> noise, int firstOctave, double firstAmplitude, double... amplitudes) {
        BuiltinRegistries.add(BuiltinRegistries.NOISE_PARAMETERS, noise, new DoublePerlinNoiseSampler.NoiseParameters(firstOctave, firstAmplitude, amplitudes));
    }

     */


    private static RegistryKey<DoublePerlinNoiseSampler.NoiseParameters> registerNoiseParameter(String id) {
        return RegistryKey.of(RegistryKeys.NOISE_PARAMETERS, new Identifier(Nyctophobia.MOD_ID, id));
    }
}
