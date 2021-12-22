package com.dmcpacks.dirtmonds.item;

import com.dmcpacks.dirtmonds.Dirtmonds;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup DIRTMONDS = FabricItemGroupBuilder.build(new Identifier(Dirtmonds.MOD_ID, "dirtmonds"),
            () -> new ItemStack(ModItems.DIRTMOND));
}
