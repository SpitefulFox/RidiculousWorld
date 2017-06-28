package fox.spiteful.ridiculous.biomes;

import fox.spiteful.ridiculous.Config;
import net.minecraft.world.biome.BiomeGenBase;

public class UnrealBiomes {

    public static BiomeGenBase spooky;
    public static BiomeGenBase ossuary;
    public static BiomeGenBase candy;
    public static BiomeGenBase murica;
    public static BiomeGenBase madness;
    public static BiomeGenBase shadow;
    public static BiomeGenBase time;

    public static BiomeGenBase botania;

    public static void genesis(){
        if(Config.spookyWeight > 0)
            spooky = new BiomeGenSpooky(Config.spookyID);
        if(Config.ossuaryWeight > 0)
            ossuary = new BiomeGenOssuary(Config.ossuaryID);
        if(Config.candyWeight > 0)
            candy = new BiomeGenCandy(Config.candyID);
        if(Config.muricaWeight > 0)
            murica = new BiomeGenMurica(Config.muricaID);
        if(Config.madnessWeight > 0)
            madness = new BiomeGenMadness(Config.madnessID);
        if(Config.shadowWeight > 0)
            shadow = new BiomeGenShadow(Config.shadowID);
        if(Config.botaniaWeight > 0)
            botania = new BiomeGenBotania(Config.botaniaID);
        if(Config.timeWeight > 0)
            time = new BiomeGenTime(Config.timeID);
    }
}
