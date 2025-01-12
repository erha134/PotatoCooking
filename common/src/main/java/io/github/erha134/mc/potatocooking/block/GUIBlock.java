package io.github.erha134.mc.potatocooking.block;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class GUIBlock extends InventoryBlock {
    public GUIBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient()) {
            return ActionResult.SUCCESS;
        }

        NamedScreenHandlerFactory factory = state.createScreenHandlerFactory(world, pos);

        if (factory != null) {
            player.openHandledScreen(factory);
        }

        return ActionResult.CONSUME;
    }
}
