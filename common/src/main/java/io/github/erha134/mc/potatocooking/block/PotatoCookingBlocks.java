package io.github.erha134.mc.potatocooking.block;

import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import io.github.erha134.mc.potatocooking.PotatoCooking;
import io.github.erha134.mc.potatocooking.block.crop.RiceBlock;
import io.github.erha134.mc.potatocooking.block.machine.StoneMillBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.registry.RegistryKeys;

public final class PotatoCookingBlocks {
    public static final DeferredRegister<Block> BLOCKS;

    public static final RegistrySupplier<Block> RICE;
    public static final RegistrySupplier<Block> STONE_MILL;

    static {
        BLOCKS = DeferredRegister.create(PotatoCooking.MOD_ID, RegistryKeys.BLOCK);
        RICE = BLOCKS.register("rice", () -> new RiceBlock(
                AbstractBlock.Settings.copy(Blocks.WHEAT)));
        STONE_MILL = BLOCKS.register("stone_mill", () -> new StoneMillBlock(
                AbstractBlock.Settings.create().requiresTool().strength(3.5F)));  // FIXME: BlockState Problem
    }

    public static void register() {
        BLOCKS.register();
    }

    @Environment(EnvType.CLIENT)
    public static void registerClient() {
        RenderTypeRegistry.register(RenderLayer.getCutout(), RICE.get());
    }
}
