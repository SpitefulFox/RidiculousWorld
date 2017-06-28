package fox.spiteful.ridiculous.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.ridiculous.Ridiculous;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockTimeFluid extends BlockFluidClassic {

    public static final Material temporal = new MaterialLiquid(MapColor.lightBlueColor);

    public IIcon icon;

    public BlockTimeFluid(Fluid fluid){
        super(fluid, temporal);
        setBlockName("blockLiquidTime");
        setCreativeTab(Ridiculous.tab);
    }

    /*@Override
    public int getRenderBlockPass ()
    {
        return 0;
    }*/

    @Override
    public void registerBlockIcons (IIconRegister iconRegister)
    {
        icon = iconRegister.registerIcon("ridiculous:liquid_time");
        RidiculousBlocks.liquidTime.setIcons(icon);
    }
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon (int side, int meta)
    {
        return icon;
    }

}
