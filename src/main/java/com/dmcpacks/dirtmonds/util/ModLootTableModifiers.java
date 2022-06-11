package com.dmcpacks.dirtmonds.util;

import com.dmcpacks.dirtmonds.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModLootTableModifiers {
    private static final Identifier VILLAGE_TOOLSMITH_ID = new Identifier("minecraft", "chests/village/village_toolsmith");
    private static final Identifier VILLAGE_WEAPONSMITH_ID = new Identifier("minecraft", "chests/village/village_weaponsmith");

    public static void modifyLootTables() {

        LootTableEvents.MODIFY.register(((resourceManager, manager, id, supplier, setter) -> {
            //check for leaves loot table.
            if(VILLAGE_TOOLSMITH_ID.equals(id)) {
                // Adds dirtmonds to the toolsmith loot table.
                LootPool poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .conditionally(RandomChanceLootCondition.builder(.70f).build())
                        .with(ItemEntry.builder(ModItems.DIRTMOND))
                        .build();
                supplier.pool(poolBuilder);
            }
            if(VILLAGE_TOOLSMITH_ID.equals(id)) {
                LootPool poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(.60f))
                        .with(ItemEntry.builder(ModItems.DIRTMOND_CHESTPLATE))
                        .with(ItemEntry.builder(ModItems.DIRTMOND_BOOTS))
                        .with(ItemEntry.builder(ModItems.DIRTMOND_LEGGINGS))
                        .with(ItemEntry.builder(ModItems.DIRTMOND_HELMET))
                        .build();
                supplier.pool(poolBuilder);
            }
            if(VILLAGE_WEAPONSMITH_ID.equals(id)) {
                // Adds dirtmonds to the weaponsmith loot table.
                LootPool poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .conditionally(RandomChanceLootCondition.builder(.65f))
                        .with(ItemEntry.builder(ModItems.DIRTMOND))
                        .build();
                supplier.pool(poolBuilder);
            }
            //tp @s 1104 80 -1568
            //8038865430415659132
            if(VILLAGE_WEAPONSMITH_ID.equals(id)) {
                // Adds armor to the weaponsmith loot table.
                LootPool poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(.75f))
                        .with(ItemEntry.builder(ModItems.DIRTMOND_CHESTPLATE))
                        .with(ItemEntry.builder(ModItems.DIRTMOND_BOOTS))
                        .with(ItemEntry.builder(ModItems.DIRTMOND_LEGGINGS))
                        .with(ItemEntry.builder(ModItems.DIRTMOND_HELMET))
                        .build();
                supplier.pool(poolBuilder);
            }
        }));
    }
}
