package io.github.erha134.mc.potatocooking.block.crop;

import io.github.erha134.mc.potatocooking.item.PotatoCookingItems;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;

public class RiceBlock extends CropBlock {
    public RiceBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ItemConvertible getSeedsItem() {
        return PotatoCookingItems.RICE.get();
    }
}
