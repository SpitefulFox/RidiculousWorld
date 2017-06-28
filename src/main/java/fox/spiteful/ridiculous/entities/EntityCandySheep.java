package fox.spiteful.ridiculous.entities;

import fox.spiteful.ridiculous.items.RidiculousItems;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;

public class EntityCandySheep extends EntitySheep {

    public EntityCandySheep(World world){
        super(world);
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        setSheared(true);
        int i = 1 + rand.nextInt(3);
        for (int j = 0; j < i; j++)
        {
            ret.add(new ItemStack(RidiculousItems.cottonCandy, 1));
        }
        this.playSound("mob.sheep.shear", 1.0F, 1.0F);
        return ret;
    }

    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
     * par2 - Level of Looting used to kill this mob.
     */
    @Override
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
        if (!this.getSheared())
        {
            this.entityDropItem(new ItemStack(RidiculousItems.cottonCandy, 1), 0.0F);
        }
    }
}
