package fox.spiteful.ridiculous.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockCrafting extends ItemBlock{
    public ItemBlockCrafting(Block block){
        super(block);
        this.setHasSubtypes(true);
    }

}
