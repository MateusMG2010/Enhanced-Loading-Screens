package net.mgstudios.els.client.mixin;

import net.mgstudios.els.client.util.BackgroundRenderer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.DisconnectedScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(DisconnectedScreen.class)
public class DisconnectedScreenMixin extends Screen {
    protected DisconnectedScreenMixin(Component component) {
        super(component);
    }
    @Override
    public void renderBackground(GuiGraphics guiGraphics, int i, int j, float f){
        super.renderBackground(guiGraphics, i, j ,f);
        BackgroundRenderer.renderBackground(guiGraphics, width, height);
    }
    @Override
    public void onClose(){
        super.onClose();
        BackgroundRenderer.newBackground();
    }
}