package fox.spiteful.ridiculous.client.entities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderFrankenstein extends RenderBiped {
    private static final ResourceLocation texture = new ResourceLocation("ridiculous", "textures/models/frankenstein.png");
    /** Scale of the model to use */
    private float scale;

    public RenderFrankenstein(){
        super(new ModelZombie(), 0.5F, 1.0F);
        this.scale = 1.2F;
    }

    public ResourceLocation getEntityTexture(Entity mob){
        return texture;
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_)
    {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }
}
