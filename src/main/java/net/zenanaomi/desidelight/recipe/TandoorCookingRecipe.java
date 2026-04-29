package net.zenanaomi.desidelight.recipe;

import com.google.gson.JsonObject;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class TandoorCookingRecipe implements Recipe<Container> {

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        return false;
    }

    @Override
    public ItemStack assemble(Container pContainer, RegistryAccess pRegistryAccess) {
        return null;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return false;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return null;
    }

    @Override
    public ResourceLocation getId() {
        return null;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return null;
    }

    @Override
    public RecipeType<?> getType() {
        return null;
    }

    public static class Type implements RecipeType<TandoorCookingRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "tandoor_cooking";
    }

    public static class Serializer implements RecipeSerializer<TandoorCookingRecipe> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public TandoorCookingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            return null;
        }

        @Override
        public @Nullable TandoorCookingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            return null;
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, TandoorCookingRecipe pRecipe) {

        }
    }
}
