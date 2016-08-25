package fox.spiteful.ridiculous.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ContainerFancyWorkbench extends ContainerWorkbench {
    private BlockPos pos;
    World worldObj;

    public ContainerFancyWorkbench(InventoryPlayer inv, World world, BlockPos posin){
        super(inv, world, posin);
        pos = posin;
        worldObj = world;
    }

    public boolean canInteractWith(EntityPlayer player)
    {
        return this.worldObj.isAirBlock(pos) ? false : player.getDistanceSq(pos) <= 64.0D;
    }
}
