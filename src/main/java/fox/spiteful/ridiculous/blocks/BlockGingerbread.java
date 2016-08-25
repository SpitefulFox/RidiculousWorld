package fox.spiteful.ridiculous.blocks;

import fox.spiteful.ridiculous.Ridiculous;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockGingerbread extends Block {

    public BlockGingerbread(){
        super(Material.SPONGE);
        setHardness(0.5F);
        setSoundType(SoundType.CLOTH);
        setUnlocalizedName("gingerbread");
        setCreativeTab(Ridiculous.tab);
    }

}
