package fox.spiteful.ridiculous.blocks;

import fox.spiteful.ridiculous.Ridiculous;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockModdedStairs extends BlockStairs {

    public BlockModdedStairs(Block block, int meta){
        super(block, meta);
        setCreativeTab(Ridiculous.tab);
    }
}
