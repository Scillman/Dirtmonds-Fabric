package com.dmcpacks.dirtmonds;

import com.dmcpacks.dirtmonds.block.ModBlocks;
import com.dmcpacks.dirtmonds.config.ModConfigs;
import com.dmcpacks.dirtmonds.item.ModItemGroup;
import com.dmcpacks.dirtmonds.item.ModItems;
import com.dmcpacks.dirtmonds.item.custom.DirtmondFinder;
import com.dmcpacks.dirtmonds.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.util.registry.Registry;

public class Dirtmonds implements ModInitializer {

	public static final String MOD_ID = "dirtmonds";

	//dirtmond finder
	public static final Item DIRTMOND_FINDER = new DirtmondFinder(new FabricItemSettings()
			.group(ModItemGroup.DIRTMONDS).maxCount(1));

	//ore spawning

	private static ConfiguredFeature<?, ?> OVERWORLD_DIRTMOND_ORE_CONFIGURED_FEATURE = Feature.ORE
			.configure(new OreFeatureConfig(
					OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
					ModBlocks.DIRTMOND_ORE.getDefaultState(),
					8)); // vein size

	public static PlacedFeature OVERWORLD_WOOL_ORE_PLACED_FEATURE = OVERWORLD_DIRTMOND_ORE_CONFIGURED_FEATURE.withPlacement(
			CountPlacementModifier.of(10), // number of veins per chunk
			SquarePlacementModifier.of(), // spreading horizontally
			HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))); // height

	@Override
	public void onInitialize() {
		ModConfigs.registerConfigs();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModLootTableModifiers.modifyLootTables();

		//registering dirtmond_finder
		if(ModConfigs.dirtmondfinder) {
			Registry.register(Registry.ITEM, new Identifier("dirtmonds", "dirtmond_finder"), DIRTMOND_FINDER);
		}

		//registering dirtmonds
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier("dirtmonds", "overworld_dirtmond_ore"), OVERWORLD_DIRTMOND_ORE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("dirtmonds", "overworld_dirtmond_ore"),
				OVERWORLD_WOOL_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier("dirtmonds", "overworld_dirtmond_ore")));

		System.out.print("Fully registered" + MOD_ID);
	}
}
