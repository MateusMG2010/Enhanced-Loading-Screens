package net.mgstudios.els.client.mixin;

import net.mgstudios.els.client.util.BackgroundRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.ReceivingLevelScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ReceivingLevelScreen.class)
public class ReceivingLevelScreenMixin extends Screen {
    protected ReceivingLevelScreenMixin(Component component) {
        super(component);
    }
    @Override
    public void render(GuiGraphics guiGraphics, int i, int j, float f){
        guiGraphics.drawString(getFont(), Component.translatable("multiplayer.downloadingTerrain"), 5, Minecraft.getInstance().getWindow().getGuiScaledHeight() - 15, 0xFFFFFF);
        BackgroundRenderer.renderBackground(guiGraphics, width, height);
    }
    @Override
    public void onClose(){
        super.onClose();
        BackgroundRenderer.newBackground();
    }
}