package com.dmcpacks.dirtmonds.block;

import com.dmcpacks.dirtmonds.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import com.dmcpacks.dirtmonds.Dirtmonds;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;


public class ModBlocks {

    public static final Block DIRTMOND_ORE = registerBlock("dirtmond_ore", new Block(FabricBlockSettings
            .of(Material.SOIL)
            .requiresTool()
            .strength(2f, 5f)
            .sounds(BlockSoundGroup.GRASS)));

    public static final Block DIRTMOND_BLOCK = registerBlock("dirtmond_block", new Block(FabricBlockSettings
            .of(Material.METAL)
            .requiresTool()
            .strength(4f, 20f)
            .sounds(BlockSoundGroup.METAL)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Dirtmonds.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(Dirtmonds.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.DIRTMONDS).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlocks() {
        System.out.println("Registering blocks");
    }
}
