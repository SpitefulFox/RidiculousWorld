package fox.spiteful.ridiculous.blocks;

import fox.spiteful.ridiculous.Ridiculous;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

public class BlockModdedStairs extends BlockStairs {

    public BlockModdedStairs(IBlockState state){
        super(state);
        setCreativeTab(Ridiculous.tab);
    }
}
