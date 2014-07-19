package fox.spiteful.ridiculous;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import fox.spiteful.ridiculous.biomes.UnrealBiomes;
import fox.spiteful.ridiculous.blocks.RidiculousBlocks;
import fox.spiteful.ridiculous.entities.RidiculousMobs;
import fox.spiteful.ridiculous.items.RidiculousItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

@Mod(
        modid = "RidiculousWorld",
        name = "Ridiculous Worlds",
        version = "0.1"
        //dependencies = "required-after:Thaumcraft;after:ThaumicTinkerer"
)
public class Ridiculous {
    @Instance("RidWorlds")
    public static Ridiculous instance;
    @SidedProxy(
            clientSide = "fox.spiteful.ridiculous.client.ClientProxy",
            serverSide = "fox.spiteful.ridiculous.CommonProxy"
    )
    public static CommonProxy proxy;
    public static final CreativeTabs tab = new RidiculousTab();

    @EventHandler
    public void prologue(FMLPreInitializationEvent event)
    {
        instance = this;
        Config.configurate(event.getSuggestedConfigurationFile());
        MinecraftForge.EVENT_BUS.register(new RWEventHandler());
        proxy.doTheRenderThing();
        RidiculousItems.itemize();
        RidiculousBlocks.blockBlockity();
    }

    @EventHandler
    public void climax(FMLInitializationEvent event)
    {
        UnrealBiomes.genesis();
        RidiculousMobs.mobify();
        Crafter.artsAndCrafts();
    }

    @EventHandler
    public void conclusion(FMLPostInitializationEvent event)
    {

    }
}
