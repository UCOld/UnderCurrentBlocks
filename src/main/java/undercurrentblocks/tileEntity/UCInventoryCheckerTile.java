package undercurrentblocks.tileEntity;

import api.undercurrent.iface.UCTileDefinition;
import api.undercurrent.iface.IUCTile;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import undercurrentblocks.definitions.UCInventoryCheckerDefinition;

import java.util.ArrayList;

/**
 * Created by Niel on 10/16/2015.
 */
public class UCInventoryCheckerTile extends TileEntity implements IUCTile {


    @Override
    public void writeToNBT(NBTTagCompound tag) {

        super.writeToNBT(tag);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {

        super.readFromNBT(tag);
    }

    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        this.writeToNBT(tag);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 2, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
        super.onDataPacket(net, packet);
        readFromNBT(packet.func_148857_g());
    }

    @Override
    public UCTileDefinition getTileDefinition() throws Exception {

        ArrayList<IInventory> inventories = new ArrayList<IInventory>();

        if (worldObj.getTileEntity(xCoord + 1, yCoord, zCoord) instanceof IInventory) {
            inventories.add((IInventory) worldObj.getTileEntity(xCoord + 1, yCoord, zCoord));
        }

        if (worldObj.getTileEntity(xCoord - 1, yCoord, zCoord) instanceof IInventory) {
            inventories.add((IInventory) worldObj.getTileEntity(xCoord - 1, yCoord, zCoord));
        }

        if (worldObj.getTileEntity(xCoord, yCoord + 1, zCoord) instanceof IInventory) {
            inventories.add((IInventory) worldObj.getTileEntity(xCoord, yCoord + 1, zCoord));
        }

        if (worldObj.getTileEntity(xCoord, yCoord - 1, zCoord) instanceof IInventory) {
            inventories.add((IInventory) worldObj.getTileEntity(xCoord, yCoord - 1, zCoord));
        }

        if (worldObj.getTileEntity(xCoord, yCoord, zCoord + 1) instanceof IInventory) {
            inventories.add((IInventory) worldObj.getTileEntity(xCoord, yCoord, zCoord + 1));
        }

        if (worldObj.getTileEntity(xCoord, yCoord, zCoord - 1) instanceof IInventory) {
            inventories.add((IInventory) worldObj.getTileEntity(xCoord, yCoord, zCoord - 1));
        }

        return new UCInventoryCheckerDefinition(this, inventories);
    }


}
