package net.mgstudios.els.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;

import java.io.FileNotFoundException;
import java.util.Random;

public final class BackgroundSupplier {
    private static String PATH;

    private static boolean CheckIdentifier(Identifier id){
        try {
            MinecraftClient.getInstance().getResourceManager().getResourceOrThrow(id);
            return true;
        }catch (FileNotFoundException e){
            return false;
        }
    }

    private static void SortImage(){
        final int SORTED = new Random().nextInt(1,13);
        if(CheckIdentifier(Identifier.of("els","textures/image_%s.png".formatted(SORTED)))){
            PATH = "image_%s.png".formatted(SORTED);
        }
        else {
            SortImage();
        }
    }

    public static String getPath(){
        if(PATH == null){
            int FOUND_TEXTURES = 0;
            for (int i = 1; i < 13; i++) {
                if(CheckIdentifier(Identifier.of("els","textures/image_%s.png".formatted(i)))){
                    FOUND_TEXTURES+=1;
                }
            }
            if(FOUND_TEXTURES > 0) {
                SortImage();
            }
            else {
                PATH = "default.png";
            }
        }
        return PATH;
    }
    public static void newPath(){
        PATH = null;
    }
}