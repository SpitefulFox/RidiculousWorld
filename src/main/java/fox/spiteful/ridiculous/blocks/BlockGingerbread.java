package fox.spiteful.ridiculous.blocks;

import fox.spiteful.ridiculous.Ridiculous;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockGingerbread extends Block {
    private IIcon texture;

    public BlockGingerbread(){
        super(Material.sponge);
        setHardness(0.5F);
        setStepSound(Block.soundTypeCloth);
        setBlockName("gingerbread");
        setCreativeTab(Ridiculous.tab);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        texture = iconRegister.registerIcon("ridiculous:gingerbread_block");
    }

    @Override
    public IIcon getIcon(int side, int metadata)
    {
        return texture;
    }
}
