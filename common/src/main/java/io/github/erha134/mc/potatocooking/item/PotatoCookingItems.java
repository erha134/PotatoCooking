package io.github.erha134.mc.potatocooking.item;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import io.github.erha134.mc.potatocooking.PotatoCooking;
import io.github.erha134.mc.potatocooking.block.PotatoCookingBlocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;

public final class PotatoCookingItems {
    public static final DeferredRegister<Item> ITEMS;

    public static final RegistrySupplier<AliasedBlockItem> RICE_CROP;
    public static final RegistrySupplier<Item> RICE;
    public static final RegistrySupplier<Item> STONE_MILL;

    static {
        ITEMS = DeferredRegister.create(PotatoCooking.MOD_ID, RegistryKeys.ITEM);
        RICE_CROP = ITEMS.register("rice_crop", () -> new AliasedBlockItem(PotatoCookingBlocks.RICE.get(),
                new Item.Settings().arch$tab(PotatoCookingItemGroups.MAIN_GROUP)));
        RICE = ITEMS.register("rice", () -> new Item(
                new Item.Settings().arch$tab(PotatoCookingItemGroups.MAIN_GROUP)));
        STONE_MILL = ITEMS.register("stone_mill", () -> new BlockItem(PotatoCookingBlocks.STONE_MILL.get(),
                new Item.Settings().arch$tab(PotatoCookingItemGroups.MAIN_GROUP)));
    }

    public static void register() {
        ITEMS.register();
    }
}
