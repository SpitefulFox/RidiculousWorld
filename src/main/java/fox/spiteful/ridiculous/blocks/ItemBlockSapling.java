package fox.spiteful.ridiculous.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemBlockSapling extends ItemBlock {
    public ItemBlockSapling(Block block){
        super(block);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int meta)
    {
        return meta & (BlockFantasySapling.types.length - 1);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return "tile.ridiculous_sapling_" + BlockFantasySapling.types[itemStack.getItemDamage()];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int damage) {
        return RidiculousBlocks.treeSaplings.getIcon(0, damage);
    }
}