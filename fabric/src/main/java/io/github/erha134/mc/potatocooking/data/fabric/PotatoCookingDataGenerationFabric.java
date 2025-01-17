package io.github.erha134.mc.potatocooking.data.fabric;

import io.github.erha134.mc.potatocooking.PotatoCooking;
import io.github.erha134.mc.potatocooking.data.PotatoCookingDataGeneration;
import io.github.erha134.mc.sparklib.data.fabric.SDataGenerationFabric;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public final class PotatoCookingDataGenerationFabric implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        PotatoCookingDataGeneration.init(SDataGenerationFabric.create(PotatoCooking.MOD_ID, fabricDataGenerator));
    }
}
