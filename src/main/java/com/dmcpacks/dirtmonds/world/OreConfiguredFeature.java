package com.dmcpacks.dirtmonds.world;

import com.dmcpacks.dirtmonds.block.ModBlocks;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class OreConfiguredFeature {

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_DIRTMONDS_LARGE;
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_DIRTMONDS_MEDIUM;
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_DIRTMONDS_SMALL;

    static {
        ORE_DIRTMONDS_LARGE = ConfiguredFeatures.register("ore_dirtmonds_large", Feature.ORE, new OreFeatureConfig(List.of(OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.DIRTMOND_ORE.getDefaultState())), 7, 1.0F));
        ORE_DIRTMONDS_MEDIUM = ConfiguredFeatures.register("ore_dirtmonds_medium", Feature.ORE, new OreFeatureConfig(List.of(OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.DIRTMOND_ORE.getDefaultState())), 5, .05F));
        ORE_DIRTMONDS_SMALL = ConfiguredFeatures.register("ore_dirtmonds_small", Feature.ORE, new OreFeatureConfig(List.of(OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.DIRTMOND_ORE.getDefaultState())), 3));
    }

}
