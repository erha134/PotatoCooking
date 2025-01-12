package io.github.erha134.mc.potatocooking.client;

import io.github.erha134.mc.potatocooking.block.PotatoCookingBlocks;
import io.github.erha134.mc.potatocooking.client.screen.PotatoCookingScreens;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public final class PotatoCookingClient {
    public static void initClient() {
        PotatoCookingBlocks.registerClient();

        PotatoCookingScreens.register();
    }
}
