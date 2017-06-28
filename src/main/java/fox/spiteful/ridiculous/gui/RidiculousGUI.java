package fox.spiteful.ridiculous.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import fox.spiteful.ridiculous.tile.TileEntityChestRidiculous;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.world.World;

public class RidiculousGUI implements IGuiHandler {

    @Override
    public Object getClientGuiElement (int ID, EntityPlayer player, World world, int x, int y, int z){
        if(ID == 0)
            return new GuiCrafting(player.inventory, world, x, y, z);
        else if(ID == 1 && world.getTileEntity(x, y, z) instanceof TileEntityChestRidiculous)
            return new GUILargeChest(player.inventory, (TileEntityChestRidiculous)(world.getTileEntity(x, y, z)));
        return null;
    }

    @Override
    public Object getServerGuiElement (int ID, EntityPlayer player, World world, int x, int y, int z){
        if(ID == 0)
            return new ContainerFancyWorkbench(player.inventory, world, x, y, z);
        else if(ID == 1 && world.getTileEntity(x, y, z) instanceof TileEntityChestRidiculous)
            return new ContainerLargeChest(player.inventory, (TileEntityChestRidiculous)(world.getTileEntity(x, y, z)));
        return null;
    }
}
