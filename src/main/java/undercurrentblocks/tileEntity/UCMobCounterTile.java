package undercurrentblocks.tileEntity;

import api.undercurrent.iface.IUCTile;
import api.undercurrent.iface.UCTileDefinition;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import undercurrentblocks.definitions.UCInventoryCheckerDefinition;
import undercurrentblocks.definitions.UCMobCounterDefinition;
import undercurrentblocks.definitions.UCPlayerCounterDefinition;

/**
 * Created by Niel on 10/16/2015.
 */
public class UCMobCounterTile extends TileEntity implements IUCTile {


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

        AxisAlignedBB box = AxisAlignedBB.getBoundingBox(this.xCoord - 25, this.yCoord - 25, this.zCoord - 25, this.xCoord + 25, this.yCoord + 25, this.zCoord + 25);
        int entitiesCount = worldObj.getEntitiesWithinAABB(EntityLivingBase.class, box).size();
        return new UCMobCounterDefinition(entitiesCount);
    }


}
