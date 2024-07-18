package com.dmcpacks.dirtmonds.item;

import com.dmcpacks.dirtmonds.Dirtmonds;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup DIRTMONDS;

    public static void registerItemGroup() {
        DIRTMONDS = FabricItemGroup.builder(new Identifier(Dirtmonds.MOD_ID, "dirtmonds"))
                .displayName(Text.translatable("itemGroup.dirtmonds.dirtmonds"))
                .icon(() -> new ItemStack(ModItems.DIRTMOND)).build();
    }
}
