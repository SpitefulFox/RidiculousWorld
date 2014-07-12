package fox.spiteful.ridiculous.client.entities;

import fox.spiteful.ridiculous.entities.EntityUnicorn;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.ResourceLocation;

public class RenderUnicorn extends RenderLiving {
    private static final ResourceLocation[] textures = new ResourceLocation[] {
            new ResourceLocation("ridiculous", "textures/models/unicorn_white.png"),
            new ResourceLocation("ridiculous", "textures/models/unicorn_pink.png"),
            new ResourceLocation("ridiculous", "textures/models/unicorn_blue.png"),
            new ResourceLocation("ridiculous", "textures/models/unicorn_purple.png"),
            new ResourceLocation("ridiculous", "textures/models/unicorn_black.png"),
            new ResourceLocation("ridiculous", "textures/models/unicorn_peach.png"),
            new ResourceLocation("ridiculous", "textures/models/unicorn_rainbow.png")
    };
    private static final ResourceLocation[] armorTextures = new ResourceLocation[]{
            new ResourceLocation("textures/entity/horse/armor/horse_armor_iron.png"),
            new ResourceLocation("textures/entity/horse/armor/horse_armor_gold.png"),
            new ResourceLocation("textures/entity/horse/armor/horse_armor_diamond.png")
    };

    public RenderUnicorn(){
        super(new ModelUnicorn(), 0.75F);
        this.setRenderPassModel(new ModelUnicorn(0.6F));
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLivingBase mob, int p_77032_2_, float p_77032_3_)
    {

        EntityUnicorn unicorn = (EntityUnicorn)mob;

        if (p_77032_2_ == 0 && unicorn.func_110241_cb() > 0 && unicorn.func_110241_cb() < armorTextures.length + 1)
        {
            this.bindTexture(armorTextures[unicorn.func_110241_cb() - 1]);
            return 1;
        }
        else
        {
            return -1;
        }
    }

    public ResourceLocation getEntityTexture(Entity mob){
        EntityUnicorn unicorn = (EntityUnicorn)mob;
        return textures[(unicorn.getHorseVariant() & 255) % textures.length];
    }
}
