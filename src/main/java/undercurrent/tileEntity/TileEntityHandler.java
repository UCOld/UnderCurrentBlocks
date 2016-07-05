package undercurrent.tileEntity;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityHandler {
    public static void init() {
        GameRegistry.registerTileEntity(UCRedstoneBlockTile.class, "UCRedstoneBlockTile");
        GameRegistry.registerTileEntity(UCInventoryCheckerTile.class, "UCInventoryCheckerTile");
    }
}
