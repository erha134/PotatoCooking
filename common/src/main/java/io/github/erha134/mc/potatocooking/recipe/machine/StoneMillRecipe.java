package io.github.erha134.mc.potatocooking.recipe.machine;

import io.github.erha134.mc.potatocooking.item.PotatoCookingItems;
import io.github.erha134.mc.potatocooking.recipe.PotatoCookingRecipeSerializers;
import io.github.erha134.mc.potatocooking.recipe.PotatoCookingRecipeTypes;
import io.github.erha134.mc.potatocooking.recipe.SingleIngredientRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;

public class StoneMillRecipe extends SingleIngredientRecipe<StoneMillRecipe> {
    public StoneMillRecipe(Identifier id, Ingredient ingredient, ItemStack output) {
        super(PotatoCookingRecipeSerializers.STONE_MILL.get(), PotatoCookingRecipeTypes.STONE_MILL.get(), id, ingredient, output);
    }

    @Override
    public ItemStack createIcon() {
        return PotatoCookingItems.STONE_MILL.get().sparklib$asStack();
    }
}
