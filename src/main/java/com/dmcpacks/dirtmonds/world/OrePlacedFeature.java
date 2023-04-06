package com.dmcpacks.dirtmonds.world;

import com.dmcpacks.dirtmonds.Dirtmonds;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class OrePlacedFeature {
    public static final RegistryKey<PlacedFeature> ORE_DIRTMONDS_LARGE = registerKey("ore_dirtmonds_large");
    public static final RegistryKey<PlacedFeature> ORE_DIRTMONDS_MEDIUM = registerKey("ore_dirtmonds_medium");
    public static final RegistryKey<PlacedFeature> ORE_DIRTMONDS_SMALL = registerKey("ore_dirtmonds_small");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        register(context, ORE_DIRTMONDS_LARGE, configuredFeatureRegistryEntryLookup.getOrThrow(OreConfiguredFeature.ORE_DIRTMONDS_LARGE),
                modifiersWithCount(2, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));
        register(context, ORE_DIRTMONDS_MEDIUM, configuredFeatureRegistryEntryLookup.getOrThrow(OreConfiguredFeature.ORE_DIRTMONDS_MEDIUM),
                modifiersWithCount(4, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));
        register(context, ORE_DIRTMONDS_SMALL, configuredFeatureRegistryEntryLookup.getOrThrow(OreConfiguredFeature.ORE_DIRTMONDS_SMALL),
                modifiersWithCount(2, // VeinsPerChunk
                        HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Dirtmonds.MOD_ID, name));
    }
    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

}
