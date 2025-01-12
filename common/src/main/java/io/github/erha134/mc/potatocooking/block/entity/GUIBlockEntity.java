package io.github.erha134.mc.potatocooking.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public abstract class GUIBlockEntity extends InventoryBlockEntity implements NamedScreenHandlerFactory {
    public GUIBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, DefaultedList<ItemStack> items) {
        super(type, pos, state, items);
    }

    public GUIBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, int size) {
        super(type, pos, state, size);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }
}
