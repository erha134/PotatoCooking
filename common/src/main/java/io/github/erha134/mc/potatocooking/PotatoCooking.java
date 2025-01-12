package io.github.erha134.mc.potatocooking;

import dev.architectury.platform.Platform;
import io.github.erha134.mc.potatocooking.block.PotatoCookingBlocks;
import io.github.erha134.mc.potatocooking.block.entity.PotatoCookingBlockEntityTypes;
import io.github.erha134.mc.potatocooking.item.PotatoCookingItemGroups;
import io.github.erha134.mc.potatocooking.item.PotatoCookingItems;
import io.github.erha134.mc.potatocooking.item.food.PotatoCookingFoodComponents;
import io.github.erha134.mc.potatocooking.recipe.PotatoCookingRecipeSerializers;
import io.github.erha134.mc.potatocooking.recipe.PotatoCookingRecipeTypes;
import io.github.erha134.mc.potatocooking.screen.PotatoCookingScreenHandlerTypes;
import io.github.erha134.mc.potatocooking.sound.PotatoCookingSoundEvents;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PotatoCooking {
    public static final String MOD_ID = "potatocooking";
    public static final String MOD_NAME = "Potato Cooking";
    public static final String MOD_VERSION = Platform.getMod(MOD_ID).getVersion();
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {
        LOGGER.info("Mod {} loaded. Version: {}", MOD_ID, MOD_VERSION);

        PotatoCookingBlocks.register();

        PotatoCookingBlockEntityTypes.register();

        PotatoCookingFoodComponents.register();
        PotatoCookingItems.register();
        PotatoCookingItemGroups.register();

        PotatoCookingRecipeTypes.register();
        PotatoCookingRecipeSerializers.register();

        PotatoCookingScreenHandlerTypes.register();

        PotatoCookingSoundEvents.register();
    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}
