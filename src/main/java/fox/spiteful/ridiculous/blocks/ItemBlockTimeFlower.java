package fox.spiteful.ridiculous.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemBlockTimeFlower extends ItemBlock {

    public ItemBlockTimeFlower(Block block){
        super(block);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int meta)
    {
        return meta;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return "tile.ridiculous_flowers_" + BlockTimeFlower.types[itemStack.getItemDamage() % BlockTimeFlower.types.length];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int damage) {
        return RidiculousBlocks.flower.getIcon(0, damage);
    }
}
