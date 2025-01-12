package io.github.erha134.mc.potatocooking.item.food;

import net.minecraft.item.FoodComponent;

public class PotatoCookingFoodComponents {
    public static final FoodComponent MUSHROOM_SOUP;

    static {
        MUSHROOM_SOUP = new FoodComponent.Builder()
                .hunger(4)
                .saturationModifier(0.6f)
                .build();
    }

    public static void register() {
        // dummy
    }
}
