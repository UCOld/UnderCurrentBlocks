package undercurrentblocks;

import undercurrentblocks.blocks.Blocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class UnderCurrentTab extends CreativeTabs {

    public UnderCurrentTab(String label) {
        super(label);
    }

    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(Blocks.redstoneToggleBlock);
    }

    @Override
    public Item getTabIconItem() {
        return null;
    }
}
