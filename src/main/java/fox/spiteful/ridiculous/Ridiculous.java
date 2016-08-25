package fox.spiteful.ridiculous;

import fox.spiteful.ridiculous.biomes.UnrealBiomes;
import fox.spiteful.ridiculous.blocks.RidiculousBlocks;
import fox.spiteful.ridiculous.compat.Compat;
import fox.spiteful.ridiculous.items.RidiculousItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(
        modid = "RidiculousWorld",
        name = "Ridiculous World",
        version = "0.1",
        dependencies = "required-after:Forge@[10.13.2.1231,);after:Botania"
)
public class Ridiculous {
    @Mod.Instance("RidiculousWorld")
    public static Ridiculous instance;
    @SidedProxy(
            clientSide = "fox.spiteful.ridiculous.client.ClientProxy",
            serverSide = "fox.spiteful.ridiculous.CommonProxy"
    )
    public static CommonProxy proxy;
    public static final CreativeTabs tab = new CreativeTabs("ridiculous"){
        @Override
        public Item getTabIconItem() {
            return RidiculousItems.peepRaw;
        }
    };

    @Mod.EventHandler
    public void prologue(FMLPreInitializationEvent event)
    {
        instance = this;
        Config.configurate(event.getSuggestedConfigurationFile());
        MinecraftForge.EVENT_BUS.register(new RWEventHandler());
        RidiculousItems.itemize();
        RidiculousBlocks.blockBlockity();
        Compat.preparatoryCompatification();
    }

    @Mod.EventHandler
    public void climax(FMLInitializationEvent event)
    {
        proxy.doTheRenderThing();
        UnrealBiomes.genesis();
        //RidiculousMobs.mobify();
        Crafter.artsAndCrafts();
        //GameRegistry.registerWorldGenerator(new RidiculousWorldGenerator(), 5);
        //NetworkRegistry.INSTANCE.registerGuiHandler(instance, new RidiculousGUI());
    }

    @Mod.EventHandler
    public void conclusion(FMLPostInitializationEvent event)
    {
        Compat.compatify();
    }

    @Mod.EventHandler
    public void serverTheHappening(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandPlayerHead());
    }
}
