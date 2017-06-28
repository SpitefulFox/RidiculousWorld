package fox.spiteful.ridiculous.client.entities;

import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderMummy extends RenderBiped {
    private static final ResourceLocation texture = new ResourceLocation("ridiculous", "textures/models/mummy.png");

    public RenderMummy(){
        super(new ModelZombie(), 0.5F, 1.0F);
    }

    public ResourceLocation getEntityTexture(Entity mob){
        return texture;
    }
}
