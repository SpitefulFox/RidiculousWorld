package fox.spiteful.ridiculous.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerLargeChest extends Container {

    private IInventory chest;

    public ContainerLargeChest(IInventory playerInventory, IInventory chestInventory){
        chest = chestInventory;

        for (int chestRow = 0; chestRow < 6; chestRow++)
        {
            for (int chestCol = 0; chestCol < 9; chestCol++)
            {
                addSlotToContainer(new Slot(chestInventory, chestCol + chestRow * 9, 12 + chestCol * 18, 8 + chestRow * 18));
            }
        }
        int leftCol = (184 - 162) / 2 + 1;
        for (int playerInvRow = 0; playerInvRow < 3; playerInvRow++)
        {
            for (int playerInvCol = 0; playerInvCol < 9; playerInvCol++)
            {
                addSlotToContainer(new Slot(playerInventory, playerInvCol + playerInvRow * 9 + 9, leftCol + playerInvCol * 18, 202 - (4 - playerInvRow) * 18
                        - 10));
            }
        }
        for (int hotbarSlot = 0; hotbarSlot < 9; hotbarSlot++)
        {
            addSlotToContainer(new Slot(playerInventory, hotbarSlot, leftCol + hotbarSlot * 18, 202 - 24));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return chest.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer p, int i)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot) inventorySlots.get(i);
        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (i < 54)
            {
                if (!mergeItemStack(itemstack1, 54, inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (!mergeItemStack(itemstack1, 0, 54, false))
            {
                return null;
            }
            if (itemstack1.stackSize == 0)
            {
                slot.putStack(null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }
        return itemstack;
    }

    @Override
    public void onContainerClosed(EntityPlayer entityplayer)
    {
        super.onContainerClosed(entityplayer);
        chest.closeInventory();
    }

}
