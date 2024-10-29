package net.mgstudios.els.client;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ClientModInitializer;

public class EnhancedLoadingScreensClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        LogUtils.getLogger().info("Enhanced Loading Screens (ELS) has been initialized!");
    }
}