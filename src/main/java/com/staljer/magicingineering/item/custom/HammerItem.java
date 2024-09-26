package com.staljer.magicingineering.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.ArrayList;
import java.util.List;

public class HammerItem extends DiggerItem {
    public HammerItem(Tier pTier, Properties pProperties) {
        super(pTier, BlockTags.MINEABLE_WITH_PICKAXE, pProperties);
    }

    public static List<BlockPos> getBlocksToBeDestroyed(int range, int depth, BlockPos initialBlockPos, ServerPlayer player) {
        List<BlockPos> positions = new ArrayList<>();

        BlockHitResult traceResult = player.level().clip(new ClipContext(player.getEyePosition(1f),
                (player.getEyePosition(1f).add(player.getViewVector(1f).scale(6f))),
                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
        if(traceResult.getType() == HitResult.Type.MISS) {
            return positions;
        }

        Direction direction = traceResult.getDirection();
        for (int x = -range; x <= range; x++) {
            for (int y = -range; y <= range; y++) {
                for (int z = 0; z <= depth; z++) {
                    if (direction == Direction.DOWN) {
                        positions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY() + z, initialBlockPos.getZ() + y));
                    } else if (direction == Direction.UP) {
                        positions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY() - z, initialBlockPos.getZ() + y));
                    } else if (direction == Direction.NORTH) {
                        positions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY() + y, initialBlockPos.getZ() + z));
                    } else if (direction == Direction.SOUTH) {
                        positions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY() + y, initialBlockPos.getZ() - z));
                    } else if (direction == Direction.WEST) {
                        positions.add(new BlockPos(initialBlockPos.getX() + z, initialBlockPos.getY() + y, initialBlockPos.getZ() + x));
                    } else if (direction == Direction.EAST) {
                        positions.add(new BlockPos(initialBlockPos.getX() - z, initialBlockPos.getY() + y, initialBlockPos.getZ() + x));
                    }
                }
            }
        }

        return positions;
    }
}
