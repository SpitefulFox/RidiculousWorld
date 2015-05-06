package fox.spiteful.ridiculous;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import fox.spiteful.ridiculous.biomes.UnrealBiomes;
import fox.spiteful.ridiculous.blocks.RidiculousBlocks;
import fox.spiteful.ridiculous.compat.Compat;
import fox.spiteful.ridiculous.entities.RidiculousMobs;
import fox.spiteful.ridiculous.gui.RidiculousGUI;
import fox.spiteful.ridiculous.items.RidiculousItems;
import fox.spiteful.ridiculous.world.RidiculousWorldGenerator;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

@Mod(
        modid = "RidiculousWorld",
        name = "Ridiculous World",
        version = "0.1",
        dependencies = "required-after:Forge@[10.13.2.1231,);after:Botania"
)
public class Ridiculous {
    @Instance("RidiculousWorld")
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

    @EventHandler
    public void prologue(FMLPreInitializationEvent event)
    {
        instance = this;
        Config.configurate(event.getSuggestedConfigurationFile());
        MinecraftForge.EVENT_BUS.register(new RWEventHandler());
        RidiculousItems.itemize();
        RidiculousBlocks.blockBlockity();
        Compat.preparatoryCompatification();
    }

    @EventHandler
    public void climax(FMLInitializationEvent event)
    {
        proxy.doTheRenderThing();
        UnrealBiomes.genesis();
        RidiculousMobs.mobify();
        Crafter.artsAndCrafts();
        GameRegistry.registerWorldGenerator(new RidiculousWorldGenerator(), 5);
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new RidiculousGUI());
    }

    @EventHandler
    public void conclusion(FMLPostInitializationEvent event)
    {
        Compat.compatify();
    }
}
