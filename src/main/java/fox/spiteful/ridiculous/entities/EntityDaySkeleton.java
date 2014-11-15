package fox.spiteful.ridiculous.entities;

import fox.spiteful.ridiculous.blocks.RidiculousBlocks;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityDaySkeleton extends EntitySkeleton {
    public EntityDaySkeleton(World world){
        super(world);
        //isImmuneToFire = true;
        setCurrentItemOrArmor(4, new ItemStack(Items.chainmail_helmet));
    }

    @Override
    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.boundingBox.minY);
        int k = MathHelper.floor_double(this.posZ);
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL //&& this.getBlockPathWeight(i, j, k) >= 0.0F
                && this.worldObj.checkNoEntityCollision(this.boundingBox)
                && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty()
                && !this.worldObj.isAnyLiquid(this.boundingBox)
                && this.worldObj.canBlockSeeTheSky(i, j, k) && this.worldObj.getTopBlock(i, k) == RidiculousBlocks.boneDust;
    }

}