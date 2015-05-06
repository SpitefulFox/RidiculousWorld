package fox.spiteful.ridiculous;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.ReflectionHelper;
import fox.spiteful.ridiculous.biomes.UnrealBiomes;
import fox.spiteful.ridiculous.entities.EntityWarhorse;
import fox.spiteful.ridiculous.items.RidiculousItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Random;

public class RWEventHandler {

    Random randy = new Random();
    boolean halloween = false;

    public RWEventHandler(){
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        if(cal.get(Calendar.MONTH) + 1 == 10)
            halloween = true;
    }

    @SubscribeEvent
    public void onSpawn(EntityJoinWorldEvent event){

        NBTTagCompound tag = event.entity.getEntityData();
        if(tag.getBoolean("ridiculous"))
            return;
        tag.setBoolean("ridiculous", true);

        if(event.world.getBiomeGenForCoords(MathHelper.floor_double(event.entity.posX), MathHelper.floor_double(event.entity.posZ)) == UnrealBiomes.spooky) {
            if((event.entity instanceof EntityZombie || event.entity instanceof EntitySkeleton)&& randy.nextInt(12) == 1) {
                event.entity.setCurrentItemOrArmor(4, new ItemStack(Blocks.lit_pumpkin, 1));
                event.entity.setCurrentItemOrArmor(0, new ItemStack(RidiculousItems.rustySickle, 1));
                ((EntityLiving)event.entity).setEquipmentDropChance(0, 0.2F);
            }
            else if(event.entity instanceof EntityWolf && randy.nextInt(4) != 1)
                ((EntityWolf)event.entity).setAngry(true);
        }
        else if(event.world.getBiomeGenForCoords(MathHelper.floor_double(event.entity.posX), MathHelper.floor_double(event.entity.posZ)) == UnrealBiomes.ossuary) {
            if(event.entity instanceof EntitySkeleton && randy.nextInt(5) <= 3 &&
                    ((EntityLiving)event.entity).getCanSpawnHere() &&
                    event.world.canBlockSeeTheSky(MathHelper.floor_double(event.entity.posX), MathHelper.floor_double(event.entity.posY), MathHelper.floor_double(event.entity.posZ))){
                EntityWarhorse steed = new EntityWarhorse(event.world);
                steed.setLocationAndAngles(event.entity.posX, event.entity.posY, event.entity.posZ, event.entity.rotationYaw, event.entity.rotationPitch);
                event.world.spawnEntityInWorld(steed);
            }
        }
        else if(event.world.getBiomeGenForCoords(MathHelper.floor_double(event.entity.posX), MathHelper.floor_double(event.entity.posZ)) == UnrealBiomes.murica) {
            if(event.entity instanceof EntitySheep){
                EntitySheep sheepy = (EntitySheep)event.entity;
                int freedom = randy.nextInt(3);
                if(freedom == 0)
                    freedom = 0;
                else if(freedom == 1)
                    freedom = 11;
                else if(freedom == 2)
                    freedom = 14;
                sheepy.setFleeceColor(freedom);
            }
        }
        else if(event.world.getBiomeGenForCoords(MathHelper.floor_double(event.entity.posX), MathHelper.floor_double(event.entity.posZ)) == UnrealBiomes.botania) {
            if(event.entity instanceof EntitySheep){
                EntitySheep sheepy = (EntitySheep)event.entity;
                if(randy.nextInt(3) <= 1)
                    sheepy.setFleeceColor(6);
                else
                    sheepy.setFleeceColor(randy.nextInt(16));
            }
        }
        else if(event.world.getBiomeGenForCoords(MathHelper.floor_double(event.entity.posX), MathHelper.floor_double(event.entity.posZ)) == UnrealBiomes.madness) {
            if (event.entity instanceof EntityEnderman && ((EntityEnderman)event.entity).getCanSpawnHere()
                && event.world.rand.nextInt(20) < 1) {
                EntityEnderman enderman = (EntityEnderman)event.entity;
                try {
                    Field aggro = ReflectionHelper.findField(EntityEnderman.class, "isAggressive", "field_104003_g");
                    aggro.setAccessible(true);
                    aggro.setBoolean(enderman, true);
                }
                catch(Exception e){}

            }
        }
        else if(event.world.getBiomeGenForCoords(MathHelper.floor_double(event.entity.posX), MathHelper.floor_double(event.entity.posZ)) == UnrealBiomes.shadow) {
            if(event.entity instanceof EntitySheep){
                EntitySheep sheepy = (EntitySheep)event.entity;
                if(randy.nextInt(30) <= 1)
                    sheepy.setFleeceColor(10);
                else
                    sheepy.setFleeceColor(15);
            }
        }
    }

    @SubscribeEvent
    public void onLivingDrops(LivingDropsEvent event)
    {
        if(event.entityLiving instanceof IMob && halloween && event.recentlyHit && event.source.getEntity() != null
            && event.source.getEntity() instanceof EntityPlayer && randy.nextInt(10) == 0){
            addDrop(event, new ItemStack(RidiculousItems.candyCorn, 1));
        }

        if (event.entityLiving instanceof EntitySkeleton && event.recentlyHit && event.source.getEntity() != null
                && event.source.getEntity() instanceof EntityPlayer)
        {
            ItemStack weap = ((EntityPlayer)event.source.getEntity()).getCurrentEquippedItem();

            if (weap != null && weap.getItem() == RidiculousItems.rustySickle && randy.nextInt(26) <= (3 + EnchantmentHelper.getEnchantmentLevel(Enchantment.looting.effectId, weap)))
            {
                addDrop(event, new ItemStack(Items.skull, 1, ((EntitySkeleton)event.entityLiving).getSkeletonType()));
            }
        }

        if (event.entityLiving instanceof EntityZombie && event.recentlyHit && event.source.getEntity() != null
                && event.source.getEntity() instanceof EntityPlayer)
        {
            ItemStack weap = ((EntityPlayer)event.source.getEntity()).getCurrentEquippedItem();

            if (weap != null && weap.getItem() == RidiculousItems.rustySickle && randy.nextInt(26) <= (2 + 2 * EnchantmentHelper.getEnchantmentLevel(Enchantment.looting.effectId, weap)))
            {
                addDrop(event, new ItemStack(Items.skull, 1, 2));
            }
        }

        if (event.entityLiving instanceof EntityCreeper && event.recentlyHit && event.source.getEntity() != null
                && event.source.getEntity() instanceof EntityPlayer)
        {
            ItemStack weap = ((EntityPlayer)event.source.getEntity()).getCurrentEquippedItem();

            if (weap != null && weap.getItem() == RidiculousItems.rustySickle && randy.nextInt(26) <= (2 + 2 * EnchantmentHelper.getEnchantmentLevel(Enchantment.looting.effectId, weap)))
            {
                addDrop(event, new ItemStack(Items.skull, 1, 4));
            }
        }

        if (event.entityLiving instanceof EntityPlayer)
        {
            if(event.recentlyHit && event.source.getEntity() != null && event.source.getEntity() instanceof EntityPlayer) {

                ItemStack weap = ((EntityPlayer) event.source.getEntity()).getCurrentEquippedItem();

                if (weap != null && weap.getItem() == RidiculousItems.rustySickle && randy.nextInt(11) <= (1 + EnchantmentHelper.getEnchantmentLevel(Enchantment.looting.effectId, weap))) {
                    ItemStack head = new ItemStack(Items.skull, 1, 3);
                    NBTTagCompound nametag = new NBTTagCompound();
                    nametag.setString("SkullOwner", ((EntityPlayer) event.entityLiving).getDisplayName());
                    head.setTagCompound(nametag);
                    addDrop(event, head);
                }
            }
            else if(event.source.getEntity() != null
                    && event.source.getEntity() instanceof EntityLiving && event.entityLiving.getHeldItem() != null
                    && event.entityLiving.getHeldItem().getItem() == RidiculousItems.rustySickle) {
                ItemStack head = new ItemStack(Items.skull, 1, 3);
                NBTTagCompound nametag = new NBTTagCompound();
                nametag.setString("SkullOwner", ((EntityPlayer) event.entityLiving).getDisplayName());
                head.setTagCompound(nametag);
                addDrop(event, head);
            }
        }
    }

    public void addDrop(LivingDropsEvent event, ItemStack drop)
    {
        EntityItem entityitem = new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, drop);
        entityitem.delayBeforeCanPickup = 10;
        event.drops.add(entityitem);
    }

}
