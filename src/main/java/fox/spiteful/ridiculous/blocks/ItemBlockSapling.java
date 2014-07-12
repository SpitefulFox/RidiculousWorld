package fox.spiteful.ridiculous.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockSapling extends ItemBlock {
    public ItemBlockSapling(Block block){
        super(block);
        this.setMaxDamage(BlockFantasyLeaves.types.length - 1);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int meta)
    {
        return meta & BlockFantasyLeaves.types.length;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return "tile.ridiculous_sapling_" + BlockFantasySapling.types[itemStack.getItemDamage()];
    }
}