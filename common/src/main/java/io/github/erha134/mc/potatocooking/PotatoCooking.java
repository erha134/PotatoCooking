package io.github.erha134.mc.potatocooking;

import dev.architectury.platform.Platform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PotatoCooking {
    public static final String MOD_ID = "potatocooking";
    public static final String MOD_NAME = "Potato Cooking";
    public static final String MOD_VERSION = Platform.getMod(MOD_ID).getVersion();
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {
        LOGGER.info("Mod {} loaded. Version: {}", MOD_ID, MOD_VERSION);
    }
}
