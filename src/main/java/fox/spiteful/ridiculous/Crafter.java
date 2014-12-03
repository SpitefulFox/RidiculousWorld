package fox.spiteful.ridiculous;

import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import fox.spiteful.ridiculous.blocks.BlockFantasyLog;
import fox.spiteful.ridiculous.blocks.RidiculousBlocks;
import fox.spiteful.ridiculous.items.RidiculousItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class Crafter {

    public static void artsAndCrafts(){
        scissors();
        lexify();
    }

    public static void scissors(){

        GameRegistry.addShapelessRecipe(new ItemStack(RidiculousBlocks.treePlanks, 4, 0), new Object[] {new ItemStack(RidiculousBlocks.treeLogs,1,0)});
        GameRegistry.addShapelessRecipe(new ItemStack(RidiculousBlocks.treePlanks, 4, 0), new Object[] {new ItemStack(RidiculousBlocks.spookyLog,1,0)});
        GameRegistry.addShapelessRecipe(new ItemStack(RidiculousBlocks.treePlanks, 4, 1), new Object[] {new ItemStack(RidiculousBlocks.treeLogs,1,1)});
        GameRegistry.addShapedRecipe(new ItemStack(RidiculousBlocks.craftBench, 1, 0), new Object[] {"XX", "XX", 'X', new ItemStack(RidiculousBlocks.treePlanks, 1, 0)});

        GameRegistry.addSmelting(new ItemStack(RidiculousItems.unicornRaw, 1), new ItemStack(RidiculousItems.unicornCooked, 1), 0.35F);
        GameRegistry.addSmelting(new ItemStack(RidiculousItems.peepRaw, 1), new ItemStack(RidiculousItems.peepCooked, 1), 0.35F);

        for(int x = 0;x < BlockFantasyLog.types.length;x++) {
            GameRegistry.addSmelting(new ItemStack(RidiculousBlocks.treeLogs, 1, x), new ItemStack(Items.coal, 1, 1), 0.15F);
        }
        GameRegistry.addSmelting(new ItemStack(RidiculousBlocks.spookyLog, 1), new ItemStack(Items.coal, 1, 1), 0.15F);

    }

    public static void lexify(){
        OreDictionary.registerOre("logWood", new ItemStack(RidiculousBlocks.treeLogs, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("logWood", new ItemStack(RidiculousBlocks.spookyLog, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("treeLeaves", new ItemStack(RidiculousBlocks.treeLeaves, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("treeSapling", new ItemStack(RidiculousBlocks.treeSaplings, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("plankWood", new ItemStack(RidiculousBlocks.treePlanks, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("crafterWood", new ItemStack(RidiculousBlocks.craftBench, 1, 0));
        OreDictionary.registerOre("craftingTableWood", new ItemStack(RidiculousBlocks.craftBench, 1, 0));

    }

}
