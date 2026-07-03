package net.zenanaomi.desidelight.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.zenanaomi.desidelight.DesiDelight;
import net.zenanaomi.desidelight.block.ModBlocks;
import net.zenanaomi.desidelight.recipe.TandoorCookingRecipe;
import org.jetbrains.annotations.Nullable;

public class TandoorCookingCategory implements IRecipeCategory<TandoorCookingRecipe> {

    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(DesiDelight.MOD_ID, "tandoor_cooking");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(DesiDelight.MOD_ID, "textures/gui/tandoor_cooking_gui.png");
    public static final RecipeType<TandoorCookingRecipe> TANDOOR_COOKING_TYPE = new RecipeType<>(UID, TandoorCookingRecipe.class);
    private final IDrawable background;
    private final IDrawable icon;

    public TandoorCookingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 38, 25, 100, 38);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.TANDOOR.get()));
    }

    @Override
    public RecipeType<TandoorCookingRecipe> getRecipeType() {
        return TANDOOR_COOKING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.zenadesidelight.tandoor");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public int getHeight() {
        return this.background.getHeight();
    }

    @Override
    public int getWidth() {
        return this.background.getWidth();
    }

    @Override
    public void draw(TandoorCookingRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.background.draw(guiGraphics, 0, 0);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, TandoorCookingRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 2, 2).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 20, 2).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 2, 20).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 78, 13).addItemStack(recipe.getResultItem(null));
    }
}
