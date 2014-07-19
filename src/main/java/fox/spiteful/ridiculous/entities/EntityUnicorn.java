package fox.spiteful.ridiculous.entities;

import fox.spiteful.ridiculous.items.RidiculousItems;
import net.minecraft.command.IEntitySelector;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public class EntityUnicorn extends EntityHorse {
    private static final IEntitySelector unicornBreedingSelector = new IEntitySelector()
    {
        private static final String __OBFID = "CL_00001642";
        /**
         * Return whether the specified entity is applicable to this filter.
         */
        public boolean isEntityApplicable(Entity p_82704_1_)
        {
            return p_82704_1_ instanceof EntityUnicorn && ((EntityUnicorn)p_82704_1_).func_110205_ce();
        }
    };

    static {
        try {
            Field stupidMojangPrivateVariable = Class.forName("net.minecraft.entity.passive.EntityHorse").getField("horseJumpStrength");
            stupidMojangPrivateVariable.setAccessible(true);
            IAttribute horseJumpStrength = (IAttribute) (stupidMojangPrivateVariable.get(null));
        }
        catch(Exception e){
            horseJumpStrength = null;
        }
    }

    public static IAttribute horseJumpStrength;

    public EntityUnicorn(World world){
        super(world);
    }

    public void setHorseType(int p_110214_1_){}

    /**
     * returns the horse type
     */
    public int getHorseType()
    {
        return 0;
    }

    /**
     * Gets the name of this command sender (usually username, but possibly "Rcon")
     */
    public String getCommandSenderName()
    {
        if (this.hasCustomNameTag())
            return this.getCustomNameTag();
        else
            return StatCollector.translateToLocal("entity.RidiculousWorld.Unicorn.name");
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        int mark = (getHorseVariant() & 65280) >> 8;
        if(mark == 2 && rand.nextInt(3) == 0) {
            for (int k = 0; k < 2; ++k) {
                this.worldObj.spawnParticle("spell", this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width, this.posY + this.rand.nextDouble() * (double) this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, this.rand.nextDouble(), this.rand.nextDouble(), this.rand.nextDouble());
            }
        }
        else if(mark == 3 && rand.nextInt(3) == 0) {
            for (int k = 0; k < 2; ++k) {
                this.worldObj.spawnParticle("reddust", this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width, this.posY + this.rand.nextDouble() * (double) this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, this.rand.nextDouble(), this.rand.nextDouble(), this.rand.nextDouble());
            }
        }
        else if(mark == 4 && rand.nextInt(3) == 0) {
            for (int k = 0; k < 2; ++k) {
                this.worldObj.spawnParticle("happyVillager", this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width, this.posY + this.rand.nextDouble() * (double) this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, this.rand.nextDouble(), this.rand.nextDouble(), this.rand.nextDouble());
            }
        }
    }

    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
     * par2 - Level of Looting used to kill this mob.
     */
    protected void dropFewItems(boolean recentlyHit, int looting)
    {
        int j = this.rand.nextInt(3) + this.rand.nextInt(1 + looting);
        int k;

        for (k = 0; k < j; ++k)
        {
            this.dropItem(Items.leather, 1);
        }

        j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + looting);

        for (k = 0; k < j; ++k)
        {
            if (this.isBurning())
            {
                this.dropItem(RidiculousItems.unicornCooked, 1);
            }
            else
            {
                this.dropItem(RidiculousItems.unicornRaw, 1);
            }
        }

        if(looting > 0 && rand.nextInt(100) >= looting){
            ItemStack horn = new ItemStack(RidiculousItems.unicornHorn);
            horn.addEnchantment(Enchantment.smite, 4);
            this.entityDropItem(horn, 0.0F);
        }
    }

    protected EntityHorse getClosestHorse(Entity p_110250_1_, double p_110250_2_)
    {
        double d1 = Double.MAX_VALUE;
        Entity entity1 = null;
        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(p_110250_1_, p_110250_1_.boundingBox.addCoord(p_110250_2_, p_110250_2_, p_110250_2_), unicornBreedingSelector);
        Iterator iterator = list.iterator();

        while (iterator.hasNext())
        {
            Entity entity2 = (Entity)iterator.next();
            double d2 = entity2.getDistanceSq(p_110250_1_.posX, p_110250_1_.posY, p_110250_1_.posZ);

            if (d2 < d1)
            {
                entity1 = entity2;
                d1 = d2;
            }
        }

        return (EntityHorse)entity1;
    }

    public EntityAgeable createChild(EntityAgeable p_90011_1_)
    {
        EntityUnicorn entityhorse = (EntityUnicorn)p_90011_1_;
        EntityUnicorn entityhorse1 = new EntityUnicorn(this.worldObj);

        int i1 = this.rand.nextInt(9);
        int l;

        if (i1 < 4)
        {
            l = this.getHorseVariant() & 255;
        }
        else if (i1 < 8)
        {
            l = entityhorse.getHorseVariant() & 255;
        }
        else
        {
            l = this.rand.nextInt(7);
        }

        int j1 = this.rand.nextInt(5);

        if (j1 < 2)
        {
            l |= this.getHorseVariant() & 65280;
        }
        else if (j1 < 4)
        {
            l |= entityhorse.getHorseVariant() & 65280;
        }
        else
        {
            l |= this.rand.nextInt(5) << 8 & 65280;
        }

        entityhorse1.setHorseVariant(l);

        double d1 = this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() + p_90011_1_.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() + (double)this.func_110267_cL();
        entityhorse1.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(d1 / 3.0D);
        if(horseJumpStrength != null) {
            double d2 = this.getEntityAttribute(horseJumpStrength).getBaseValue() + p_90011_1_.getEntityAttribute(horseJumpStrength).getBaseValue() + this.func_110245_cM();
            entityhorse1.getEntityAttribute(horseJumpStrength).setBaseValue(d2 / 3.0D);
        }
        double d0 = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue() + p_90011_1_.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue() + this.func_110203_cN();
        entityhorse1.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(d0 / 3.0D);
        return entityhorse1;
    }

    private float func_110267_cL()
    {
        return 15.0F + (float)this.rand.nextInt(8) + (float)this.rand.nextInt(9);
    }

    private double func_110245_cM()
    {
        return 0.4000000059604645D + this.rand.nextDouble() * 0.2D + this.rand.nextDouble() * 0.2D + this.rand.nextDouble() * 0.2D;
    }

    private double func_110203_cN()
    {
        return (0.44999998807907104D + this.rand.nextDouble() * 0.3D + this.rand.nextDouble() * 0.3D + this.rand.nextDouble() * 0.3D) * 0.25D;
    }

}
