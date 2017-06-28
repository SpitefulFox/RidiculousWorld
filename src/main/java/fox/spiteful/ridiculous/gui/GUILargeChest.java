package fox.spiteful.ridiculous.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GUILargeChest extends GuiContainer {

    private static final ResourceLocation gui = new ResourceLocation("ridiculous", "textures/gui/largecontainer.png");

    public GUILargeChest(IInventory player, IInventory chest){
        super(new ContainerLargeChest(player, chest));
        this.xSize = 184;
        this.ySize = 202;
        this.allowUserInput = false;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(gui);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
}
