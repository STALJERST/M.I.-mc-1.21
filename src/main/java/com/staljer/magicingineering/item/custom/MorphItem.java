package com.staljer.magicingineering.item.custom;

import com.staljer.magicingineering.block.ModBlocks;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MorphItem extends Item {
    private static final Map<Block, Block> SWAP =
            Map.of(
                    Blocks.RAW_IRON_BLOCK, ModBlocks.RAW_TITANIUM_BLOCK.get(),
                    Blocks.IRON_ORE, ModBlocks.TITANIUM_ORE.get()
            );

    public MorphItem(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if(SWAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(pContext.getClickedPos(), SWAP.get(clickedBlock).defaultBlockState());

                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, pContext.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()){
        pTooltipComponents.add(Component.translatable("tooltipe:magicingineering.morph.shift_sown"));
        }else{
            pTooltipComponents.add(Component.translatable("tooltip.magicingineering.morph"));
        }
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
