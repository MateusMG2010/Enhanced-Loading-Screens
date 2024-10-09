package net.mgstudios.els.mixin;

import net.mgstudios.els.util.BackgroundSupplier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.DownloadingTerrainScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(DownloadingTerrainScreen.class)
public class DownloadingTerrainScreenMixin extends Screen {
    public DownloadingTerrainScreenMixin(Text title) {
        super(title);
    }

    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context,mouseX,mouseY,delta);
    }

    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
        final int WIDTH = MinecraftClient.getInstance().getWindow().getScaledWidth();
        final int HEIGHT = MinecraftClient.getInstance().getWindow().getScaledHeight();
        context.drawTexture(Identifier.of("els", "textures/"+ BackgroundSupplier.getPath()), 0,0, 0, 0, 0, width, height,WIDTH,HEIGHT);
        context.drawText(this.textRenderer, Text.translatable("multiplayer.downloadingTerrain"), 5, HEIGHT - 15, 0xFFFFFFFF, true);
    }

    @Override
    public void close() {
        super.close();
        BackgroundSupplier.newPath();
    }
}