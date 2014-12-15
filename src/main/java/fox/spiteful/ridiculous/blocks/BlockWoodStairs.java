package fox.spiteful.ridiculous.blocks;

import fox.spiteful.ridiculous.Ridiculous;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockWoodStairs extends BlockStairs {

    public BlockWoodStairs(Block block, int meta){
        super(block, meta);
        setCreativeTab(Ridiculous.tab);
    }
}
