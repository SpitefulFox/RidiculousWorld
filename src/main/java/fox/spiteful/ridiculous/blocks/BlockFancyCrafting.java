package fox.spiteful.ridiculous.blocks;

import fox.spiteful.ridiculous.Ridiculous;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class BlockFancyCrafting extends BlockWorkbench {
    public static final String[] types = {"spooky", "bubblegum", "shadow"};


    public BlockFancyCrafting(){
        this.setSoundType(SoundType.WOOD);
        setHardness(2.5F);
        this.setUnlocalizedName("workbench");
        setCreativeTab(Ridiculous.tab);
    }

    @Override
    public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list)
    {
        for (int x = 0; x < types.length;x++)
        {
            list.add(new ItemStack(block, 1, x));
        }
    }

    /*@Override
    public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            player.openGui(Ridiculous.instance, 0, world, x, y, z);
            return true;
        }
    }*/

}
