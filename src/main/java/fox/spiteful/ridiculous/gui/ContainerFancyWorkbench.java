package fox.spiteful.ridiculous.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.world.World;

public class ContainerFancyWorkbench extends ContainerWorkbench {
    int posX;
    int posY;
    int posZ;

    public ContainerFancyWorkbench(InventoryPlayer inv, World world, int x, int y, int z){
        super(inv, world, x, y, z);
        posX = x;
        posY = y;
        posZ = z;
    }

    public boolean canInteractWith(EntityPlayer player)
    {
        return player.getDistanceSq((double)this.posX + 0.5D, (double)this.posY + 0.5D, (double)this.posZ + 0.5D) <= 64.0D;
    }
}
