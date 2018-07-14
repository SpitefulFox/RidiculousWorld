package fox.spiteful.ridiculous;

import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;
import org.apache.logging.log4j.Level;

public class Config {

    /*public static int spookyID;
    public static int ossuaryID;
    public static int candyID;
    public static int madnessID;
    public static int shadowID;
    public static int botaniaID;
    public static int timeID;*/

    public static int spookyWeight = 9;
    public static int ossuaryWeight = 7;
    public static int candyWeight = 9;
    public static int madnessWeight = 8;
    public static int shadowWeight = 8;
    public static int timeWeight = 7;

    public static int botaniaWeight = 9;

    //public static boolean heads = true;
    public static boolean shaders = true;

    public static boolean botania = true;
    public static boolean thaum = true;

    public static void configurate(File targ)
    {
        Configuration conf = new Configuration(targ);

        try
        {
            conf.load();
            //heads = conf.get("General", "Overwrite Head Render", heads, "Enable to make player heads render correctly").getBoolean(true);
            shaders = conf.get("General", "Shaders", shaders, "Disable to get rid of the fancy effects on the shoggoth").getBoolean(true);

            /*int biome = 175;
            spookyID = conf.get("Biome IDs", "Spooky Forest", biome).getInt(biome++);
            ossuaryID = conf.get("Biome IDs", "Ossuary", biome).getInt(biome++);
            candyID = conf.get("Biome IDs", "Rock Candy Mountain", biome).getInt(biome++);
            madnessID = conf.get("Biome IDs", "Mountain of Madness", biome).getInt(biome++);
            shadowID = conf.get("Biome IDs", "Shadow Fen", biome).getInt(biome++);
            botaniaID = conf.get("Biome IDs", "Botanical Garden", biome).getInt(biome++);
            timeID = conf.get("Biome IDs", "Timeslip Fields", biome).getInt(biome++);*/

            spookyWeight = conf.get("Biome Weights", "Spooky Forest", spookyWeight).getInt(spookyWeight);
            ossuaryWeight = conf.get("Biome Weights", "Ossuary", ossuaryWeight).getInt(ossuaryWeight);
            candyWeight = conf.get("Biome Weights", "Rock Candy Mountain", candyWeight).getInt(candyWeight);
            madnessWeight = conf.get("Biome Weights", "Mountain of Madness", madnessWeight).getInt(madnessWeight);
            shadowWeight = conf.get("Biome Weights", "Shadow Fen", shadowWeight).getInt(shadowWeight);
            timeWeight = conf.get("Biome Weights", "Timeslip Fields", timeWeight).getInt(timeWeight);

            botaniaWeight = conf.get("Biome Weights", "Botanical Garden", botaniaWeight).getInt(botaniaWeight);

            botania = conf.get("Compatibility", "Botania", botania).getBoolean(true);
            thaum = conf.get("Compatibility", "Thaumcraft", thaum).getBoolean(true);
        }
        catch (Exception e)
        {
            Lumberjack.log(Level.ERROR, e, "Ridiculous World was unable to load its config.");
        }
        finally
        {
            conf.save();
        }

    }
}
