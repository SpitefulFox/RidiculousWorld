package fox.spiteful.ridiculous.blocks;

import fox.spiteful.ridiculous.Ridiculous;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockCandyCane extends BlockRotatedPillar {

    public BlockCandyCane(){
        super(Material.WOOD);
        this.setHardness(1.5F);
        this.setResistance(5F);
        this.setSoundType(SoundType.STONE);
        this.setUnlocalizedName("candycane");
        this.setCreativeTab(Ridiculous.tab);
    }
}
