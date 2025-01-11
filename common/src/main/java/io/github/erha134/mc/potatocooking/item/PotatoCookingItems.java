package io.github.erha134.mc.potatocooking.item;

import io.github.erha134.mc.potatocooking.PotatoCooking;
import io.github.erha134.mc.sparklib.registry.impl.ItemDeferredRegister;
import io.github.erha134.mc.sparklib.registry.impl.ItemRegistrySupplier;
import net.minecraft.item.Item;

public final class PotatoCookingItems {
    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister(PotatoCooking.MOD_ID);

    public static final ItemRegistrySupplier<Item> TEST_ITEM = ITEMS.register("test_item", Item::new);

    public static void register() {
        ITEMS.register();
    }
}
