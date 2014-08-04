package fox.spiteful.ridiculous.client.entities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderStarspawn extends RenderLiving
{
    private static final ResourceLocation slimeTextures = new ResourceLocation("textures/entity/end_portal.png");
    private ModelBase scaleAmount;

    public RenderStarspawn()
    {
        super(new ModelSlime(16), 0.25F);
        this.scaleAmount = new ModelSlime(0);
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntitySlime slime, int renderPass, float wat)
    {
        if (slime.isInvisible())
        {
            return 0;
        }
        else if (renderPass == 0)
        {
            this.setRenderPassModel(this.scaleAmount);
            GL11.glEnable(GL11.GL_NORMALIZE);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

            return 1;
        }
        else
        {
            if (renderPass == 1)
            {
                GL11.glDisable(GL11.GL_BLEND);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

            }

            return -1;
        }
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntitySlime slime, float partialTickTime)
    {
        float f1 = (float)slime.getSlimeSize();
        float f2 = (slime.prevSquishFactor + (slime.squishFactor - slime.prevSquishFactor) * partialTickTime) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        GL11.glScalef(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase mob, float partialTickTime)
    {
        this.preRenderCallback((EntitySlime)mob, partialTickTime);
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLivingBase mob, int renderPass, float wat)
    {
        return this.shouldRenderPass((EntitySlime)mob, renderPass, wat);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return slimeTextures;
    }

}