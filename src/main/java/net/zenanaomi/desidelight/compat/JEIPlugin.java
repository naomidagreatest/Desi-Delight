package net.zenanaomi.desidelight.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.zenanaomi.desidelight.DesiDelight;
import net.zenanaomi.desidelight.block.ModBlocks;
import net.zenanaomi.desidelight.recipe.TandoorCookingRecipe;

import java.util.List;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(DesiDelight.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new TandoorCookingCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<TandoorCookingRecipe> tandoorRecipes = recipeManager.getAllRecipesFor(TandoorCookingRecipe.Type.INSTANCE);
        registration.addRecipes(TandoorCookingCategory.TANDOOR_COOKING_TYPE, tandoorRecipes);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.TANDOOR.get()), TandoorCookingCategory.TANDOOR_COOKING_TYPE);
    }
}
