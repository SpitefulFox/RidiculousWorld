package fox.spiteful.ridiculous.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

public class BlockGloom extends Block {

    public BlockGloom(){
        super(Material.AIR);
        setLightOpacity(215);
        //setBlockBounds(0, 0, 0, 0, 0, 0);
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor Block
     */
    /*public void onNeighborBlockChange(World world, int x, int y, int z, Block wut) {
        if(world.getBlock(x + 1, y, z) == Blocks.air && world.getBiomeGenForCoords(x + 1, z) == UnrealBiomes.shadow)
            world.setBlock(x + 1, y, z, this);
        if(world.getBlock(x - 1, y, z) == Blocks.air && world.getBiomeGenForCoords(x - 1, z) == UnrealBiomes.shadow)
            world.setBlock(x - 1, y, z, this);
        if(world.getBlock(x, y, z + 1) == Blocks.air && world.getBiomeGenForCoords(x, z + 1) == UnrealBiomes.shadow)
            world.setBlock(x, y, z + 1, this);
        if(world.getBlock(x, y, z - 1) == Blocks.air && world.getBiomeGenForCoords(x, z - 1) == UnrealBiomes.shadow)
            world.setBlock(x, y, z - 1, this);
    }*/

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_){}

    //@Override
    /**
     * Determines if the player can harvest this block, obtaining it's drops when the block is destroyed.
     *
     * param player The player damaging the block, may be null
     * param meta The block's current metadata
     * @return True to spawn the drops
     */
    /*public boolean canHarvestBlock(EntityPlayer player, int meta){
        return false;
    }*/

    /*@Override
    public int getRenderType(){
        return -1;
    }

    @Override
    public boolean isBlockNormalCube() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity e) {
        return false;
    }

    @Override
    public boolean canCollideCheck(int par1, boolean par2) {
        return false;
    }

    @Override
    public boolean canBeReplacedByLeaves(IBlockAccess world, int x, int y, int z) {
        return true;
    }*/

    @Override
    public boolean canDropFromExplosion(Explosion par1Explosion) {
        return false;
    }

    /*@Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        return new ArrayList();
    }*/

    /*@Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
        return null;
    }

    @Override
    public boolean isAir(IBlockAccess world, int x, int y, int z) {
        return true;
    }*/

}
