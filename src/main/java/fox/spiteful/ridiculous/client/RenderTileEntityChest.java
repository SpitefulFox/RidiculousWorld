package fox.spiteful.ridiculous.client;

import fox.spiteful.ridiculous.tile.TileEntityChestRidiculous;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glScalef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import java.util.Random;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderTileEntityChest extends TileEntitySpecialRenderer {

    public static final ResourceLocation botanyChest = new ResourceLocation("ridiculous", "textures/models/botanical_chest.png");

    private ModelChest model = new ModelChest();

    public void render(TileEntityChestRidiculous tile, double x, double y, double z, float partialTick) {
        if (tile == null) {
            return;
        }
        int facing = 3;
        if (tile != null && tile.hasWorldObj()) {
            facing = tile.getFacing();
        }
        bindTexture(botanyChest);
        glPushMatrix();
        glEnable(32826 /* GL_RESCALE_NORMAL_EXT */);
        glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        glTranslatef((float) x, (float) y + 1.0F, (float) z + 1.0F);
        glScalef(1.0F, -1F, -1F);
        glTranslatef(0.5F, 0.5F, 0.5F);
        int k = 0;
        if (facing == 2) {
            k = 180;
        }
        if (facing == 3) {
            k = 0;
        }
        if (facing == 4) {
            k = 90;
        }
        if (facing == 5) {
            k = -90;
        }
        glRotatef(k, 0.0F, 1.0F, 0.0F);
        glTranslatef(-0.5F, -0.5F, -0.5F);
        float lidangle = tile.prevLidAngle + (tile.lidAngle - tile.prevLidAngle) * partialTick;
        lidangle = 1.0F - lidangle;
        lidangle = 1.0F - lidangle * lidangle * lidangle;
        model.chestLid.rotateAngleX = -((lidangle * 3.141593F) / 2.0F);
// Render the chest itself
        model.renderAll();
        glDisable(32826 /* GL_RESCALE_NORMAL_EXT */);
        glPopMatrix();
        glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

    }
    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float partialTick)
    {
        render((TileEntityChestRidiculous) tileentity, x, y, z, partialTick);
    }

}
