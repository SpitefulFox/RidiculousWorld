package fox.spiteful.ridiculous.client.entities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderFrankenstein extends RenderBiped {
    private static final ResourceLocation texture = new ResourceLocation("ridiculous", "textures/models/frankenstein.png");

    public RenderFrankenstein(){
        super(new ModelZombie(), 0.5F, 1.0F);
    }

    public ResourceLocation getEntityTexture(Entity mob){
        return texture;
    }
}
