package fox.spiteful.ridiculous.items;

import fox.spiteful.ridiculous.Ridiculous;
import net.minecraft.item.ItemFood;

public class ItemRidiculousFood extends ItemFood {
    public ItemRidiculousFood(int food, float saturation, boolean wolfFood){
        super(food, saturation, wolfFood);
        this.setCreativeTab(Ridiculous.tab);
    }

}
