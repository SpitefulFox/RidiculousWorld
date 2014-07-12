package fox.spiteful.ridiculous.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.ridiculous.Ridiculous;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.IIcon;

public class ItemRustySickle extends ItemSword {
    IIcon icon;

    public ItemRustySickle(){
        super(ToolMaterial.IRON);
        setCreativeTab(Ridiculous.tab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ir) {
        this.icon = ir.registerIcon("ridiculous:rustysickle");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1) {
        return this.icon;
    }

    @Override
    /**
    * returns the action that specifies what animation to play when the items is being used
    */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.none;
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
        return par2ItemStack.getItem() == Items.iron_ingot ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }
}
