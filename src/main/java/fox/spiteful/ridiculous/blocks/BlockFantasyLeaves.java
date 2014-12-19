package fox.spiteful.ridiculous.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.ridiculous.Ridiculous;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BlockFantasyLeaves extends BlockLeaves {
    public static final String[] types = new String[] {"spooky", "bubblegum", "shadow", "livingwood"};

    public BlockFantasyLeaves(){
        super();
        this.setCreativeTab(Ridiculous.tab);
    }

    /**
     * Returns the color this block should be rendered. Used by leaves.
     */
    @SideOnly(Side.CLIENT)
    public int getRenderColor(int metadata)
    {
        if((metadata & 3) == 0)
            return 0xF2A100;
        else if((metadata & 3) == 1)
            return 0xFF70F7;
        else if ((metadata & 3) == 2)
            return 0xFFFFFF;
        else if ((metadata & 3) == 3)
            return 0x00E107;
        else
            return super.getRenderColor(metadata);
    }

    /**
     * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
     * when first determining what to render.
     */
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess world, int x, int y, int z)
    {
        int l = world.getBlockMetadata(x, y, z);
        if((l & 3) == 0)
            return 0xF2A100;
        else if((l & 3) == 1)
            return 0xFF70F7;
        else if ((l & 3) == 2)
            return 0xFFFFFF;
        else
            return super.colorMultiplier(world, x, y, z);
    }

    /* Extra drops like apples */
    protected void func_150124_c(World world, int x, int y, int z, int metadata, int chance)
    {
        //if ((metadata & 3) == 0 && world.rand.nextInt(chance) == 0)
        //{
        //    this.dropBlockAsItem(world, x, y, z, new ItemStack(Items.apple, 1, 0));
        //}
    }

    public Item getItemDropped(int metdata, Random rand, int fortune)
    {
        return Item.getItemFromBlock(RidiculousBlocks.treeSaplings);
    }

    /* Chance of drops */
    protected int func_150123_b(int metadata)
    {
        int j = super.func_150123_b(metadata);

        /*if ((metadata & 3) == 3)
        {
            j = 40;
        }*/

        return j;
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        return this.field_150129_M[(!isOpaqueCube() ? 0 : 1)][(metadata & 3) % types.length];
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
        this.field_150129_M[0] = new IIcon[types.length];
        this.field_150129_M[1] = new IIcon[types.length];

        for (int x = 0;x < types.length;x++){
            this.field_150129_M[0][x] = iconRegister.registerIcon("ridiculous:leaves_" + types[x]);
            this.field_150129_M[1][x] = iconRegister.registerIcon("ridiculous:leaves_" + types[x] + "_opaque");
        }
    }

    public String[] func_150125_e()
    {
        return types;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return Blocks.leaves.isOpaqueCube();
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side)
    {
        return true;
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World world, int x, int y, int z, Random rand)
    {
        if((world.getBlockMetadata(x, y, z) & 3) == 3)
            return;
        else
            super.updateTick(world, x, y, z, rand);
    }
}
