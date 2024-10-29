package net.mgstudios.els.client.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import java.io.FileNotFoundException;
import java.util.Random;

public final class BackgroundRenderer {
    private static String BACKGROUND_PATH = "textures/default.png";
    private static boolean checkPath(String PATH) {
        try {
            Minecraft.getInstance().getResourceManager().getResourceOrThrow(ResourceLocation.fromNamespaceAndPath("els",PATH));
            return true;
        }catch (FileNotFoundException e){
            return false;
        }
    }
    public static void newBackground(){
        int found_textures = 0;
        for (int i = 1; i < 13; i++) {
            if(checkPath("textures/image_%d.png".formatted(i))){
                found_textures+=1;
            }
        }
        if(found_textures > 0) {
            while (true){
                int sorted = new Random().nextInt(1,13);
                if(checkPath("textures/image_%d.png".formatted(sorted))){
                    BACKGROUND_PATH = "textures/image_%d.png".formatted(sorted);
                    break;
                }
            }
        }
    }
    public static void renderBackground(GuiGraphics guiGraphics, int width, int height){
        if(BACKGROUND_PATH.equals("textures/default.png")) newBackground();
        guiGraphics.blit(resourceLocation -> RenderType.guiTextured(ResourceLocation.fromNamespaceAndPath("els",BACKGROUND_PATH)), ResourceLocation.fromNamespaceAndPath("els","textures/default.png"), 0, 0, 0,0, width, height, Minecraft.getInstance().getWindow().getGuiScaledWidth(), Minecraft.getInstance().getWindow().getGuiScaledHeight());
    }
}