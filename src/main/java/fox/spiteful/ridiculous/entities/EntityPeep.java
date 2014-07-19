package fox.spiteful.ridiculous.entities;

import fox.spiteful.ridiculous.items.RidiculousItems;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityPeep extends EntityChicken {
    public int timeUntilNextEasterEgg;
    public EntityPeep(World world){
        super(world);
        this.timeUntilNextEasterEgg = this.rand.nextInt(6000) + 6000;
        EntityAIBase tempt = null;
        for(Object thingy : tasks.taskEntries){
            EntityAITasks.EntityAITaskEntry ai = (EntityAITasks.EntityAITaskEntry)thingy;
            if(ai.action instanceof EntityAITempt) {
                tempt = ai.action;
                break;
            }
        }
        if(tempt !=null)
            this.tasks.removeTask(tempt);
        this.tasks.addTask(3, new EntityAITempt(this, 1.0D, Items.sugar, false));
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        timeUntilNextEgg = 12000;

        if (!this.worldObj.isRemote && !this.isChild() && !this.func_152116_bZ() && --this.timeUntilNextEasterEgg <= 0)
        {
            this.playSound("mob.chicken.plop", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(RidiculousItems.chocoEgg, 1);
            this.timeUntilNextEasterEgg = this.rand.nextInt(6000) + 6000;
        }
    }

    public EntityChicken createChild(EntityAgeable p_90011_1_)
    {
        return new EntityPeep(this.worldObj);
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    public boolean isBreedingItem(ItemStack item)
    {
        return item != null && item.getItem() == Items.sugar;
    }

    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
     * par2 - Level of Looting used to kill this mob.
     */
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
        int j = this.rand.nextInt(3) + this.rand.nextInt(1 + p_70628_2_);

        if (this.isBurning())
        {
            this.dropItem(RidiculousItems.peepCooked, 1);
        }
        else
        {
            this.dropItem(RidiculousItems.peepRaw, 1);
        }
    }
}
