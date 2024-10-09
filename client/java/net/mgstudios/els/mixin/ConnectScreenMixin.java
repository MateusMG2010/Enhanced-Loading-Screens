package net.mgstudios.els.mixin;

import net.mgstudios.els.util.BackgroundSupplier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.multiplayer.ConnectScreen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ConnectScreen.class)
public class ConnectScreenMixin extends Screen {
    protected ConnectScreenMixin(Text title) {
        super(title);
    }

    @Override
    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
        final int WIDTH = MinecraftClient.getInstance().getWindow().getScaledWidth();
        final int HEIGHT = MinecraftClient.getInstance().getWindow().getScaledHeight();
        context.drawTexture(Identifier.of("els","textures/"+ BackgroundSupplier.getPath()), 0,0, 0, 0, 0, width, height,WIDTH, HEIGHT);
    }
}