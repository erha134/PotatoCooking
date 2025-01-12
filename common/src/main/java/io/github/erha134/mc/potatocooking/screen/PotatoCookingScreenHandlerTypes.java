package io.github.erha134.mc.potatocooking.screen;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import io.github.erha134.mc.potatocooking.PotatoCooking;
import io.github.erha134.mc.potatocooking.screen.machine.StoneMillScreenHandler;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;

public final class PotatoCookingScreenHandlerTypes {
    public static final DeferredRegister<ScreenHandlerType<?>> SCREEN_HANDLER_TYPES;

    public static final RegistrySupplier<ScreenHandlerType<StoneMillScreenHandler>> STONE_MILL;

    static {
        SCREEN_HANDLER_TYPES = DeferredRegister.create(PotatoCooking.MOD_ID, RegistryKeys.SCREEN_HANDLER);
        STONE_MILL = SCREEN_HANDLER_TYPES.register("stone_mill", () ->
                new ScreenHandlerType<>(StoneMillScreenHandler::new, FeatureFlags.VANILLA_FEATURES));
    }

    public static void register() {
        SCREEN_HANDLER_TYPES.register();
    }
}
