package undercurrentblocks.definitions;

import api.undercurrent.iface.UCCollection;
import api.undercurrent.iface.UCTileDefinition;
import api.undercurrent.iface.editorTypes.InfoEditorType;

/**
 * Created by Niel on 10/16/2015.
 */
public class UCPlayerCounterDefinition extends UCTileDefinition {

    public UCPlayerCounterDefinition(int playerCount) throws Exception {

        UCCollection collection = new UCCollection("Player Counter");
        collection.getEditableFields().add(new InfoEditorType("playerCount", "Player Count", "The amount of players around the block", String.valueOf(playerCount)));
        getCollections().add(collection);
    }
}

