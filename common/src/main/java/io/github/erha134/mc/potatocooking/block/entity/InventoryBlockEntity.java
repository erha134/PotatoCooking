package io.github.erha134.mc.potatocooking.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public abstract class InventoryBlockEntity extends BlockEntity implements SimpleSidedInventory {
    protected final DefaultedList<ItemStack> items;

    public InventoryBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, DefaultedList<ItemStack> items) {
        super(type, pos, state);
        this.items = items;
    }

    public InventoryBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, int size) {
        this(type, pos, state, DefaultedList.ofSize(size, ItemStack.EMPTY));
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, this.items);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, this.items);
    }
}
