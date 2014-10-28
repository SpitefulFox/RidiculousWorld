package fox.spiteful.ridiculous;

import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;
import org.apache.logging.log4j.Level;

public class Config {

    public static int spookyID;
    public static int ossuaryID;
    public static int candyID;
    public static int muricaID;
    public static int madnessID;

    public static int spookyWeight = 15;
    public static int ossuaryWeight = 7;
    public static int candyWeight = 10;
    public static int muricaWeight = 0;
    public static int madnessWeight = 8;

    public static boolean heads = true;

    public static void configurate(File targ)
    {
        Configuration conf = new Configuration(targ);

        try
        {
            conf.load();
            heads = conf.get("General", "Overwrite Head Render", heads, "Enable to make player heads render correctly").getBoolean(false);

            int biome = 175;
            spookyID = conf.get("Biome IDs", "Spooky Forest", biome).getInt(biome++);
            ossuaryID = conf.get("Biome IDs", "Ossuary", biome).getInt(biome++);
            candyID = conf.get("Biome IDs", "Rock Candy Mountain", biome).getInt(biome++);
            muricaID = conf.get("Biome IDs", "Murica", biome).getInt(biome++);
            madnessID = conf.get("Biome IDs", "Mountain of Madness", biome).getInt(biome++);

            spookyWeight = conf.get("Biome Weights", "Spooky Forest", spookyWeight).getInt(spookyWeight);
            ossuaryWeight = conf.get("Biome Weights", "Ossuary", ossuaryWeight).getInt(ossuaryWeight);
            candyWeight = conf.get("Biome Weights", "Rock Candy Mountain", candyWeight).getInt(candyWeight);
            muricaWeight = conf.get("Biome Weights", "MURICA!", muricaWeight).getInt(muricaWeight);
            madnessWeight = conf.get("Biome Weights", "Mountain of Madness", madnessWeight).getInt(madnessWeight);
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
