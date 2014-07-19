package fox.spiteful.ridiculous;

import fox.spiteful.ridiculous.blocks.RidiculousBlocks;
import fox.spiteful.ridiculous.items.RidiculousItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class RidiculousTab extends CreativeTabs {
    public RidiculousTab() {
        super("ridiculous");
    }

    @Override
    public Item getTabIconItem() {
        return RidiculousItems.peepRaw;
    }
}
