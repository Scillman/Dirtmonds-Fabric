package com.dmcpacks.dirtmonds.world;

import com.dmcpacks.dirtmonds.Dirtmonds;
import com.dmcpacks.dirtmonds.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class OreConfiguredFeature {
    public static final RegistryKey<ConfiguredFeature<?,?>> ORE_DIRTMONDS_LARGE = registerKey("ore_dirtmonds_large");
    public static final RegistryKey<ConfiguredFeature<?,?>> ORE_DIRTMONDS_MEDIUM = registerKey("ore_dirtmonds_medium");
    public static final RegistryKey<ConfiguredFeature<?,?>> ORE_DIRTMONDS_SMALL = registerKey("ore_dirtmonds_small");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        var placedFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> ore_Dirtmonds_large =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.DIRTMOND_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> ore_dirtmonds_medium =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.DIRTMOND_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> ore_dirtmonds_small =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.DIRTMOND_ORE.getDefaultState()));

        register(context, ORE_DIRTMONDS_LARGE, Feature.ORE, new OreFeatureConfig(ore_Dirtmonds_large,  7, 1.0F));
        register(context, ORE_DIRTMONDS_MEDIUM, Feature.ORE, new OreFeatureConfig(ore_dirtmonds_medium, 5, .05F));
        register(context, ORE_DIRTMONDS_SMALL, Feature.ORE, new OreFeatureConfig(ore_dirtmonds_small, 3));

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Dirtmonds.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
