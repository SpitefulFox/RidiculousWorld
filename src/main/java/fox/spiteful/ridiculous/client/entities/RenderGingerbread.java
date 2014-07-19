package fox.spiteful.ridiculous.client.entities;

import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGingerbread extends RenderBiped {
    private static final ResourceLocation texture = new ResourceLocation("ridiculous", "textures/models/gingerbreadman.png");

    public RenderGingerbread(){
        super(new ModelGingerbread(), 0.5F, 1.0F);
    }

    public ResourceLocation getEntityTexture(Entity mob){
        return texture;
    }
}
