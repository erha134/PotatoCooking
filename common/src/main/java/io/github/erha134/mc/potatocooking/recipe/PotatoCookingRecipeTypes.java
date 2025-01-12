package io.github.erha134.mc.potatocooking.recipe;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import io.github.erha134.mc.potatocooking.PotatoCooking;
import io.github.erha134.mc.potatocooking.recipe.machine.StoneMillRecipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryKeys;

public final class PotatoCookingRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES;

    public static final RegistrySupplier<RecipeType<StoneMillRecipe>> STONE_MILL;

    static {
        RECIPE_TYPES = DeferredRegister.create(PotatoCooking.MOD_ID, RegistryKeys.RECIPE_TYPE);
        STONE_MILL = RECIPE_TYPES.register("stone_mill", () -> new RecipeType<>() {
            @Override
            public String toString() {
                return "stone_mill";
            }
        });
    }

    public static void register() {
        RECIPE_TYPES.register();
    }
}
