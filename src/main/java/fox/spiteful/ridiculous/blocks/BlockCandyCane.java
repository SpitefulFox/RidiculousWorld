package fox.spiteful.ridiculous.blocks;

import fox.spiteful.ridiculous.Ridiculous;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockCandyCane extends BlockRotatedPillar {
    IIcon side;
    IIcon core;

    public BlockCandyCane(){
        super(Material.wood);
        this.setHardness(1.5F);
        this.setResistance(5F);
        this.setStepSound(Block.soundTypeStone);
        this.setBlockName("candycane");
        this.setCreativeTab(Ridiculous.tab);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        side = iconRegister.registerIcon("ridiculous:candycane");
        core = iconRegister.registerIcon("ridiculous:candycane_core");
    }

    @Override
    public IIcon getSideIcon(int wat){
        return side;
    }

    @Override
    public IIcon getTopIcon(int wat){
        return core;
    }
}
