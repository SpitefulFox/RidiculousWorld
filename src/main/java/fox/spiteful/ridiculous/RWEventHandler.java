package fox.spiteful.ridiculous;

import fox.spiteful.ridiculous.biomes.UnrealBiomes;
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
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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

        if(event.getWorld().isRemote)
            return;
        NBTTagCompound tag = event.getEntity().getEntityData();
        if(tag.getBoolean("ridiculous"))
            return;
        tag.setBoolean("ridiculous", true);

        if(event.getWorld().getBiome(new BlockPos(MathHelper.floor(event.getEntity().posX), MathHelper.floor(event.getEntity().posY), MathHelper.floor(event.getEntity().posZ))) == UnrealBiomes.spooky) {
            if((event.getEntity() instanceof EntityZombie || event.getEntity() instanceof EntitySkeleton)){//&& randy.nextInt(12) == 1) {
                event.getEntity().setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Blocks.LIT_PUMPKIN, 1));
                event.getEntity().setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(RidiculousItems.rustySickle, 1));
                ((EntityLiving)event.getEntity()).setDropChance(EntityEquipmentSlot.MAINHAND, 0.3F);
            }
            else if(event.getEntity() instanceof EntityWolf && randy.nextInt(4) != 1)
                ((EntityWolf)event.getEntity()).setAngry(true);
        }
        /*else if(event.getWorld().getBiome(MathHelper.floor(event.getEntity().posX), MathHelper.floor(event.getEntity().posZ)) == UnrealBiomes.ossuary) {
            if(event.getEntity() instanceof EntitySkeleton && randy.nextInt(5) <= 3 &&
                    ((EntityLiving)event.getEntity()).getCanSpawnHere() &&
                    event.getWorld().canBlockSeeTheSky(MathHelper.floor(event.getEntity().posX), MathHelper.floor(event.getEntity().posY), MathHelper.floor(event.getEntity().posZ))){
                EntityWarhorse steed = new EntityWarhorse(event.getWorld());
                steed.setLocationAndAngles(event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, event.getEntity().rotationYaw, event.getEntity().rotationPitch);
                event.getWorld().spawnEntityInWorld(steed);
                event.getEntity().mountEntity(steed);
            }
        }
        else if(event.getWorld().getBiome(MathHelper.floor(event.getEntity().posX), MathHelper.floor(event.getEntity().posZ)) == UnrealBiomes.murica) {
            if(event.getEntity() instanceof EntitySheep){
                EntitySheep sheepy = (EntitySheep)event.getEntity();
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
        else if(event.getWorld().getBiome(MathHelper.floor(event.getEntity().posX), MathHelper.floor(event.getEntity().posZ)) == UnrealBiomes.botania) {
            if(event.getEntity() instanceof EntitySheep){
                EntitySheep sheepy = (EntitySheep)event.getEntity();
                if(randy.nextInt(3) <= 1)
                    sheepy.setFleeceColor(6);
                else
                    sheepy.setFleeceColor(randy.nextInt(16));
            }
        }
        else if(event.getWorld().getBiome(MathHelper.floor(event.getEntity().posX), MathHelper.floor(event.getEntity().posZ)) == UnrealBiomes.madness) {
            if (event.getEntity() instanceof EntityEnderman && ((EntityEnderman)event.getEntity()).getCanSpawnHere()
                && event.getWorld().rand.nextInt(20) < 1) {
                EntityEnderman enderman = (EntityEnderman)event.getEntity();
                try {
                    Field aggro = ReflectionHelper.findField(EntityEnderman.class, "isAggressive", "field_104003_g");
                    aggro.setAccessible(true);
                    aggro.setBoolean(enderman, true);
                }
                catch(Exception e){}

            }
        }
        else if(event.getWorld().getBiome(MathHelper.floor(event.getEntity().posX), MathHelper.floor(event.getEntity().posZ)) == UnrealBiomes.shadow) {
            if(event.getEntity() instanceof EntitySheep){
                EntitySheep sheepy = (EntitySheep)event.getEntity();
                if(randy.nextInt(30) <= 1)
                    sheepy.setFleeceColor(10);
                else
                    sheepy.setFleeceColor(15);
            }
        }*/
    }

    @SubscribeEvent
    public void onLivingDrops(LivingDropsEvent event)
    {
        if(event.getEntity() instanceof IMob && halloween && event.isRecentlyHit() && event.getSource().getTrueSource() != null
            && event.getSource().getTrueSource() instanceof EntityPlayer && randy.nextInt(10) == 0){
            addDrop(event, new ItemStack(RidiculousItems.candyCorn, 1));
        }

        if (event.getEntity() instanceof EntitySkeleton && event.isRecentlyHit() && event.getSource().getTrueSource() != null
                && event.getSource().getTrueSource() instanceof EntityPlayer)
        {
            ItemStack weap = ((EntityPlayer)event.getSource().getTrueSource()).getHeldItemMainhand();

            if (weap.getItem() == RidiculousItems.rustySickle && randy.nextInt(26) <= (10 + event.getLootingLevel()))
            {
                addDrop(event, new ItemStack(Items.SKULL, 1));
            }
        }

        if (event.getEntity() instanceof EntityWitherSkeleton && event.isRecentlyHit() && event.getSource().getTrueSource() != null
                && event.getSource().getTrueSource() instanceof EntityPlayer)
        {
            ItemStack weap = ((EntityPlayer)event.getSource().getTrueSource()).getHeldItemMainhand();

            if (weap.getItem() == RidiculousItems.rustySickle && randy.nextInt(26) <= (10 + event.getLootingLevel()))
            {
                addDrop(event, new ItemStack(Items.SKULL, 1, 1));
            }
        }

        if (event.getEntity() instanceof EntityZombie && event.isRecentlyHit() && event.getSource().getTrueSource() != null
                && event.getSource().getTrueSource() instanceof EntityPlayer)
        {
            ItemStack weap = ((EntityPlayer)event.getSource().getTrueSource()).getHeldItemMainhand();

            if (weap.getItem() == RidiculousItems.rustySickle && randy.nextInt(26) <= (10 + 2 * event.getLootingLevel()))
            {
                addDrop(event, new ItemStack(Items.SKULL, 1, 2));
            }
        }

        /*if (event.getEntity() instanceof EntityZombie && event.getEntity().worldObj.getBiome(MathHelper.floor(event.getEntity().posX), MathHelper.floor(event.getEntity().posZ)) == UnrealBiomes.time){
            for(EntityItem drop : event.drops){
                ItemStack stack = drop.getEntityItem();
                if(stack.getItem() == Items.rotten_flesh)
                    drop.setEntityItemStack(new ItemStack(Items.feather, stack.stackSize));
            }
        }*/

        if (event.getEntity() instanceof EntityCreeper && event.isRecentlyHit() && event.getSource().getTrueSource() != null
                && event.getSource().getTrueSource() instanceof EntityPlayer)
        {
            ItemStack weap = ((EntityPlayer)event.getSource().getTrueSource()).getHeldItemMainhand();

            if (weap.getItem() == RidiculousItems.rustySickle && randy.nextInt(26) <= (10 + 2 * event.getLootingLevel()))
            {
                addDrop(event, new ItemStack(Items.SKULL, 1, 4));
            }
        }

        if (event.getEntity() instanceof EntityPlayer)
        {
            if(event.isRecentlyHit() && event.getSource().getTrueSource() != null && event.getSource().getTrueSource() instanceof EntityPlayer) {

                ItemStack weap = ((EntityPlayer) event.getSource().getTrueSource()).getHeldItemMainhand();

                if (weap.getItem() == RidiculousItems.rustySickle) {
                    ItemStack head = new ItemStack(Items.SKULL, 1, 3);
                    NBTTagCompound nametag = new NBTTagCompound();
                    nametag.setString("SkullOwner", ((EntityPlayer) event.getEntity()).getDisplayNameString());
                    head.setTagCompound(nametag);
                    addDrop(event, head);
                }
            }
            else if(event.getSource().getTrueSource() != null
                    && event.getSource().getTrueSource() instanceof EntityLiving
                    && ((EntityLiving)event.getEntity()).getHeldItemMainhand().getItem() == RidiculousItems.rustySickle) {
                ItemStack head = new ItemStack(Items.SKULL, 1, 3);
                NBTTagCompound nametag = new NBTTagCompound();
                nametag.setString("SkullOwner", ((EntityPlayer) event.getEntity()).getDisplayNameString());
                head.setTagCompound(nametag);
                addDrop(event, head);
            }
        }
    }

    public void addDrop(LivingDropsEvent event, ItemStack drop)
    {
        EntityItem entityitem = new EntityItem(event.getEntity().getEntityWorld(), event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, drop);
        entityitem.setDefaultPickupDelay();
        event.getDrops().add(entityitem);
    }

    /*@SubscribeEvent
    public void fillBucket(FillBucketEvent event) {
        if(event.target.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            if(event.getWorld().getBlock(event.target.blockX, event.target.blockY, event.target.blockZ) == RidiculousBlocks.liquidTimeBlock && event.getWorld().getBlockMetadata(event.target.blockX, event.target.blockY, event.target.blockZ) == 0) {
                event.getWorld().setBlockToAir(event.target.blockX, event.target.blockY, event.target.blockZ);
                event.result = new ItemStack(RidiculousItems.timeBucket);
                event.setResult(Event.Result.ALLOW);
                return;
            }

        }

    }*/

}
