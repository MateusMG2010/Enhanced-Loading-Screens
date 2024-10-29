package net.mgstudios.els.client.mixin;

import net.mgstudios.els.client.util.BackgroundRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.ProgressScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ProgressScreen.class)
public class ProgressScreenMixin extends Screen {
    protected ProgressScreenMixin(Component component) {
        super(component);
    }
    @Override
    public void render(GuiGraphics guiGraphics, int i, int j, float f){
        super.render(guiGraphics,i,j,f);
        if(Minecraft.getInstance().getWindow().shouldClose()){
            guiGraphics.drawString(getFont(), Component.translatable("text.onQuit"), 5, Minecraft.getInstance().getWindow().getGuiScaledHeight() - 15, 0xFFFFFF);
        }
        BackgroundRenderer.renderBackground(guiGraphics, width, height);
    }
}