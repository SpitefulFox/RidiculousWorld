package fox.spiteful.ridiculous;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import fox.spiteful.ridiculous.biomes.UnrealBiomes;
import fox.spiteful.ridiculous.entities.EntityWarhorse;
import fox.spiteful.ridiculous.items.RidiculousItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityHorse;
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
import net.minecraftforge.event.entity.living.LivingSpawnEvent;

import java.util.Random;

public class RWEventHandler {

    Random randy = new Random();

    @SubscribeEvent
    public void onSpawn(LivingSpawnEvent event){
        if(event.world.getBiomeGenForCoords(MathHelper.floor_double(event.x), MathHelper.floor_double(event.z)) == UnrealBiomes.spooky) {
            if((event.entityLiving instanceof EntityZombie || event.entityLiving instanceof EntitySkeleton)&& randy.nextInt(12) == 1) {
                event.entityLiving.setCurrentItemOrArmor(4, new ItemStack(Blocks.lit_pumpkin, 1));
                event.entityLiving.setCurrentItemOrArmor(0, new ItemStack(RidiculousItems.rustySickle, 1));
                ((EntityLiving)event.entityLiving).setEquipmentDropChance(0, 0.2F);
            }
            else if(event.entityLiving instanceof EntityWolf && randy.nextInt(4) != 1)
                ((EntityWolf)event.entityLiving).setAngry(true);
        }
        else if(event.world.getBiomeGenForCoords(MathHelper.floor_double(event.x), MathHelper.floor_double(event.z)) == UnrealBiomes.ossuary) {
            if(event.entityLiving instanceof EntitySkeleton && randy.nextInt(5) <= 3 &&
                    ((EntityLiving)event.entityLiving).getCanSpawnHere() &&
                    event.world.canBlockSeeTheSky(MathHelper.floor_double(event.entityLiving.posX), MathHelper.floor_double(event.entityLiving.posY), MathHelper.floor_double(event.entityLiving.posZ))){
                EntityWarhorse steed = new EntityWarhorse(event.world);
                steed.setLocationAndAngles(event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, event.entityLiving.rotationYaw, event.entityLiving.rotationPitch);
                event.world.spawnEntityInWorld(steed);
            }
            if((event.entityLiving instanceof EntitySkeleton || event.entityLiving instanceof EntityZombie) &&
                    event.world.canBlockSeeTheSky(MathHelper.floor_double(event.entityLiving.posX), MathHelper.floor_double(event.entityLiving.posY), MathHelper.floor_double(event.entityLiving.posZ))
                    && event.world.isDaytime()) {
                event.entityLiving.setCurrentItemOrArmor(4, new ItemStack(Items.golden_helmet, 1, 0));
                event.setResult(Event.Result.ALLOW);
            }
        }
        else if(event.world.getBiomeGenForCoords(MathHelper.floor_double(event.x), MathHelper.floor_double(event.z)) == UnrealBiomes.murica) {
            if(event.entityLiving instanceof EntitySheep){
                EntitySheep sheepy = (EntitySheep)event.entityLiving;
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
        else if(event.world.getBiomeGenForCoords(MathHelper.floor_double(event.x), MathHelper.floor_double(event.z)) == UnrealBiomes.candy) {
            if(event.entityLiving instanceof EntitySheep){
                EntitySheep sheepy = (EntitySheep)event.entityLiving;
                sheepy.setFleeceColor(randy.nextInt(16));
            }
        }
        /*if(event.world.getBiomeGenForCoords(MathHelper.floor_double(event.x), MathHelper.floor_double(event.z)) == UnrealBiomes.madness) {
            if (event.entityLiving instanceof EntityZombie) {
                EntityZombie entityZombie = (EntityZombie) event.entity;
                if (!entityZombie.isVillager()) {
                    if (entityZombie.worldObj.playerEntities.size() > 0) {
                        int i = randy.nextInt(entityZombie.worldObj.playerEntities.size());
                        EntityPlayer player = (EntityPlayer) entityZombie.worldObj.playerEntities.get(i);
                        ItemStack head = new ItemStack(Items.skull, 1, 3);
                        NBTTagCompound nametag = new NBTTagCompound();
                        nametag.setString("SkullOwner", player.getDisplayName());
                        head.setTagCompound(nametag);
                        entityZombie.setCurrentItemOrArmor(4, head);
                        entityZombie.setEquipmentDropChance(4, 100);
                    }
                }
            }
        }*/
    }

    @SubscribeEvent
    public void onLivingDrops(LivingDropsEvent event)
    {
        if (event.entityLiving.getClass() == EntitySkeleton.class && event.recentlyHit && event.source.getEntity() != null
                && event.source.getEntity() instanceof EntityPlayer)
        {
            ItemStack weap = ((EntityPlayer)event.source.getEntity()).getCurrentEquippedItem();

            if (weap != null && weap.getItem() == RidiculousItems.rustySickle && randy.nextInt(26) <= (3 + EnchantmentHelper.getEnchantmentLevel(Enchantment.looting.effectId, weap)))
            {
                addDrop(event, new ItemStack(Items.skull, 1, ((EntitySkeleton)event.entityLiving).getSkeletonType()));
            }
        }

        if (event.entityLiving.getClass() == EntityZombie.class && event.recentlyHit && event.source.getEntity() != null
                && event.source.getEntity() instanceof EntityPlayer)
        {
            ItemStack weap = ((EntityPlayer)event.source.getEntity()).getCurrentEquippedItem();

            if (weap != null && weap.getItem() == RidiculousItems.rustySickle && randy.nextInt(26) <= (2 + 2 * EnchantmentHelper.getEnchantmentLevel(Enchantment.looting.effectId, weap)))
            {
                addDrop(event, new ItemStack(Items.skull, 1, 2));
            }
        }

        if (event.entityLiving.getClass() == EntityCreeper.class && event.recentlyHit && event.source.getEntity() != null
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
