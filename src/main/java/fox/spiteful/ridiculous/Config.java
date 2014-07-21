package fox.spiteful.ridiculous;

import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;
import java.util.logging.Level;

public class Config {

    public static int spookyID;
    public static int ossuaryID;
    public static int candyID;
    public static int muricaID;

    public static boolean heads = true;

    public static void configurate(File targ)
    {
        Configuration conf = new Configuration(targ);

        try
        {
            conf.load();
            heads = conf.get("general", "Overwrite Head Render", heads, "Enable to make player heads render correctly").getBoolean(false);

            int biome = 175;
            spookyID = conf.get("biomes", "Spooky Woods", biome).getInt(biome++);
            ossuaryID = conf.get("biomes", "Ossuary", biome).getInt(biome++);
            candyID = conf.get("biomes", "Rock Candy Mountain", biome).getInt(biome++);
            muricaID = conf.get("biomes", "Murica", biome).getInt(biome++);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            conf.save();
        }

    }
}
