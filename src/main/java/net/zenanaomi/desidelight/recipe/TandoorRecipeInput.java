package net.zenanaomi.desidelight.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public class TandoorRecipeInput implements RecipeInput {
    private final ItemStack[] items;

    public TandoorRecipeInput(ItemStack[] items) {
        this.items = items;
    }

    @Override
    public ItemStack getItem(int index) {
        return items[index];
    }

    @Override
    public int size() {
        return items.length;
    }
}
