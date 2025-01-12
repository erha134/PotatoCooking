package io.github.erha134.mc.potatocooking.block.entity;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import io.github.erha134.mc.potatocooking.PotatoCooking;
import io.github.erha134.mc.potatocooking.block.PotatoCookingBlocks;
import io.github.erha134.mc.potatocooking.block.entity.machine.StoneMillBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.RegistryKeys;

public final class PotatoCookingBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES;

    public static final RegistrySupplier<BlockEntityType<StoneMillBlockEntity>> STONE_MILL;

    static {
        BLOCK_ENTITY_TYPES = DeferredRegister.create(PotatoCooking.MOD_ID, RegistryKeys.BLOCK_ENTITY_TYPE);
        STONE_MILL = BLOCK_ENTITY_TYPES.register("stone_mill", () -> BlockEntityType.Builder.create(
                StoneMillBlockEntity::new, PotatoCookingBlocks.STONE_MILL.get()).build(null));
    }

    public static void register() {
        BLOCK_ENTITY_TYPES.register();
    }
}
