package fox.spiteful.ridiculous.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import fox.spiteful.ridiculous.CommonProxy;
import fox.spiteful.ridiculous.Config;
import fox.spiteful.ridiculous.client.entities.*;
import fox.spiteful.ridiculous.client.shaders.ShaderHelper;
import fox.spiteful.ridiculous.entities.*;
import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.tileentity.TileEntitySkull;

public class ClientProxy extends CommonProxy {
    public void doTheRenderThing(){
        RenderingRegistry.registerEntityRenderingHandler(EntityFrankenstein.class, new RenderFrankenstein());
        RenderingRegistry.registerEntityRenderingHandler(EntityWarhorse.class, new RenderWarhorse());
        RenderingRegistry.registerEntityRenderingHandler(EntityPeep.class, new RenderPeep());
        RenderingRegistry.registerEntityRenderingHandler(EntityUnicorn.class, new RenderUnicorn());
        RenderingRegistry.registerEntityRenderingHandler(EntityCalavera.class, new RenderCalavera());
        RenderingRegistry.registerEntityRenderingHandler(EntityGingerbread.class, new RenderGingerbread());
        RenderingRegistry.registerEntityRenderingHandler(EntityShoggoth.class, new RenderShoggoth());
        RenderingRegistry.registerEntityRenderingHandler(EntityDaySkeleton.class, new RenderSkeleton());
        RenderingRegistry.registerEntityRenderingHandler(EntityDayZombie.class, new RenderZombie());

        if(Config.heads && !Loader.isModLoaded("foxlib")){
            TileEntityRendererDispatcher.instance.mapSpecialRenderers.remove(TileEntitySkull.class);
            BlockSkullRenderer blockSkullRenderer = new BlockSkullRenderer();
            ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySkull.class, blockSkullRenderer);
        }

        ShaderHelper.initShaders();
    }
}
