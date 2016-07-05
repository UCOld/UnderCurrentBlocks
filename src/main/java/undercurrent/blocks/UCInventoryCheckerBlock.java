package undercurrent.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import undercurrent.UnderCurrentBlocks;
import undercurrent.reference.ModInfo;
import undercurrent.tileEntity.UCInventoryCheckerTile;

public class UCInventoryCheckerBlock extends BlockContainer {

    public UCInventoryCheckerBlock() {
        super(Material.rock);
        this.setCreativeTab(UnderCurrentBlocks.underCurrentTab);
        this.setResistance(3.0F);
        this.setStepSound(Block.soundTypeStone);
        this.setBlockName("ucInventoryCheckerBlock");
    }

    @Override
    public void registerBlockIcons(IIconRegister p_149651_1_) {
        super.registerBlockIcons(p_149651_1_);

        blockIcon = p_149651_1_.registerIcon(ModInfo.ID.toLowerCase() + ":ucInventoryChecker");
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new UCInventoryCheckerTile();
    }
}
