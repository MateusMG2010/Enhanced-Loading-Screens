package net.mgstudios.els.client.mixin;

import net.mgstudios.els.client.util.BackgroundRenderer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.DirectJoinServerScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(DirectJoinServerScreen.class)
public class DirectJoinServerScreenMixin extends Screen {
    protected DirectJoinServerScreenMixin(Component component) {
        super(component);
    }
    @Override
    public void renderBackground(GuiGraphics guiGraphics, int i, int j, float f){
        super.renderBackground(guiGraphics, i, j, f);
        BackgroundRenderer.renderBackground(guiGraphics, width, height);
    }
}