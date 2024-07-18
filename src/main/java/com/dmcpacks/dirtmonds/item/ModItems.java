package com.dmcpacks.dirtmonds.item;

import com.dmcpacks.dirtmonds.config.ModConfigs;
import com.dmcpacks.dirtmonds.item.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.dmcpacks.dirtmonds.Dirtmonds;

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

    public static final Item DIRTMOND_HELMET = registerItem("dirtmond_helmet", new ModArmorItem(ModArmorMaterial.DIRTMOND, EquipmentSlot.HEAD,
            new FabricItemSettings()
            ));

    public static final Item DIRTMOND_CHESTPLATE = registerItem("dirtmond_chestplate", new ModArmorItem(ModArmorMaterial.DIRTMOND, EquipmentSlot.CHEST,
            new FabricItemSettings()
            ));

    public static final Item DIRTMOND_LEGGINGS = registerItem("dirtmond_leggings", new ModArmorItem(ModArmorMaterial.DIRTMOND, EquipmentSlot.LEGS,
            new FabricItemSettings()
            ));

    public static final Item DIRTMOND_BOOTS = registerItem("dirtmond_boots", new ModArmorItem(ModArmorMaterial.DIRTMOND, EquipmentSlot.FEET,
            new FabricItemSettings()
            ));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Dirtmonds.MOD_ID, name), item);
    }

    public static void addItemsToItemGroups() {
        addToItemGroup(ModItemGroup.DIRTMONDS, DIRTMOND);
        addToItemGroup(ModItemGroup.DIRTMONDS, DIRTMOND_SWORD);
        addToItemGroup(ModItemGroup.DIRTMONDS, DIRTMOND_SHOVEL);
        addToItemGroup(ModItemGroup.DIRTMONDS, DIRTMOND_AXE);
        addToItemGroup(ModItemGroup.DIRTMONDS, DIRTMOND_PICKAXE);
        addToItemGroup(ModItemGroup.DIRTMONDS, DIRTMOND_HOE);
        addToItemGroup(ModItemGroup.DIRTMONDS, DIRTMOND_HELMET);
        addToItemGroup(ModItemGroup.DIRTMONDS, DIRTMOND_CHESTPLATE);
        addToItemGroup(ModItemGroup.DIRTMONDS, DIRTMOND_LEGGINGS);
        addToItemGroup(ModItemGroup.DIRTMONDS, DIRTMOND_BOOTS);

        if(ModConfigs.dirtmondfinder) {
            addToItemGroup(ModItemGroup.DIRTMONDS, Dirtmonds.DIRTMOND_FINDER);
        }
    }

    public static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void registerModItems() {
        addItemsToItemGroups();
        System.out.println("Registered Dirtmonds items");
    }
}
