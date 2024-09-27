package com.staljer.magicingineering.item.custom;

import com.staljer.magicingineering.foundation.datagen.ModBlockTagProvider;
import com.staljer.magicingineering.foundation.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HammerItem extends DiggerItem {
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public HammerItem(Tier pTier, Properties pProperties) {
        super(pTier, ModTags.Blocks.MINEABLE_WITH_HAMMER, pProperties);
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
        for (int z = 0; z <= depth; z++) {
            List<BlockPos> layerPositions = new ArrayList<>();
            for (int x = -range; x <= range; x++) {
                for (int y = -range; y <= range; y++) {
                    if (direction == Direction.DOWN) {
                        layerPositions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY() + z, initialBlockPos.getZ() + y));
                    } else if (direction == Direction.UP) {
                        layerPositions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY() - z, initialBlockPos.getZ() + y));
                    } else if (direction == Direction.NORTH) {
                        layerPositions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY() + y, initialBlockPos.getZ() + z));
                    } else if (direction == Direction.SOUTH) {
                        layerPositions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY() + y, initialBlockPos.getZ() - z));
                    } else if (direction == Direction.WEST) {
                        layerPositions.add(new BlockPos(initialBlockPos.getX() + z, initialBlockPos.getY() + y, initialBlockPos.getZ() + x));
                    } else if (direction == Direction.EAST) {
                        layerPositions.add(new BlockPos(initialBlockPos.getX() - z, initialBlockPos.getY() + y, initialBlockPos.getZ() + x));
                    }
                }
            }
            destroyLayerWithDelay(layerPositions, player, z * 5000); // Затримка пропорційна глибині
        }

        return positions;
    }

    public static void destroyLayerWithDelay(List<BlockPos> positions, ServerPlayer player, int delay) {
        scheduler.schedule(() -> {
            for (BlockPos pos : positions) {
                BlockState state = player.level().getBlockState(pos);
                if (!state.isAir()) {
                    player.level().destroyBlock(pos, true, player);
                }
            }
        }, delay, TimeUnit.MILLISECONDS);
    }
}
