package com.dmcpacks.dirtmonds;

import com.dmcpacks.dirtmonds.block.ModBlocks;
import com.dmcpacks.dirtmonds.config.ModConfigs;
import com.dmcpacks.dirtmonds.item.ModItemGroup;
import com.dmcpacks.dirtmonds.item.ModItems;
import com.dmcpacks.dirtmonds.item.custom.DirtmondFinder;
import com.dmcpacks.dirtmonds.util.ModLootTableModifiers;
import com.dmcpacks.dirtmonds.world.OreConfiguredFeature;
import com.dmcpacks.dirtmonds.world.OrePlacedFeature;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.passive.PandaEntity;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.util.registry.Registry;

import java.util.List;

import static com.dmcpacks.dirtmonds.block.ModBlocks.DIRTMOND_ORE;
import static net.minecraft.world.gen.feature.Feature.*;
import static net.minecraft.world.gen.feature.OreConfiguredFeatures.STONE_ORE_REPLACEABLES;

public class Dirtmonds implements ModInitializer {

	public static final String MOD_ID = "dirtmonds";

	//dirtmond finder
	public static final Item DIRTMOND_FINDER = new DirtmondFinder(new FabricItemSettings()
			.group(ModItemGroup.DIRTMONDS).maxCount(1));

	@Override
	public void onInitialize() {
		ModConfigs.registerConfigs();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModLootTableModifiers.modifyLootTables();
		OrePlacedFeature.init();

		//registering dirtmond_finder
		if(ModConfigs.dirtmondfinder) {
			Registry.register(Registry.ITEM, new Identifier("dirtmonds", "dirtmond_finder"), DIRTMOND_FINDER);
		}

		System.out.print("Fully registered" + MOD_ID);
	}
}
