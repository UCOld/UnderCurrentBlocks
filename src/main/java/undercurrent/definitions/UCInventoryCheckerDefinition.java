package undercurrent.definitions;

import api.undercurrent.iface.UCCollection;
import api.undercurrent.iface.UCTileDefinition;
import api.undercurrent.iface.editorTypes.InfoEditorType;
import net.minecraft.inventory.IInventory;
import undercurrent.tileEntity.UCInventoryCheckerTile;

import java.util.List;

/**
 * Created by Niel on 10/16/2015.
 */
public class UCInventoryCheckerDefinition extends UCTileDefinition {

    public UCInventoryCheckerDefinition(UCInventoryCheckerTile te, List<IInventory> inventories) throws Exception {
        super(te);
        for (IInventory inventory : inventories) {
            UCCollection collection = new UCCollection(inventory.getInventoryName());
            for (int i = 0; i < inventory.getSizeInventory(); i++) {
                if (inventory.getStackInSlot(i) != null) {
                    collection.getEditableFields().add(new InfoEditorType("slot" + i, "Slot " + i, "", inventory.getStackInSlot(i).stackSize + " " + inventory.getStackInSlot(i).getDisplayName()));
                }
            }
            getCollections().add(collection);
        }
    }
}
