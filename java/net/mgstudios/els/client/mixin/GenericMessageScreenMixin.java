package net.mgstudios.els.client.mixin;

import net.mgstudios.els.client.util.BackgroundRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.GenericMessageScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(GenericMessageScreen.class)
public class GenericMessageScreenMixin extends Screen {
    protected GenericMessageScreenMixin(Component component) {
        super(component);
    }
    @Override
    public void init() {
        super.init();
    }
    @Override
    public void render(GuiGraphics guiGraphics, int i, int j, float f){
        super.render(guiGraphics, i, j, f);
        guiGraphics.drawString(getFont(), this.getTitle(), 5, Minecraft.getInstance().getWindow().getGuiScaledHeight() - 15, 0xFFFFFF);
        BackgroundRenderer.renderBackground(guiGraphics, width, height);
    }
}