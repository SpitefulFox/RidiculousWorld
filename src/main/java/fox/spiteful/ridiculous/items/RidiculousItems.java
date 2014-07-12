package fox.spiteful.ridiculous.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class RidiculousItems {

    public static Item candyCorn;
    public static Item rustySickle;
    public static Item chocoEgg;
    public static Item unicornRaw;
    public static Item unicornCooked;

    public static void itemize(){
        candyCorn = new ItemRidiculousFood(2, 0.1F, false, "candycorn").setUnlocalizedName("CandyCorn");
        GameRegistry.registerItem(candyCorn, "CandyCorn");
        rustySickle = new ItemRustySickle().setUnlocalizedName("RustySickle");
        GameRegistry.registerItem(rustySickle, "RustySickle");
        chocoEgg = new ItemRidiculousFood(3, 0.2F, false, "chocoegg").setUnlocalizedName("ChocoEgg");
        GameRegistry.registerItem(chocoEgg, "ChocoEgg");
        unicornRaw = new ItemRidiculousFood(3, 0.3F, true, "unicorn_raw").setUnlocalizedName("UnicornRaw");
        GameRegistry.registerItem(unicornRaw, "UnicornRaw");
        unicornCooked = new ItemRidiculousFood(8, 0.8F, true, "unicorn_cooked").setUnlocalizedName("UnicornCooked");
        GameRegistry.registerItem(unicornCooked, "UnicornCooked");
    }
}
