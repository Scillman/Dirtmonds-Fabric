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
    public static final RegistryEntry<PlacedFeature> ORE_DIRTMONDS;

    static {
        ORE_DIRTMONDS = PlacedFeatures.register("ore_dirtmonds", OreConfiguredFeature.ORE_DIRTMONDS, modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.aboveBottom(80), YOffset.fixed(70)) ));
    }

    public static void init() {
        RegistryKey<PlacedFeature> oreDirtmonds = ORE_DIRTMONDS.getKey().get();

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreDirtmonds);
    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

}
