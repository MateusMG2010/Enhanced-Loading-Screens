package net.mgstudios.els.client.mixin;

import net.mgstudios.els.client.util.BackgroundRenderer;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.LevelLoadingScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.progress.StoringChunkProgressListener;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(LevelLoadingScreen.class)
public class LevelLoadingScreenMixin extends Screen {
    @Shadow @Final private StoringChunkProgressListener progressListener;
    @Unique private long lastNarration = -1L;
    protected LevelLoadingScreenMixin(Component component) {
        super(component);
    }
    @Override
    public void render(GuiGraphics guiGraphics, int i, int j, float f){
        long l = Util.getMillis();
        if (l - this.lastNarration > 2000L) {
            this.lastNarration = l;
            this.triggerImmediateNarration(true);
        }
        BackgroundRenderer.renderBackground(guiGraphics, width, height);
        guiGraphics.blit(resourceLocation -> RenderType.guiTextured(getBarTexture()), getBarTexture(), 5, Minecraft.getInstance().getWindow().getGuiScaledHeight() - 30, 0, 0, 75, 25,75, 25);
    }

    @Unique
    private ResourceLocation getBarTexture(){
        return ResourceLocation.fromNamespaceAndPath("els","textures/bar/bar_%s.png".formatted(getFillLevel()));
    }

    @Unique
    private int getFillLevel(){
        final int percentage = progressListener.getProgress();
        if(percentage > 90) return 10;
        if(percentage > 80) return 9;
        if(percentage > 70) return 8;
        if(percentage > 60) return 7;
        if(percentage > 50) return 6;
        if(percentage > 40) return 5;
        if(percentage > 30) return 4;
        if(percentage > 20) return 3;
        if(percentage > 10) return 2;
        if(percentage > 0) return 1;
        return 0;
    }
}