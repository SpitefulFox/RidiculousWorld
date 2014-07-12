package fox.spiteful.ridiculous.client.entities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelHorse;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderWarhorse extends RenderLiving {
    private static final ResourceLocation texture = new ResourceLocation("textures/entity/horse/horse_skeleton.png");

    public RenderWarhorse(){
        super(new ModelWarhorse(), 0.75F);
    }

    public ResourceLocation getEntityTexture(Entity mob){
        return texture;
    }
}
