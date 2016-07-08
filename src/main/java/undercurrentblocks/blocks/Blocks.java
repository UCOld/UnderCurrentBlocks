package undercurrentblocks.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;


public class Blocks {
    public static Block redstoneToggleBlock;
    public static Block inventoryCheckerBlock;
    public static Block mobCounterBlock;
    public static Block playerCounterBlock;

    public static void init() {
        redstoneToggleBlock = new UCRedstoneBlock();
        GameRegistry.registerBlock(redstoneToggleBlock, "redstoneToggleBlock");

        inventoryCheckerBlock = new UCInventoryCheckerBlock();
        GameRegistry.registerBlock(inventoryCheckerBlock, "inventoryCheckerBlock");

        mobCounterBlock = new UCMobCounterBlock();
        GameRegistry.registerBlock(mobCounterBlock, "mobCounterBlock");

        playerCounterBlock = new UCPlayerCounterBlock();
        GameRegistry.registerBlock(playerCounterBlock, "playerCounterBlock");

    }
}
