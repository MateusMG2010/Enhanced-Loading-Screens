package net.mgstudios.els.client;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;

public class EnhancedLoadingScreensClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        final Logger logger = LogUtils.getLogger();
        logger.info("Enhanced Loading Screens is here baby.");
    }
}