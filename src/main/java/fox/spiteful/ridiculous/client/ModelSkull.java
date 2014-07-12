package fox.spiteful.ridiculous.client;

/* Player head rendering code courtesy of Kihira ^_^ */

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSkull extends ModelBase {

    private final ModelRenderer bipedHead;
    private final ModelRenderer bipedHeadwear;

    public ModelSkull() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0F);
        this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedHeadwear = new ModelRenderer(this, 32, 0);
        this.bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
        this.bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
    }

    public void renderWithoutRotation(float par1) {
        this.bipedHead.render(par1);
        this.bipedHeadwear.render(par1);
    }

    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
        this.bipedHead.render(par7);
        this.bipedHeadwear.render(par7);
    }

    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
        this.bipedHead.rotateAngleY = this.bipedHeadwear.rotateAngleY = par4 / (180F / (float)Math.PI);
        this.bipedHead.rotateAngleX = this.bipedHeadwear.rotateAngleX = par5 / (180F / (float)Math.PI);
    }
}
