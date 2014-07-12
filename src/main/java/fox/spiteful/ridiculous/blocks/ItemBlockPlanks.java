package fox.spiteful.ridiculous.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockPlanks extends ItemBlock {
    public ItemBlockPlanks(Block block){
        super(block);
        this.setMaxDamage(BlockFantasyPlanks.types.length - 1);
        this.setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return "tile.ridiculous_planks_" + BlockFantasyPlanks.types[itemStack.getItemDamage()];
    }
}
