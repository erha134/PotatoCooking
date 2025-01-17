package io.github.erha134.mc.potatocooking.forge;

import dev.architectury.platform.forge.EventBuses;
import io.github.erha134.mc.potatocooking.PotatoCooking;
import io.github.erha134.mc.potatocooking.client.PotatoCookingClient;
import io.github.erha134.mc.potatocooking.data.PotatoCookingDataGeneration;
import io.github.erha134.mc.sparklib.data.forge.SDataGenerationForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(PotatoCooking.MOD_ID)
public final class PotatoCookingForge {
    public PotatoCookingForge() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(PotatoCooking.MOD_ID, bus);
        PotatoCooking.init();

        if (FMLEnvironment.dist.isClient()) {
            PotatoCookingClient.initClient();
        }

        bus.addListener(this::gatherData);
    }

    private void gatherData(GatherDataEvent e) {
        PotatoCookingDataGeneration.init(SDataGenerationForge.create(PotatoCooking.MOD_ID, e));
    }
}
