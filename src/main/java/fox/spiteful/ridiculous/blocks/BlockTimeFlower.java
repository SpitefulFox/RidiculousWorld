package fox.spiteful.ridiculous.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.ridiculous.Ridiculous;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class BlockTimeFlower extends BlockBush {

    public static final String[] types = {"rose", "cyan", "peony"};

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public BlockTimeFlower(){
        super(Material.plants);
        setHardness(0.0F);
        setStepSound(soundTypeGrass);
        setCreativeTab(Ridiculous.tab);
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        return this.icons[metadata % types.length];
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int metadata)
    {
        return metadata;
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
        this.icons = new IIcon[types.length];

        for (int i = 0; i < this.icons.length; ++i)
        {
            this.icons[i] = iconRegister.registerIcon("ridiculous:flower_" + types[i]);
        }
    }

}
