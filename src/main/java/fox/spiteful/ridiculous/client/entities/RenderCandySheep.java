package fox.spiteful.ridiculous.client.entities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderCandySheep extends RenderLiving
{
    private static final ResourceLocation woolTexture = new ResourceLocation("ridiculous", "textures/models/sheep_candy.png");
    private static final ResourceLocation shearedSheepTexture = new ResourceLocation("textures/entity/sheep/sheep.png");

    public RenderCandySheep(ModelBase body, ModelBase wool, float wat)
    {
        super(body, wat);
        this.setRenderPassModel(wool);
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntitySheep shoop, int pass, float yeah)
    {
        if (pass == 0 && !shoop.getSheared())
        {
            this.bindTexture(woolTexture);

            return 1;
        }
        else
        {
            return -1;
        }
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLivingBase shoop, int pass, float wat)
    {
        return this.shouldRenderPass((EntitySheep)shoop, pass, wat);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity shoop)
    {
        return shearedSheepTexture;
    }
}