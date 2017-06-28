package fox.spiteful.ridiculous.client.entities;

import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderCalavera extends RenderSkeleton {
    private static final ResourceLocation texture = new ResourceLocation("ridiculous", "textures/models/calavera.png");
    public RenderCalavera(){
        super();
    }

    public ResourceLocation getEntityTexture(Entity mob){
        return texture;
    }
}
