package com.dmcpacks.dirtmonds;

import com.dmcpacks.dirtmonds.block.ModBlocks;
import com.dmcpacks.dirtmonds.config.ModConfigs;
import com.dmcpacks.dirtmonds.item.ModItemGroup;
import com.dmcpacks.dirtmonds.item.ModItems;
import com.dmcpacks.dirtmonds.item.custom.DirtmondFinder;
import com.dmcpacks.dirtmonds.util.ModLootTableModifiers;
import com.dmcpacks.dirtmonds.world.OrePlacedFeature;
import com.dmcpacks.dirtmonds.world.gen.OreGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class Dirtmonds implements ModInitializer {

	public static final String MOD_ID = "dirtmonds";

	//dirtmond finder

	public static final Item DIRTMOND_FINDER = new DirtmondFinder(new FabricItemSettings().maxCount(1));

	public static void addToItemGroup(ItemGroup group, Item item) {
		ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
	}

	public static void addItemsToItemGroups() {
		addToItemGroup(ModItemGroup.DIRTMONDS, DIRTMOND_FINDER);
	}

	@Override
	public void onInitialize() {
		ModConfigs.registerConfigs();
		ModItemGroup.registerItemGroup();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		OreGeneration.generateOres();
		ModLootTableModifiers.modifyLootTables();

			Registry.register(Registries.ITEM, new Identifier("dirtmonds", "dirtmond_finder"), DIRTMOND_FINDER);
			addItemsToItemGroups();


		System.out.print("\nFully registered " + MOD_ID + "\n");
	}
}
