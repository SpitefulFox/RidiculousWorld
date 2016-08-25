package fox.spiteful.ridiculous.items;

import fox.spiteful.ridiculous.Ridiculous;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemUnicornHorn extends ItemSword {

    public ItemUnicornHorn(){
        super(ToolMaterial.STONE);
        setCreativeTab(Ridiculous.tab);
    }

    @Override
    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.NONE;
    }

    @Override
    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 0;
    }

    @Override
    /**
     * Return whether this item is repairable in an anvil.
     */
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return false;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemstack, World world, EntityPlayer player, EnumHand hand) {
        player.swingArm(EnumHand.MAIN_HAND);
        if(player != null && player.getActivePotionEffects().size() > 0 && !world.isRemote) {
            player.curePotionEffects(new ItemStack(Items.MILK_BUCKET));
            itemstack.damageItem(1, player);
            return new ActionResult(EnumActionResult.SUCCESS, itemstack);
        }
        return new ActionResult(EnumActionResult.PASS, itemstack);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item par1, CreativeTabs xCreativeTabs, List list) {
        ItemStack horn = new ItemStack(this);
        horn.addEnchantment(Enchantments.SMITE, 4);
        list.add(horn);
    }
}
