package fox.spiteful.ridiculous.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.ridiculous.Ridiculous;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public class BlockFancyCrafting extends BlockWorkbench {
    static final String[] types = {"spooky", "bubblegum"};
    IIcon[] top;
    IIcon[] front;
    IIcon[] sides;
    IIcon[] bottom;

    public BlockFancyCrafting(){
        setStepSound(Block.soundTypeWood);
        setHardness(2.5F);
        setBlockName("workbench");
        setCreativeTab(Ridiculous.tab);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons (IIconRegister iconRegister)
    {
        this.top = new IIcon[types.length];
        this.front = new IIcon[types.length];
        this.sides = new IIcon[types.length];
        this.bottom = new IIcon[types.length];
        for (int i = 0; i < this.top.length; ++i)
        {
            this.top[i] = iconRegister.registerIcon("ridiculous:crafting_table_top_" + types[i]);
            this.front[i] = iconRegister.registerIcon("ridiculous:crafting_table_front_" + types[i]);
            this.sides[i] = iconRegister.registerIcon("ridiculous:crafting_table_side_" + types[i]);
            this.bottom[i] = iconRegister.registerIcon("ridiculous:planks_" + types[i]);
        }
    }
    @Override
    public int damageDropped (int meta)
    {
        return meta;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon (int side, int metadata)
    {
        if (side == 0)
            return bottom[metadata];
        if (side == 1)
            return top[metadata];
        if (side == 2 || side == 4)
            return front[metadata];
        return sides[metadata];
    }

    @Override
    public boolean renderAsNormalBlock ()
    {
        return false;
    }

    @Override
    public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list)
    {
        for (int x = 0; x < types.length;x++)
        {
            list.add(new ItemStack(block, 1, x));
        }
    }

    @Override
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
    }

}
