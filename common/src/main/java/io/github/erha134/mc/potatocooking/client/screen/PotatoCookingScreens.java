package io.github.erha134.mc.potatocooking.client.screen;

import dev.architectury.registry.menu.MenuRegistry;
import io.github.erha134.mc.potatocooking.client.screen.machine.StoneMillScreen;
import io.github.erha134.mc.potatocooking.screen.PotatoCookingScreenHandlerTypes;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public final class PotatoCookingScreens {
    public static void register() {
        MenuRegistry.registerScreenFactory(PotatoCookingScreenHandlerTypes.STONE_MILL.get(), StoneMillScreen::new);
    }
}
