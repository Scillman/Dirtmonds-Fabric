package com.dmcpacks.dirtmonds.util;

import com.dmcpacks.dirtmonds.item.ModItems;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier VILLAGE_TOOLSMITH_ID = new Identifier("minecraft", "chests/village/village_toolsmith");
    private static final Identifier VILLAGE_WEAPONSMITH_ID = new Identifier("minecraft", "chests/village/village_weaponsmith");

    public static void modifyLootTables() {

        LootTableLoadingCallback.EVENT.register(((resourceManager, manager, id, supplier, setter) -> {
            //check for leaves loot table.
            if(VILLAGE_TOOLSMITH_ID.equals(id)) {
                // Adds dirtmonds to the toolsmith loot table.
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .conditionally(RandomChanceLootCondition.builder(.70f))
                        .with(ItemEntry.builder(ModItems.DIRTMOND))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build());
                supplier.withPool(poolBuilder.build());
            }
            if(VILLAGE_TOOLSMITH_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(.65f))
                        .with(ItemEntry.builder(ModItems.DIRTMOND_CHESTPLATE))
                        .with(ItemEntry.builder(ModItems.DIRTMOND_BOOTS))
                        .with(ItemEntry.builder(ModItems.DIRTMOND_LEGGINGS))
                        .with(ItemEntry.builder(ModItems.DIRTMOND_HELMET))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            }
            if(VILLAGE_WEAPONSMITH_ID.equals(id)) {
                // Adds dirtmonds to the weaponsmith loot table.
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .conditionally(RandomChanceLootCondition.builder(.75f))
                        .with(ItemEntry.builder(ModItems.DIRTMOND))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build());
                supplier.withPool(poolBuilder.build());
            }
            //tp @s 1104 80 -1568
            //8038865430415659132
            if(VILLAGE_WEAPONSMITH_ID.equals(id)) {
                // Adds armor to the weaponsmith loot table.
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(.70f))
                        .with(ItemEntry.builder(ModItems.DIRTMOND_CHESTPLATE))
                        .with(ItemEntry.builder(ModItems.DIRTMOND_BOOTS))
                        .with(ItemEntry.builder(ModItems.DIRTMOND_LEGGINGS))
                        .with(ItemEntry.builder(ModItems.DIRTMOND_HELMET))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());
            }
        }));
    }
}
