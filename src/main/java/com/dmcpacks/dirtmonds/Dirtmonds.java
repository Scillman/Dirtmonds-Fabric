package com.dmcpacks.dirtmonds;

import com.dmcpacks.dirtmonds.block.ModBlocks;
import com.dmcpacks.dirtmonds.config.ModConfigs;
import com.dmcpacks.dirtmonds.item.ModItemGroup;
import com.dmcpacks.dirtmonds.item.ModItems;
import com.dmcpacks.dirtmonds.item.custom.DirtmondFinder;
import com.dmcpacks.dirtmonds.util.ModLootTableModifiers;
import com.dmcpacks.dirtmonds.world.OrePlacedFeature;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


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
		OrePlacedFeature.init();
		ModLootTableModifiers.modifyLootTables();

			Registry.register(Registry.ITEM, new Identifier("dirtmonds", "dirtmond_finder"), DIRTMOND_FINDER);


		System.out.print("Fully registered" + MOD_ID);
	}
}
