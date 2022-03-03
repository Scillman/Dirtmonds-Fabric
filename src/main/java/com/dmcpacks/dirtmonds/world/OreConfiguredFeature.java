package com.dmcpacks.dirtmonds.world;

import com.dmcpacks.dirtmonds.block.ModBlocks;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class OreConfiguredFeature {

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE_DIRTMONDS;

    static {
        ORE_DIRTMONDS = ConfiguredFeatures.register("ore_dirtmonds", Feature.ORE, new OreFeatureConfig(List.of(OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.DIRTMOND_ORE.getDefaultState())), 7));
    }

}
