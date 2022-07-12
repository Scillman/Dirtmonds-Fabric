package com.dmcpacks.dirtmonds.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class OrePlacedFeature {
    public static final RegistryEntry<PlacedFeature> ORE_DIRTMONDS_LARGE;
    public static final RegistryEntry<PlacedFeature> ORE_DIRTMONDS_MEDIUM;
    public static final RegistryEntry<PlacedFeature> ORE_DIRTMONDS_SMALL;

    static {
        ORE_DIRTMONDS_LARGE = PlacedFeatures.register("ore_dirtmonds_large", OreConfiguredFeature.ORE_DIRTMONDS_LARGE, modifiersWithCount(1, HeightRangePlacementModifier.uniform(YOffset.aboveBottom(80), YOffset.fixed(70)) ));
        ORE_DIRTMONDS_MEDIUM = PlacedFeatures.register("ore_dirtmonds_medium", OreConfiguredFeature.ORE_DIRTMONDS_MEDIUM, modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.aboveBottom(80), YOffset.fixed(70)) ));
        ORE_DIRTMONDS_SMALL = PlacedFeatures.register("ore_dirtmonds_small", OreConfiguredFeature.ORE_DIRTMONDS_SMALL, modifiersWithCount(1, HeightRangePlacementModifier.uniform(YOffset.aboveBottom(80), YOffset.fixed(70)) ));
    }

    public static void init() {
        RegistryKey<PlacedFeature> oreDirtmondsLarge = ORE_DIRTMONDS_LARGE.getKey().get();
        RegistryKey<PlacedFeature> oreDirtmondsMedium = ORE_DIRTMONDS_MEDIUM.getKey().get();
        RegistryKey<PlacedFeature> oreDirtmondsSmall = ORE_DIRTMONDS_SMALL.getKey().get();

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreDirtmondsLarge);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreDirtmondsMedium);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreDirtmondsSmall);
    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

}
