package undercurrentblocks.definitions;

import api.undercurrent.iface.UCCollection;
import api.undercurrent.iface.UCTileDefinition;
import api.undercurrent.iface.editorTypes.BooleanEditorType;
import undercurrentblocks.tileEntity.UCRedstoneBlockTile;

/**
 * Created by Niel on 10/16/2015.
 */
public class UCRedstoneBlockDefinition extends UCTileDefinition {

    public UCRedstoneBlockDefinition(Boolean redstoneState) throws Exception {
        UCCollection collection = new UCCollection("Redstone Block Settings");
        collection.getEditableFields().add(new BooleanEditorType("redstoneState", "Redstone State:", "The toggleable state of the block's redstone output", redstoneState));
        getCollections().add(collection);
    }
}
