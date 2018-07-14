package fox.spiteful.ridiculous.client;

import fox.spiteful.ridiculous.CommonProxy;
import fox.spiteful.ridiculous.Lumberjack;
import fox.spiteful.ridiculous.blocks.RidiculousBlocks;
import fox.spiteful.ridiculous.items.RidiculousItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.Level;

//@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {


    //@SubscribeEvent
    public void doTheRenderThing(){//ModelRegistryEvent event){
        ModelLoader.setCustomModelResourceLocation(RidiculousItems.rustySickle, 0, new ModelResourceLocation(RidiculousItems.rustySickle.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(RidiculousItems.candyCorn, 0, new ModelResourceLocation(RidiculousItems.candyCorn.getRegistryName(), "inventory"));

        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(RidiculousBlocks.spookyLog), 0, new ModelResourceLocation(RidiculousBlocks.spookyLog.getRegistryName(), "inventory"));


        //Lumberjack.log(Level.WARN, "REGISTERING MODEL LOLOLOLOLOL");

        /*RenderingRegistry.registerEntityRenderingHandler(EntityFrankenstein.class, new RenderFrankenstein());
        RenderingRegistry.registerEntityRenderingHandler(EntityWarhorse.class, new RenderWarhorse());
        RenderingRegistry.registerEntityRenderingHandler(EntityPeep.class, new RenderPeep());
        RenderingRegistry.registerEntityRenderingHandler(EntityUnicorn.class, new RenderUnicorn());
        RenderingRegistry.registerEntityRenderingHandler(EntityCalavera.class, new RenderCalavera());
        RenderingRegistry.registerEntityRenderingHandler(EntityGingerbread.class, new RenderGingerbread());
        RenderingRegistry.registerEntityRenderingHandler(EntityShoggoth.class, new RenderShoggoth());
        RenderingRegistry.registerEntityRenderingHandler(EntityDaySkeleton.class, new RenderSkeleton());
        RenderingRegistry.registerEntityRenderingHandler(EntityDayZombie.class, new RenderZombie());
        RenderingRegistry.registerEntityRenderingHandler(EntityShadowSlime.class, new RenderShadowSlime());
        RenderingRegistry.registerEntityRenderingHandler(EntityCandySheep.class, new RenderCandySheep(new ModelSheep2(), new ModelSheep1(), 0.7F));
        RenderingRegistry.registerEntityRenderingHandler(EntityOldEnderman.class, new RenderOldEnderman());

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChestRidiculous.class, new RenderTileEntityChest());
        BlockChestRidiculous.render = RenderingRegistry.getNextAvailableRenderId();
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(RidiculousBlocks.chest), new RenderItemChest());

        ShaderHelper.initShaders();*/
    }
}
