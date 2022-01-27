package com.dmcpacks.dirtmonds.item;

import com.dmcpacks.dirtmonds.item.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import com.dmcpacks.dirtmonds.Dirtmonds;

public class ModItems {

    public static final Item DIRTMOND = registerItem("dirtmond", new Item(new FabricItemSettings()
            .group(ModItemGroup.DIRTMONDS)));

    public static final Item DIRTMOND_SWORD = registerItem("dirtmond_sword", new SwordItem(ModToolMaterial.DIRTMOND, 3, -2.4f,
            new FabricItemSettings()
            .group(ModItemGroup.DIRTMONDS).maxDamage(1)));

    public static final Item DIRTMOND_SHOVEL = registerItem("dirtmond_shovel", new ShovelItem(ModToolMaterial.DIRTMOND, 0, -2.9f,
            new FabricItemSettings()
            .group(ModItemGroup.DIRTMONDS)));

    public static final Item DIRTMOND_AXE = registerItem("dirtmond_axe", new ModAxeItem(ModToolMaterial.DIRTMOND, 5f, -2.9f,
            new FabricItemSettings()
            .group(ModItemGroup.DIRTMONDS)));

    public static final Item DIRTMOND_PICKAXE = registerItem("dirtmond_pickaxe", new ModPickaxeItem(ModToolMaterial.DIRTMOND, 1, -2.8f,
            new FabricItemSettings()
            .group(ModItemGroup.DIRTMONDS)));

    public static final Item DIRTMOND_HOE = registerItem("dirtmond_hoe", new ModHoeItem(ModToolMaterial.DIRTMOND, 0, -1f,
            new FabricItemSettings()
            .group(ModItemGroup.DIRTMONDS)));

    public static final Item DIRTMOND_HELMET = registerItem("dirtmond_helmet", new ModArmorItem(ModArmorMaterial.DIRTMOND, EquipmentSlot.HEAD,
            new FabricItemSettings()
            .group(ModItemGroup.DIRTMONDS)));

    public static final Item DIRTMOND_CHESTPLATE = registerItem("dirtmond_chestplate", new ModArmorItem(ModArmorMaterial.DIRTMOND, EquipmentSlot.CHEST,
            new FabricItemSettings()
            .group(ModItemGroup.DIRTMONDS)));

    public static final Item DIRTMOND_LEGGINGS = registerItem("dirtmond_leggings", new ModArmorItem(ModArmorMaterial.DIRTMOND, EquipmentSlot.LEGS,
            new FabricItemSettings()
            .group(ModItemGroup.DIRTMONDS)));

    public static final Item DIRTMOND_BOOTS = registerItem("dirtmond_boots", new ModArmorItem(ModArmorMaterial.DIRTMOND, EquipmentSlot.FEET,
            new FabricItemSettings()
            .group(ModItemGroup.DIRTMONDS)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Dirtmonds.MOD_ID, name), item);
    }

    public static void registerModItems() {
        System.out.println("Registering mod items");
    }
}
