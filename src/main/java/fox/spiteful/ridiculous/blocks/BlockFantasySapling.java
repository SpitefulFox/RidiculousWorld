package fox.spiteful.ridiculous.blocks;

import fox.spiteful.ridiculous.Ridiculous;
import fox.spiteful.ridiculous.world.WorldGenBigSpookyTree;
import fox.spiteful.ridiculous.world.WorldGenBubblegumTree;
import fox.spiteful.ridiculous.world.WorldGenShadowTree;
import fox.spiteful.ridiculous.world.WorldGenSpookyTree;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.List;
import java.util.Random;

public class BlockFantasySapling extends BlockSapling
{
    public static final String[] types = new String[] {"spooky", "bubblegum", "shadow"};
    private IIcon[] textures;

    public BlockFantasySapling()
    {
        this.setHardness(0.0F);
        this.setStepSound(Block.soundTypeGrass);
        this.setCreativeTab(Ridiculous.tab);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        textures = new IIcon[types.length];

        for (int i = 0; i < types.length; ++i) {
            textures[i] = iconRegister.registerIcon("ridiculous:sapling_" + types[i]);
        }

    }

    @Override
    public IIcon getIcon(int side, int metadata)
    {
        return textures[(metadata & (types.length - 1)) % types.length];
    }

    @Override
    public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list)
    {
        for (int x = 0; x < types.length;x++)
        {
            list.add(new ItemStack(block, 1, x));
        }
    }

    public boolean isValidPosition(World world, int x, int y, int z, int metadata)
    {
        Block block = world.getBlock(x, y - 1, z);
        if(block == null)
            return false;
        return block.getMaterial() == Material.grass || block == Blocks.dirt || block.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this);
    }

    @Override
    public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side)
    {
        return isValidPosition(world, x, y, z, -1);
    }

    @Override
    public boolean canBlockStay(World world, int x, int y, int z)
    {
        return isValidPosition(world, x, y, z, -1);
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random)
    {
        if (!world.isRemote)
        {
            if (world.getBlockLightValue(x, y + 1, z) >= 9 && random.nextInt(7) == 0)
            {
                this.func_149878_d(world, x, y, z, random);
            }
        }
    }

    @Override
    /* Grow the tree */
    public void func_149878_d(World world, int x, int y, int z, Random rand)
    {
        int meta = world.getBlockMetadata(x, y, z) & (types.length - 1);
        Object obj = null;
        //int rnd = rand.nextInt(8);

        if (obj == null)
        {
            switch (meta)
            {
                case 0:
                    obj = rand.nextInt(10) == 0 ? new WorldGenBigSpookyTree(true) : new WorldGenSpookyTree(true);
                    break;
                case 1:
                    obj = new WorldGenBubblegumTree(true);
                    break;
                case 2:
                    obj = new WorldGenShadowTree(true, 4, 2, 2, false);
                    break;
            }
        }

        if (obj != null)
        {
            world.setBlockToAir(x, y, z);

            if (!((WorldGenerator)obj).generate(world, rand, x, y, z))
            {
                world.setBlock(x, y, z, this, meta, 2);
            }
        }
    }

    @Override
    public int damageDropped(int meta)
    {
        return meta & (types.length - 1);
    }

    @Override
    public int getDamageValue(World world, int x, int y, int z)
    {
        return world.getBlockMetadata(x, y, z) & (types.length - 1);
    }
}
