package io.github.erha134.mc.potatocooking.block.machine;

import io.github.erha134.mc.potatocooking.block.GUIBlock;
import io.github.erha134.mc.potatocooking.block.entity.machine.StoneMillBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class StoneMillBlock extends GUIBlock {
    public StoneMillBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient()) {
            return ActionResult.SUCCESS;
        }

        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof StoneMillBlockEntity stoneMill) {
            if (player.isSneaking()) {
                NamedScreenHandlerFactory factory = state.createScreenHandlerFactory(world, pos);

                if (factory != null) {
                    player.openHandledScreen(factory);
                }
            } else if (stoneMill.crush()) {
                player.addExhaustion(0.5f);
            }
        }

        return ActionResult.CONSUME;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new StoneMillBlockEntity(pos, state);
    }
}
