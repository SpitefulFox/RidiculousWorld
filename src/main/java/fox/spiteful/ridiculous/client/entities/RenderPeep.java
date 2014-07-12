package fox.spiteful.ridiculous.client.entities;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.renderer.entity.RenderChicken;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderPeep extends RenderChicken {
    private static final ResourceLocation texture = new ResourceLocation("ridiculous", "textures/models/peep.png");

    public RenderPeep(){
        super(new ModelChicken(), 0.3F);
    }

    public ResourceLocation getEntityTexture(Entity mob){
        return texture;
    }
}
