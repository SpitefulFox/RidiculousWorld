package fox.spiteful.ridiculous.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.ridiculous.Ridiculous;
import fox.spiteful.ridiculous.tile.TileEntityChestRidiculous;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;

public class BlockChestRidiculous extends BlockContainer {

    private IIcon icons[];
    public static int render;

    public BlockChestRidiculous(){
        super(Material.wood);
        setHardness(3.0F);
        setStepSound(Block.soundTypeWood);
        setBlockBounds(0.0625F, 0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
        setBlockName("chestRidiculous");
        setCreativeTab(Ridiculous.tab);
    }

    @Override
    public TileEntity createNewTileEntity(World w, int i)
    {
        return new TileEntityChestRidiculous();
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return render;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i1, float f1, float f2, float f3)
    {
        TileEntity te = world.getTileEntity(x, y, z);
        if (te == null || !(te instanceof TileEntityChestRidiculous))
        {
            return true;
        }
        if (world.isSideSolid(x, y + 1, z, ForgeDirection.DOWN))
        {
            return true;
        }
        if (world.isRemote)
        {
            return true;
        }
        player.openGui(Ridiculous.instance, 1, world, x, y, z);
        return true;
    }

    @Override
    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase entityliving, ItemStack itemStack)
    {
        byte chestFacing = 0;
        int facing = MathHelper.floor_double((double) ((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        if (facing == 0)
        {
            chestFacing = 2;
        }
        if (facing == 1)
        {
            chestFacing = 5;
        }
        if (facing == 2)
        {
            chestFacing = 3;
        }
        if (facing == 3)
        {
            chestFacing = 4;
        }
        TileEntity te = world.getTileEntity(i, j, k);
        if (te != null && te instanceof TileEntityChestRidiculous)
        {
            TileEntityChestRidiculous chest = (TileEntityChestRidiculous) te;
            chest.setFacing(chestFacing);
            world.markBlockForUpdate(i, j, k);
        }
    }

    @Override
    public void onBlockAdded(World world, int i, int j, int k)
    {
        super.onBlockAdded(world, i, j, k);
        world.markBlockForUpdate(i, j, k);
    }

    @Override
    public void breakBlock(World world, int i, int j, int k, Block i1, int i2)
    {
        TileEntityChestRidiculous tileentitychest = (TileEntityChestRidiculous) world.getTileEntity(i, j, k);
        if (tileentitychest != null)
        {
            dropContent(0, tileentitychest, world, tileentitychest.xCoord, tileentitychest.yCoord, tileentitychest.zCoord);
        }
        super.breakBlock(world, i, j, k, i1, i2);
    }
    public void dropContent(int newSize, IInventory chest, World world, int xCoord, int yCoord, int zCoord)
    {
        for (int l = newSize; l < chest.getSizeInventory(); l++)
        {
            ItemStack itemstack = chest.getStackInSlot(l);
            if (itemstack == null)
            {
                continue;
            }
            float f = world.rand.nextFloat() * 0.8F + 0.1F;
            float f1 = world.rand.nextFloat() * 0.8F + 0.1F;
            float f2 = world.rand.nextFloat() * 0.8F + 0.1F;
            while (itemstack.stackSize > 0)
            {
                int i1 = world.rand.nextInt(21) + 10;
                if (i1 > itemstack.stackSize)
                {
                    i1 = itemstack.stackSize;
                }
                itemstack.stackSize -= i1;
                EntityItem entityitem = new EntityItem(world, (float) xCoord + f, (float) yCoord + (newSize > 0 ? 1 : 0) + f1, (float) zCoord + f2,
                        new ItemStack(itemstack.getItem(), i1, itemstack.getItemDamage()));
                float f3 = 0.05F;
                entityitem.motionX = (float) world.rand.nextGaussian() * f3;
                entityitem.motionY = (float) world.rand.nextGaussian() * f3 + 0.2F;
                entityitem.motionZ = (float) world.rand.nextGaussian() * f3;
                if (itemstack.hasTagCompound())
                {
                    entityitem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
                }
                world.spawnEntityInWorld(entityitem);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register)
    {
        icons = new IIcon[3];
        icons[0] = register.registerIcon("ridiculous:botanical_chest_top");
        icons[1] = register.registerIcon("ridiculous:botanical_chest_front");
        icons[2] = register.registerIcon("ridiculous:botanical_chest_side");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta)
    {
        return icons[side % icons.length];
    }
}
