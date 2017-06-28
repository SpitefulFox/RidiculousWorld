package fox.spiteful.ridiculous.client.entities;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelGingerbread extends ModelZombie {
    public ModelGingerbread(){
        this(0.0F, 0.0F, 64, 64);
    }

    public ModelGingerbread(float scale, float fuckObfuscation, int textureWidth, int textureHeight){
        super(scale, fuckObfuscation, textureWidth, textureHeight);
        this.isChild = true;
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.addBox(-4.0F, -8.0F, -2.0F, 8, 8, 4, scale);
        this.bipedHead.setRotationPoint(0.0F, 0.0F + fuckObfuscation, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);

        float f6 = 2.0F;
        GL11.glPushMatrix();
        GL11.glScalef(1.5F / f6, 1.5F / f6, 1.5F / f6);
        GL11.glTranslatef(0.0F, 16.0F * p_78088_7_, 0.0F);
        this.bipedHead.render(p_78088_7_);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
        GL11.glTranslatef(0.0F, 24.0F * p_78088_7_, 0.0F);
        this.bipedBody.render(p_78088_7_);
        this.bipedRightArm.render(p_78088_7_);
        this.bipedLeftArm.render(p_78088_7_);
        this.bipedRightLeg.render(p_78088_7_);
        this.bipedLeftLeg.render(p_78088_7_);
        GL11.glPopMatrix();

    }
}