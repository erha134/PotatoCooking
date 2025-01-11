package io.github.erha134.mc.potatocooking.client.fabric;

import io.github.erha134.mc.potatocooking.client.PotatoCookingClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public final class PotatoCookingClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PotatoCookingClient.initClient();
    }
}
