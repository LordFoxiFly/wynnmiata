package de.lordfoxifly.Features.Raids.RaidUtils;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;

public abstract class BlockUpdater {

    /**
     * Checks if a Block at a Pos is different
     * @param blockPos Coords of the Block to Check
     * @param block Default Block
     * @return True if it has changed
     */
    public static boolean isBlockUpdated(BlockPos blockPos, Block block){
        if (blockPos == null){
            return  false;
        }
        if (MinecraftClient.getInstance().world == null){
            return false;
        }
        Block block1 = MinecraftClient.getInstance().world.getBlockState(blockPos).getBlock();
        return block1 != block;
    }
}
