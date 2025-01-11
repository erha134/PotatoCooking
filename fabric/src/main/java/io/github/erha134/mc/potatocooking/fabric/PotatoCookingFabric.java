package io.github.erha134.mc.potatocooking.fabric;

import io.github.erha134.mc.potatocooking.PotatoCooking;
import net.fabricmc.api.ModInitializer;

public final class PotatoCookingFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        PotatoCooking.init();
    }
}
