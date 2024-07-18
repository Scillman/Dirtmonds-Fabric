package com.dmcpacks.dirtmonds.item.custom;

import com.dmcpacks.dirtmonds.block.ModBlocks;
import com.dmcpacks.dirtmonds.config.ModConfigs;
import net.minecraft.block.Block;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;

public class DirtmondFinder extends Item {

    public DirtmondFinder(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        if (context.getWorld().isClient()) {
            if(ModConfigs.dirtmondfinder) {
                BlockPos click = context.getBlockPos();
                PlayerEntity player = context.getPlayer();
                boolean foundBlock = false;

                for (int i = 0; i <= click.getY() + 64; i++) {
                    Block below = context.getWorld().getBlockState(click.down(i)).getBlock();

                    if (isDirtmond(below)) {
                        DirtmondCoords(click.down(i), player, below);
                        foundBlock = true;
                        break;
                    }
                }

                if (!foundBlock) {
                    player.sendMessage(Text.translatable("item.dirtmonds.dirtmond_finder.novaluables"), true);
                }
            } else {
                PlayerEntity player = context.getPlayer();
                player.sendMessage(Text.literal("Hmm, this item doesn't seem to work"), true);
            }
    }
        context.getStack().damage( 1, context.getPlayer(),
                (player) -> player.sendToolBreakStatus(player.getActiveHand()));

        return super.useOnBlock(context);
    }

    private void DirtmondCoords(BlockPos blockPos, PlayerEntity player, Block dirtmond) {
        player.sendMessage(Text.literal("Detected " + dirtmond.asItem().getName().getString()
                + " at " + "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), true);
    }

    private boolean isDirtmond(Block block) {
        return block == ModBlocks.DIRTMOND_ORE;
    }
}