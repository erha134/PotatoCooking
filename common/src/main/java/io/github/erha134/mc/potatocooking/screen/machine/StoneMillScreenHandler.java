package io.github.erha134.mc.potatocooking.screen.machine;

import io.github.erha134.mc.potatocooking.block.entity.machine.StoneMillBlockEntity;
import io.github.erha134.mc.potatocooking.screen.PotatoCookingScreenHandlerTypes;
import io.github.erha134.mc.sparklib.screen.ScreenHandlerUtils;
import io.github.erha134.mc.sparklib.screen.slot.OutputSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class StoneMillScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    public StoneMillScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(2));
    }

    public StoneMillScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(PotatoCookingScreenHandlerTypes.STONE_MILL.get(), syncId);
        checkSize(inventory, 2);
        this.inventory = inventory;
        this.inventory.onOpen(playerInventory.player);

        this.addSlot(new Slot(inventory, StoneMillBlockEntity.INPUT_SLOT, 20, 33));  // Input
        this.addSlot(new OutputSlot(inventory, StoneMillBlockEntity.OUTPUT_SLOT, 143, 33));  // Output

        ScreenHandlerUtils.addPlayerInventorySlots(this, playerInventory);
    }

    // TODO: Output Slot should be taken only.
    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }
}
