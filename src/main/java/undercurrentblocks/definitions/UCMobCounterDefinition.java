package undercurrentblocks.definitions;

import api.undercurrent.iface.UCCollection;
import api.undercurrent.iface.UCTileDefinition;
import api.undercurrent.iface.editorTypes.InfoEditorType;
import net.minecraft.inventory.IInventory;

import java.util.List;

/**
 * Created by Niel on 10/16/2015.
 */
public class UCMobCounterDefinition extends UCTileDefinition {

    public UCMobCounterDefinition(int mobCount) throws Exception {

        UCCollection collection = new UCCollection("Mob Counter");
        collection.getEditableFields().add(new InfoEditorType("mobCount", "Mob Count", "The amount of mobs around the block", String.valueOf(mobCount)));
        getCollections().add(collection);
    }
}

