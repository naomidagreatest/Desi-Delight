package net.zenanaomi.desidelight.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TandoorCookingRecipe implements Recipe<TandoorRecipeInput> {
    private final NonNullList<Ingredient> inputItems;
    private final ItemStack output;
    private final int cookTime;

    public TandoorCookingRecipe(NonNullList<Ingredient> inputItems, ItemStack output, int cookTime) {
        this.inputItems = inputItems;
        this.output = output;
        this.cookTime = cookTime;
    }


    @Override
    public boolean matches(TandoorRecipeInput input, Level level) {
        if (level.isClientSide()) {
            return false;
        }

        List<Ingredient> required = new ArrayList<>(inputItems);

        for (int i = 0; i < input.size(); i++) {
            ItemStack stack = input.getItem(i);

            if (stack.isEmpty()) continue;

            boolean matched = false;

            for (Iterator<Ingredient> it = required.iterator(); it.hasNext();) {
                Ingredient ingredient = it.next();

                if (ingredient.test(stack)) {
                    it.remove();
                    matched = true;
                    break;
                }
            }

            if(!matched) {
                return false;
            }
        }
        return required.isEmpty();
    }

    @Override
    public ItemStack assemble(TandoorRecipeInput input, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.TANDOOR_COOKING_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.TANDOOR_COOKING_TYPE.get();
    }

    public NonNullList<Ingredient> getIngredients() {
        return inputItems;
    }

    public ItemStack getOutput() {
        return output;
    }

    public int getCookTime() {
        return 60;
    }
}
