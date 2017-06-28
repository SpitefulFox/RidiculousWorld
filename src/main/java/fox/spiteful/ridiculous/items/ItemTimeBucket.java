package fox.spiteful.ridiculous.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.ridiculous.Ridiculous;
import fox.spiteful.ridiculous.blocks.RidiculousBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemTimeBucket extends Item {

    @SideOnly(Side.CLIENT)
    public IIcon icon;


    public ItemTimeBucket() {
        this.setCreativeTab(Ridiculous.tab);
        this.setHasSubtypes(false);
        this.setMaxStackSize(1);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ir) {
        this.icon = ir.registerIcon("ridiculous:time_bucket");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1) {
        return this.icon;
    }

    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
        boolean flag = true;
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(p_77659_2_, p_77659_3_, flag);
        if(movingobjectposition == null) {
            return p_77659_1_;
        } else {
            if(movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;
                if(movingobjectposition.sideHit == 0) {
                    --j;
                }

                if(movingobjectposition.sideHit == 1) {
                    ++j;
                }

                if(movingobjectposition.sideHit == 2) {
                    --k;
                }

                if(movingobjectposition.sideHit == 3) {
                    ++k;
                }

                if(movingobjectposition.sideHit == 4) {
                    --i;
                }

                if(movingobjectposition.sideHit == 5) {
                    ++i;
                }

                if(!p_77659_3_.canPlayerEdit(i, j, k, movingobjectposition.sideHit, p_77659_1_)) {
                    return p_77659_1_;
                }

                if(this.tryPlaceContainedLiquid(p_77659_2_, i, j, k) && !p_77659_3_.capabilities.isCreativeMode) {
                    return new ItemStack(Items.bucket);
                }
            }

            return p_77659_1_;
        }
    }

    public boolean tryPlaceContainedLiquid(World world, int x, int y, int z) {
        Material material = world.getBlock(x, y, z).getMaterial();
        boolean flag = !material.isSolid();
        if(!world.isAirBlock(x, y, z) && !flag) {
            return false;
        } else {
            if(!world.isRemote && flag && !material.isLiquid()) {
                world.func_147480_a(x, y, z, true);
            }

            world.setBlock(x, y, z, RidiculousBlocks.liquidTimeBlock, 0, 3);
            return true;
        }
    }
}
