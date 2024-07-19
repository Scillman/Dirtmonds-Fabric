package com.dmcpacks.dirtmonds.item;

import com.dmcpacks.dirtmonds.Dirtmonds;
import com.dmcpacks.dirtmonds.config.ModConfigs;
import com.dmcpacks.dirtmonds.item.custom.ModArmorItem;
import com.dmcpacks.dirtmonds.item.custom.ModAxeItem;
import com.dmcpacks.dirtmonds.item.custom.ModHoeItem;
import com.dmcpacks.dirtmonds.item.custom.ModPickaxeItem;
import com.dmcpacks.dirtmonds.item.custom.ModSwordItem;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item DIRTMOND = registerItem("dirtmond", new Item(new FabricItemSettings()
            ));

    public static final Item DIRTMOND_SWORD = registerItem("dirtmond_sword", new ModSwordItem(ModToolMaterial.DIRTMOND, 3, -2.4f,
            new FabricItemSettings()
            ));

    public static final Item DIRTMOND_SHOVEL = registerItem("dirtmond_shovel", new ShovelItem(ModToolMaterial.DIRTMOND, 0, -2.9f,
            new FabricItemSettings()
            ));

    public static final Item DIRTMOND_AXE = registerItem("dirtmond_axe", new ModAxeItem(ModToolMaterial.DIRTMOND, 5f, -2.9f,
            new FabricItemSettings()
            ));

    public static final Item DIRTMOND_PICKAXE = registerItem("dirtmond_pickaxe", new ModPickaxeItem(ModToolMaterial.DIRTMOND, 1, -2.8f,
            new FabricItemSettings()
            ));

    public static final Item DIRTMOND_HOE = registerItem("dirtmond_hoe", new ModHoeItem(ModToolMaterial.DIRTMOND, 0, -1f,
            new FabricItemSettings()
            ));

    public static final Item DIRTMOND_HELMET = registerItem("dirtmond_helmet", new ModArmorItem(ModArmorMaterial.DIRTMOND, ArmorItem.Type.HELMET,
            new FabricItemSettings()
            ));

    public static final Item DIRTMOND_CHESTPLATE = registerItem("dirtmond_chestplate", new ModArmorItem(ModArmorMaterial.DIRTMOND, ArmorItem.Type.CHESTPLATE,
            new FabricItemSettings()
            ));

    public static final Item DIRTMOND_LEGGINGS = registerItem("dirtmond_leggings", new ModArmorItem(ModArmorMaterial.DIRTMOND, ArmorItem.Type.LEGGINGS,
            new FabricItemSettings()
            ));

    public static final Item DIRTMOND_BOOTS = registerItem("dirtmond_boots", new ModArmorItem(ModArmorMaterial.DIRTMOND, ArmorItem.Type.BOOTS,
            new FabricItemSettings()
            ));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Dirtmonds.MOD_ID, name), item);
    }

    public static void addItemsToItemGroups() {
        addToItemGroup(DIRTMOND);
        addToItemGroup(DIRTMOND_SWORD);
        addToItemGroup(DIRTMOND_SHOVEL);
        addToItemGroup(DIRTMOND_AXE);
        addToItemGroup(DIRTMOND_PICKAXE);
        addToItemGroup(DIRTMOND_HOE);
        addToItemGroup(DIRTMOND_HELMET);
        addToItemGroup(DIRTMOND_CHESTPLATE);
        addToItemGroup(DIRTMOND_LEGGINGS);
        addToItemGroup(DIRTMOND_BOOTS);

        if(ModConfigs.dirtmondfinder) {
            addToItemGroup(Dirtmonds.DIRTMOND_FINDER);
        }
    }

    public static void addToItemGroup(Item item) {
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.DIRTMONDS).register(entries -> entries.add(item));
    }
    public static void registerModItems() {
        addItemsToItemGroups();
        System.out.println("Registered Dirtmonds items");
    }
}
