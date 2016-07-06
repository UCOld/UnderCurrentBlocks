package undercurrentblocks.tileEntity;

import api.undercurrent.iface.IUCTile;
import api.undercurrent.iface.UCTileDefinition;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import undercurrentblocks.definitions.UCRedstoneBlockDefinition;


/**
 * Created by Niel on 10/16/2015.
 */
public class UCRedstoneBlockTile extends TileEntity implements IUCTile {

    public boolean redstoneState;

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setBoolean("redstoneState", redstoneState);
    }

    @Override
    public void updateEntity() {
        if (!this.worldObj.isRemote && this.worldObj.getWorldTime() % 5 == 0) {
            worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
        }
        if (this.worldObj.getWorldTime() % 5 == 0) {
            worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, redstoneState ? 1 : 0, 0);
            worldObj.notifyBlocksOfNeighborChange(xCoord, yCoord, zCoord, worldObj.getBlock(xCoord, yCoord, zCoord));
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        this.redstoneState = tag.getBoolean("redstoneState");
    }

    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setBoolean("redstoneState", redstoneState);
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
        return new UCRedstoneBlockDefinition(this.redstoneState);
    }


}
