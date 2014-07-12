package fox.spiteful.ridiculous.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockBoneDust extends BlockFalling {
    private IIcon texture;

    public BlockBoneDust(){
        super(Material.sand);
        setHardness(0.5F);
        setStepSound(Block.soundTypeGravel);
        setBlockName("bonedust");

    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        texture = iconRegister.registerIcon("ridiculous:bonedust");
    }

    @Override
    public IIcon getIcon(int side, int metadata)
    {
        return texture;
    }
}
