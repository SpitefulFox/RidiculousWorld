package fox.spiteful.ridiculous.compat;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class Compat {

    public static boolean teehee;
    public static boolean pb;

    public static Block enderGoo;
    public static Block defiled;

    public static void preparatoryCompatification(){
        if(Loader.isModLoaded("HardcoreEnderExpansion"))
            teehee = true;
        if(Loader.isModLoaded("PlayerBeacons"))
            pb = true;
    }

    public static void compatify()
    {
        if(teehee){
            enderGoo = GameRegistry.findBlock("HardcoreEnderExpansion", "ender_goo");
            if(enderGoo == null)
                teehee = false;
        }
        if(pb){
            defiled = GameRegistry.findBlock("PlayerBeacons", "defiledSoulConductorBlock");
            if(defiled == null)
                pb = false;

            Item crystal = GameRegistry.findItem("PlayerBeacons", "crystalItem");
            if(crystal != null)
                ChestGenHooks.addItem("cyclopeanRuins", new WeightedRandomChestContent(crystal, 0, 1, 1, 6));

            try {
                ItemStack book = (ItemStack)(Class.forName("kihira.playerbeacons.common.PlayerBeacons").getField("researchNotes").get(null));
                ChestGenHooks.addItem("cyclopeanRuins", new WeightedRandomChestContent(book, 1, 1, 4));
            }
            catch(Throwable e){
                System.out.println("Player Beacons showed Ridiculous World who the alpha fox is!");
                pb = false;
                e.printStackTrace();
            }
        }
    }
}
