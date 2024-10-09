package net.mgstudios.els.mixin;

import net.mgstudios.els.util.BackgroundSupplier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.world.LevelLoadingScreen;
import net.minecraft.server.WorldGenerationProgressTracker;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(LevelLoadingScreen.class)
public class LevelLoadingScreenMixin extends Screen {
    @Shadow @Final private WorldGenerationProgressTracker progressProvider;
    @Unique private long lastNarrationTime = -1L;

    public LevelLoadingScreenMixin(Text title) {
        super(title);
    }

    @Unique
    Identifier getBarTexture(int FILL_LEVEL){
        return Identifier.of("els","textures/bar/bar_%s.png".formatted(FILL_LEVEL));
    }

    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        long l = Util.getMeasuringTimeMs();
        if (l - this.lastNarrationTime > 2000L) {
            this.lastNarrationTime = l;
            this.narrateScreenIfNarrationEnabled(true);
        }
        context.drawTexture(Identifier.of("els","textures/"+ BackgroundSupplier.getPath()), 0,0, 0, 0, 0, width, height,MinecraftClient.getInstance().getWindow().getScaledWidth(), MinecraftClient.getInstance().getWindow().getScaledHeight());
        context.drawTexture(getBarTexture(getFillLevel(progressProvider.getProgressPercentage())), 5,MinecraftClient.getInstance().getWindow().getScaledHeight() - 30, 0, 0, 0, 75, 25,75, 25);
    }

    @Unique
    int getFillLevel(int percentage){
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