package fox.spiteful.ridiculous.biomes;

import fox.spiteful.ridiculous.Config;
import fox.spiteful.ridiculous.world.MapGenCyclopean;
import fox.spiteful.ridiculous.world.StructureCyclopeanShards;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructureIO;

public class UnrealBiomes {

    public static BiomeGenBase spooky;
    public static BiomeGenBase ossuary;
    public static BiomeGenBase candy;
    public static BiomeGenBase murica;
    public static BiomeGenBase madness;

    public static void genesis(){
        spooky = new BiomeGenSpooky(Config.spookyID);
        ossuary = new BiomeGenOssuary(Config.ossuaryID);
        candy = new BiomeGenCandy(Config.candyID);
        murica = new BiomeGenMurica(Config.muricaID);
        madness = new BiomeGenMadness(Config.madnessID);
    }
}
