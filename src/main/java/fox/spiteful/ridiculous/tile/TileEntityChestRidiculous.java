package fox.spiteful.ridiculous.tile;

import fox.spiteful.ridiculous.blocks.RidiculousBlocks;
import fox.spiteful.ridiculous.gui.ContainerLargeChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.Constants;

import java.util.List;

public class TileEntityChestRidiculous extends TileEntity implements IInventory{

    public ItemStack[] chestContents;
    private int numUsingPlayers;
    private int facing;
    public float lidAngle;
    public float prevLidAngle;
    private int ticksSinceSync = -1;

    public TileEntityChestRidiculous(){
        chestContents = new ItemStack[54];
    }

    @Override
    public void closeInventory()
    {
        if (worldObj == null) return;
        numUsingPlayers--;
        worldObj.addBlockEvent(xCoord, yCoord, zCoord, RidiculousBlocks.chest, 1, numUsingPlayers);
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemstack)
    {
        return true;
    }

    @Override
    public ItemStack getStackInSlot(int slot)
    {
        return chestContents[slot];
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemstack)
    {
        chestContents[i] = itemstack;
        if (itemstack != null && itemstack.stackSize > getInventoryStackLimit())
        {
            itemstack.stackSize = getInventoryStackLimit();
        }
        markDirty();
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer)
    {
        if (worldObj == null)
        {
            return true;
        }
        if (worldObj.getTileEntity(xCoord, yCoord, zCoord) != this)
        {
            return false;
        }
        return entityplayer.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64D;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        if (this.chestContents[slot] != null)
        {
            ItemStack stack = this.chestContents[slot];
            this.chestContents[slot] = null;
            return stack;
        }
        else
        {
            return null;
        }
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return false;
    }

    @Override
    public ItemStack decrStackSize(int i, int j)
    {
        if (chestContents[i] != null)
        {
            if (chestContents[i].stackSize <= j)
            {
                ItemStack itemstack = chestContents[i];
                chestContents[i] = null;
                markDirty();
                return itemstack;
            }
            ItemStack itemstack1 = chestContents[i].splitStack(j);
            if (chestContents[i].stackSize == 0)
            {
                chestContents[i] = null;
            }
            markDirty();
            return itemstack1;
        }
        else
        {
            return null;
        }
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public String getInventoryName()
    {
        return "botanicalChest";
    }

    @Override
    public int getSizeInventory()
    {
        return 54;
    }

    @Override
    public void openInventory()
    {
        if (worldObj == null) return;
        numUsingPlayers++;
        worldObj.addBlockEvent(xCoord, yCoord, zCoord, RidiculousBlocks.chest, 1, numUsingPlayers);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readFromNBT(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.getTagList("Items", Constants.NBT.TAG_COMPOUND);
        chestContents = new ItemStack[getSizeInventory()];
        for (int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 0xff;
            if (j >= 0 && j < chestContents.length)
            {
                chestContents[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
        facing = nbttagcompound.getByte("facing");
    }
    @Override
    public void writeToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeToNBT(nbttagcompound);
        NBTTagList nbttaglist = new NBTTagList();
        for (int i = 0; i < chestContents.length; i++)
        {
            if (chestContents[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte) i);
                chestContents[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }
        nbttagcompound.setTag("Items", nbttaglist);
        nbttagcompound.setByte("facing", (byte)facing);
    }

    @Override
    public void updateEntity()
    {
        super.updateEntity();
        // Resynchronize clients with the server state
        if (worldObj != null && !this.worldObj.isRemote && this.numUsingPlayers != 0 && (this.ticksSinceSync + this.xCoord + this.yCoord + this.zCoord) % 200 == 0)
        {
            this.numUsingPlayers = 0;
            float var1 = 5.0F;
            @SuppressWarnings("unchecked")
            List<EntityPlayer> var2 = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox((double) ((float) this.xCoord - var1), (double) ((float) this.yCoord - var1), (double) ((float) this.zCoord - var1), (double) ((float) (this.xCoord + 1) + var1), (double) ((float) (this.yCoord + 1) + var1), (double) ((float) (this.zCoord + 1) + var1)));
            for (EntityPlayer var4 : var2) {
                if (var4.openContainer instanceof ContainerLargeChest) {
                    ++this.numUsingPlayers;
                }
            }
        }
        if (worldObj != null && !worldObj.isRemote && ticksSinceSync < 0)
        {
            worldObj.addBlockEvent(xCoord, yCoord, zCoord, RidiculousBlocks.chest, 3, ((numUsingPlayers << 3) & 0xF8) | (facing & 0x7));
        }
        this.ticksSinceSync++;
        prevLidAngle = lidAngle;
        float f = 0.1F;
        if (numUsingPlayers > 0 && lidAngle == 0.0F)
        {
            double d = (double) xCoord + 0.5D;
            double d1 = (double) zCoord + 0.5D;
            worldObj.playSoundEffect(d, (double) yCoord + 0.5D, d1, "random.chestopen", 0.5F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
        }
        if (numUsingPlayers == 0 && lidAngle > 0.0F || numUsingPlayers > 0 && lidAngle < 1.0F)
        {
            float f1 = lidAngle;
            if (numUsingPlayers > 0)
            {
                lidAngle += f;
            }
            else
            {
                lidAngle -= f;
            }
            if (lidAngle > 1.0F)
            {
                lidAngle = 1.0F;
            }
            float f2 = 0.5F;
            if (lidAngle < f2 && f1 >= f2)
            {
                double d2 = (double) xCoord + 0.5D;
                double d3 = (double) zCoord + 0.5D;
                worldObj.playSoundEffect(d2, (double) yCoord + 0.5D, d3, "random.chestclosed", 0.5F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
            }
            if (lidAngle < 0.0F)
            {
                lidAngle = 0.0F;
            }
        }
    }

    public int getFacing()
    {
        return this.facing;
    }

    public void setFacing(int facing2)
    {
        this.facing = facing2;
    }
}
