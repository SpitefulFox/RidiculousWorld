package fox.spiteful.ridiculous.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.ridiculous.Ridiculous;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockSpookyLog extends BlockDirectional
{
    @SideOnly(Side.CLIENT)
    private IIcon top;
    @SideOnly(Side.CLIENT)
    private IIcon faceIcon;

    protected BlockSpookyLog()
    {
        super(Material.wood);
        this.setHardness(1.5F);
        this.setResistance(5F);
        this.setStepSound(Block.soundTypeWood);
        this.setBlockName("ridiculous_log_spooky");
        this.setCreativeTab(Ridiculous.tab);
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        return side == 1 ? this.top : (side == 0 ? this.top : (metadata == 2 && side == 2 ? this.faceIcon : (metadata == 3 && side == 5 ? this.faceIcon : (metadata == 0 && side == 3 ? this.faceIcon : (metadata == 1 && side == 4 ? this.faceIcon : this.blockIcon)))));
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack item)
    {
        int l = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, l, 2);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.faceIcon = iconRegister.registerIcon("ridiculous:log_spooky_face");
        this.top = iconRegister.registerIcon("ridiculous:log_spooky_top");
        this.blockIcon = iconRegister.registerIcon("ridiculous:log_spooky");
    }
}