package io.github.erha134.mc.potatocooking.sound;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import io.github.erha134.mc.potatocooking.PotatoCooking;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;

public final class PotatoCookingSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS;

    public static final RegistrySupplier<SoundEvent> STONE_MILL_CRUSH;

    static {
        SOUND_EVENTS = DeferredRegister.create(PotatoCooking.MOD_ID, RegistryKeys.SOUND_EVENT);
        STONE_MILL_CRUSH = SOUND_EVENTS.register("stone_mill_crush", () ->
                SoundEvent.of(PotatoCooking.id("stone_mill_crush")));
    }

    public static void register() {
        SOUND_EVENTS.register();
    }
}
