package fox.spiteful.ridiculous.blocks;

import fox.spiteful.ridiculous.Ridiculous;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockSerpentRune extends Block {
    private IIcon texture;
    private IIcon top;

    public BlockSerpentRune(){
        super(Material.rock);
        this.setHardness(1.5F);
        this.setResistance(10.0F);
        this.setStepSound(Block.soundTypeStone);
        this.setBlockName("serpent_rune");
        this.setCreativeTab(Ridiculous.tab);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        texture = iconRegister.registerIcon("ridiculous:serpent_runes");
        top = iconRegister.registerIcon("ridiculous:serpent");
    }

    @Override
    public IIcon getIcon(int side, int metadata)
    {
        if(side != 0 && side != 1)
            return texture;
        else
            return top;
    }
}