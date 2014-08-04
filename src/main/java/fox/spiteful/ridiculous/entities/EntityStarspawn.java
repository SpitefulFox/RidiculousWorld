package fox.spiteful.ridiculous.entities;

import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class EntityStarspawn extends EntitySlime {
    public EntityStarspawn(World world){
        super(world);
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.boundingBox.minY);
        int k = MathHelper.floor_double(this.posZ);
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.isValidLightLevel() && this.getBlockPathWeight(i, j, k) >= 0.0F
            && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty()
            && !this.worldObj.isAnyLiquid(this.boundingBox);
    }

    /**
     * Checks to make sure the light is not too bright where the mob is spawning
     */
    protected boolean isValidLightLevel()
    {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.boundingBox.minY);
        int k = MathHelper.floor_double(this.posZ);

        if (this.worldObj.getSavedLightValue(EnumSkyBlock.Sky, i, j, k) > this.rand.nextInt(32))
        {
            return false;
        }
        else
        {
            int l = this.worldObj.getBlockLightValue(i, j, k);

            if (this.worldObj.isThundering())
            {
                int i1 = this.worldObj.skylightSubtracted;
                this.worldObj.skylightSubtracted = 10;
                l = this.worldObj.getBlockLightValue(i, j, k);
                this.worldObj.skylightSubtracted = i1;
            }

            return l <= this.rand.nextInt(8);
        }
    }

    /**
     * Takes a coordinate in and returns a weight to determine how likely this creature will try to path to the block.
     * Args: x, y, z
     */
    public float getBlockPathWeight(int x, int y, int z)
    {
        return 0.5F - this.worldObj.getLightBrightness(x, y, z);
    }

    protected EntitySlime createInstance()
    {
        return new EntityStarspawn(this.worldObj);
    }
}
