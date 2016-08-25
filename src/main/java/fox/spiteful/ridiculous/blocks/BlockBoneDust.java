package fox.spiteful.ridiculous.blocks;

import fox.spiteful.ridiculous.Ridiculous;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockBoneDust extends BlockFalling {

    public BlockBoneDust(){
        super(Material.SAND);
        setHardness(0.5F);
        this.setSoundType(SoundType.GROUND);
        this.setUnlocalizedName("bonedust");
        setCreativeTab(Ridiculous.tab);

    }

}
