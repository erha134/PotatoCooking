package io.github.erha134.mc.potatocooking.block.entity.machine;

import io.github.erha134.mc.potatocooking.block.entity.GUIBlockEntity;
import io.github.erha134.mc.potatocooking.block.entity.PotatoCookingBlockEntityTypes;
import io.github.erha134.mc.potatocooking.recipe.PotatoCookingRecipeTypes;
import io.github.erha134.mc.potatocooking.recipe.machine.StoneMillRecipe;
import io.github.erha134.mc.potatocooking.screen.machine.StoneMillScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class StoneMillBlockEntity extends GUIBlockEntity {
    public static final int INPUT_SLOT = 0;
    public static final int OUTPUT_SLOT = 1;

    public StoneMillBlockEntity(BlockPos pos, BlockState state) {
        super(PotatoCookingBlockEntityTypes.STONE_MILL.get(), pos, state, 2);
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new StoneMillScreenHandler(syncId, playerInventory, this);
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(OUTPUT_SLOT).getItem() == output || inventory.getStack(OUTPUT_SLOT).isEmpty();
    }

    private static boolean canInsertAmountIntOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(OUTPUT_SLOT).getMaxCount() > inventory.getStack(OUTPUT_SLOT).getCount();
    }

    public boolean crush() {
        if (this.world == null) {
            return false;
        }

        if (this.world.isClient()) {
            return false;
        }

        SimpleInventory inventory = new SimpleInventory(this.size());
        for (int i = 0; i < this.size(); i++) {
            inventory.setStack(i, this.getStack(i));
        }

        Optional<StoneMillRecipe> matched = this.world.getRecipeManager().getFirstMatch(PotatoCookingRecipeTypes.STONE_MILL.get(),
                inventory,
                this.world);

        if (matched.isPresent()) {
            Item output = matched.get().getOutput(this.world.getRegistryManager()).getItem();

            if (canInsertItemIntoOutputSlot(inventory, output) && canInsertAmountIntOutputSlot(inventory)) {
                this.removeStack(0, 1);
                this.setStack(1, new ItemStack(output, this.getStack(1).getCount() + 1));
                return true;
            }
        }

        return false;
    }
}
