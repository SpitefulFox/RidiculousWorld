package fox.spiteful.ridiculous.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.ridiculous.Ridiculous;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class BlockFantasyLog extends BlockLog {
    public static final String[] types = new String[] {"spooky", "bubblegum", "shadow"};

    public BlockFantasyLog()
    {
        super();
        this.setHardness(1.5F);
        this.setResistance(5F);
        this.setStepSound(Block.soundTypeWood);
        this.setCreativeTab(Ridiculous.tab);
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        for(int x = 0;x < types.length;x++)
            list.add(new ItemStack(item, 1, x));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.field_150167_a = new IIcon[types.length];
        this.field_150166_b = new IIcon[types.length];

        for (int i = 0; i < this.field_150167_a.length; ++i)
        {
            this.field_150167_a[i] = iconRegister.registerIcon("ridiculous:" + "log" + "_" + types[i]);
            this.field_150166_b[i] = iconRegister.registerIcon("ridiculous:" + "log" + "_" + types[i] + "_top");
        }
    }

}
