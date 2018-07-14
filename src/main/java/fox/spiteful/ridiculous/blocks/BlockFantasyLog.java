package fox.spiteful.ridiculous.blocks;

import fox.spiteful.ridiculous.Ridiculous;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;

public class BlockFantasyLog extends BlockLog {
    //public static final String[] types = new String[] {"spooky", "bubblegum", "shadow"};

    public BlockFantasyLog()
    {
        super();
        this.setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
        this.setCreativeTab(Ridiculous.tab);
    }

    @Override
    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState state = this.getDefaultState();

        switch (meta & 0b1100)
        {
            case 0b0000:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
                break;

            case 0b0100:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
                break;

            case 0b1000:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
                break;

            case 0b1100:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
                break;
        }

        return state;
    }

    @Override
    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        switch ((BlockLog.EnumAxis)state.getValue(LOG_AXIS))
        {
            case X: return 0b0100;
            case Y: return 0b0000;
            case Z: return 0b1000;
            case NONE: return 0b1100;
        }
        return 0;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {LOG_AXIS});
    }

}
