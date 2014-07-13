package fox.spiteful.ridiculous.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.ridiculous.Ridiculous;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;
import net.minecraft.util.IIcon;

public class ItemRidiculousFood extends ItemFood {
    private String text;
    IIcon icon;
    public ItemRidiculousFood(int food, float saturation, boolean wolfFood, String texture){
        super(food, saturation, wolfFood);
        text = texture;
        this.setCreativeTab(Ridiculous.tab);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ir) {
        this.icon = ir.registerIcon("ridiculous:" + text);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1) {
        return this.icon;
    }
}
