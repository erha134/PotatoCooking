package io.github.erha134.mc.potatocooking.item;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import io.github.erha134.mc.potatocooking.PotatoCooking;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;

public final class PotatoCookingItemGroups {
    public static final DeferredRegister<ItemGroup> ITEM_GROUPS;

    public static final RegistrySupplier<ItemGroup> MAIN_GROUP;

    static {
        ITEM_GROUPS = DeferredRegister.create(PotatoCooking.MOD_ID, RegistryKeys.ITEM_GROUP);
        MAIN_GROUP = ITEM_GROUPS.register("potatocooking", () -> CreativeTabRegistry.create(
                Text.translatable("itemGroup.potatocooking.main_group"),
                Items.POTATO::sparklib$asStack));
    }

    public static void register() {
        ITEM_GROUPS.register();
    }
}
