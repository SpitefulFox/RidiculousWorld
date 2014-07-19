package fox.spiteful.ridiculous.entities;

import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.world.World;

public class EntityCalavera extends EntitySkeleton {
    public EntityCalavera(World world){
        super(world);
    }

    /**
     * Return this skeleton's type.
     */
    public int getSkeletonType()
    {
        return 0;
    }

    /**
     * Set this skeleton's type.
     */
    public void setSkeletonType(int p_82201_1_)
    {
        super.setSkeletonType(0);
    }
}
