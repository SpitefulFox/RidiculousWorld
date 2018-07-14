package fox.spiteful.ridiculous.items;

import fox.spiteful.ridiculous.Ridiculous;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class RidiculousItems {

    public static Item candyCorn;
    public static Item rustySickle;
    public static Item chocoEgg;
    public static Item unicornRaw;
    public static Item unicornCooked;
    public static Item peepRaw;
    public static Item peepCooked;
    public static Item unicornHorn;
    public static Item spawner;
    public static Item cottonCandy;
    public static Item timeBucket;

    public static void itemize(){
        candyCorn = new ItemFood(2, 0.1F, false).setUnlocalizedName("candycorn").setCreativeTab(Ridiculous.tab).setRegistryName("candycorn");
        ForgeRegistries.ITEMS.register(candyCorn);
        rustySickle = new ItemRustySickle();
        ForgeRegistries.ITEMS.register(rustySickle);
        /*chocoEgg = new ItemRidiculousFood(3, 0.2F, false, "chocoegg").setUnlocalizedName("ChocoEgg");
        GameRegistry.registerItem(chocoEgg, "ChocoEgg");
        unicornRaw = new ItemRidiculousFood(3, 0.3F, true, "unicorn_raw").setUnlocalizedName("UnicornRaw");
        GameRegistry.registerItem(unicornRaw, "UnicornRaw");
        unicornCooked = new ItemRidiculousFood(8, 0.8F, true, "unicorn_cooked").setUnlocalizedName("UnicornCooked");
        GameRegistry.registerItem(unicornCooked, "UnicornCooked");
        peepRaw = new ItemRidiculousFood(2, 0.3F, false, "marshmallow_peep").setUnlocalizedName("PeepRaw");
        GameRegistry.registerItem(peepRaw, "PeepRaw");
        peepCooked = new ItemRidiculousFood(6, 0.6F, false, "roasted_peep").setUnlocalizedName("PeepCooked");
        GameRegistry.registerItem(peepCooked, "PeepCooked");
        unicornHorn = new ItemUnicornHorn().setUnlocalizedName("UnicornHorn");
        GameRegistry.registerItem(unicornHorn, "UnicornHorn");
        spawner = new ItemRidiculousSpawner();
        GameRegistry.registerItem(spawner, "Spawner");
        cottonCandy = new ItemRidiculousFood(2, 0.1F, false, "cotton_candy").setUnlocalizedName("CottonCandy");
        GameRegistry.registerItem(cottonCandy, "CottonCandy");
        timeBucket = new ItemTimeBucket().setUnlocalizedName("BucketOfTime");
        GameRegistry.registerItem(timeBucket, "BucketOfTime");*/
    }
}
