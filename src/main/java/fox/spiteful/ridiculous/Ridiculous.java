package fox.spiteful.ridiculous;

import fox.spiteful.ridiculous.biomes.UnrealBiomes;
import fox.spiteful.ridiculous.blocks.RidiculousBlocks;
import fox.spiteful.ridiculous.items.RidiculousItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(
        modid = "ridiculousworld",
        name = "Ridiculous World",
        version = "1.0"
        //dependencies = "required-after:Forge@[10.13.2.1231,);after:Botania"
)
public class Ridiculous {
    @Mod.Instance("ridiculousworld")
    public static Ridiculous instance;
    @SidedProxy(
            clientSide = "fox.spiteful.ridiculous.client.ClientProxy",
            serverSide = "fox.spiteful.ridiculous.CommonProxy"
    )
    public static CommonProxy proxy;
    public static final CreativeTabs tab = new CreativeTabs("ridiculous"){
        @Override
        public ItemStack getTabIconItem() {
            //return RidiculousItems.peepRaw;
            return new ItemStack(Items.COOKIE);
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
        proxy.doTheRenderThing();
        //Compat.preparatoryCompatification();
    }

    @Mod.EventHandler
    public void climax(FMLInitializationEvent event)
    {
        UnrealBiomes.genesis();
        //RidiculousMobs.mobify();
        //Crafter.artsAndCrafts();
        //GameRegistry.registerWorldGenerator(new RidiculousWorldGenerator(), 5);
        //NetworkRegistry.INSTANCE.registerGuiHandler(instance, new RidiculousGUI());
    }

    @Mod.EventHandler
    public void conclusion(FMLPostInitializationEvent event)
    {
        //Compat.compatify();
    }

    @Mod.EventHandler
    public void serverTheHappening(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandPlayerHead());
    }
}
