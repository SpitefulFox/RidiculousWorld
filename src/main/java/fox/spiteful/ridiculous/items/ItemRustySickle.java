package fox.spiteful.ridiculous.items;

import fox.spiteful.ridiculous.Ridiculous;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemRustySickle extends ItemSword {

    public ItemRustySickle(){
        super(ToolMaterial.IRON);
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
        return par2ItemStack.getItem() == Items.IRON_INGOT ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }
}
