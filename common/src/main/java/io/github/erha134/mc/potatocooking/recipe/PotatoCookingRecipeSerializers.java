package io.github.erha134.mc.potatocooking.recipe;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import io.github.erha134.mc.potatocooking.PotatoCooking;
import io.github.erha134.mc.potatocooking.recipe.machine.StoneMillRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.RegistryKeys;

public final class PotatoCookingRecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS;

    public static final RegistrySupplier<RecipeSerializer<StoneMillRecipe>> STONE_MILL;

    static {
        RECIPE_SERIALIZERS = DeferredRegister.create(PotatoCooking.MOD_ID, RegistryKeys.RECIPE_SERIALIZER);
        STONE_MILL = RECIPE_SERIALIZERS.register("stone_mill", () -> new SingleIngredientRecipe.Serializer<>(StoneMillRecipe::new));
    }

    public static void register() {
        RECIPE_SERIALIZERS.register();
    }
}
