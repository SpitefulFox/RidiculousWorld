package fox.spiteful.ridiculous.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.ridiculous.entities.*;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.List;

public class ItemRidiculousSpawner extends Item
{
    private IIcon easter;
    private final int[] speckles = {0x2EAB25, 0xFFF557, 0x75FFFB, 0x04F8FF, 0xF8FCE1, 0xFFFFFF};
    private final int[] shell = {0x90621D, 0xFFF557, 0xFF80FF, 0xFFFFFF, 0xA98125, 0x110054};
    private final String[] mobNames = {"RidiculousWorld.Frankenstein", "RidiculousWorld.Peep", "RidiculousWorld.Unicorn", "RidiculousWorld.Calavera", "RidiculousWorld.Gingerbread", "RidiculousWorld.Shoggoth"};

    public ItemRidiculousSpawner()
    {
        super();
        this.setCreativeTab(CreativeTabs.tabMisc);
        this.setHasSubtypes(true);
    }

    @Override
    public void registerIcons (IIconRegister iconRegister){
        easter = iconRegister.registerIcon("ridiculous:easter_egg");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses ()
    {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamageForRenderPass (int damage, int pass)
    {
        if(damage == 1)
            return easter;
        else
            return Items.spawn_egg.getIconFromDamageForRenderPass(damage, pass);
    }

    @Override
    public String getItemStackDisplayName (ItemStack item)
    {
        String s = ("" + StatCollector.translateToLocal(Items.spawn_egg.getUnlocalizedName() + ".name")).trim();
        String s1 = mobNames[item.getItemDamage()];

        if (s1 != null)
        {
            s = s + " " + StatCollector.translateToLocal("entity." + s1 + ".name");
        }

        return s;
    }

    @Override
    public void getSubItems (Item id, CreativeTabs tab, List list)
    {
        for (int x = 0; x < mobNames.length; x++)
            list.add(new ItemStack(id, 1, x));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack (ItemStack stack, int pass)
    {
        int damage = stack.getItemDamage();
        if(damage == 1)
            return 16777215;
        else
            return pass == 0 ? shell[damage] : speckles[damage];
    }

    @Override
    public boolean onItemUse (ItemStack stack, EntityPlayer player, World world, int posX, int posY, int posZ, int par7, float par8, float par9, float par10)
    {
        if (!world.isRemote)
        {
            activateSpawnEgg(stack, world, posX, posY, posZ, par7);
            if (!player.capabilities.isCreativeMode)
            {
                --stack.stackSize;
            }
        }
        return true;
    }

    public static EntityLiving activateSpawnEgg (ItemStack stack, World world, double posX, double posY, double posZ, int par7)
    {
        Block i1 = world.getBlock((int) posX, (int) posY, (int) posZ);
        posX += Facing.offsetsXForSide[par7];
        posY += Facing.offsetsYForSide[par7];
        posZ += Facing.offsetsZForSide[par7];
        double d0 = 0.0D;

        if (par7 == 1 && i1 != null && i1.getRenderType() == 11)
        {
            d0 = 0.5D;
        }

        int damage = stack.getItemDamage();
        EntityLiving entity = null;
        switch (damage)
        {
            case 0:
                entity = new EntityFrankenstein(world);
                spawnEntity(posX, posY, posZ, entity, world);
                break;
            case 1:
                entity = new EntityPeep(world);
                spawnEntity(posX, posY, posZ, entity, world);
                break;
            case 2:
                entity = new EntityUnicorn(world);
                spawnEntity(posX, posY, posZ, entity, world);
                break;
            case 3:
                entity = new EntityCalavera(world);
                spawnEntity(posX, posY, posZ, entity, world);
                break;
            case 4:
                entity = new EntityGingerbread(world);
                spawnEntity(posX, posY, posZ, entity, world);
                break;
            case 5:
                entity = new EntityShoggoth(world);
                spawnEntity(posX, posY, posZ, entity, world);
                break;
        }
        return entity;
    }

    public static void spawnEntity (double x, double y, double z, EntityLiving entity, World world)
    {
        if (!world.isRemote)
        {
            entity.setPosition(x, y, z);
            entity.onSpawnWithEgg((IEntityLivingData)null);
            world.spawnEntityInWorld(entity);
        }
    }
}