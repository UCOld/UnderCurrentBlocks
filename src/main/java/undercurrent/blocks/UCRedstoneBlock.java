package undercurrent.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import undercurrent.UnderCurrentBlocks;
import undercurrent.reference.ModInfo;
import undercurrent.tileEntity.UCRedstoneBlockTile;

public class UCRedstoneBlock extends BlockContainer {

    public IIcon[] icons = new IIcon[2];

    public UCRedstoneBlock() {
        super(Material.rock);
        this.setCreativeTab(UnderCurrentBlocks.underCurrentTab);
        this.setResistance(3.0F);
        this.setStepSound(Block.soundTypeStone);
        this.setBlockName("ucRedstoneToggleBlock");
    }

    @Override
    public void registerBlockIcons(IIconRegister p_149651_1_) {
        super.registerBlockIcons(p_149651_1_);

        icons[0] = p_149651_1_.registerIcon(ModInfo.ID.toLowerCase()
                + ":ucRedstoneBlockOff");

        icons[1] = p_149651_1_.registerIcon(ModInfo.ID.toLowerCase()
                + ":ucRedstoneBlockOn");

    }

    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
        if (p_149691_2_ == 0) {
            this.setLightLevel(0);
            return icons[0];
        } else {
            this.setLightLevel(8);
            return icons[1];
        }
    }

    @Override
    public int isProvidingStrongPower(IBlockAccess p_149748_1_, int p_149748_2_, int p_149748_3_, int p_149748_4_, int p_149748_5_) {
        if (p_149748_1_.getBlockMetadata(p_149748_2_, p_149748_3_, p_149748_4_) == 0) {
            return 0;
        } else {
            return 15;
        }
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess p_149709_1_, int p_149709_2_, int p_149709_3_, int p_149709_4_, int p_149709_5_) {
        if (p_149709_1_.getBlockMetadata(p_149709_2_, p_149709_3_, p_149709_4_) == 0) {
            return 0;
        } else {
            return 15;
        }
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new UCRedstoneBlockTile();
    }
}
