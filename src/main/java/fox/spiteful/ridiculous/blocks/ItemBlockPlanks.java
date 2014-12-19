package fox.spiteful.ridiculous.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockPlanks extends ItemBlock {
    public ItemBlockPlanks(Block block){
        super(block);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int meta)
    {
        return meta;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return "tile.ridiculous_planks_" + BlockFantasyPlanks.types[itemStack.getItemDamage() % BlockFantasyPlanks.types.length];
    }
}
