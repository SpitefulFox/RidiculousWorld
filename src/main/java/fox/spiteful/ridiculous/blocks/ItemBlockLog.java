package fox.spiteful.ridiculous.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockLog extends ItemBlock {
    public ItemBlockLog(Block block){
        super(block);
        this.setMaxDamage(BlockFantasyLog.types.length - 1);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int meta)
    {
        return meta & 3;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return "tile.ridiculous_log_" + BlockFantasyLog.types[itemStack.getItemDamage()];
    }
}